import animal.birds.IFlying;
import data.AnimalTypeData;
import data.CommandsData;
import animal.AbsAnimal;
import factory.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.*;

public class Runner {

    private final static Scanner scanner = new Scanner(in);

    public static void main(String... args) {
        List<AbsAnimal> animals = new ArrayList<>();
        while (true) {
            String commandsStr = "";
            do {
                out.println("введите команду add/list/exit");
                commandsStr = scanner.next().toUpperCase().trim();
            } while (!commandsStr.equals("ADD") && !commandsStr.equals("LIST") && !commandsStr.equals("EXIT"));

            CommandsData commandsData = CommandsData.valueOf(commandsStr);
            switch (commandsData) {
                case ADD -> {
                    String animalTypeStr = "";
                    do {
                        out.println("введите тип животного cat,dog,duck");
                        animalTypeStr = scanner.next().toUpperCase().trim();
                    } while (!animalTypeStr.equals("CAT") && !animalTypeStr.equals("DOG") && !animalTypeStr.equals("DUCK"));


                    AnimalTypeData animalTypeData = AnimalTypeData.valueOf(animalTypeStr);
                    Factory factory = new Factory();

                    AbsAnimal absAnimal = factory.create(animalTypeData);

                    if (absAnimal instanceof IFlying) {
                        ((IFlying) absAnimal).fly();
                    }


                    animals.add(fillAnimalData(absAnimal));
                }
                case LIST -> animals.forEach((AbsAnimal animal) -> System.out.println(animal.toString()));
                case EXIT -> exit(0);
            }

        }
    }

    private static AbsAnimal fillAnimalData(AbsAnimal animal) {
        System.out.println("Введите имя животного");
        String name = scanner.next();
        animal.setName(name);

        // Ввод и проверка возраста
        int age = 0;
        boolean isAgeValid = false;
        while (!isAgeValid) {
            System.out.println("Введите возраст животного");
            String ageStr = scanner.next();
            try {
                age = Integer.parseInt(ageStr);
                if (age < 0) {
                    System.out.println("Вы ввели отрицательный возраст!");
                } else {
                    isAgeValid = true;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Вы ввели неверный возраст!");
            }
        }
        animal.setAge(age);


        int weight = 0;
        boolean isWeightValid = false;
        while (!isWeightValid) {
            System.out.println("Введите вес животного");
            String weightStr = scanner.next();
            try {
                weight = Integer.parseInt(weightStr);
                if (weight < 0) {
                    System.out.println("Вы ввели отрицательный вес!");
                } else {


                isWeightValid = true;}
            } catch (NumberFormatException exception) {
                System.out.println("Вы ввели неверный вес!");
            }
        }
        animal.setWeight(weight);


        String colorStr = null;
        boolean isColorValid = false;
        while (!isColorValid) {
            System.out.println("Введите цвет животного");
            colorStr = scanner.next();
            if (colorStr.matches(".*\\d.*")) {
                System.out.println("Введите цвет буквами!");
                continue;
            }
            isColorValid = true;
        }
        animal.setColor(colorStr);


        return animal;
    }
}


