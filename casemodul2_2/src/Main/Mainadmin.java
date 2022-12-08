package Main;

import Manage.ManageStudent;
import Manage.ManageSubjects;

import java.util.Scanner;

public class Mainadmin {
    static Scanner scanner = new Scanner(System.in);
    static ManageStudent manage_student = new ManageStudent();
    static ManageSubjects manage_subjects= new ManageSubjects();

    public void showMain_Admin() {
        while (true) {

            System.out.println("      ----Mennu---- ");
            System.out.println("[1].Thêm tài khoản sinh viên");
            System.out.println("[2].Sửa tài khoản sinh viên");
            System.out.println("[3].Tìm tài khoản sinh viên ");
            System.out.println("[4].Hiển thị các sinh vien");
            System.out.println("[5].Sắp xếp tài khoản");
            System.out.println("[6].Xóa tài khoản");
            System.out.println("   ------------------------  ");
            System.out.println("[7].Thêm môn học");
            System.out.println("[8].Sủa môn học");
            System.out.println("[9].Xóa môn học");
            System.out.println("[10].Sắp xếp môn học");
            System.out.println("[11].Đăng xuất");

          try {
              int Number = Integer.parseInt(scanner.nextLine());
              switch (Number) {

                  case 1:
                      manage_student.register_Student();
                      break;
                  case 2:
                      manage_student.edit_Student();
                      break;
                  case 3:
                      manage_student.find_Studnet();
                      break;
                  case 4:
                      manage_student.show_SaveStudent();
                      break;
                  case 5:
                      manage_student.sortName();
                      break;
                  case 6:
                      manage_student.delete_Student();
                      break;
                  case 7:
                      manage_subjects.create_subjects();
                      break;
                  case 8:
                      manage_subjects.edit_subjects();
                      break;
                  case 9:
                      manage_subjects.delete();
                      break;
                  case 10:
                      manage_subjects.SortbyNumber();
                      break;
                  case 11:
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
