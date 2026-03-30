package seedu.address.ui;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores executed commands (per session) and provides terminal-like navigation.
 *
 * <p>The navigation model mirrors a terminal:
 * calling {@link #previous(String)} returns older commands; calling {@link #next(String)} returns newer commands and
 * eventually restores the draft input that was present when navigation began.
 */
public class CommandHistory {

    private final List<String> commands = new ArrayList<>();

    /**
     * Index into {@link #commands} while navigating, or {@code commands.size()} to represent the draft position.
     *
     * <p>Invariant: {@code 0 <= pointer <= commands.size()}.
     */
    private int pointer = 0;
    private String draft = "";
    private boolean navigating = false;

    /**
     * Adds an executed command to history and exits any active navigation session.
     *
     * @param commandText Command text as entered by the user.
     */
    public void add(String commandText) {
        commands.add(commandText);
        resetNavigation();
    }

    /**
     * Exits the active navigation session (if any).
     *
     * <p>Call this when the user edits the input normally so the next Up/Down navigation starts from the new draft.
     */
    public void resetNavigation() {
        navigating = false;
        draft = "";
        pointer = commands.size();
    }

    /**
     * Moves to an older command (as if pressing the Up key).
     *
     * <p>If this starts a new navigation session, {@code currentInput} is captured as the draft to restore later.
     * If there is no history, {@code currentInput} is returned unchanged.
     *
     * @param currentInput Current input text.
     * @return Text that should be displayed after moving to an older command.
     */
    public String previous(String currentInput) {
        if (commands.isEmpty()) {
            return currentInput;
        }

        ensureDraftCaptured(currentInput);
        pointer = Math.max(0, pointer - 1);
        return commands.get(pointer);
    }

    /**
     * Moves to a newer command (as if pressing the Down key).
     *
     * <p>If this starts a new navigation session, {@code currentInput} is captured as the draft.
     * When moving beyond the newest command, the captured draft is returned and navigation ends.
     *
     * @param currentInput Current input text.
     * @return Text that should be displayed after moving to a newer command, or the draft when at the end.
     */
    public String next(String currentInput) {
        if (commands.isEmpty()) {
            return currentInput;
        }

        ensureDraftCaptured(currentInput);
        pointer = Math.min(commands.size(), pointer + 1);
        if (pointer == commands.size()) {
            navigating = false;
            return draft;
        }
        return commands.get(pointer);
    }

    private void ensureDraftCaptured(String currentInput) {
        if (!navigating) {
            navigating = true;
            draft = currentInput;
            pointer = commands.size();
        }
    }
}

