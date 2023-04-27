package factory;

import animal.AbsAnimal;
import birds.duck;
import data.AnimalTypeData;
import pet.cat;
import pet.dog;

public class Factory {
    public AbsAnimal create(AnimalTypeData animalTypeData) {
        switch (animalTypeData) {
            case CAT -> {
                return new cat();
            }
            case DOG -> {
                return new dog();
            }
            case DUCK -> {
                return new duck();
            }
        }
        return null;
    }
}



