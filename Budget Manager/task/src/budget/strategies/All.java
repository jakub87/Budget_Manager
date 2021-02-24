package budget.strategies;

import budget.model.Product;
import budget.staticService.Service;

import java.util.List;

public class All implements SortingCertainTypeStrategy{
    @Override
    public void certainType(List<Product> type) {
        System.out.println("\nAll");
        List <Product> allList = Service.sort(type);
        allList.forEach(product -> System.out.println(product.getName() + " $" + product.getPrice()));
        System.out.println("Total sum: $" + Service.getSum(type) + "\n");
    }
}
