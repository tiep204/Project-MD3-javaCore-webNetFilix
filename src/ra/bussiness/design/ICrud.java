package ra.bussiness.design;

import java.util.List;
import java.util.Scanner;

public interface ICrud<T,E> {
    boolean create(T t);
    boolean update(T t);
    boolean delete(E id);
    boolean writeToFile(List<T> list);
    List<T> readFromFile();
    T inputData (Scanner sc);
    void displayData();
}