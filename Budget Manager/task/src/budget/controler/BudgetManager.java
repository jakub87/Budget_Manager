package budget.controler;

import budget.model.Product;
import budget.model.Type;
import budget.repository.BudgetRepository;
import budget.staticService.Service;
import budget.strategies.SortingCertainTypeStrategy;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class BudgetManager implements Serializable, BudgetRepository {
    private List<Product> foodProducts;
    private List<Product> clothesProducts;
    private List<Product> entertainmentProducts;
    private List<Product> otherProducts;
    private List<Product> allProducts;
    private BigDecimal balance;
    private SortingCertainTypeStrategy sortingCertainTypeStrategy;

    public void setSortingCertainTypeStrategy(SortingCertainTypeStrategy sortingCertainTypeStrategy) {
        this.sortingCertainTypeStrategy = sortingCertainTypeStrategy;
    }

    public void printSort(List<Product> productList) {
        sortingCertainTypeStrategy.certainType(productList);
    }

    public List<Product> getFoodProducts() {
        return foodProducts;
    }

    public List<Product> getClothesProducts() {
        return clothesProducts;
    }

    public List<Product> getEntertainmentProducts() {
        return entertainmentProducts;
    }

    public List<Product> getOtherProducts() {
        return otherProducts;
    }

    public List<Product> getAllProducts() {
        return allProducts;
    }

    public BudgetManager() {
        foodProducts = new ArrayList<>();
        clothesProducts = new ArrayList<>();
        entertainmentProducts = new ArrayList<>();
        otherProducts = new ArrayList<>();
        allProducts = new ArrayList<>();
        balance = BigDecimal.ZERO;
    }

    public BigDecimal getBalance() {
        return balance.setScale(2, RoundingMode.HALF_EVEN);
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public boolean addIncome(BigDecimal income) {
        setBalance(getBalance().add(income));
        return true;
    }

    @Override
    public boolean addPurchase(Type type) {
        System.out.println("\nEnter purchase name:");
        String productName = new Scanner(System.in).nextLine();
        System.out.println("Enter its price:");
        BigDecimal productPrice = new Scanner(System.in).nextBigDecimal().setScale(2);
        if (type == Type.FOOD) {
            foodProducts.add(new Product(productName, productPrice));
        } else if (type == Type.ENTERTAINMENT) {
            entertainmentProducts.add(new Product(productName, productPrice));
        } else if (type == Type.CLOTHES) {
            clothesProducts.add(new Product(productName, productPrice));
        } else if (type == Type.OTHER) {
            otherProducts.add(new Product(productName, productPrice));
        }
        allProducts.add(new Product(productName, productPrice));
        setBalance(balance.subtract(productPrice));
        System.out.println("Purchase was added!");
        return true;
    }

    @Override
    public void showListPurchases(Type type) {
        List<Product> products = new ArrayList<>();
        if (type == Type.FOOD) {
            products = foodProducts;
        } else if (type == Type.ENTERTAINMENT) {
            products = entertainmentProducts;
        } else if (type == Type.CLOTHES) {
            products = clothesProducts;
        } else if (type == Type.OTHER) {
            products = otherProducts;
        } else if (type == Type.ALL){
            products = allProducts;
        }

        if (products.isEmpty()) {
            System.out.println("\nPurchase list is empty!");
        } else {
            System.out.println("\n" + type.getName() + ":");
            products.forEach(food -> System.out.println(food.getName() + " $" + food.getPrice().setScale(2, RoundingMode.HALF_EVEN)));
            System.out.println("Total sum: $" + Service.getSum(products));
        }
    }

    public void sortByType() {
        Map<Type, BigDecimal> types = new LinkedHashMap();
        types.put(Type.FOOD, Service.getSum(foodProducts));
        types.put(Type.ENTERTAINMENT, Service.getSum(entertainmentProducts));
        types.put(Type.CLOTHES, Service.getSum(clothesProducts));
        types.put(Type.OTHER, Service.getSum(otherProducts));

        Map<Type, BigDecimal> result = new LinkedHashMap<>();

        types.entrySet().stream()
                .sorted(Map.Entry.<Type, BigDecimal>comparingByValue()
                .reversed()).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        System.out.println("\nTypes:");
        result.forEach((type, bigDecimal) -> System.out.println(type.getName() + " - $" + bigDecimal));
        System.out.println("Total sum: $" + Service.getSum(allProducts));
    }
}
