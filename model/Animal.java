package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public abstract class Animal {

    protected int animalID;
    protected String name;
    protected LocalDate birthday;
    protected ArrayList<AnimalCommand> commands;

    public Animal(int animalID, String name, LocalDate birthday) {
        this.animalID = animalID;
        this.name = name;
        this.birthday = birthday;
        this.commands = new ArrayList<>();
    }

    public int getAnimalID() {
        return animalID;
    }

    public void setAnimalID(int animalID) {
        this.animalID = animalID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public ArrayList<AnimalCommand> getCommands() {
        return commands;
    }

    public void addCommand(AnimalCommand command) {
        this.commands.add(command);
    }

    public void addCommands(ArrayList<AnimalCommand> commands) {
        this.commands.addAll(commands);
    }

    @Override
    public abstract String toString();
}
