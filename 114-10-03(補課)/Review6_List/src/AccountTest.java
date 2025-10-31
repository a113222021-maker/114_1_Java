import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        List<Account> customers = new ArrayList<>();
        Account acc1 = new Account("A001", "Alice", 5000);
        addCustomer(customers, acc1);
        Account acc2 = new Account("A002", "Bob", 3000); // 測試負初始餘額
        addCustomer(customers, acc2);
        Account acc3 = new Account("A003", "Charlie", -100);// 使用預設建構子
        addCustomer(customers, acc3);
        opperation(customers);
        // 顯示所有帳戶資訊
        //System.out.println("\n所有客戶帳戶資訊:");
        //printCustomerAccounts(customers);


    }
    public static void opperation(List<Account> customers) {
        Scanner scanner = new Scanner(System.in);
        Account selectAccount = null;
        int choice;
        do {
            menu();
            System.out.print("請選擇操作 (1-5): ");
            while (!scanner.hasNextInt()) {
                scanner.next(); // skip invalid input
            }
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("輸入帳戶號碼: ");
                    String accNum = scanner.next();
                    System.out.print("輸入擁有者姓名: ");
                    String ownerName = scanner.next();
                    System.out.print("輸入初始餘額: ");
                    double initialBalance = scanner.nextDouble();
                    Account newAccount = new Account(accNum, ownerName, initialBalance);
                    addCustomer(customers, newAccount);
                    break;
                case 2:
                    System.out.print("輸入要查詢的帳戶號碼: ");
                    String searchAccNum = scanner.next();
                    selectAccount = customerInaction(customers, searchAccNum);
                    if (selectAccount == null) {
                        System.out.println("找不到該帳戶號碼的客戶。");
                        break;
                    }
                    System.out.println("\n指定客戶帳戶資訊:");
                    printCustomerInfo(selectAccount);
                    break;
                case 3:
                    System.out.println("\n所有客戶帳戶資訊:");
                    printCustomerAccounts(customers);
                    break;
                case 4:
                    System.out.print("輸入要刪除的帳戶號碼: ");
                    String delAccNum = scanner.next();
                    Account toDelete = customerInaction(customers, delAccNum);
                    if (toDelete == null) {
                        System.out.println("找不到該帳戶號碼的客戶，無法刪除。");
                    } else {
                        customers.remove(toDelete);
                        System.out.println("成功刪除帳戶: " + delAccNum);
                    }
                    break;
                case 5:
                    System.out.println("離開系統，謝謝使用!");
                    break;
                default:
                    System.out.println("無效選項，請重新選擇。");
            }
        } while (choice != 5);
        scanner.close();
    }
    public static Account customerInaction(List<Account> customers, String accountNumber) {
        for (Account acct : customers) {
            if (acct.getAccountNumber().equals(accountNumber)) {
                return acct;
            }
        }
        return null;
    }
    public static void addCustomer(List<Account> customers, Account newAccount) {
        customers.add(newAccount);
        System.out.println("成功新增客戶帳戶: " + newAccount.getAccountNumber());
    }
    public static void printCustomerAccounts(List<Account> customers) {
        if (customers.isEmpty()) {
            System.out.println("目前沒有任何客戶帳戶資料。");
            return;
        }
        for (Account acct : customers) {
            printCustomerInfo(acct);
        }
    }
    public static void deleteCustomer(List<Account> customers, String accountNumber) {
        for(int i=0;i<customers.size();i++){
            if(customers.get(i).getAccountNumber().equals(accountNumber)){
                customers.remove(i);
                System.out.println("成功刪除帳戶: " + accountNumber);
                return;
            }
        }
    }
    public static void printCustomerInfo(Account account) {
        if(account==null){
            System.out.println("無此帳戶資料");
            return;
        }
        System.out.println("帳戶號碼: " + account.getAccountNumber() +
                ", 擁有者: " + account.getOwnerName() +
                ", 餘額: " + account.getBalance());
    }
    //功能選單 (1.新增客戶帳戶 2.列印指定客戶帳戶資訊 3.顯示所有客戶帳戶資訊 4.刪除帳戶 5.離開系統)
    public static  void menu() {
        System.out.println("功能選單");
        System.out.println("1. 新增客戶帳戶");
        System.out.println("2. 列印指定客戶帳戶資訊");
        System.out.println("3. 顯示所有客戶帳戶資訊");
        System.out.println("4. 刪除帳戶");
        System.out.println("5. 離開系統");

    }
}
