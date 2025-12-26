import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner scanner=new Scanner(System.in);
    static ArrayList<Student> studentstore= new ArrayList<>();

    public static void main(String[] args){

        int choice=0;

        System.out.println("*******************************************");
        System.out.println("Welcome to the Student Management System!");
        System.out.println("*******************************************");

        while(choice!=8){
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Update Student Marks");
        System.out.println("5. Delete Student");
        System.out.println("6. Save to File");
        System.out.println("7. Load from File");
        System.out.println("8. Exit");
        System.out.print("Enter your choice:");
        choice=scanner.nextInt();
        switch (choice){
            case 1-> addStudent();
            case 2-> viewStudent();
            case 3-> searchStudent();
            case 4-> updateStudent();
            case 5-> deleteStudent();
            case 6-> savefile();
            case 7-> loadfile();
            case 8-> System.out.println("Thanks for using!!");
            default -> System.out.println("Invalid Choice!!");

        };}


    }
    public static void addStudent(){
        int studentId;
        String name;
        double marks;


        System.out.print("Enter the studentId:");
        studentId=scanner.nextInt();
        System.out.print("Enter the name:");
        name=scanner.next();
        System.out.print("Enter the marks:");
        marks=scanner.nextDouble();
        Student student=new Student(studentId,name,marks);

        studentstore.add(student);



    }
    public static void viewStudent(){

        for(Student student:studentstore){
            System.out.println("StudentId:"+ student.getStudentId()+"|Name:"+ student.getName()+"| Marks:"+ student.getMarks());

        }

    }
    public static void searchStudent(){
        int studentId;
        boolean match=false;
        System.out.print("Enter the studentId to search:");
        studentId=scanner.nextInt();
        for(Student student:studentstore){
            if(studentId==student.getStudentId()){
                System.out.println(student);
                match=true;

            }

        }
        if(match ==false){System.out.println("Not Found!");}

    }
    public static void updateStudent(){
        int studentId;
        String name;
        double marks;
        boolean match=false;
        System.out.print("Enter the studentId to update:");
        studentId=scanner.nextInt();
        System.out.print("Enter new name for student:");
        name=scanner.next();
        System.out.print("Enter new marks for student:");
        marks=scanner.nextDouble();

        for(Student student:studentstore){

            if(student.getStudentId()==studentId){
            student.setName(name);
            student.setMarks(marks);
            match=true;
            break;
            }

        }
        if(match ==false){System.out.println("Not Found!");}

    }
    public static void deleteStudent(){
        int studentId;
        boolean match=false;
        System.out.print("Enter the studentId to delete:");
        studentId=scanner.nextInt();
        for(int i=0;i< studentstore.size();i++){

            if(studentstore.get(i).getStudentId()==studentId){
                studentstore.remove(i);
                match=true;
                break;
            }

        }
        if(match ==false){System.out.println("Not Found!");}



    }
    public static void savefile(){
        String filepath="test.txt";
        try(FileWriter fileWriter=new FileWriter(filepath);) {

            String text;
            boolean match=false;

            for(Student student:studentstore){
               text=student.tofileString();
               fileWriter.write(text);
               match=true;

            }
            if (match == true){System.out.println("File saved in test.txt!!");}
            else {
                System.out.println("File not found!!");
            }

        } catch (IOException e) {
            System.out.println("file not saved");
        }
    }
    public static void loadfile(){
        String filepath="test.txt";
        int studentId;
        String name;
        double marks;
        try(BufferedReader reader=new BufferedReader(new FileReader(filepath))) {
            String line;
            boolean match=false;
            while ((line= reader.readLine())!=null){



                String[] parts=line.split(",");
                studentId = Integer.parseInt(parts[0]);
                name = parts[1];
                marks = Double.parseDouble(parts[2]);
                Student student=new Student(studentId,name,marks);
                studentstore.add(student);
                match=true;


            }
            if(match==true){System.out.println("File Loaded successfully!");}


        } catch (IOException e) {
            System.out.println("file not found!!");
        }

    }

}
