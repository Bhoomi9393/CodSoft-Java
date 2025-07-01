import java.util.Scanner;
class BankAccount
{
    private double balance;
    public BankAccount(double initBal)
    {
        balance = initBal;
    }
    public double showBal()
    {
        return balance;
    }
    public boolean withdraw(double amount)
    {
        if (amount > 0 && amount <= balance)
        {
            balance -= amount;
            return true;
        }
        return false;
    }
    public boolean deposit(double amount)
    {
        if (amount > 0)
        {
            balance += amount;
            return true;
        }
        return false;
    }
}
public class atm
{
    private BankAccount account;
    private Scanner Sc;
    public atm(BankAccount account)
    {
        this.account = account;
        Sc = new Scanner(System.in);
    }

    private void checkBal()
    {
        System.out.printf("Your current balance is: Rs.%.2f%n%n", account.showBal());
    }
    private void withdraw()
    {
        System.out.println("Enter the amount you want to withdraw:");
        double amount = Sc.nextDouble();
        if(account.withdraw(amount))
        {
            System.out.println("Withdrawl Successful!");
        }
        else
        {
            System.out.println("Invalid Amount. Withdrawl failed!");
        }
    }
    private void deposit()
    {
        System.out.println("Enter the amount you want to deposit:");
        double amount = Sc.nextDouble();
        if(account.deposit(amount))
        {
            System.out.println("Deposit Successful!");
        }
        else
        {
            System.out.println("Invalid Amount. Deposit Failed!");
        }
    }

    public void start()
    {
        while (true)
        {
            System.out.println("------ ATM Menu ------");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");
            int choice = Sc.nextInt();

            switch (choice)
            {
                case 1: checkBal(); break;
                case 2: withdraw(); break;
                case 3: deposit(); break;
                case 4: System.out.println("Thankyou for using ATM");
                Sc.close(); return;
                default: System.out.println("Invalid Choice! Please Try Again.");
            }
        }
    }
    public static void main(String[] args) 
    {
        BankAccount userAccount = new BankAccount(100000);
        atm atm = new atm(userAccount);
        atm.start();
    }
}


