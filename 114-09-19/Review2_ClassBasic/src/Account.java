public class Account {
    private  String accountNumber;
    private double balance;
    public Account(String accountNumber, double initialBalance)
    {
        this.accountNumber = accountNumber;
            this.balance = initialBalance;
    }
    public String getAccountNumber()
    {
        return accountNumber;
    }
    public double getBalance()
    {
        return balance;
    }
public void deposit(double amount)
{
    if (amount > 0)
    {
        balance += amount;
    }
    else
    {
        System.out.println("存款金額必須大於零");
    }
}
public void withdraw(double amount)
{
    if (amount > 0)
    {
        if (amount <= balance)
        {
            balance -= amount;
        }
        else
        {
            System.out.println("餘額不足");
        }
    }
    else
    {
        System.out.println("提款金額必須大於零");
    }
}
}



