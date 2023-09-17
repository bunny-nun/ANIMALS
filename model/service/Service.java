package model.service;

import model.Animal;
import model.AnimalCommand;
import model.HomeAnimal;
import model.PackAnimal;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Service {
    ArrayList<Animal> animalList;
    HashMap<Integer, AnimalCommand> commandList;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Service() {
        this.commandList = new HashMap<>();
        loadCommands();
        this.animalList = new ArrayList<>();
        loadAnimals();
    }

    public ArrayList<Animal> getAnimalList() {
        return animalList;
    }

    public HashMap<Integer, AnimalCommand> getCommandList() {
        return commandList;
    }

    private void loadAnimals() {

        String query = "SELECT * FROM all_animals";
        try (Connection connection = DriverManager.getConnection(Config.HOST, Config.USER, Config.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int animalID = resultSet.getInt("id");
                String name = resultSet.getString("animal_name");
                LocalDate birthday = LocalDate.parse(resultSet.getString("birthday"), formatter);
                String animalClassName = resultSet.getString("class_name");
                HomeAnimal.HomeAnimalClass homeAnimalClass = null;
                PackAnimal.PackAnimalClass packAnimalClass = null;
                switch (animalClassName) {
                    case "cat":
                        homeAnimalClass = HomeAnimal.HomeAnimalClass.CAT;
                        break;
                    case "dog":
                        homeAnimalClass = HomeAnimal.HomeAnimalClass.DOG;
                        break;
                    case "hamster":
                        homeAnimalClass = HomeAnimal.HomeAnimalClass.HAMSTER;
                        break;
                    case "horse":
                        packAnimalClass = PackAnimal.PackAnimalClass.HORSE;
                        break;
                    case "camel":
                        packAnimalClass = PackAnimal.PackAnimalClass.CAMEL;
                        break;
                    case "donkey":
                        packAnimalClass = PackAnimal.PackAnimalClass.DONKEY;
                        break;
                }
                Animal animal;
                if (homeAnimalClass != null) {
                    animal = new HomeAnimal(animalID, name, birthday, homeAnimalClass);
                } else {
                    animal = new PackAnimal(animalID, name, birthday, packAnimalClass);
                }
                int command = resultSet.getInt("command_1");
                animal.addCommand(this.commandList.get(command));
                command = resultSet.getInt("command_2");
                animal.addCommand(this.commandList.get(command));
                command = resultSet.getInt("command_3");
                animal.addCommand(this.commandList.get(command));
                this.animalList.add(animal);
            }
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void loadCommands() {
        String query = "SELECT * FROM command";
        try (Connection connection = DriverManager.getConnection(Config.HOST, Config.USER, Config.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int commandID = resultSet.getInt("id");
                String description = resultSet.getString("command");
                AnimalCommand animalCommand = new AnimalCommand(commandID, description);
                this.commandList.put(commandID, animalCommand);
            }
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
