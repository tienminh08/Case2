package Manage;

import Model.Subjects;
import Main.MainStudent;
import OI.WriteReadStudent;
import Model.Student;
import Sort.SortNameStundent;

import java.util.*;

import static java.lang.System.*;

public class ManageStudent {
    static Scanner scanner = new Scanner(in);
    static ArrayList<Student> SaveStudent = (ArrayList<Student>) WriteReadStudent.read();
    static int studentID = -1;
    static ManageStudent manageStudent = new ManageStudent();
    static MainStudent mainStudent = new MainStudent();


    public void register_Student() {
        while (true) {
            do {
                System.out.println("Nhập tài khoản");
                String AccountName = scanner.nextLine();
                if (!checkname_Student(AccountName)) {
                    do {
                        System.out.println("Nhập mật khẩu");
                        String Password = scanner.nextLine();
                        if (Password.length() > 3 && Password.length() < 9) {
                            System.out.println("Nhập tên sinh viên");
                            String Name = scanner.nextLine();
                            do {
                                try {
                                    System.out.println("Nhập tuối sinh viên");
                                    int age = Integer.parseInt(scanner.nextLine());
                                    if (check_age_Student(age)) {
                                        System.out.println("Nhập mã sinh viên");
                                        String Idstudent = scanner.nextLine();
                                        System.out.println("Sinh viên lớp?");
                                        String ClassStudent = scanner.nextLine();
                                        List<Subjects> save1 = new ArrayList<>();
                                        List<Integer> save2 = new ArrayList<>();
                                        int sumtuion = 0;
                                        Student student = new Student(AccountName, Password, Name, age, Idstudent, ClassStudent, save1, save2, sumtuion);
                                        SaveStudent.add(student);
                                        WriteReadStudent.write(SaveStudent);
                                        System.out.println("Đăng kí thành công");
                                        break;
                                    }
                                } catch (NumberFormatException | InputMismatchException e) {
                                    err.println("Hãy Nhập số");

                                }
                            } while (true);
                            break;
                        } else {
                            err.println("Mật khẩu không đủ dộ dài ");
                        }
                    } while (true);
                    break;

                } else {
                    err.println("Tài khoan đã tồn tại");
                }

            }while (true);
            break;
        }


    }


    public boolean checkname_Student(String AccountName) {
        for (int i = 0; i < SaveStudent.size(); i++) {
            if (AccountName.equals(SaveStudent.get(i).getAccountName())) {
                studentID = i;
                return true;
            }
        }
        return false;
    }

    public boolean checkPass_Student(String Password) {
        for (int i = 0; i < SaveStudent.size(); i++) {
            if (Password.equals(SaveStudent.get(i).getPassword())) {
                return true;
            }

        }
        return false;
    }

    public int ckeck_i_studnet(String AccountName) {
        for (int i = 0; i < SaveStudent.size(); i++) {
            if (AccountName.equals(SaveStudent.get(i).getAccountName())) {
                return i;
            }

        }
        return -1;
    }


    public void login_Student() {

        System.out.println("Nhập tài khoản");
        String AccountName = scanner.nextLine();
        if (checkname_Student(AccountName)) {
            System.out.println("Nhập mật khẩu");
            String Password = scanner.nextLine();
            if (checkPass_Student(Password)) {
                System.out.println("Đăng nhập thành công");
                mainStudent.showMain_Student();
            } else {
                err.println("Mật khẩu không đúng");
            }
        } else {
            err.println(" Tài khoản không đúng");
        }


    }

    public void delete_Student() {
        System.out.println("Nhập tên tài khoản muốn xóa");
        String AccountName = scanner.nextLine();
        int index = manageStudent.ckeck_i_studnet(AccountName);
        if (index == -1) {
            err.println("Tài khoản không tồn tại");
        } else {
            System.out.println("Bạn có chắc chắn muốn xóa?");
            System.out.println("[1].Có");
            System.out.println("[2].Không");
            int Number = Integer.parseInt(scanner.nextLine());
            switch (Number) {
                case 1:
                    SaveStudent.remove(index);
                    WriteReadStudent.write(SaveStudent);
                    System.out.println("Đã xóa thành công");
                    break;
                case 2:
                    return;
            }
        }
    }

    public void show_SaveStudent() {
        for (int i = 0; i < SaveStudent.size(); i++) {
            System.out.println(SaveStudent.get(i).toString());

        }
    }

    public boolean check_age_Student(int age1) {
        if (age1 > 0 && age1 < 100) {

            return true;
        } else {
            err.println("Tuổi phải lớn hơn 0 và nhỏ hơn 100");

            return false;
        }

    }

    public void edit_Student() {

        System.out.println("Nhập tên tài khoản");
        String AccountName = scanner.nextLine();

        if (checkname_Student(AccountName)) {
            do {
                System.out.println("Bạn muốn thay đổi gì?");
                System.out.println("[1].Thay đổi tên");
                System.out.println("[2].Thay đổi tuổi");
                System.out.println("[3].Thay đổi mã sinh viên");
                System.out.println("[4].Thay đổi lớp học ");
                System.out.println("[5].Thoát");
                int Number = Integer.parseInt(scanner.nextLine());
                int index = manageStudent.ckeck_i_studnet(AccountName);
                switch (Number) {
                    case 1:
                        System.out.println("Nhập tên mới muốn thay đổi");
                        String newName = scanner.nextLine();
                        System.out.println("Bạn có chắc chắn muốn thay đổi?");
                        System.out.println("[1].Có");
                        System.out.println("[2].Không");
                        Number = Integer.parseInt(scanner.nextLine());
                        switch (Number) {
                            case 1:
                                SaveStudent.get(index).setName(newName);
                                WriteReadStudent.write(SaveStudent);
                                System.out.println("Thay dổi thành công");
                                break;
                            case 2:
                                return;
                        }
                        break;
                    case 2:
                        while (true) {
                            try {
                                System.out.println("Nhập tuổi muốn thay đổi?");
                                int new_age = Integer.parseInt(scanner.nextLine());
                                if (check_age_Student(new_age)) {
                                    System.out.println("Bạn có chắc chắn muốn thay đổi?");
                                    System.out.println("[1].Có");
                                    System.out.println("[2].Không");
                                    Number = Integer.parseInt(scanner.nextLine());
                                    if (Number == 1) {

                                        SaveStudent.get(index).setAge(new_age);
                                        WriteReadStudent.write(SaveStudent);
                                        System.out.println("Thay đổi thành công");
                                        return;
                                    } else if (Number == 2) {
                                        return;
                                    } else {
                                        System.out.println("Nhập lại");
                                    }

                                }
                            } catch (NumberFormatException | InputMismatchException e) {
                                System.out.println("Hãy nhập số");
                            }
                        }

                    case 3:
                        System.out.println("Mời nhập mã sinh viên muốn thay đổi");
                        String newIdStudent = scanner.nextLine();
                        System.out.println("Bạn có chắc chắn muốn thay đổi?");
                        System.out.println("[1].Có");
                        System.out.println("[2].Không");
                        Number = Integer.parseInt(scanner.nextLine());
                        switch (Number) {
                            case 1:
                                SaveStudent.get(index).setIdStudent(newIdStudent);
                                WriteReadStudent.write(SaveStudent);
                                System.out.println("Thay đổi thành công");
                                break;
                            case 2:
                                return;
                        }
                        break;
                    case 4:
                        System.out.println("Nhập lớp muốn thay đổi");
                        String newClassStudent = scanner.nextLine();
                        System.out.println("Bạn có chắc chắn muốn thay đổi?");
                        System.out.println("[1].Có");
                        System.out.println("[2].Không");
                        Number = Integer.parseInt(scanner.nextLine());
                        switch (Number) {
                            case 1:
                                SaveStudent.get(index).setClassStudent(newClassStudent);
                                WriteReadStudent.write(SaveStudent);
                                System.out.println("Thay dổi thành công");
                                break;
                            case 2:
                                return;
                        }
                        break;
                    case 5:
                        return;

                }

            } while (true);
        } else {
            err.println("Đăng nhập không thành công");
        }


    }

    public void find_Studnet() {
        System.out.println("Nhập tên tài khoản muốn tìm");
        String AccountName = scanner.nextLine();
        int index = manageStudent.ckeck_i_studnet(AccountName);
        if (index == -1) {
            err.println("Tài khoản không tồn tại");
        } else {
            System.out.println(SaveStudent.get(index).toString());

        }
    }


    public void fixPass_Student() {
        System.out.println("Nhập tên tài khoản");
        String AccountName = scanner.nextLine();
        if (checkname_Student(AccountName)) {
            int index = manageStudent.ckeck_i_studnet(AccountName);
            if (index == -1) {
                err.println("Tài khoản không tồn tại");

            } else {
                System.out.println("Nhập mật khẩu cũ");
                String Password = scanner.nextLine();
                if (checkPass_Student(Password)) {
                    System.out.println("Nhập mật khẩu mới");
                    String newPassword = scanner.nextLine();
                    SaveStudent.get(index).setPassword(newPassword);
                    WriteReadStudent.write(SaveStudent);
                    System.out.println("Đổi mật khẩu thành công");
                } else {
                    err.println("Đổi mật khẩu thất bại");
                }
            }
        } else {
            err.println("Tài khoản không tồn tại");
        }
    }

    public void sortName() {
        Collections.sort(SaveStudent, new SortNameStundent());
        show_SaveStudent();
    }


}
