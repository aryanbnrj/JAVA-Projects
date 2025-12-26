import java.util.Scanner;

public class Main {
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args){
        double balance = 0;
        boolean isRunning=true;
        int choice;
        while(isRunning){
            System.out.println("Banking System!!!");
            System.out.println("1.Show balance");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Exit");
            System.out.print("Enter your choice:");
            choice=scanner.nextInt();
            switch (choice) {
                case 1 -> System.out.println(balance);
                case 2 -> balance+=deposit();
                case 3 -> balance-=withdraw(balance);
                case 4 -> isRunning=false;
                default -> System.out.println("Invalid choice!");
            }





        }

    }
    static double deposit(){
        double amount;
        System.out.print("Enter the amount to be deposited:");
        amount=scanner.nextDouble();
        if(amount <0){
            System.out.println("Amount can't be negative");
            return 0;
        }
        else {
            return amount;
        }




    }
    static double withdraw(double balance){

        double amount;
        System.out.print("Enter the amount to be withdrawn:");
        amount=scanner.nextDouble();

        if(amount>balance){
            System.out.println("Insufficient funds!");
            return 0;
        }
        else if(amount<0){
            System.out.println("amount can't be negative");
            return 0;
        }
        else{
            return amount;
        }
    }

}
