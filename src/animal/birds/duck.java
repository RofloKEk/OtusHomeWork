package animal.birds;

import animal.AbsAnimal;

public class duck extends AbsAnimal implements IFlying {
    public duck(){
        say();

    }
    public void fly() {
        System.out.println("я лeчу");
    }

    public void say() {
        System.out.println("KRYAKRYA");

    }
}
