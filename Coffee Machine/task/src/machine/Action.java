package machine;

import coffee.Cappuccino;
import coffee.Espresso;
import coffee.Latte;

import java.util.Scanner;

public class Action {
    Scanner scanner = new Scanner(System.in);
    private String action;
    private boolean enoughStock;
    Machine machine = new Machine();



    protected void chooseAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        action = scanner.next();
    }

    protected void processTheAction() {
        chooseAction();
        switch (action) {
            case "buy":
                buyCoffee();
                processTheAction();
                break;
            case "fill":
                fillSupplies();
                processTheAction();
                break;
            case "take":
                System.out.printf("I gave you $%d%n", machine.getMoney());
                machine.setMoney(0);
                processTheAction();
                break;
            case "remaining":
                machine.getInfo();
                processTheAction();
                break;
            case "exit":
                break;
        }
    }

    private void calculateRemainders(int water, int milk, int beans, int money) {
        machine.setWater(machine.getWater() - water);
        machine.setMilk(machine.getMilk() - milk);
        machine.setBeans(machine.getBeans() - beans);
        machine.setCup(machine.getCup() - 1);
        machine.setMoney(machine.getMoney() + money);
    }

    private void checkRemainders(int water, int milk, int beans) {
        if (machine.getWater() < water) {
            System.out.println("Sorry, not enough water!");
            enoughStock = false;
        } else if (machine.getMilk() < milk) {
            System.out.println("Sorry, not enough milk!");
            enoughStock = false;
        } else if (machine.getBeans() < beans) {
            System.out.println("Sorry, not enough coffee beans!");
            enoughStock = false;
        } else if (machine.getCup() < 1) {
            System.out.println("Sorry, not enough cups!");
            enoughStock = false;
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            enoughStock = true;
        }
    }

    private void buyCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        switch (scanner.next()) {
            case "1":
                Espresso espresso = new Espresso();
                checkRemainders(espresso.getWater(), espresso.getMilk(), espresso.getBeans());
                if (enoughStock) {
                    calculateRemainders(espresso.getWater(), espresso.getMilk(), espresso.getBeans(), espresso.getPrice());
                }
                break;

            case "2":
                Latte latte = new Latte();
                checkRemainders(latte.getWater(), latte.getMilk(), latte.getBeans());
                if (enoughStock) {
                    calculateRemainders(latte.getWater(), latte.getMilk(), latte.getBeans(), latte.getPrice());
                }
                break;
            case "3":
                Cappuccino cappuccino = new Cappuccino();
                checkRemainders(cappuccino.getWater(), cappuccino.getMilk(), cappuccino.getBeans());
                if (enoughStock) {
                    calculateRemainders(cappuccino.getWater(), cappuccino.getMilk(), cappuccino.getBeans(), cappuccino.getPrice());
                }
                break;
            case "back":
                break;

        }

    }

    protected void fillSupplies() {
        System.out.println("Write how many ml of water you want to add: ");
        machine.setWater(machine.getWater() + scanner.nextInt());
        System.out.println("Write how many ml of milk you want to add: ");
        machine.setMilk(machine.getMilk() + scanner.nextInt());
        System.out.println("Write how many grams of coffee beans you want to add: ");
        machine.setBeans(machine.getBeans() + scanner.nextInt());
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        machine.setCup(machine.getCup() + scanner.nextInt());
    }
}
