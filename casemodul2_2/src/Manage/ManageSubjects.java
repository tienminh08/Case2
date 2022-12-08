package Manage;

import Model.Subjects;
import OI.WriteReadStudent;
import OI.WriteReadSubjects;
import Sort.SortByNumberOfSinginah;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ManageSubjects {

    static Scanner scanner = new Scanner(System.in);
    static ManageSubjects manageSubjects = new ManageSubjects();
    static ArrayList<Subjects> SaveSubjects = (ArrayList<Subjects>) WriteReadSubjects.read();


    public void create_subjects() {

        System.out.println("Nhập tên môn học");
        String NameSubjects = scanner.nextLine();
        System.out.println("Nhập thời gian bắt đầu");
        String StartTime = scanner.nextLine();
        System.out.println("Nhập số tín chỉ");
        int numberOfSignal = Integer.parseInt(scanner.nextLine());
        int tuition = numberOfSignal * 370;
        Subjects subjects = new Subjects(NameSubjects, StartTime, numberOfSignal, tuition);
        SaveSubjects.add(subjects);
        WriteReadSubjects.write(SaveSubjects);
    }

    public void show() {
        for (int i = 0; i < SaveSubjects.size(); i++) {
            System.out.println(SaveSubjects.get(i).toString());

        }
    }

    public int chekibyIndex(int index) {
        for (int i = 0; i < SaveSubjects.size(); i++) {
            if ((index - 1) == i) {
                return i;
            }

        }
        return -1;

    }

    public void RegisterSubjects() {
        show();
        System.out.println("Chọn môn học muốn đăng kí (nhập số để lựa chọn)");
        int index = Integer.parseInt(scanner.nextLine());
        if (index == -1) {
            System.err.println("Môn học khôn tồn tại");
        } else {
            if (!cheknamebysave(index)) {
                int indexbyi = chekibyIndex(index);
                SaveSubjects.get(indexbyi);

                ManageStudent.SaveStudent.get(ManageStudent.studentID).getSave().add(SaveSubjects.get(indexbyi));
                WriteReadStudent.write(ManageStudent.SaveStudent);

                System.out.println("Thành công");
            } else {
                System.err.println("Môn học đã được đăng kí");
            }
        }
    }


    public void showsave() {
        for (int i = 0; i < ManageStudent.SaveStudent.get(ManageStudent.studentID).getSave().size(); i++) {
            System.out.println(ManageStudent.SaveStudent.get(ManageStudent.studentID).getSave().get(i).toString());
        }
    }


    public int check_i_NameSub(String newNameSubjects) {
        for (int i = 0; i < SaveSubjects.size(); i++) {
            if (newNameSubjects.equals(SaveSubjects.get(i).getNameSubjects())) {
                return i;
            }

        }
        return -1;

    }

    public int check_i_Time(String newStartTime) {
        for (int i = 0; i < SaveSubjects.size(); i++) {
            if (newStartTime.equals(SaveSubjects.get(i).getStartTime())) {
                return i;
            }

        }
        return -1;

    }


    public void edit_subjects() {
        System.out.println(" Nhập tên môn hoc muốn sửa");
        String nameSubjects = scanner.nextLine();
        if (check_i_NameSub(nameSubjects) == -1) {
            System.err.println("Môn học muốn sửa không tồn tại ");
        } else {
            int index = check_i_NameSub(nameSubjects);
            System.out.println("Bạn muốn sửa gì");
            System.out.println("[1].Sửa tên môn học");
            System.out.println("[2].Sửa thời gian bắt đầu ");
            System.out.println("[3].Sửa số tín chỉ");
            System.out.println("[4].Thoát ");
            int Number = Integer.parseInt(scanner.nextLine());
            switch (Number) {
                case 1:
                    System.out.println("Nhập tên muốn thay đổi");
                    String newNameSubjects = scanner.nextLine();
                    System.out.println("Bạn có chắc chắn muốn thay đổi?");
                    System.out.println("[1].Có");
                    System.out.println("[2].Không");
                    Number = Integer.parseInt(scanner.nextLine());
                    switch (Number) {
                        case 1:
                            SaveSubjects.get(index).setNameSubjects(newNameSubjects);
                            WriteReadSubjects.write(SaveSubjects);
                            System.out.println("Thành công");
                            break;
                        case 2:
                            return;
                    }
                    break;
                case 2:
                    System.out.println("Nhập thời gian muốn thay dổi");
                    String newStarttime = scanner.nextLine();
                    System.out.println("Bạn có chắc chắn muốn thay đổi?");
                    System.out.println("[1].Có");
                    System.out.println("[2].Không");
                    Number = Integer.parseInt(scanner.nextLine());
                    switch (Number) {
                        case 1:
                            SaveSubjects.get(index).setStartTime(newStarttime);
                            WriteReadSubjects.write(SaveSubjects);
                            System.out.println("Thành công");
                            break;
                        case 2:
                            return;
                    }
                    break;
                case 3:
                    System.out.println("Nhập số tín chỉ muốn thay đổi");
                    int newNumberOfSignal = Integer.parseInt(scanner.nextLine());
                    System.out.println("Bạn có chắc chắn muốn thay đổi?");
                    System.out.println("[1].Có");
                    System.out.println("[2].Không");
                    Number = Integer.parseInt(scanner.nextLine());
                    switch (Number) {
                        case 1:
                            SaveSubjects.get(index).setNumberOfSignal(newNumberOfSignal);
                            WriteReadSubjects.write(SaveSubjects);
                            System.out.println("Thành công");
                            break;
                        case 2:
                            return;
                    }
                    break;
                case 4:
                    return;

            }

        }

    }

    public void delete() {
        System.out.println(" Nhập tên môn học muốn xóa ");
        String NameSubjects = scanner.nextLine();
        int index = manageSubjects.check_i_NameSub(NameSubjects);
        if (index == -1) {
            System.err.println("Môn học không tồn tại");

        } else {
            System.out.println("Bạn có chắc chắn muốn thay đổi?");
            System.out.println("[1].Có");
            System.out.println("[2].Không");
            int Number = Integer.parseInt(scanner.nextLine());
            switch (Number) {
                case 1:
                    SaveSubjects.remove(index);
                    WriteReadSubjects.write(SaveSubjects);
                    System.out.println("Đã xóa thành công");
                    break;
                case 2:
                    return;

            }
        }

    }


    public void SortbyNumber() {
        Collections.sort(SaveSubjects, new SortByNumberOfSinginah());
        for (int i = 0; i < SaveSubjects.size(); i++) {
            System.out.println(SaveSubjects.get(i).toString());
        }
    }

    public int chekishowmang(int index) {
        for (int i = 0; i < ManageStudent.SaveStudent.get(ManageStudent.studentID).save.size(); i++) {
            if ((index - 1) == i) {
                return i;
            }

        }
        return -1;
    }

    public void deletesubj() {
        showsave();
        System.out.println("Chọn môn học muốn xóa");
        int index = Integer.parseInt(scanner.nextLine());
        int idexbyi = chekishowmang(index);
        if (idexbyi == -1) {
            System.err.println("Môn học không tồn tại");
        } else {
            System.out.println("Bạn có chắc chắn muốn thay đổi?");
            System.out.println("[1].Có");
            System.out.println("[2].Không");
            int Number = Integer.parseInt(scanner.nextLine());
            switch (Number) {
                case 1:
                    ManageStudent.SaveStudent.get(ManageStudent.studentID).save.remove(idexbyi);
                    WriteReadStudent.write(ManageStudent.SaveStudent);
                    System.out.println("Đã xóa thành công");
                    break;
                case 2:
                    return;

            }

        }
    }


    public boolean cheknamebysave(int index) {
        for (int i = 0; i < ManageStudent.SaveStudent.get(ManageStudent.studentID).getSave().size(); i++) {
            if (SaveSubjects.get((index - 1)).getNameSubjects().equals(ManageStudent.SaveStudent
                    .get(ManageStudent.studentID).getSave().get(i).getNameSubjects())) {
                return true;
            }


        }
        return false;
    }




    public void SumTuition() {
        int sum = 0;
        for (int i = 0; i < ManageStudent.SaveStudent.get(ManageStudent.studentID).save.size(); i++) {
            sum += ManageStudent.SaveStudent.get(ManageStudent.studentID).save.get(i).getTuition();

            ManageStudent.SaveStudent.get(ManageStudent.studentID).setSumtuition(sum);

        }
        System.out.println(" Sinh viên " + '\'' + ManageStudent.SaveStudent.get(ManageStudent.studentID).getName()
                + '\'' + "có học phí là" + '\'' + ManageStudent.SaveStudent.get(ManageStudent.studentID).getSumtuition() + '\'' + "VND");


    }


}
