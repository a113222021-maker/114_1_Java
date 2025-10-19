public class AccountTest {
    public static  int CustomerCount; //帳戶數量統計
    public static  void main(String[] args) {
        Account[] customers = new Account[10];
        Account acc1 = new Account("A001", "Alice", 5000);
        addCustomer(customers, acc1);
        Account acc2 = new Account("A002", "Bob", 3000); // 測試負初始餘額
        addCustomer(customers, acc2);
        Account acc3 = new Account("A003", "Charlie", -100);// 使用預設建構子
        addCustomer(customers, acc3);
        // 顯示所有帳戶資訊
        System.out.println("\n所有客戶帳戶資訊:");
        printCustomerAccounts(customers);


    }
    public static void addCustomer(Account[] customers, Account newAccount) {
        if (CustomerCount < customers.length) {
            customers[CustomerCount] = newAccount;
            CustomerCount++;
            System.out.println("成功新增客戶帳戶: " + newAccount.getAccountNumber());
            return;
        }
            System.out.println("無法新增更多客戶，已達上限。");

    }
    public static void printCustomerAccounts(Account[] customers) {
        for (int i = 0; i < CustomerCount; i++) {
            printCustomerInfo(customers[i]);
        }
    }
    public static void printCustomerInfo(Account account) {
        System.out.println("帳戶號碼: " + account.getAccountNumber() +
                           ", 擁有者: " + account.getOwnerName() +
                           ", 餘額: " + account.getBalance());
    }
}
