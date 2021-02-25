package budget.staticService;

import budget.model.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Service {
    public static List<Product> sort(List<Product> productList) {
        return productList.stream()
                   .sorted(Comparator.comparing(Product::getPrice).reversed())
                   .collect(Collectors.toList());
    }

    public static BigDecimal getSum(List<Product> productList) {
                BigDecimal totalSum = Optional.ofNullable(productList.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.UNNECESSARY)).orElse(BigDecimal.ZERO);
        if (totalSum.compareTo(new BigDecimal(0.00)) == 0) {
            totalSum = BigDecimal.ZERO;
        }
        return totalSum;
    }
}
