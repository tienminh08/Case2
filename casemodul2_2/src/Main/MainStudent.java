package Main;

import Manage.ManageStudent;
import Manage.ManageSubjects;

import java.util.Scanner;

public class MainStudent {
    static Scanner scanner = new Scanner(System.in);
    static ManageStudent manageStudent = new ManageStudent();
    static ManageSubjects manageSubjects = new ManageSubjects();

    public void showMain_Student() {
        while (true) {
            System.out.println("      ---Mennu---");
            System.out.println("[1].Thay đổi mật khẩu ");
            System.out.println("   --------------------  ");
            System.out.println("[2].Đăng kí môn học ");
            System.out.println("[3].Xóa môn học đã đăng kí");
            System.out.println("[4].Xem thời khóa biểu ");
            System.out.println("[5].Xem học phí  ");
            System.out.println("   ---------------------  ");
            System.out.println("[6].Đăng xuất ");
            try {
                int Number = Integer.parseInt(scanner.nextLine());
                switch (Number) {
                    case 1:
                        manageStudent.fixPass_Student();
                        break;
                    case 2:
                        manageSubjects.RegisterSubjects();
                        break;
                    case 3:

                        manageSubjects.deletesubj();
                        break;
                    case 4:
                        manageSubjects.showsave();

                        break;
                    case 5:
                        manageSubjects.SumTuition();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("khong co lua chon nay");
                        break;

                }
            }catch (Exception e){

            }


        }
    }
}
