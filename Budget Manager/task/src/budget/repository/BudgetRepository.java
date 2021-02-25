package budget.repository;

import budget.model.Type;

import java.math.BigDecimal;

public interface BudgetRepository {
    boolean addIncome(BigDecimal income);
    boolean addPurchase(Type type);
    void showListPurchases(Type type);
}
