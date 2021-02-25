package budget.model;

public enum Type {
    FOOD ("Food"),
    CLOTHES("Clothes"),
    OTHER("Other"),
    ENTERTAINMENT("Entertainment"),
    ALL("all");

    String name;

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
