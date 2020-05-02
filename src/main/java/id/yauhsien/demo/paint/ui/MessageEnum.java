package id.yauhsien.demo.paint.ui;

/**
 * Usable message for user interaction.
 */
public enum MessageEnum {

    Nothing,
    EnterCommand("Enter command: "),
    BadCommand("Bad command.\n"),
    LineCommandNotSupported("Line command not supported.\n"),
    NoCanvas("No canvas.\n"),
    OK("OK.");

    private String meaning;

    MessageEnum() {}
    MessageEnum(String meaning) {
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        return meaning;
    }
}
