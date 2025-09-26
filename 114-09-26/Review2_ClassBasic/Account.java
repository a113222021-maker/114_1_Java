import java.util.Scanner;

public class Account {
    private double balance;

    public void setBalance(double amount) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        while (attempts < 3) {
            if (amount >= 0) {
                this.balance = amount;
                return;
            } else {
                attempts++;
                if (attempts < 3) {
                    System.out.print("金額不合法，請重新輸入：");
                    amount = scanner.nextDouble();
                }
            }
        }
        throw new IllegalArgumentException("金額不合法，超過三次輸入機會");
    }

    public void deposit(double amount) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        while (attempts < 3) {
            if (amount > 0) {
                this.balance += amount;
                return;
            } else {
                attempts++;
                if (attempts < 3) {
                    System.out.print("存款金額不合法，請重新輸入：");
                    amount = scanner.nextDouble();
                }
            }
        }
        throw new IllegalArgumentException("存款金額不合法，超過三次輸入機會");
    }

    public void withdrawn(double amount) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        while (attempts < 3) {
            if (amount > 0 && amount <= this.balance) {
                this.balance -= amount;
                return;
            } else {
                attempts++;
                if (attempts < 3) {
                    System.out.print("提款金額不合法，請重新輸入：");
                    amount = scanner.nextDouble();
                }
            }
        }
        throw new IllegalArgumentException("提款金額不合法，超過三次輸入機會");
    }
}
