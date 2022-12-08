package OI;

import Model.Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class WriteReadStudent {
    static String url = "Studnet4.txt";

    public static void write(List<Student> SaveStudent) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(url);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(SaveStudent);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            System.err.println("Lỗi");
        }


    }

    public static List<Student> read() {

        try {
            FileInputStream fileInputStream = new FileInputStream(url);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (List<Student>) objectInputStream.readObject();

        } catch (Exception e) {
            System.err.println("Lỗi");
            return new ArrayList<>();
        }
    }
}
