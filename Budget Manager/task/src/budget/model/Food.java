package budget.model;

public class Food extends Purchase{
    @Override
    public void display() {
        System.out.println("\nFood:");
        super.display();
    }
}
