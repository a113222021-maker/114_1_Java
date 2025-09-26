import java.util.Scanner;
public class AccountTest {
    public static void main(String[] args) {


        Account account1 = new Account("A009", 1000.0);
        Account account2 = new Account("A09", -2000.0);
        //System.out.printf("帳戶號碼: ", account1.getAccountNumber());
        //System.out.printf("初始餘額: ", account1.getBalance());


        // 顯示帳戶資訊

        System.out.printf("帳戶號碼: %s%n", account1.getAccountNumber(),account1.getBalance());
        System.out.printf("帳戶號碼: %s%n", account2.getAccountNumber(),account1.getBalance());

        account1.deopsit(500.0);
        System.out.printf("初始餘額: %.2f%n", account1.getBalance(),account1.getAccountNumber());
        account1.withdraw(1000.0);
        System.out.printf("初始餘額: %.2f%n", account1.getBalance());
        //測試非法存款
        try {
            account1.deopsit(-1000.0);
        } catch (IllegalArgumentException e) {
            System.out.println("存款錯誤: " + e.getMessage());
        }


        //測試非法提款
        try {
            account1.withdraw(2000.0);
        } catch (IllegalArgumentException e) {
            System.out.println("提款錯誤: " + e.getMessage());
        }






    }


    public class Account1 {
        private String accountNumber;
        private double balance;

        public Account1(String accountNumber, double balance) {
            this.accountNumber = accountNumber;
            setBalance(balance);
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double amount) {
            Scanner scanner = new Scanner(System.in);
            int attempts = 0;
            while (amount < 0 && attempts < 3) {
                System.out.print("金額不能為負數，請重新輸入：");
                amount = scanner.nextDouble();
                attempts++;
            }
            if (amount < 0) {
                throw new IllegalArgumentException("金額不合法，已超過三次嘗試。");
            }
            this.balance = amount;
        }

        public void deposit(double amount) {
            Scanner scanner = new Scanner(System.in);
            int attempts = 0;
            while (amount <= 0 && attempts < 3) {
                System.out.print("存款金額必須大於0，請重新輸入：");
                amount = scanner.nextDouble();
                attempts++;
            }
            if (amount <= 0) {
                throw new IllegalArgumentException("存款金額不合法，已超過三次嘗試。");
            }
            this.balance += amount;
        }

        public void withdraw(double amount) {
            Scanner scanner = new Scanner(System.in);
            int attempts = 0;
            while ((amount <= 0 || amount > balance) && attempts < 3) {
                System.out.print("提款金額必須大於0且小於等於餘額，請重新輸入：");
                amount = scanner.nextDouble();
                attempts++;
            }
            if (amount <= 0 || amount > balance) {
                throw new IllegalArgumentException("提款金額不合法，已超過三次嘗試。");
            }
            this.balance -= amount;
        }
    }

}
