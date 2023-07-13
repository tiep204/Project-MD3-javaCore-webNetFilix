package ra.data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileImpl<T> {
    public List<T> readDataFromFile(String filePath) {
        File file = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<T> list = new ArrayList<>();
        try {
            file = new File(filePath);
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            list = (List<T>) ois.readObject();
        } catch (EOFException e) {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public boolean writeDataToFile(List<T> list, String filePath) {
        File file = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        boolean result = false;
        try {
            file = new File(filePath);
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}