package model;

public class AnimalCommand {
    int commandID;
    String description;

    public AnimalCommand(int commandID, String description) {
        this.commandID = commandID;
        this.description = description;
    }

    public int getCommandID() {
        return commandID;
    }

    public void setCommandID(int commandID) {
        this.commandID = commandID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%d - %s", commandID, description);
    }
}
