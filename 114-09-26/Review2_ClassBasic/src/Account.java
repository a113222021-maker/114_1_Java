public class Account {
    private String accountNumber;
    private double balance;

    /**
     * 建構子，初始化帳戶號碼和初始餘額
     *
     * @param accountNumber  帳戶號碼
     * @param initialBalance 初始餘額
     */
    public Account (String accountNumber, double initialBalance) {

        this.setAccountNumber(accountNumber);
        try{
             this.setBalance(initialBalance);
        } catch (IllegalArgumentException e){

            System.out.println("初始餘額錯誤: " + e.getMessage());

        }

    }

    /**
     * 取得帳戶號碼
     *
     * @return 帳戶號碼
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * 取得帳戶餘額
     *
     * @return 帳戶餘額
     */
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance){
    if (balance > 0)
    {
        this .balance = balance;
    }
    else

    {
        throw new IllegalArgumentException("存款金額必須大於零");
    }
    }

    private void setAccountNumber(String accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    /**
     * 存款方法，將指定金額存入帳戶
     * @param amount 存款金額，必須大於零
     * @throws IllegalArgumentException 如果存款金額小於或等於零，則拋出例外
     */
    public void deopsit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("存款金額必須大於零");
        }
    }
    /**
     * 提款方法，從帳戶中提取指定金額
     * @param amount 提款金額，必須大於零且小於或等於帳戶餘額
     * @throws IllegalArgumentException 如果提款金額小於或等於零，或超過帳戶餘額，則拋出例外
     */
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("提款金額必須大於零且小於或等於帳戶餘額");
        }
    }
}






