package budget.repository;

import budget.controler.BudgetManager;
import budget.repository.BudgetRepository;

public interface PersistentRepository {
    void save(BudgetManager budgetManager);
    BudgetManager load();
}
