package factory;

import animal.AbsAnimal;
import animal.birds.duck;
import data.AnimalTypeData;
import animal.pet.cat;
import animal.pet.dog;

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



