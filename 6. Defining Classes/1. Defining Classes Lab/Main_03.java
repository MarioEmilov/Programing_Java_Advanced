import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Bank_Account_03> vault = new HashMap<>();

        String[] tokens = scanner.nextLine().split("\\s+");
        while (!tokens[0].equals("End")) {

            String output = null;
            switch (tokens[0]) {

                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    int amount = Integer.parseInt(tokens[2]);
                    if (vault.containsKey(id)) {
                        vault.get(id).deposit(amount);
                        output = String.format("Deposited %d to ID%d", amount, id);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double newInterest = Double.parseDouble(tokens[1]);
                    Bank_Account_03.setInterest(newInterest);
                    break;
                case "GetInterest":
                    id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    if (vault.containsKey(id)) {
                        double interest = vault.get(id).getInterest(years);
                        output = String.format("%.2f", interest);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                default:
                    Bank_Account_03 bankAccount = new Bank_Account_03();
                    vault.put(bankAccount.getId(), bankAccount);
                    output = "Account ID" + bankAccount.getId() + " created";
                    break;
            }

            if (output != null) {
                System.out.println(output);
            }

            tokens = scanner.nextLine().split("\\s+");
        }
    }
}
