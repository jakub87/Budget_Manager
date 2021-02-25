package budget.model;

public class Entertainment extends Purchase{
    @Override
    public void display() {
        System.out.println("\nEntertainment:");
        super.display();
    }
}
