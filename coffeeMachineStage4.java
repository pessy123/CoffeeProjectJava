/*Buy, fill, take!
 Medium
 
Ternary operator
The while and do-while loops
The for-loop
Branching statements
Switch statement

Description
Let's simulate an actual coffee machine! What do we need for that? This coffee machine will have a limited supply of water, milk, coffee beans, and disposable cups. Also, it will calculate how much money it gets for selling coffee.

There are several options for the coffee machine we want you to implement: first, it should sell coffee. It can make different types of coffee: espresso, latte, and cappuccino. Of course, each variety requires a different amount of supplies, however, in any case, you will need only one disposable cup for a drink. Second, the coffee machine must get replenished by a special worker. Third, another special worker should be able to take out money from the coffee machine.

Objectives
Write a program that offers to buy one cup of coffee or to fill the supplies or to take its money out. Note that the program is supposed to do one of the mentioned actions at a time. It should also calculate the amounts of remaining ingredients and how much money is left. Display the quantity of supplies before and after purchase.

First, your program reads one option from the standard input, which can be "buy", "fill", "take". If a user wants to buy some coffee, the input is "buy". If a special worker thinks that it is time to fill out all the supplies for the coffee machine, the input line will be "fill". If another special worker decides that it is time to take out the money from the coffee machine, you'll get the input "take".
If the user writes "buy" then they must choose one of three types of coffee that the coffee machine can make: espresso, latte, or cappuccino.
For one espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
For a latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
And for a cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee beans. It costs $6.
If the user writes "fill", the program should ask them how much water, milk, coffee and how many disposable cups they want to add into the coffee machine.
If the user writes "take" the program should give all the money that it earned from selling coffee.
At the moment, the coffee machine has $550, 400 ml of water, 540 ml of milk, 120 g of coffee beans, and 9 disposable cups.

To sum up, your program should print the coffee machine's state, process one query from the user, as well as print the coffee machine's state after that. Try to use functions for implementing every action that the coffee machine can do.
*/

import java.util.Scanner;

public class CoffeeMachine {

    public static void print(int water, int milk, int beans, int cups, int money) {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }

    public static void buy(Scanner scanner, int water, int milk, int beans, int cups, int money) {
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        int type = scanner.nextInt();

        switch (type) {
            case 1: // espresso
                water -= 250;
                beans -= 16;
                cups -= 1;
                money += 4;
                break;
            case 2: // latte
                water -= 350;
                milk -= 75;
                beans -= 20;
                cups -= 1;
                money += 7;
                break;
            case 3: // cappuccino
                water -= 200;
                milk -= 100;
                beans -= 12;
                cups -= 1;
                money += 6;
                break;
            default:
                System.out.println("Unknown coffee type");
                break;
        }

        System.out.println();
        print(water, milk, beans, cups, money);
    }

    public static void fill(Scanner scanner, int water, int milk, int beans, int cups, int money) {
        System.out.print("Write how many ml of water do you want to add: ");
        water += scanner.nextInt();
        System.out.print("Write how many ml of milk do you want to add: ");
        milk += scanner.nextInt();
        System.out.print("Write how many grams of coffee beans do you want to add: ");
        beans += scanner.nextInt();
        System.out.print("Write how many disposable cups of coffee do you want to add: ");
        cups += scanner.nextInt();

        System.out.println();
        print(water, milk, beans, cups, money);
    }

    public static void take(int water, int milk, int beans, int cups, int money) {
        System.out.printf("I gave you %s$\n", money);
        money = 0;

        System.out.println();
        print(water, milk, beans, cups, money);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int water = 400;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int money = 550;

        print(water, milk, beans, cups, money);
        System.out.println();

        System.out.print("Write action (buy, fill, take): ");
        String command = scanner.next();

        switch (command) {
            case "buy":
                buy(scanner, water, milk, beans, cups, money);
                break;
            case "fill":
                fill(scanner, water, milk, beans, cups, money);
                break;
            case "take":
                take(water, milk, beans, cups, money);
                break;
            default:
                System.out.println("Unknown command");
                break;
        }
    }
}
