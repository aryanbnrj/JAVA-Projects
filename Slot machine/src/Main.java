
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        int balance=200;
        int bet = 0;
        int payout;
        String play;
        String[] row;
        System.out.println("***************************");
        System.out.println("Welcome to Slot machine!!");
        System.out.println("Symbols: 🍕 🍔 🍟 🌭 🍿");
        System.out.println("***************************");
        while (balance>0){
            System.out.println("Current Balance:"+balance+"₹");
            System.out.print("Enter the bet:");
            bet=scanner.nextInt();
            scanner.nextLine();
            if(bet>balance){
                System.out.println("Insufficient funds!!!");
                continue;
            }
            else if(bet<=0){
                System.out.println("Bet should be greater than 0");
                continue;
            }
            else{
                balance-=bet;
            }
            System.out.println("Spinning.......");
            row = spinRow();
            System.out.println("**********************");
            printRow(row);
            System.out.println("**********************");
            payout=getPayout(row,bet);
            if(payout>0){

                System.out.println("You won:"+payout+"₹");
                balance+=payout;
            }
            else {
                System.out.println("sorry better luck next time!!");}
            System.out.print("Do want to continue (Y/N):");
            play=scanner.nextLine().toUpperCase();
            if(!play.equals("Y")){
                break;
            }
            System.out.println("Game over your final balance is:"+balance+"₹");


        }


        scanner.close();
    }
    static String[] spinRow(){
        String[] symbols={"🍕", "🍔", "🍟", "🌭","🍿"};
        String[] row= new String[3];
        Random random= new Random();

        for(int i=0;i<3;i++){
            row[i]=symbols[random.nextInt(5)];}
        return row;
    }
    static void printRow(String[] row){
        System.out.println(" "+String.join(" | ",row));
    }
    static int getPayout(String[] row,int bet){

        if(row[0].equals(row[1])&& row[1].equals(row[2])){
            return switch (row[0]){
                case "🍕" -> bet*3;
                case "🍔" -> bet*6;
                case "🍟" -> bet*9;
                case "🌭" -> bet*12;
                case "🍿" -> bet*15;
                default -> 0;

            };
        }
        else if(row[0].equals(row[1])){
            return switch (row[0]){
                case "🍕" -> bet*2;
                case "🍔" -> bet*4;
                case "🍟" -> bet*6;
                case "🌭" -> bet*8;
                case "🍿" -> bet*10;
                default -> 0;

            };}
        else if(row[1].equals(row[2])){
            return switch (row[1]){
                case "🍕" -> bet*2;
                case "🍔" -> bet*4;
                case "🍟" -> bet*6;
                case "🌭" -> bet*8;
                case "🍿" -> bet*10;
                default -> 0;

            };}

        return 0;

    }
}
