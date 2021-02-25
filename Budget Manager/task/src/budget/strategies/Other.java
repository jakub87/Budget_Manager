package budget.strategies;

import budget.model.Product;
import budget.staticService.Service;

import java.util.List;

public class Other implements SortingCertainTypeStrategy{
    @Override
    public void certainType(List<Product> productList) {
        System.out.println("\nOther");
        List <Product> otherList = Service.sort(productList);
        otherList.forEach(product -> System.out.println(product.getName() + " $" + product.getPrice()));
        System.out.println("Total sum: $" + Service.getSum(productList) + "\n");
    }
}
