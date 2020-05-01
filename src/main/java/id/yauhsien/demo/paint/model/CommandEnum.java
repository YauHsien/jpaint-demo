package id.yauhsien.demo.paint.model;

public enum CommandEnum {

    Q("Q", "Quit"),
    L("L", "Line"),
    R("R", "Rectangle"),
    B("B", "Bucket painting"),
    C("C", "Create canvas");

    private String type;
    private String meaning;

    CommandEnum(String type, String meaning) {
        this.type = type;
        this.meaning = meaning;
    }

    public String getType() {
        return type;
    }

    public String getMeaning() {
        return meaning;
    }
}
