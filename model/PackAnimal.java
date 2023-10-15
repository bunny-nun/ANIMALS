package model;

import java.time.LocalDate;

public class PackAnimal extends Animal {

    private PackAnimalClass animalClass;

    public enum PackAnimalClass {
        HORSE, CAMEL, DONKEY;

        @Override
        public String toString() {
            String packAnimalClass = "";
            switch (this) {
                case HORSE -> {
                    packAnimalClass = "horse";
                    break;
                }
                case CAMEL -> {
                    packAnimalClass = "camel";
                    break;
                }
                case DONKEY -> {
                    packAnimalClass = "donkey";
                    break;
                }
            }
            return packAnimalClass;
        }
    }

    public PackAnimal(int animalID, String name, LocalDate birthday, PackAnimalClass animalClass) {
        super(animalID, name, birthday);
        this.animalClass = animalClass;
    }

    public PackAnimalClass getAnimalClass() {
        return animalClass;
    }

    public void setAnimalClass(PackAnimalClass animalClass) {
        this.animalClass = animalClass;
    }

    public String getClassString() {
        return animalClass.toString();
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s, id: %d", this.animalClass, this.name, this.birthday.toString(), this.animalID);
    }
}
