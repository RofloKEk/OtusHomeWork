package animal;

public abstract class AbsAnimal {
   private String name = "";
   private int age = 1;
   private int weight = 1;
   private String color = "";

   public String getName() {
      return name;
   }

   public int getAge() {
      return age;
   }

   public int getWeight() {
      return weight;
   }

   public String getColor() {
      return color;
   }

   public void setName(String name) {
      this.name = name;

   }
   public void setAge(int age) {
      this.age = age;
   }

   public void setWeight(int age) {
      this.weight = weight;
   }

   public void setColor(String color) {
      this.color = color;
   }

   public void say() {
      System.out.println("я говорю");
   }

   public void go() {
      System.out.println("я иду");
   }

   public void drink() {
      System.out.println("я пью");
   }

   public void eat() {
      System.out.println("я ем");
   }


   public String toString() {
      return String.format(
              "Привет! меня зовут %s, мне %d %s, я вешу - %d кг, мой цвет - %s",
              name, age, getYearPrefix(age), weight, color
      );
   }

   private String getYearPrefix(int age) {
      int ostatok = age % 10;

      if (ostatok >= 5 || ostatok == 0 || (age >= 11 && age < 15)) {
         return "лет";
      }

      if (ostatok == 1) {
         return "год";

      }
      return "года";
   }
}
