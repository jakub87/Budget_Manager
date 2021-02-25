package budget;

public class Menu {
    public static void main() {
        System.out.println("\nChoose your action:");
        System.out.println("1) Add income");
        System.out.println("2) Add purchase");
        System.out.println("3) Show list of purchases");
        System.out.println("4) Balance");
        System.out.println("5) Save");
        System.out.println("6) Load");
        System.out.println("7) Analyze (Sort)");
        System.out.println("0) Exit");
    }

    private static void subMenu() {
        System.out.println("\nChoose the type of purchase");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
    }

    public static void purchaseType() {
        subMenu();
        System.out.println("5) Back");
    }

    public static void purchaseList() {
        subMenu();
        System.out.println("5) All");
        System.out.println("6) Back");
    }

    public static void sorting() {
        System.out.println("\n1) Sort all purchases");
        System.out.println("2) Sort by type");
        System.out.println("3) Sort certain type");
        System.out.println("4) Back");
    }

    public static void sortingCertainType() {
        subMenu();
    }
}
