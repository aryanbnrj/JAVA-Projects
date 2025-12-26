import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        Random random= new Random();
        int diceno;
        int total=0;

        System.out.print("Enter the no of the dice:");
        diceno= scanner.nextInt();
        if(diceno>0) {
            for (int i = 0; i < diceno; i++){
                int roll= random.nextInt(1,7);
                die(roll);
                System.out.println("you rolled:"+roll);
                total=total+roll;

            }
        }
        else{
            System.out.println("dice should be more than 0");
        }
        System.out.println("Total:"+total);





        scanner.close();
    }
    static void die(int roll){
        String die1= """
                 --------
                |        |
                |    ●   |
                |        |
                 --------
                """;
        String die2= """
                 --------
                |    ●   |
                |    ●   |
                |        |
                 --------       """;

        String die3= """
                 --------
                |    ●   |
                |    ●   |
                |    ●   |
                 --------       """;

        String die4= """
                 --------
                | ●    ● |
                |        |
                | ●    ● |
                 --------       """;

        String die5= """
                 --------
                | ●    ● |
                |    ●   |
                | ●     ●|
                 --------       """;

        String die6= """
                 --------
                | ●    ● |
                | ●    ● |
                | ●    ● |
                 --------       """;
        switch (roll){
            case 1-> System.out.println(die1);
            case 2-> System.out.println(die2);
            case 3-> System.out.println(die3);
            case 4-> System.out.println(die4);
            case 5-> System.out.println(die5);
            case 6-> System.out.println(die6);
        }
    }
}
