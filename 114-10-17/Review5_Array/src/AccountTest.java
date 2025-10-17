public class AccountTest {
    private  static int customerCount;
    public static void main(String[] args) {
        Account[] accounts = new Account[10];
        Account acc1 = new Account("A001", 5000.0 );
        addCustomer(accounts, acc1);
        Account acc2 = new Account("A002", 3000.0);
        addCustomer(accounts, acc2);
        Account acc3 = new Account("A003", 7000.0);
        addCustomer(accounts, acc3);

        // 顯示所有帳戶資訊
        System.out.println("所有帳戶資訊:");

        for (int i = 0; i < customerCount; i++) {
            Account acc = accounts[i];
            System.out.printf("帳戶號碼: %s, 餘額: %.2f%n", acc.getAccountNumber(), acc.getBalance());
        }

}
public static  void addCustomer(Account[] customers, Account NewAccount) {

   if (customerCount<customers.length) {
         customers[customerCount] = NewAccount;
            customerCount++;
       System.out.println("成功新增帳戶: " + NewAccount.getAccountNumber());
       return;
}
    System.out.println("無法新增帳戶，已達上限");
}
public static  void printCustomerCount(Account [] customers) {
    for(int i=0; i<customers.length; i++) {
        if (customers[i] != null) {
            System.out.println("帳戶號碼: " + customers[i].getAccountNumber());
        }
    }

}
}
