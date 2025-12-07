import java.util.Random;
import java.util.Scanner;

public class ATM 
{

    private String account_num;
    private String acc_holder;
    private String pin;
    private double balance;




    public ATM(String account_num,String acc_holder,String pin,double balance )
    {
        this.account_num = account_num;
        this.acc_holder = acc_holder;
        this.pin = pin;
        this.balance = balance;
    }

    public String get_acc_num()
    {
        return account_num;
    }

    public String get_acc_holder()
    {
        return acc_holder;
    }

    public String get_pin()
    {
        return pin;
    }

    public double balance()
    {
        return balance;
    }

    //for withdraw

    public boolean withdraw(double amount)
    {
        if(amount<=0)
        {
            System.out.println("Enter a valid amount...");
            return false;
        }

        if(balance() < amount)
        {
            System.out.println("Insuffient Funds!");
            return false;
        }

        balance = balance() - amount;
        return true;
    }

    //to check the balance

    public double check_balance()
    {
        return balance();
    }

    public void deposite(double amount)
    {
        if(amount <= 0)
        {
            System.out.println("Deposite starts from 1");
            return;
        }

        balance = balance() + amount;
    }

    public  boolean login_page(Scanner sc)
    {
        System.out.println("=== Login Page ===");

        System.out.print("Enter Account Number : ");
        String log_acc_num = sc.nextLine();


        System.out.print("Enter the PIN: ");
        String log_pin = sc.nextLine();

        if(account_num.equals(log_acc_num) && pin.equals(log_pin) ){
            System.out.println("Account Login Successfully");
            return true;
        }
        System.out.println("Login credentials Failed!");
        return false;
    }

    public void atm_menu()
    {
        System.out.println("===== ATM Menu =====");
        System.out.println("1. Check Balnace");
        System.out.println("2. Deposite");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }


    public static void main(String[] args) 
    {
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name :");
        String user_name = sc.nextLine();
        
        System.out.println("Set a pin :");
        String acc_pin = sc.nextLine();

        int acc_num = rd.nextInt(100000000);

        String str_acc_num = String.valueOf(acc_num);

        System.out.println("Your Account is Created SuccessFully");
        System.out.println("Account Number :" + acc_num);
        System.out.println("Default Balance : 1000");

        ATM atm = new ATM(str_acc_num,user_name,acc_pin,1000);


        System.out.flush();

         

        atm.login_page(sc);

        if(atm.login_page(sc)){
        atm.atm_menu();

        boolean isValid = true;
        while(isValid)
            {
            System.out.print("Enter your Choice: ");
            int choice = sc.nextInt();

        switch (choice) 
        {
            case 1:
               System.out.println("Account Balance : "+atm.check_balance());
                break;
            
            case 2:
                System.out.println("Enter the amount:");
                double n = sc.nextDouble();
                atm.deposite(n);
                break;
                
            case 3:
                System.out.println("Enter the amount:");
                double k = sc.nextDouble();
                atm.withdraw(k);
                break;
            case 4:
                System.out.println("Thank you from your mini ATM😊");
                System.out.println("Have a nice day");
                break;
            default:
                System.out.println("Invalid Choice...");
                break;
        }

        if(choice == 4){
            isValid = false;
        }
    }
}
        sc.close();

    }

}
