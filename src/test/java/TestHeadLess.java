import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestHeadLess {

    @BeforeAll
    public static void wb() {

        WebDriverManager.chromedriver().setup();
    }
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

    }

    @Test
    public void testHeadLess() {

        driver.get("https://duckduckgo.com/");
        driver.findElement(By.name("q")).sendKeys("ОТУС");
        driver.findElement(By.id("search_button_homepage")).click();
        String firstResult = driver.findElement(By.cssSelector("#links .result__title a")).getText();
        assertEquals("Онлайн‑курсы для профессионалов, дистанционное обучение", firstResult);
    }
        @AfterEach
        public void close() {
            if (driver != null)
                driver.quit();
        }

    }




