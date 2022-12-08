package OI;

import Model.Subjects;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class WriteReadSubjects {
    static String url = "Subjects4.txt";

    public static void write(List<Subjects> SaveSubjects) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(url);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(SaveSubjects);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            System.err.println("Lỗi");
        }


    }

    public static List<Subjects> read() {

        try {
            FileInputStream fileInputStream = new FileInputStream(url);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (List<Subjects>) objectInputStream.readObject();

        } catch (Exception e) {
            System.err.println("Lỗi");
            return new ArrayList<>();
        }
    }
}
