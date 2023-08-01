package classes;

import interfaces.User;
import fileio.MyFile;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Student implements User {

    int choise;
    String student_id;
    String student_pass;

    public Student(String student_id, String student_pass) {
        this.student_id = student_id;
        this.student_pass = student_pass;

    }

    @Override
    public void login() {
        try {
            Scanner reader = new Scanner(new File("student.txt"));
            PrintWriter writer = new PrintWriter(new File("myfile2.txt"));
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] tokens = line.split(" ");

                writer.println(tokens[0] + ", " + tokens[1] + ", " + tokens[2]);
                if (tokens[1].equals(student_id) && tokens[3].equals(student_pass)) {
                    welcomeStudent();
		   
                } else {
                    System.out.println("");
                    System.out.println("");
                    Start.allLogInOptions(2);
                }
            }
            writer.close();
            reader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
            Start.allLogInOptions(2);
        }

    }

    private void welcomeStudent() {
        
        System.out.println("");
        //System.out.println("\t\t\t\t\t\t\t\t\t     Login Successful");
        System.out.println("");
        System.out.println("\t\t\t\t\t\t\t\t      # Welcome to the Student Portal #");
        System.out.println("\t\t\t\t\t\t\t\t      =================================");
        System.out.println("");
        System.out.println("");

        System.out.println("\t\t\t\t\t\t\t\t          Choose any mention number...");
        System.out.println("");

        System.out.println("\t\t\t\t\t\t\t        +~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
        System.out.println("\t\t\t\t\t\t\t        |                                           |");
        System.out.println("\t\t\t\t\t\t\t        |       1.See Result                        |");
        System.out.println("\t\t\t\t\t\t\t        |                                           |");
        System.out.println("\t\t\t\t\t\t\t        |            2.Application for re-check     |");
        System.out.println("\t\t\t\t\t\t\t        |                                           |");
        System.out.println("\t\t\t\t\t\t\t        |                 3.Logout                  |");
        System.out.println("\t\t\t\t\t\t\t        |                                           |");
        System.out.println("\t\t\t\t\t\t\t        +~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");

        Scanner i = new Scanner(System.in);

        System.out.println("");
        System.out.print("\t\t\t\t\t\t\t\t              Enter Your Choise : ");
        System.out.print("");
        choise = i.nextInt();
        StudentOptions(choise);
    }

    private void StudentOptions(int choise) {
        
       //Start.clearConsole();
        switch (choise) {

            case 1:
                //result method 
                showResult();			

                break;
            case 2:
                System.out.println("\t\t\t\t\t\t\t\t                 Application");
                System.out.println("\t\t\t\t\t\t\t\t      =================================");
                System.out.println("");
                //application method
                applicationCheck(student_id);
	        welcomeStudent();
                break;
            case 3:
			    System.out.println("\t\t\t\t\t\t\t\t      You Are Loged Out From The System.");
			Start.mainMethod();
               // System.out.println("\t\t\t\t\t\t\t\t      You Are Loged Out From The System.");
		break;
               //return;

            default:
                System.out.println("");
                System.out.println("\t\t\t\t\t\t      Please input valid number.");
                welcomeStudent();
                System.out.println("");
        }
    }

    //........................................Show Result
    public void showResult() {
        try {
            System.out.println("\t\t\t\t\t\t\t\t                   Result");
            System.out.println("\t\t\t\t\t\t\t\t      =================================");
            System.out.println("");

            Scanner reader = new Scanner(new File("studentResult.txt"));
            PrintWriter writer = new PrintWriter(new File("myResultQueryfile.txt"));
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] tokens = line.split(" ");

                writer.println(tokens[0] + ", " + tokens[1] + ", " + tokens[2] + ", " + tokens[3] + ", " + tokens[4] + ", "
                        + tokens[5] + ", " + tokens[6] + ", " + tokens[7] + ", " + tokens[8] + ", " + tokens[9] + ", " + tokens[10] + ", " + tokens[11]
                        + ", " + tokens[12] + ", " + tokens[13] + ", " + tokens[14] + ", " + tokens[15] + ", " + tokens[16]);

                if (tokens[1].equals(student_id)) {
                    System.out.println(
                              "\t\t\t\t\t\t UserId                  :  " + tokens[1] + "\n\n"
						    + "\t\t\t\t\t\t============================================\n"
                            + "\t\t\t\t\t\t Quiz1                   :  " + tokens[3] +  "\n"
                            + "\t\t\t\t\t\t Quiz2                   :  " + tokens[5] +  "\n"
                            + "\t\t\t\t\t\t Viva                    :  " + tokens[7] +  "\n"
                            + "\t\t\t\t\t\t Assignment              :  " + tokens[9] +  "\n"
                            + "\t\t\t\t\t\t Performance & Attendanc :  " + tokens[13] + "\n"
							+ "\t\t\t\t\t\t============================================ \n"
                            + "\t\t\t\t\t\t        Total Marks : " + tokens[16] +"\n"
                    );
                } else {
                    System.out.println("");
//                    System.out.println("\t\t\t\t\t\t      Please input valid User_id and Password.");
                    System.out.println("");
                }
            }
            writer.close();
            reader.close();
	    welcomeStudent();
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
            welcomeStudent();
			
        }
    }

    private void applicationCheck(String student_id) {
        String descriptions;
        Scanner i = new Scanner(System.in);
       
        System.out.println("");
        System.out.print("\t\t\t\t\t\t\t\t              Enter Your UserId : ");
        choise = i.nextInt();
        

        System.out.println("");
        System.out.println("\t\t\t\t\t\t\t\t              Enter Your applications : ");
        System.out.print("Application: ");
        descriptions = i.next();
        
        MyFile.createStudentApplicationFile();
        MyFile.writeStudentApplicationFile(student_id, descriptions);
        
        System.out.println("\t\t\t\t\t\t\t\t              Successfully Send Applications. ");
        
        
        
        
    }

}
