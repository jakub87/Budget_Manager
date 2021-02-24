package budget;

import budget.controler.BudgetManager;
import budget.controler.PersistentController;
import budget.model.Type;
import budget.strategies.All;
import budget.strategies.Clothes;
import budget.strategies.Entertainment;
import budget.strategies.Food;
import budget.strategies.Other;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mainMenuSelect;

        BudgetManager budgetManager = new BudgetManager();
        PersistentController persistentController = new PersistentController();

        do {
            Menu.main();
            mainMenuSelect = Integer.parseInt(scanner.nextLine());
            System.out.println();
            if (mainMenuSelect == 1) {
                System.out.println("Enter income:");
                BigDecimal income = BigDecimal.valueOf(Long.parseLong(scanner.nextLine()));
                budgetManager.setBalance(income);
                System.out.println("Income was added!");
            } else if (mainMenuSelect == 2) {
                int productTypeSelect;
                do {
                    Menu.purchaseType();
                    productTypeSelect = Integer.parseInt(scanner.nextLine());
                    if (productTypeSelect == 1) {
                        budgetManager.addPurchase(Type.FOOD);
                    } else if (productTypeSelect == 2) {
                        budgetManager.addPurchase(Type.CLOTHES);
                    } else if (productTypeSelect == 3) {
                        budgetManager.addPurchase(Type.ENTERTAINMENT);
                    } else if (productTypeSelect == 4) {
                        budgetManager.addPurchase(Type.OTHER);
                    }
                } while (productTypeSelect != 5);
            } else if (mainMenuSelect == 3) {
                int productShowList;
                do {
                    Menu.purchaseList();
                    productShowList = Integer.parseInt(scanner.nextLine());
                    if (productShowList == 1) {
                        budgetManager.showListPurchases(Type.FOOD);
                    } else if (productShowList == 2) {
                        budgetManager.showListPurchases(Type.CLOTHES);
                    } else if (productShowList == 3) {
                        budgetManager.showListPurchases(Type.ENTERTAINMENT);
                    } else if (productShowList == 4) {
                        budgetManager.showListPurchases(Type.OTHER);
                    } else if (productShowList == 5) {
                        budgetManager.showListPurchases(Type.ALL);
                    }
                } while(productShowList != 6);
            } else if (mainMenuSelect == 4) {
                System.out.println("Balance: $" + budgetManager.getBalance());
            } else if (mainMenuSelect == 5) {
                persistentController.save(budgetManager);
            } else if (mainMenuSelect == 6) {
                budgetManager = persistentController.load();
            } else if (mainMenuSelect == 7) {
                int sortingSelect;
                do {
                    Menu.sorting();
                    sortingSelect = Integer.parseInt(scanner.nextLine());
                    if (sortingSelect == 1) {
                        if (budgetManager.getAllProducts().isEmpty()) {
                            System.out.println("\nThe purchase list is empty!");
                        } else {
                            budgetManager.setSortingCertainTypeStrategy(new All());
                            budgetManager.printSort(budgetManager.getAllProducts());
                        }
                    } else if (sortingSelect == 2) {
                        budgetManager.sortByType();
                    } else if(sortingSelect == 3) {
                        Menu.sortingCertainType();
                        int sortingCertainTypeSelect = Integer.parseInt(scanner.nextLine());
                        if (sortingCertainTypeSelect == 1) {
                            if (budgetManager.getFoodProducts().isEmpty()) {
                                System.out.println("\nThe purchase list is empty!");
                            } else {
                                budgetManager.setSortingCertainTypeStrategy(new Food());
                                budgetManager.printSort(budgetManager.getFoodProducts());
                            }
                        } else if (sortingCertainTypeSelect == 2) {
                            if (budgetManager.getClothesProducts().isEmpty()) {
                                System.out.println("\nThe purchase list is empty!");
                            } else {
                                budgetManager.setSortingCertainTypeStrategy(new Clothes());
                                budgetManager.printSort(budgetManager.getClothesProducts());
                            }
                        } else if (sortingCertainTypeSelect == 3) {
                            if (budgetManager.getEntertainmentProducts().isEmpty()) {
                                System.out.println("\nThe purchase list is empty!");
                            } else {
                                budgetManager.setSortingCertainTypeStrategy(new Entertainment());
                                budgetManager.printSort(budgetManager.getEntertainmentProducts());
                            }
                        } else if (sortingCertainTypeSelect == 4) {
                            if (budgetManager.getOtherProducts().isEmpty()) {
                                System.out.println("\nThe purchase list is empty!");
                            } else {
                                budgetManager.setSortingCertainTypeStrategy(new Other());
                                budgetManager.printSort(budgetManager.getOtherProducts());
                            }
                        }
                    }
                }while (sortingSelect != 4);
            }
        }while (mainMenuSelect != 0) ;
        System.out.println("Bye!");
        }
    }
