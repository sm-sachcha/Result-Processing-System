package classes;

import fileio.MyFile;
import java.io.*;
import java.util.*;

public class Start {

    static List<String> student_id_list = new ArrayList<String>();//creating new generic arraylist  
    static List<String> student_pass_list = new ArrayList<String>();//creating new generic arraylist  
    static List<String> teacher_id_list = new ArrayList<String>();//creating new generic arraylist  
    static List<String> teacher_pass_list = new ArrayList<String>();//creating new generic arraylist 
    static boolean q = false;

    public static void main(String[] args) {
        // TODO code application logic here

        mainMethod();

    }

    public static void mainMethod() {
        Start.clearConsole();
        int choise;

        if (!q) {
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("\t\t\t\t\t\t\t =============================================================");
            System.out.println("\t\t\t\t\t\t\t    +++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("\t\t\t\t\t\t\t          +----------------------------------------+");
            System.out.println("\t\t\t\t\t\t\t          |                                        |");
            System.out.println("\t\t\t\t\t\t\t          |   Welcome to Result Processing System  |");
            System.out.println("\t\t\t\t\t\t\t          |                                        |");
            System.out.println("\t\t\t\t\t\t\t          +----------------------------------------+");
            System.out.println("\t\t\t\t\t\t\t    +++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("\t\t\t\t\t\t\t =============================================================");
            System.out.println("");
            System.out.println("\t\t\t\t\t\t\t          Choose any number where you want to go....");
            System.out.println("");
            System.out.println("\t\t\t\t\t\t\t       ==========     ==================     =========");
            System.out.println("\t\t\t\t\t\t\t        1. login       2. Registrations       0. Exit ");
            System.out.println("\t\t\t\t\t\t\t       ==========     ==================     =========");
            System.out.println("");

            //by default 1 teacher add admin
            teacher_id_list.add("teacher");
            teacher_pass_list.add("teacher");

            Scanner sc = new Scanner(System.in);

            //System.out.println("\t\t\t\t\t\t\t         	      Enter Your Choise");
            choise = sc.nextInt();
            logInSections(choise);
        } else {
            System.out.println("\t\t\t\t\t\t\t\t      Take Care. Stay Home, Stay Safe....");
        }
    }
    
     private static void logInSections(int choise) {
	clearConsole();
        switch (choise) {
            case 1:
                System.out.println("");
                System.out.println("\t\t\t\t\t\t\t\t    .~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~.");
                System.out.println("\t\t\t\t\t\t\t\t    |          1. Teacher              |");
                System.out.println("\t\t\t\t\t\t\t\t    |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
                System.out.println("\t\t\t\t\t\t\t\t    |          2. Student              |");
                System.out.println("\t\t\t\t\t\t\t\t    |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
                System.out.println("\t\t\t\t\t\t\t\t    |          3. Admin                |");
                System.out.println("\t\t\t\t\t\t\t\t    '~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~'");
                Scanner sc1 = new Scanner(System.in);

                System.out.println("");
                System.out.print("\t\t\t\t\t\t\t\t              Enter Your Choise : ");
                choise = sc1.nextInt();

                allLogInOptions(choise);
                break;
            case 2:
                //Registrations System.......................
                registrations();

                break;

            case 0:
			    System.out.println("\t\t\t\t\t\t\t\t      Take Care. Stay Home, Stay Safe....");
                q = true;
                break;
	    case 3:
		return;

            default:
                System.out.println("");
                System.out.println("\t\t\t\t\t\t      Please input valid number.");
                System.out.println("");
                mainMethod();

        }
    }
     

    private static void registrations() {
        System.out.println("\t\t\t\t\t\t\t          +----------------------------------------+");
        System.out.println("\t\t\t\t\t\t\t          |                                        |");
        System.out.println("\t\t\t\t\t\t\t          |     Only Student for registration!     |");
        System.out.println("\t\t\t\t\t\t\t          |                                        |");
        System.out.println("\t\t\t\t\t\t\t          +----------------------------------------+");
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t\t\t\t\t\t\t                        Enter your UserId    => ");
        String userName = scanner.nextLine();
        student_id_list.add(userName);

        System.out.print("\t\t\t\t\t\t\t                    Enter your User_Password => ");
        String userPassword = scanner.nextLine();
        student_pass_list.add(userPassword);

        //File Create and Write..........................
        MyFile.createStudentFile();
        MyFile.writeStudentFile(userPassword, userName);
        MyFile.readStudentFile();

        System.out.println(" ");
        System.out.println("\t\t\t\t\t\t\t                                               ");
        System.out.println("\t\t\t\t\t\t\t            Thank you for your registration!  ");
        System.out.println("\t\t\t\t\t\t\t                Please, login continue        ");
        System.out.println("\t\t\t\t\t\t\t                  ..................           ");

        //caling main method................................
        mainMethod();
    }

    public static void allLogInOptions(int choise) {
        String user_id, password;
        switch (choise) {
            //Loging Teacher.............................
            case 1:
                System.out.println("\t\t\t\t\t\t\t\t        Enter your User_ID & User_Password");
                System.out.println("\t\t\t\t\t\t\t\t       ------------------------------------");
                System.out.println("");
                System.out.println("");
                System.out.print("\t\t\t\t\t\t    Enter Your UserId     : ");
                Scanner x = new Scanner(System.in);
                user_id = x.nextLine();

                System.out.print("\t\t\t\t\t\t  Enter Your UserPassword : ");
                Scanner x1 = new Scanner(System.in);
                password = x1.nextLine();

                Teacher t1 = new Teacher(user_id, password);
                t1.login();

                break;

            //Loging Student...........................
            case 2:
                System.out.println("\t\t\t\t\t\t\t\t        Enter your User_ID & User_Password");
                System.out.println("\t\t\t\t\t\t\t\t       ------------------------------------");
                System.out.println("");
                System.out.println("");
                System.out.print("\t\t\t\t\t\t     Enter Your UserId     : ");
                Scanner s = new Scanner(System.in);
                user_id = s.nextLine();

                System.out.print("\t\t\t\t\t\t  Enter Your User_Password : ");
                Scanner s2 = new Scanner(System.in);
                password = s2.nextLine();

                Student s1 = new Student(user_id, password);
                s1.login();

                break;

            //Loging Admin........................
            case 3:
                System.out.println("\t\t\t\t\t\t\t\t        Enter your User_ID & password");
                System.out.println("\t\t\t\t\t\t\t\t      ---------------------------------");
                System.out.println("");
                System.out.print("\t\t\t\t\t\t      Enter Your UserId    : ");
                Scanner ad = new Scanner(System.in);
                user_id = ad.nextLine();

                System.out.print("\t\t\t\t\t\t  Enter Your User_Password : ");
                Scanner ad1 = new Scanner(System.in);
                password = ad1.nextLine();

                Admin a1 = new Admin(user_id, password);
                a1.login();

                break;
                
            default:
                System.out.println("");
                System.out.println("\t\t\t\t\t\t      Please input valid number.");
                System.out.println("");
                logInSections(1);

        }
    }
    public final static void clearConsole() {
        try {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    } catch (IOException | InterruptedException ex) {}
    }

}
