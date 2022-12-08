package Sort;

import Model.Subjects;

import java.util.Comparator;

public class SortByNumberOfSinginah implements Comparator<Subjects> {


    @Override
    public int compare(Subjects o1, Subjects o2) {
       if (o1.getNumberOfSignal()>o2.getNumberOfSignal()){
           return 1;

       }else if (o1.getNumberOfSignal()<o2.getNumberOfSignal()){
           return -1;
       }else {
           return 0;
       }
    }
}
