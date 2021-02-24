package budget.strategies;

import budget.model.Product;

import java.util.List;

public interface SortingCertainTypeStrategy {
    void certainType(List<Product> productList);
}
