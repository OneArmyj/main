package seedu.planner.logic.commands;

import static seedu.planner.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.planner.testutil.TypicalContacts.getTypicalPlanner;

import org.junit.jupiter.api.Test;

import seedu.planner.model.Model;
import seedu.planner.model.ModelManager;
import seedu.planner.model.Planner;
import seedu.planner.model.UserPrefs;

public class ClearCommandTest {

    @Test
    public void execute_emptyPlanner_success() {
        Model model = new ModelManager();
        Model expectedModel = new ModelManager();

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_nonEmptyPlanner_success() {
        Model model = new ModelManager(getTypicalPlanner(), new UserPrefs());
        Model expectedModel = new ModelManager(getTypicalPlanner(), new UserPrefs());
        expectedModel.setPlanner(new Planner());

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

}
