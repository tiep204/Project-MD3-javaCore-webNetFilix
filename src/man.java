import ra.config.Validation;

import java.time.Duration;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class man {
    public static void main(String[] args) {
        /*Duration duration = Duration.ofMinutes(1);*/
        /*rungingFilm(duration);*/
        System.out.println("      -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                                          *****************************Danh sách phim***********************************");
        System.out.println("      -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("      %-10s %-25s %-40s %-45s %-20s %-20s %-25s\n",
                "ID", "Tên phim", "Tiêu đề", "Thể loại", "Quốc gia", "Ngôn ngữ", "Loại phim", "Năm phát hành", "Trạng thái");
        System.out.println("      -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    private static AtomicBoolean pause = new AtomicBoolean(true);

    public static void rungingFilm(Duration duration) {
        Duration duration1 = duration;
        final long[] runningTime = {0l};
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int count = 0;

            public void run() {
                if (pause.get()) {
                    return;
                }
                runningTime[0] += 2;
                System.out.println("thời gian đã chạy được: " + Duration.ofSeconds(runningTime[0]));
                if (runningTime[0] >= duration.getSeconds()) {
                    System.out.println("hết phim");
                    this.cancel();
                }
            }
        };
        timer.schedule(task, 0, 2000);
        int choice;
        while (true) {
            if (pause.get()) {
                System.out.println("1. tiếp tục");
                System.out.println("2. dừng hẳn");
                choice = Validation.getInteger();
                if (choice == 1) {
                    pause.set(false);
                    System.out.println("đã tiếp tục");
                } else if (choice == 2) {
                    task.cancel();
                } else System.out.println("nhập không đúng");
            } else {
                System.out.println("1. tạm dừng");
                System.out.println("2. dừng hẳn");
                choice = Validation.getInteger();
                if (choice == 1) {
                    pause.set(true);
                    System.out.println(" đã tạm dừng");
                } else if (choice == 2) {
                    task.cancel();
                } else System.out.println("nhập không đúng");
            }
        }
    }
    public static Duration parseDuration(String durationStr) {
        String[] parts = durationStr.split("h|H|m|M|s|S");
        long hours = 0;
        long minutes = 0;
        long seconds = 0;
        for (String part : parts) {
            if (part.isEmpty()) {
                continue;
            }
            long value = Long.parseLong(part.replaceAll("[^\\d]", "").trim());
            if (part.contains("h") || part.contains("H")) {
                hours += value;
            } else if (part.contains("m") || part.contains("M")) {
                minutes += value;
            } else if (part.contains("s") || part.contains("S")) {
                seconds += value;
            }
        }
        return Duration.ofHours(hours).plusMinutes(minutes).plusSeconds(seconds);
    }

}