package budget.model;

public class Other extends Purchase {
    @Override
    public void display() {
        System.out.println("\nOther:");
        super.display();
    }
}
