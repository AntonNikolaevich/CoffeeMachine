package machine;


public class Machine {

    private int water;
    private int milk;
    private int beans;
    private int cup;
    private int money;

    public Machine() {
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.cup = 9;
        this.money = 550;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getCup() {
        return cup;
    }

    public void setCup(int cup) {
        this.cup = cup;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getBeans() {
        return beans;
    }

    public void setBeans(int beans) {
        this.beans = beans;
    }

    protected void getInfo() {
        System.out.printf("The coffee machine has:%n" +
                "%d ml of water %n" +
                "%d ml of milk %n" +
                "%d g of coffee beans %n" +
                "%d disposable cups %n" +
                "$%d of money%n%n", getWater(),getMilk(),getBeans(),getCup(),getMoney());
    }

}
