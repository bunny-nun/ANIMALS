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

        String query = "SELECT hh1.animal_class AS `class_name`, c.id, c.animal_name, c.birthday, c.command_1, c.command_2, c.command_3 FROM cat AS c\n" +
                "LEFT JOIN home_animal AS hh1 ON c.class_id = hh1.id\n" +
                "UNION\n" +
                "SELECT hh1.animal_class AS `class_name`, d.id, d.animal_name, d.birthday, d.command_1, d.command_2, d.command_3 FROM dog AS d\n" +
                "LEFT JOIN home_animal AS hh1 ON d.class_id = hh1.id\n" +
                "UNION\n" +
                "SELECT hh1.animal_class AS `class_name`, h.id, h.animal_name, h.birthday, h.command_1, h.command_2, h.command_3 FROM hamster AS h\n" +
                "LEFT JOIN home_animal AS hh1 ON h.class_id = hh1.id\n" +
                "UNION\n" +
                "SELECT pp1.animal_class AS `class_name`, h.id, h.animal_name, h.birthday, h.command_1, h.command_2, h.command_3 FROM horse AS h\n" +
                "LEFT JOIN pack_animal AS pp1 ON h.class_id = pp1.id\n" +
                "UNION\n" +
                "SELECT pp1.animal_class AS `class_name`, c.id, c.animal_name, c.birthday, c.command_1, c.command_2, c.command_3 FROM camel AS c\n" +
                "LEFT JOIN pack_animal AS pp1 ON c.class_id = pp1.id\n" +
                "UNION\n" +
                "SELECT pp1.animal_class AS `class_name`, d.id, d.animal_name, d.birthday, d.command_1, d.command_2, d.command_3 FROM donkey AS d\n" +
                "LEFT JOIN pack_animal AS pp1 ON d.class_id = pp1.id;";
        try (Connection connection = DriverManager.getConnection(Config.HOST, Config.USER, Config.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int animalID = resultSet.getInt("id");
                String name = resultSet.getString("animal_name");
                String date = resultSet.getString("birthday");
                String animalClass = resultSet.getString("class_name");
                int command1 = resultSet.getInt("command_1");
                int command2 = resultSet.getInt("command_2");
                int command3 = resultSet.getInt("command_3");
                Animal animal = create(animalID, name, date, animalClass, command1, command2, command3);
                this.animalList.add(animal);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Animal loadAnimal(String animalClass, String name, String birthday) {
        String query = String.format("SELECT id, animal_name, birthday, " +
                "command_1, command_2, command_3 FROM %s\n" +
                "WHERE animal_name = '%s' AND birthday = '%s';", animalClass, name, birthday);
        Animal animal = null;
        try (Connection connection = DriverManager.getConnection(Config.HOST, Config.USER, Config.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int animalID = resultSet.getInt("id");
                String date = resultSet.getString("birthday");
                int command1 = resultSet.getInt("command_1");
                int command2 = resultSet.getInt("command_2");
                int command3 = resultSet.getInt("command_3");
                animal = create(animalID, name, date, animalClass, command1, command2, command3);
                if (animal != null) {
                    this.animalList.add(animal);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return animal;
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
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Animal create(int animalID, String name, String date, String animalClass, int command1, int command2, int command3) {
        LocalDate birthday = LocalDate.parse(date, formatter);
        HomeAnimal.HomeAnimalClass homeAnimalClass = null;
        PackAnimal.PackAnimalClass packAnimalClass = null;
        switch (animalClass) {
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
        animal.addCommand(this.commandList.get(command1));
        animal.addCommand(this.commandList.get(command2));
        animal.addCommand(this.commandList.get(command3));
        return animal;
    }

    public void add(String animalClass, String name, String birthday, int command1, int command2, int command3) {
        int classID = switch (animalClass) {
            case "cat", "horse" -> 1;
            case "dog", "camel" -> 2;
            case "hamster", "donkey" -> 3;
            default -> 0;
        };
        String query = String.format("INSERT INTO %s (class_id, animal_name, birthday, command_1, command_2, command_3)\n" +
                "VALUES (%d, '%s', '%s', %d, %d, %d);", animalClass, classID, name, birthday, command1, command2, command3);

        try (Connection connection = DriverManager.getConnection(Config.HOST, Config.USER, Config.PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Animal find(String name, String birthday) {
        Animal animal = null;
        for (Animal result : this.animalList) {
            if (result.getName().equals(name) && result.getBirthday().format(formatter).equals(birthday)) {
                animal = result;
            }
        }
        return animal;
    }

    public boolean delete(Animal animal) {
        if (animal != null) {
            String query = String.format("DELETE FROM %s WHERE animal_name = '%s' AND birthday = '%s';",
                    animal.getClassString(), animal.getName(), animal.getBirthday().format(formatter));
            try (Connection connection = DriverManager.getConnection(Config.HOST, Config.USER, Config.PASSWORD);
                 Statement statement = connection.createStatement()) {
                statement.executeUpdate(query);
                this.animalList.remove(animal);
                return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return false;
            }
        } else {
            return false;
        }
    }
}
