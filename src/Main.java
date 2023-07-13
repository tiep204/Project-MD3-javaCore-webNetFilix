import ra.bussiness.impl.FilmImpl;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    private static FilmImpl film = new FilmImpl();

    public static void main(String[] args) throws InterruptedException {




        System.out.println("                  -------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                                  *****************************Lịch sử xem phim***********************************");
        System.out.println("                  -------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("                   %-10s %-30s %-30s %-20s %-30s %-30s\n", "ID Phim", "Tên phim", "Ngày xem", "Tập phim", "Thời gian xem", "Người dùng");
        System.out.println("                  -------------------------------------------------------------------------------------------------------------------------------------------------");


        /*Duration runningTime = Duration.ofSeconds(0);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        while (true) {
            runningTime = runningTime.plusSeconds(1);
            String formattedTime = LocalTime.MIDNIGHT.plus(runningTime).format(timeFormatter);
            System.out.print("\r" + formattedTime);
            Thread.sleep(1000);
        }*/
    }
}
