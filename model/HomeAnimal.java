package model;

import java.time.LocalDate;
import java.util.Date;

public class HomeAnimal extends Animal {

    protected HomeAnimalClass animalClass;

    public enum HomeAnimalClass {
        CAT, DOG, HAMSTER;

        @Override
        public String toString() {
            String homeAnimalClass = "";
            switch (this) {
                case CAT -> {
                    homeAnimalClass = "cat";
                    break;
                }
                case DOG -> {
                    homeAnimalClass = "dog";
                    break;
                }
                case HAMSTER -> {
                    homeAnimalClass = "hamster";
                    break;
                }
            }
            return homeAnimalClass;
        }
    }

    public HomeAnimal(int animalID, String name, LocalDate birthday, HomeAnimalClass animalClass) {
        super(animalID, name, birthday);
        this.animalClass = animalClass;
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s, id: %d", this.animalClass, this.name, this.birthday.toString(), this.animalID);
    }
}
