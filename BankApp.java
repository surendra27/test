import java.lang.*;

class Account
{
    private int balance;
    Account()
    {
        balance=200;
    }
   /* synchronized public int getBalance()
    {
        return balance;
    }
    synchronized public void withdraw(int amt)
    {
        balance-=amt;
    }
    synchronized public void deposit(int amt)
    {
        balance+=amt;
    }
    synchronized public void transfer(Account dest,int amt)
    {
        this.withdraw(amt);
        try {
            Thread.sleep(400);
        } catch (Exception e) {

        }
        dest.deposit(amt);
    }*/
    public int getBalance()
    {
        return balance;
    }
    public void withdraw(int amt)
    {
        balance-=amt;
    }
    public void deposit(int amt)
    {
        balance+=amt;
    }
    public void transfer(Account dest,int amt)
    {
        this.withdraw(amt);
        try {
            Thread.sleep(400);
        } catch (Exception e) {

        }
        dest.deposit(amt);
    }
}




public class BankApp extends Thread
{
    public Account A,B;
    public static void main(String args[])
    {
       BankApp bank=new BankApp();
       bank.A=new Account();
       bank.B=new Account();
       System.out.println("Balance of A[before transfer] : " + bank.A.getBalance());
       System.out.println("Balance of B[before transfer] : " + bank.B.getBalance());
       synchronized(bank)
       {
         bank.start();
       }

       try {
           Thread.sleep(200);
       } catch (Exception e) {

       }
       System.out.println("Balance of A[during transfer] : " + bank.A.getBalance());
       System.out.println("Balance of B[during transfer] : " + bank.B.getBalance());
    }
    public void run()
    {
      A.transfer(B,100);
      System.out.println("Balance of A[after transfer] : " + A.getBalance());
      System.out.println("Balance of B[after transfer] : " + B.getBalance());
    }
}