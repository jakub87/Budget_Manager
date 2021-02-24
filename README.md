# Budget-Manager from hyperskill.org

# Stage 1/5

## Description
First, let’s implement the counting of your purchases. It’s much easier to analyze when your expenses are presented as a list. Read data from the console and at the end show the list of all purchases and its total amount.
It should be displayed as follows: **Total: $23.00**

Your program should process every line the user inputs. To end the input, the user should type End-of-file symbol that tells your operating system that no more input will be provided. It's Ctrl+D on Linux and Mac and Ctrl+Z on Windows. Don't be scared: you don’t have to implement it yourself, this is a special built-in hot-key that gives the command to stop input. See for yourself!

## Example

The greater-than symbol followed by a space (> ) represents the user input. Notice that it's not part of the input.

```bash
> Almond 250gm $35.43
> LEGO DUPLO Town Farm Animals $10.10
> Sensodyne Pronamel Toothpaste $19.74
> Hershey's milk chocolate bars $8.54
> Gildan LT $8.61
Almond 250gm $35.43
LEGO DUPLO Town Farm Animals $10.10
Sensodyne Pronamel Toothpaste $19.74
Hershey's milk chocolate bars $8.54
Gildan LT $8.61

Total: $82.42
```

# Stage 2/5

## Description
Let's make your application more convenient. Only counting the expenses is a little bit sad, right?

To make your application flexible and functional, add a menu that consists of 4 items.

1. Add Income. We must track both our expenses and our income. When this item is selected, the program should ask to enter the amount of income.
2. Add Purchase. This item should add a purchase to the list. You have implemented this feature in the previous stage.
3. Show the list of purchases. This menu item should display a list of all expenses and incomes in the order they were made.
4. Balance. Show the balance.
5. Exit. Exit the program. Make this item under number 0, not number 5.

Notice, that the amount of remaining money cannot be negative. In this case, make the balance equal to $0.

When displaying the price or the total amount, print 2 numbers after the point.
Example: **$14.20**
Follow this rule in the next stages.

## Example

The greater-than symbol followed by a space (> ) represents the user input. Notice that it's not part of the input.

```bash
Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
0) Exit
> 1

Enter income:
> 1000
Income was added!

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
0) Exit
> 4

Balance: $1000.00

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
0) Exit
> 3

The purchase list is empty

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
0) Exit
> 2

Enter purchase name:
>Red Fuji Apple
Enter its price:
> 5.99
Purchase was added!

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
0) Exit
> 3

Red Fuji Apple $5.99
Total sum: $5.99

Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
0) Exit
> 0

Bye!
```