package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student extends Admin implements Serializable{
    private String Name;
    private int age;
    private String IdStudent;
    private String ClassStudent;
    public List<Subjects> save= new ArrayList<>();
    public List<Integer> save1= new ArrayList<>();
    private int Sumtuition;

    public Student() {
    }




    public Student(String accountName, String password, String name, int age, String idStudent
            , String classStudent, List<Subjects> save, List<Integer> save1, int sumtuition) {
        super(accountName, password);
        Name = name;
        this.age = age;
        IdStudent = idStudent;
        ClassStudent = classStudent;
        this.save = save;
        this.save1 = save1;
        Sumtuition = sumtuition;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdStudent() {
        return IdStudent;
    }

    public void setIdStudent(String idStudent) {
        IdStudent = idStudent;
    }

    public String getClassStudent() {
        return ClassStudent;
    }

    public void setClassStudent(String classStudent) {
        ClassStudent = classStudent;
    }

    public List<Subjects> getSave() {
        return save;
    }

    public void setSave(List<Subjects> save) {
        this.save = save;
    }

    public List<Integer> getSave1() {
        return save1;
    }

    public void setSave1(List<Integer> save1) {
        this.save1 = save1;
    }

    public int getSumtuition() {
        return Sumtuition;
    }

    public void setSumtuition(int sumtuition) {
        Sumtuition = sumtuition;
    }

    @Override
    public String toString() {
        return "Student{" +super.toString()+
                "Name='" + Name + '\'' +
                ", age=" + age +
                ", IdStudent='" + IdStudent + '\'' +
                ", ClassStudent='" + ClassStudent + '\'' +
                ", save=" + save +
                ", save1=" + save1 +
                '}';
    }

}
