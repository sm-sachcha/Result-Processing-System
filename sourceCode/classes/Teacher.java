package classes;

import interfaces.User;
import fileio.MyFile;
import java.io.*;
import java.util.*;


public class Teacher implements User {

    int choise;
    String quiz1, quiz2, viva, assignment, performance_attendance, result;
    String studentUserId;

    String teacher_id;
    String teacher_pass;

    public Teacher(){
        //default constructor
    }
    public Teacher(String teacher_id, String teacher_pass) {
        this.teacher_id = teacher_id;
        this.teacher_pass = teacher_pass;
    }

    @Override
    public void login() {
        if (Start.teacher_id_list.contains(teacher_id) && Start.teacher_pass_list.contains(teacher_pass)) {

            welcomeTeacher();
	    

            //TeacherOptions();
        } else {
            System.out.println("");
            System.out.println("\t\t\t\t\t      Please input valid User_id and Password.");
            Start.allLogInOptions(1);
            System.out.println("");
        }
    }

    private void welcomeTeacher() {
        
        System.out.println("");
        System.out.println("\t\t\t\t\t\t\t\t\t     Login Successful");
        System.out.println("");
        //System.out.println("\t\t\t\t\t\t\t\t *****************************");
        System.out.println("\t\t\t\t\t\t\t\t      # Welcome to the Teacher Portal #");
        System.out.println("\t\t\t\t\t\t\t\t      =================================");
        System.out.println("");
        System.out.println("");

        //System.out.println("\t\t\t\t\t\t\t\t          Choose any mention number...");
        System.out.println("");
        System.out.println("\t\t\t\t\t\t\t        +-------------------------------------------+");
        System.out.println("\t\t\t\t\t\t\t        |                                           |");
        System.out.println("\t\t\t\t\t\t\t        |       1.Teacher Details                   |");
        System.out.println("\t\t\t\t\t\t\t        |                                           |");
        System.out.println("\t\t\t\t\t\t\t        |            2.Update/Modify result         |");
        System.out.println("\t\t\t\t\t\t\t        |                                           |");
        System.out.println("\t\t\t\t\t\t\t        |                3.Logout                   |");
        System.out.println("\t\t\t\t\t\t\t        |                                           |");
        System.out.println("\t\t\t\t\t\t\t        +-------------------------------------------+");
        Scanner sc2 = new Scanner(System.in);
        System.out.println("");
        System.out.print("\t\t\t\t\t\t\t\t              Enter Your Choise : ");
        choise = sc2.nextInt();
        TeacherOptions(choise);
    }

    public void TeacherOptions(int choise) {
       
        switch (choise) {
            case 1:
                //Add teacher details method
                Admin a1 = new Admin();
                a1.showTeacInfo();
                welcomeTeacher();
                break;

            case 2:
                System.out.println("\t\t\t\t\t\t\t\t          Press the mention number...");
                System.out.println("");
                System.out.println("\t\t\t\t\t\t\t\t     +---------------------------------+");
                System.out.println("\t\t\t\t\t\t\t\t     |                                 |");
                System.out.println("\t\t\t\t\t\t\t\t     |     1. See Course               |");
                System.out.println("\t\t\t\t\t\t\t\t     |     2. Set Student Result       |");
                System.out.println("\t\t\t\t\t\t\t\t     |     3. Re-Check Application     |");
                System.out.println("\t\t\t\t\t\t\t\t     |  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  |");
                System.out.println("\t\t\t\t\t\t\t\t     |       Press 0 for go back       |");
                System.out.println("\t\t\t\t\t\t\t\t     +---------------------------------+");
                System.out.println("");

                Scanner sc2 = new Scanner(System.in);
                System.out.println("");
                System.out.print("\t\t\t\t\t\t\t\t              Enter Your Choise : ");
                choise = sc2.nextInt();

                seeCourse(choise);
                break;

            case 3:
              System.out.println("\t\t\t\t\t\t\t\t      You Are Loged Out From The System.");
				
		Start.mainMethod();
		       // System.out.println("\t\t\t\t\t\t\t\t      You Are Loged Out From The System.");
                return;

            case 4:

                break;

            default:
                System.out.println("");
                System.out.println("\t\t\t\t\t\t      Please input valid number.");
                welcomeTeacher();

        }
    }

    private void seeCourse(int choise) {
        switch (choise) {
            case 0:
                //Go To Back
                welcomeTeacher();
                break;
            case 1:
                System.out.println("");
                System.out.println("\t\t\t\t\t\t\t       ===============< Choose a Course >============");
                System.out.println("");
                System.out.println("\t\t\t\t\t\t\t       +------------------+     +-----------------+  ");
                System.out.println("\t\t\t\t\t\t\t       |                  |     |                 |  ");
                System.out.println("\t\t\t\t\t\t\t       |     1. OOP-1     |     |     2. OOP-2    |  ");
                System.out.println("\t\t\t\t\t\t\t       |                  |     |                 |  ");
                System.out.println("\t\t\t\t\t\t\t       +------------------+     +-----------------+  ");
                System.out.println("\t\t\t\t\t\t\t                 ~~~~~~~~~~~~~~~~~~~~~~~~~~          ");
                System.out.println("\t\t\t\t\t\t\t                     Press 0 for go back             ");
                System.out.println("\t\t\t\t\t\t\t       ==============================================");

                Scanner sc2 = new Scanner(System.in);
                System.out.println("");
                System.out.print("\t\t\t\t\t\t\t\t              Enter Your Choise : ");
                choise = sc2.nextInt();

                choiseCourse(choise);

            case 2:
                //create result

                createStudentResult();

                break;
            case 3:
                //check application

                MyFile.readStudentApplicationFile();
                TeacherOptions(2);

                break;

            default:
                System.out.println("");
                System.out.println("\t\t\t\t\t\t      Please input valid number.");
                TeacherOptions(2);
                
        }
    }

    private void choiseCourse(int choise) {
        Start.clearConsole();
        switch (choise) {
            case 0:
                //Go To Back
                TeacherOptions(2);
                break;

            case 1:
                System.out.println("\t\t\t\t\t\t\t\t       ==============< Choose a section >===========");
                System.out.println("\t\t\t\t\t\t\t\t       |                                           |");
                System.out.println("\t\t\t\t\t\t\t\t       |  +------------------+                     |");
                System.out.println("\t\t\t\t\t\t\t\t       |  |                  |                     |");
                System.out.println("\t\t\t\t\t\t\t\t       |  |   1. Section-E   |                     |");
                System.out.println("\t\t\t\t\t\t\t\t       |  |                  |                     |");
                System.out.println("\t\t\t\t\t\t\t\t       |  +------------------+                     |");
                System.out.println("\t\t\t\t\t\t\t\t       |                       +-----------------+ |");
                System.out.println("\t\t\t\t\t\t\t\t       |                       |                 | |");
                System.out.println("\t\t\t\t\t\t\t\t       |                       |  2. Section-F   | |");
                System.out.println("\t\t\t\t\t\t\t\t       |                       |                 | |");
                System.out.println("\t\t\t\t\t\t\t\t       |                       +-----------------+ |");
                System.out.println("\t\t\t\t\t\t\t\t       |    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~     |");
                System.out.println("\t\t\t\t\t\t\t\t       |            Press 0 for go back            |");
                System.out.println("\t\t\t\t\t\t\t\t       =============================================");

                Scanner sc2 = new Scanner(System.in);
                System.out.println("");
                System.out.print("\t\t\t\t\t\t\t\t              Enter Your Choise : ");
                choise = sc2.nextInt();

                choiseSections(choise);

                break;
            case 2:
                System.out.println("\t\t\t\t\t\t\t\t       ==============< Choose a section >===========");
                System.out.println("\t\t\t\t\t\t\t\t       |                                           |");
                System.out.println("\t\t\t\t\t\t\t\t       |  +------------------+                     |");
                System.out.println("\t\t\t\t\t\t\t\t       |  |                  |                     |");
                System.out.println("\t\t\t\t\t\t\t\t       |  |   1. Section-c   |                     |");
                System.out.println("\t\t\t\t\t\t\t\t       |  |                  |                     |");
                System.out.println("\t\t\t\t\t\t\t\t       |  +------------------+                     |");
                System.out.println("\t\t\t\t\t\t\t\t       |                       +-----------------+ |");
                System.out.println("\t\t\t\t\t\t\t\t       |                       |                 | |");
                System.out.println("\t\t\t\t\t\t\t\t       |                       |  2. Section-D   | |");
                System.out.println("\t\t\t\t\t\t\t\t       |                       |                 | |");
                System.out.println("\t\t\t\t\t\t\t\t       |                       +-----------------+ |");
                System.out.println("\t\t\t\t\t\t\t\t       |    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~     |");
                System.out.println("\t\t\t\t\t\t\t\t       |            Press 0 for go back            |");
                System.out.println("\t\t\t\t\t\t\t\t       =============================================");

                Scanner sc3 = new Scanner(System.in);
                System.out.println("");
                System.out.print("\t\t\t\t\t\t\t\t              Enter Your Choise : ");
                choise = sc3.nextInt();

                uploadAndModifySection(choise);
                
            default:
                System.out.println("");
                System.out.println("\t\t\t\t\t\t      Please input valid number.");
                seeCourse(1);
                
        }
    }

    
    private void choiseSections(int choise) {
        switch (choise) {
            case 0:
                //Go To Back..........
                seeCourse(1);
                break;

            case 1:
                System.out.println("\t\t\t\t\t\t\t\t              Upload/Modify result of E section...");
                System.out.println("\t\t\t\t\t\t\t\t           ==========================================");
                System.out.println("");
                //Result Method
                TeacherOptions(2);
                break;
                
            case 2:
                System.out.println("\t\t\t\t\t\t\t\t              Upload/Modify result of F section...");
                System.out.println("\t\t\t\t\t\t\t\t           ==========================================");
                System.out.println("");
                //Result Method
                TeacherOptions(2);
                break;

            default:
                System.out.println("");
                System.out.println("\t\t\t\t\t\t      Please input valid number.");
                choiseCourse(1);
        }
    }

    private void uploadAndModifySection(int choise) {

        switch (choise) {
            case 0:
                //Go To Back
                seeCourse(1);
                break;

            case 1:
                System.out.println("\t\t\t\t\t\t\t\t              Upload/Modify result of C section...");
                System.out.println("\t\t\t\t\t\t\t\t           ==========================================");
                System.out.println("");
                TeacherOptions(2);
                break;
            case 2:
                System.out.println("\t\t\t\t\t\t\t\t              Upload/Modify result of D section...");
                System.out.println("\t\t\t\t\t\t\t\t           ==========================================");
                System.out.println("");
                TeacherOptions(2);
                break;
           

            default:
                System.out.println("");
                System.out.println("\t\t\t\t\t\t      Please input valid number.");
                choiseCourse(2);
        }
    }

    private void createStudentResult() {
        Scanner sc4 = new Scanner(System.in);
        System.out.println("");
        System.out.print("\t\t\t\t\t\t\t\t              Enter Student UserId : ");
        studentUserId = sc4.nextLine();
        System.out.println();
        System.out.print("\t\t\t\t\t Enter Quiz1 Marks                           : ");
        quiz1 = sc4.nextLine();
        System.out.print("\t\t\t\t\t Enter Quiz2 Marks                           : ");
        quiz2 = sc4.nextLine();
        System.out.print("\t\t\t\t\t Enter Viva Marks                            : ");
        viva = sc4.nextLine();
        System.out.print("\t\t\t\t\t Enter Assignment Marks                      : ");
        assignment = sc4.nextLine();
        System.out.print("\t\t\t\t\t Enter Performance & Attendance Marks        : ");
        performance_attendance = sc4.nextLine();

        int total = Integer.parseInt(quiz1) + Integer.parseInt(quiz2) + Integer.parseInt(viva) + Integer.parseInt(assignment) + Integer.parseInt(performance_attendance);
        result = String.valueOf(total);
        System.out.print("\t\t\t\t\t Total Marks        : " + result);

        //Create Result File And Write Data..........................
        MyFile.createStudentResultFile();
        MyFile.writeStudentResultFile(studentUserId, quiz1, quiz2, viva, assignment, performance_attendance, result);
        //Go To Back
        TeacherOptions(2);
    }

}
