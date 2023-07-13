package ra.bussiness.impl;

import ra.bussiness.design.ICrud;
import ra.bussiness.entity.History;
import ra.config.Constanst;
import ra.config.Validation;
import ra.data.FileImpl;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HistoryImpl implements ICrud<History, Integer> {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public UserImpl user = new UserImpl();

    private int newId() {
        List<History> list = readFromFile();
        int maxId = 0;
        for (History h : list) {
            if (h.getHistoryId() > maxId) {
                maxId = h.getHistoryId();
            }
        }
        return maxId + 1;
    }

    @Override
    public boolean create(History history) {
        List<History> list = readFromFile();
        if (list == null) {
            list = new ArrayList<>();
        }
//        if (history.getHistoryId() == 0){
//            history.setHistoryId(newId());
//            list.add(history);
//            return writeToFile(list);
//        }
//        boolean check = false;
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getUserId().getUserId() == history.getUserId().getUserId() && history.getFilmId().getFilmId() == list.get(i).getFilmId().getFilmId()){
//                list.set(i, history);
//                check = true;
//                break;
//            }
//        }
//        if (!check) {
        list.add(history);
//        }
        return writeToFile(list);
    }

    @Override
    public boolean update(History history) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean writeToFile(List<History> list) {
        FileImpl<History> filmFile = new FileImpl<>();
        return filmFile.writeDataToFile(list, Constanst.HISTORY_URL_FILE);
    }

    @Override
    public List<History> readFromFile() {
        FileImpl<History> filmFile = new FileImpl<>();
        return filmFile.readDataFromFile(Constanst.HISTORY_URL_FILE);
    }

    @Override
    public History inputData(Scanner sc) {
        return null;
    }

    @Override
    public void displayData() {
        List<History> userHistory = readFromFile();
        System.out.println("Mời bạn nhập id người dùng bạn muốn xem lịch sử xem phim");
        int id = Validation.getInteger();
        System.out.println(ANSI_CYAN +"                  -------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
        System.out.println(ANSI_YELLOW +"                                                  *****************************Lịch sử xem phim***********************************"+ ANSI_RESET);
        System.out.println(ANSI_CYAN +"                  -------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
        System.out.printf(ANSI_YELLOW +"                   %-10s %-30s %-30s %-20s %-30s %-30s\n", "ID Phim", "Tên phim", "Ngày xem", "Tập phim", "Thời gian xem", "Người dùng");
        System.out.println(ANSI_CYAN +"                  -------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
        for (History history : userHistory) {
            if (history.getUserId().getUserId() == id) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String filmId = String.valueOf(history.getFilmId().getFilmId());
                String filmName = history.getFilmId().getFilmName();
                String watchDate = dateFormat.format(history.getDateTime());
                String episodeName = history.getEpisodeId() != null ? history.getEpisodeId().getEpisodeName() : "null";
                String watchTime = formatDuration(history.getWatchTime());
                String userName = history.getUserId().getUsername();
                System.out.printf("                   %-10s %-30s %-30s %-20s %-30s %-20s\n", filmId, filmName, watchDate, episodeName, watchTime, userName);
            }
        }
        System.out.println(ANSI_CYAN +"                  -------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
    }


    public void displayUserHistory() {
        List<History> userHistory = readFromFile();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("Lịch sử xem phim của bạn:");
        System.out.println("---------------------------------------");
        System.out.printf("%-20s %-20s %-20s %-20s\n", "Tên phim", "Ngày xem", "Tập phim", "Thời gian xem");
        for (History history : userHistory) {
            if (user.userLogin().getUserId() == history.getUserId().getUserId()) {
                String filmName = history.getFilmId().getFilmName();
                String watchDate = dateFormat.format(history.getDateTime());
                String episodeName = history.getEpisodeId() != null ? history.getEpisodeId().getEpisodeName() : "null";
                String watchTime = formatDuration(history.getWatchTime());
                System.out.printf("%-20s %-20s %-20s %-20s\n", filmName, watchDate, episodeName, watchTime);
            }
        }
        System.out.println("---------------------------------------");
    }

    private String formatDuration(Duration duration) {
        long hours = duration.toHours();
        long minutes = duration.minusHours(hours).toMinutes();
        long seconds = duration.minusHours(hours).minusMinutes(minutes).getSeconds();
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public History getHistoryByUIdAndFId(int uId, int fId) {
        List<History> list = readFromFile();
        History result = null;
        for (History h : list) {
            if (h.getFilmId().getFilmId() == fId && h.getUserId().getUserId() == uId) {
                result = h;
            }
        }
        return result;
    }
}