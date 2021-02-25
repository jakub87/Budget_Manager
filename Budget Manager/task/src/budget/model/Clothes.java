package budget.model;

public class Clothes extends Purchase {
    @Override
    public void display() {
        System.out.println("\nClothes:");
        super.display();
    }
}
