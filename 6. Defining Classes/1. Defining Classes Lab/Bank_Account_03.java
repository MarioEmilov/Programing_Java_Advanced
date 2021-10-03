public class Bank_Account_03 {
    private static int currentId = 1;
    private static double interestRate = 0.02;

    private int id;
    private double balance;

    public Bank_Account_03() {
        this.id = currentId++;
    }

    public static void setInterest(double interest) {
        Bank_Account_03.interestRate = interest;
    }

    public double getInterest(int years) {
        return this.balance * years * interestRate;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getId() {
        return id;
    }
}
