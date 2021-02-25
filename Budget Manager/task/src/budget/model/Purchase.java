package budget.model;

import budget.interfaces.PurchaseMethods;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Purchase implements PurchaseMethods {
    private Scanner scanner;
    public static BigDecimal balance = BigDecimal.ZERO;
    public static BigDecimal purchasesTotalSum = BigDecimal.ZERO;
    private BigDecimal purchasePrice = BigDecimal.ZERO;

    public static Map<String, BigDecimal> allPurchases;
    private Map<String, BigDecimal> purchases;

    public Purchase() {
        scanner = new Scanner(System.in);
        purchases = new LinkedHashMap<>();
        allPurchases = new LinkedHashMap<>();
    }

    @Override
    public boolean addPurchase() {
        System.out.println("\nEnter purchase name:");
        String purchase = scanner.nextLine();
        System.out.println("Enter its price:");
        BigDecimal price = new BigDecimal(scanner.nextLine());
        getPurchases().put(purchase, price);
        allPurchases.put(purchase, price);

        balance = balance.subtract(price);
        if (getBalance().compareTo(BigDecimal.ZERO) < 0) {
            setBalance(BigDecimal.ZERO);
        }
        purchasesTotalSum = purchasesTotalSum.add(price);
        purchasePrice = purchasePrice.add(price);
        System.out.println("Purchase was added!");
        return true;
    }

    @Override
    public void display() {
        if (getPurchases().isEmpty()) {
            System.out.println("Purchase list is empty!");
        } else {
            getPurchases().forEach((product, price) -> System.out.println(product + " $" + getPurchasePrice().setScale(2, RoundingMode.HALF_EVEN)));
            System.out.println("Total sum: $" + getPurchasePrice().setScale(2, RoundingMode.HALF_EVEN));
        }
    }

    public static void setBalance(BigDecimal balance) {
        Purchase.balance = balance;
    }

    public static BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public Map<String, BigDecimal> getPurchases() {
        return purchases;
    }

    @Override
    public boolean addIncome() {
        System.out.println("\nEnter income:");
        int income = Integer.parseInt(scanner.nextLine());
        BigDecimal currentMoney = getBalance();
        setBalance(currentMoney.add(BigDecimal.valueOf(income)));
        System.out.println("Income was added!");
        return true;
    }

    @Override
    public void showBalance() {
        System.out.println("\nBalance: $" + getBalance().setScale(2, RoundingMode.HALF_EVEN));
    }
    }