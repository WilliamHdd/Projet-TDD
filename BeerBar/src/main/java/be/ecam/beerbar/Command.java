package be.ecam.beerbar;

import java.util.ArrayList;

/**
 * An instance of this class records every command that has
 * been made and returns the whole or trimmed history.
 */
public class Command {
    
    private final ArrayList<String> queries;
    
    public Command() {
        this.queries = new ArrayList();
    }
    
    /**
     * Add a command to the history array
     * @param str the command
     */
    public void addCommand(String str) {
        this.queries.add(str + "\n");
    }
    
    /**
     * Returns ALL the commands history
     * @return a string with all the history
     */
    public String getCommands() {
        return this.queries.toString();
    }
    
    /**
     * Returns a specific command in the history defined by its index
     * @param index the position in the history array
     * @return the command as a string
     */
    public String getCommand(int index) {
        try {
            return this.queries.get(index);
        } catch(IndexOutOfBoundsException err) {
            System.err.println(err);
            return "";
        }
    }
    
}
