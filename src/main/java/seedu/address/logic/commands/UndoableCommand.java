package seedu.address.logic.commands;

/**
 * Represent a command then can be undone.
 */
public interface UndoableCommand {
    
    /**
     * Gets the command word of the undoable command.
     * @return command word of the undoable command.
     */
    String getCommandWord();
}