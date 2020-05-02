package id.yauhsien.demo.paint.ui;

public enum MessageEnum {
    Nothing,
    EnterCommand("Enter command: "),
    BadCommand("Bad command.\n"),
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
