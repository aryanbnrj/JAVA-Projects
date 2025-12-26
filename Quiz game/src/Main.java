import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        String[] questions={
                "Which keyword is used to start the execution of a Java program",
                "Which data type is used to store true or false values in Java?",
                "Which symbol is used to end a statement in Java?",
                "Which of the following is a correct method declaration?",
                "Which keyword is used to take input from the user in Java?",
        };
        String[][] options={
                {"A) run", "B) start", "C) main", "D) execute"},
                {"A) int","B) boolean","C) char","D) String"},
                {"A) :","B) .","C) ;","D) ,"},
                {"A) int add(int a, int b)","B) add int (a, b)","C) int add a, b" ,"D) add(int a, int b)"},
                {"A) input","B) read","C) Scanner","D) System"}};
        int[] answers={3,2,3,1,3};
        int scores=0;
        int guess;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Welcome to the quiz game !!");
        for(int i=0;i< questions.length;i++){
            System.out.println(questions[i]);
            for (String option : options[i]) {
                System.out.println(option);



            }
            System.out.print("enter your guess:");
            guess= scanner.nextInt();
            if(guess==answers[i]){
                System.out.println("correct !");
                scores=scores+2;
            }
            else{
                System.out.println("Wrong!!");
            }


        }
        System.out.println("Final Score="+scores+"out of 10");


         scanner.close();
    }

}
