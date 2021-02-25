package budget.controler;

import budget.repository.PersistentRepository;

import java.io.*;

public class PersistentController implements PersistentRepository {
    @Override
    public void save(BudgetManager budgetManager) {
                try {
                    FileOutputStream fos = new FileOutputStream("purchases.txt");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(budgetManager);
                    oos.flush();
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        System.out.println("\nPurchases were saved!");
    }

    @Override
    public BudgetManager load() {
        BudgetManager budgetManager = null;
        try {
            FileInputStream fis = new FileInputStream("purchases.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            budgetManager = (BudgetManager) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("\nPurchases were loaded!");
        return budgetManager;
    }
}
