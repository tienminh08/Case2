package Main;

import Manage.ManageAdmin;
import Manage.ManageStudent;

import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ManageAdmin manage_acount = new ManageAdmin();

    static ManageStudent manage_student1 = new ManageStudent();


    public static void main(String[] args) {

        while (true) {
           try {
               System.out.println("---Mennu---");
               System.out.println("[1].Đăng nhập ");
               System.out.println("[2].Đăng nhập Student ");
               System.out.println("[3].Thoát");
               int Number = Integer.parseInt(scanner.nextLine());
               switch (Number) {
                   case 1:
                       manage_acount.Create_Admin();
                       manage_acount.loginAdmin();
                       break;
                   case 2:
                       manage_student1.login_Student();
                       break;
                   case 3:
                       System.exit(3);
                       break;



               }
           }catch (NumberFormatException e){


           }
        }
    }
}
