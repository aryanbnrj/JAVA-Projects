import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){


        String filepath="C:\\Documents\\java\\HAngman Game1\\src\\fruit.txt";
        ArrayList<String> words=new ArrayList<>();
        try(BufferedReader reader=new BufferedReader(new FileReader(filepath))){
            String line;
            while((line= reader.readLine())!=null){
                words.add(line.trim().toLowerCase());
            }

        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
        }
        catch (IOException e){
            System.out.println("Something went wrong!");
        }
        Random random=new Random();
        String word=words.get(random.nextInt(words.size()));

        Scanner scanner = new Scanner(System.in);

        int wrongGuess=0;
        char guess;
        ArrayList<Character> wordState=new ArrayList<>();


        for(int i=0;i<word.length();i++){
            wordState.add('_');

        }

        System.out.println("*************************");
        System.out.println("Welcome to Hangman Game!");
        System.out.println("*************************");

        while (wrongGuess<6){
            System.out.println(getHangman(wrongGuess));
            System.out.print("Word:");

            for(char c :wordState){
                System.out.print(c+" ");
            }


            System.out.println();
            System.out.print("Enter the guess:");
            guess=scanner.next().toLowerCase().charAt(0);
            if(word.indexOf(guess)>=0){
                System.out.println("Correct guess!");
                for (int i=0;i<word.length();i++){
                    if(word.charAt(i)==guess) {
                        wordState.set(i,guess);
                    }
                }
                if(!wordState.contains('_')){
                    System.out.println(getHangman(wrongGuess));
                    System.out.println("You Win");
                    System.out.println("THe word was:"+word);
                    break;

                }
            }




            else {
                wrongGuess++;
                System.out.println("Wrong guess!");
            }

        }
        if(wrongGuess>=6){
            System.out.println(getHangman(wrongGuess));
            System.out.println("Game Over!!");
            System.out.println("The word was :"+word);

        }


        scanner.close();
    }
    static String  getHangman(int wrong){

        return switch (wrong){
            case 0 -> """
                      
                      
                      
                      """;
            case 1 -> """
                       0
                      
                      
                      """;
            case 2 -> """
                       0
                       |
                      
                      """;
            case 3 -> """
                       0
                      /|
                      
                      """;
            case 4 -> """
                       0
                      /|\\
                      
                      """;
            case 5 -> """
                       0
                      /|\\
                      /
                      """;
            case 6 -> """
                       0
                      /|\\
                      / \\
                      """;
            default->"";
        };

    }
}
