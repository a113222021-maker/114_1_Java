import java.util.Currency;
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
            /*try {
                account1.deopsit(-1000.0);
            } catch (IllegalArgumentException e) {
                System.out.println("存款錯誤: " + e.getMessage());
            }




            //測試非法提款
            try {
                account1.withdraw(-2000.0);
            } catch (IllegalArgumentException e) {
                System.out.println("提款錯誤: " + e.getMessage());
            }*/
            try{
                account1.deopsit(100 , currency: "TWD");
                System.out.printf("初始餘額: %.2f%n", account1.getBalance(),account1.getAccountNumber());
            } catch (IllegalArgumentException e){
                System.out.println("存款錯誤: " + e.getMessage());
            }
            try{
                account2.deopsit(50 ,currency: "USD");
                System.out.printf("初始餘額: %.2f%n", account2.getBalance(),account2.getAccountNumber());
            } catch (IllegalArgumentException e){
                System.out.println("提款錯誤: " + e.getMessage());
            }






        }
}





