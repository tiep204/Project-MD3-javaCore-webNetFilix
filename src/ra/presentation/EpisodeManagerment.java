package ra.presentation;

import ra.bussiness.entity.Episode;
import ra.bussiness.impl.EpisodeImpl;
import ra.config.Validation;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class EpisodeManagerment {
    static EpisodeImpl episodeImpl = new EpisodeImpl();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void episodeManagerment() {
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        do {
            System.out.println(ANSI_CYAN + "                                                            **********************************************************"+ ANSI_RESET);
            System.out.println(ANSI_YELLOW +"                                                            *                    Quản lý Tập phim                    *"+ ANSI_RESET);
            System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*"+ ANSI_RESET);
            System.out.println("                                                            *   1. Thêm Tập phim                                     *");
            System.out.println("                                                            *   2. Sửa tập phim                                      *");
            System.out.println("                                                            *   3. Xóa tập phim                                      *");
            System.out.println("                                                            *   4. Hiển thị tập phim                                 *");
            System.out.println("                                                            *   5. Hiển thị tập phim theo tên phim                   *");
            System.out.println("                                                            *   6. Thoát                                             *");
            System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*"+ ANSI_RESET);
            System.out.println(ANSI_CYAN + "                                                            *   Sự lựa chọn của bạn:                                 *"+ ANSI_RESET);
            System.out.println(ANSI_CYAN + "                                                            **********************************************************"+ ANSI_RESET);
            int choice = Validation.getInteger();
            switch (choice) {
                case 1:
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************"+ ANSI_RESET);
                    System.out.println("                                                            *                    Quản lý Tập phim                    *");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*"+ ANSI_RESET);
                    System.out.println(ANSI_YELLOW +"                                                            *   1. Thêm Tập phim                                     *"+ ANSI_RESET);
                    System.out.println("                                                            *   2. Sửa tập phim                                      *");
                    System.out.println("                                                            *   3. Xóa tập phim                                      *");
                    System.out.println("                                                            *   4. Hiển thị tập phim                                 *");
                    System.out.println("                                                            *   5. Hiển thị tập phim theo tên phim                   *");
                    System.out.println("                                                            *   6. Thoát                                             *");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            *   Sự lựa chọn của bạn:                                 *"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************"+ ANSI_RESET);
                    create(sc);
                    break;
                case 2:
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************"+ ANSI_RESET);
                    System.out.println("                                                            *                    Quản lý Tập phim                    *");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*"+ ANSI_RESET);
                    System.out.println("                                                            *   1. Thêm Tập phim                                     *");
                    System.out.println(ANSI_YELLOW +"                                                            *   2. Sửa tập phim                                      *"+ ANSI_RESET);
                    System.out.println("                                                            *   3. Xóa tập phim                                      *");
                    System.out.println("                                                            *   4. Hiển thị tập phim                                 *");
                    System.out.println("                                                            *   5. Hiển thị tập phim theo tên phim                   *");
                    System.out.println("                                                            *   6. Thoát                                             *");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            *   Sự lựa chọn của bạn:                                 *"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************"+ ANSI_RESET);
                    getAll();
                    update();
                    break;
                case 3:
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************"+ ANSI_RESET);
                    System.out.println("                                                            *                    Quản lý Tập phim                    *");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*"+ ANSI_RESET);
                    System.out.println("                                                            *   1. Thêm Tập phim                                     *");
                    System.out.println("                                                            *   2. Sửa tập phim                                      *");
                    System.out.println(ANSI_YELLOW +"                                                            *   3. Xóa tập phim                                      *"+ ANSI_RESET);
                    System.out.println("                                                            *   4. Hiển thị tập phim                                 *");
                    System.out.println("                                                            *   5. Hiển thị tập phim theo tên phim                   *");
                    System.out.println("                                                            *   6. Thoát                                             *");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            *   Sự lựa chọn của bạn:                                 *"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************"+ ANSI_RESET);
                    getAll();
                    deleteStatus();
                    break;
                case 4:
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************"+ ANSI_RESET);
                    System.out.println("                                                            *                    Quản lý Tập phim                    *");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*"+ ANSI_RESET);
                    System.out.println("                                                            *   1. Thêm Tập phim                                     *");
                    System.out.println("                                                            *   2. Sửa tập phim                                      *");
                    System.out.println("                                                            *   3. Xóa tập phim                                      *");
                    System.out.println(ANSI_YELLOW +"                                                            *   4. Hiển thị tập phim                                 *"+ ANSI_RESET);
                    System.out.println("                                                            *   5. Hiển thị tập phim theo tên phim                   *");
                    System.out.println("                                                            *   6. Thoát                                             *");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            *   Sự lựa chọn của bạn:                                 *"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************"+ ANSI_RESET);
                    getAll();
                    break;
                case 5:
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************"+ ANSI_RESET);
                    System.out.println("                                                            *                    Quản lý Tập phim                    *");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*"+ ANSI_RESET);
                    System.out.println("                                                            *   1. Thêm Tập phim                                     *");
                    System.out.println("                                                            *   2. Sửa tập phim                                      *");
                    System.out.println("                                                            *   3. Xóa tập phim                                      *");
                    System.out.println("                                                            *   4. Hiển thị tập phim                                 *");
                    System.out.println(ANSI_YELLOW +"                                                            *   5. Hiển thị tập phim theo tên phim                   *"+ ANSI_RESET);
                    System.out.println("                                                            *   6. Thoát                                             *");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            *   Sự lựa chọn của bạn:                                 *"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************"+ ANSI_RESET);
                    getAll();
                    searchEpisodeByFilm();
                    break;
                case 6:
                    check = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1-5");
            }
        } while (check);
    }

    public static void create(Scanner sc) {
        System.out.println("Mời bạn nhập số lượng tập phim bạn muốn thêm: ");
        int number = Validation.getInteger();
        for (int i = 0; i < number; i++) {
            Episode episode = new Episode();
            System.out.println("Tập phim thứ " + (i + 1));
            episode = episodeImpl.inputData(sc);
            boolean check = episodeImpl.create(episode);
            Validation.soutMess(check);
        }
    }

    public static void getAll() {
        episodeImpl.displayData();
    }

    public static void update() {
        List<Episode> episodeList = episodeImpl.readFromFile();
        System.out.println("Mời bạn nhập vào id tập phim bạn muốn cập nhật: ");
        int id = Validation.getInteger();
        boolean check = false;
        for (Episode episode : episodeList) {
            if (episode.getEpisodeId() == id) {
                check = true;
                System.out.println("Bạn muốn cập nhật Tên tập phim không: ");
                System.out.println("1.có                           2.không");
                int choice = Validation.getInteger();
                if (choice == 1) {
                    System.out.println("Mời bạn nhập tên phim muốn cập nhật: ");
                    episode.setEpisodeName(Validation.checkEpisodeName(episode.getFilmId().getFilmId()));
                }
                System.out.println("Bạn muốn cập nhật mô tả tập phim không:");
                System.out.println("1.có                           2.không");
                int choice1 = Validation.getInteger();
                if (choice1 == 1) {
                    System.out.println("Mời bạn nhập mô tả tập muốn cập nhật: ");
                    episode.setDecription(Validation.getString());
                }
                System.out.println("Bạn muốn cập nhật thời lượng tập phim không:");
                System.out.println("1.có                           2.không");
                int choice2 = Validation.getInteger();
                if (choice2 == 1) {
                    System.out.println("Mời bạn nhập thời lượng tập muốn cập nhật: ");
                    String durationStr = Validation.getString();
                    Duration duration = Validation.parseDuration(durationStr);
                    episode.setDuration(duration);
                }
                System.out.println("Bạn muốn cập nhật link tập phim không:");
                System.out.println("1.có                           2.không");
                int choice3 = Validation.getInteger();
                if (choice3 == 1) {
                    System.out.println("Mời bạn nhập link tập muốn cập nhật: ");
                    episode.setUrl(Validation.getString());
                }
                System.out.println("Bạn muốn cập nhật trạng thái tập phim không:");
                System.out.println("1.có                           2.không");
                int choice4 = Validation.getInteger();
                if (choice4 == 1) {
                    System.out.println("Mời bạn nhập quốc gia mà bạn muốn cập nhật: ");
                    System.out.println("1.Hoạt động                 2.không hoạt động");
                    int choicee = Validation.getInteger();
                    switch (choicee) {
                        case 1:
                            episode.setStatus(true);
                            break;
                        case 2:
                            episode.setStatus(false);
                            break;
                        default:
                            System.err.println("Vui lòng chọn từ 1-2");
                    }
                    break;
                }
                episodeImpl.update(episode);
            }
        }
        if (!check) {
            System.out.println("Không tìm thấy tập phim với ID đã nhập.");
        } else {
            episodeImpl.writeToFile(episodeList);
            System.out.println("Cập nhật phim thành công.");
        }
    }

    public static void deleteStatus() {
        System.out.println("Mời bạn nhập vào id phim bạn muốn ngừng phát/phát");
        int id = Validation.getInteger();
        boolean check = episodeImpl.delete(id);
        if (check) {
            System.out.println("bạn đã cập nhật trạng thái tập phim thành công");
        } else {
            System.err.println(" cập nhật trạng thái tập phim không thành công");
        }
    }

    public static void searchEpisodeByFilm() {
        System.out.println("Mời bạn nhập tên phim");
        String name = Validation.getString();
        List<Episode> episodeList = episodeImpl.findByEpisodeName(name);
        if (episodeList == null || episodeList.isEmpty()) {
            System.out.println("Không có tập phim nào phù hợp.");
        } else {
            System.out.println(ANSI_CYAN +"                     -----------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
            System.out.println(ANSI_YELLOW +"                                                 *****************************Danh sách tập phim***********************************"+ ANSI_RESET);
            System.out.println(ANSI_CYAN +"                     -----------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
            System.out.printf(ANSI_YELLOW +"                        %-10s %-25s %-25s %-25s %-30s %-20s \n", "ID", "Tên tập phim", "Tên phim", "Thời lượng", "Ngày phát hành", "Trạng thái"+ ANSI_RESET);
            System.out.println(ANSI_CYAN +"                     -----------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
            for (Episode episode : episodeList) {
                Duration duration = episode.getDuration();
                String durationStr;
                if (duration != null) {
                    long hours = duration.toHours();
                    long minutes = duration.toMinutes() % 60;
                    long seconds = duration.getSeconds() % 60;
                    durationStr = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                } else {
                    durationStr = "";
                }
                String pattern = "dd-M-yyyy hh:mm:ss";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                System.out.printf("                        %-10s %-25s %-25s %-25s %-30s %-20s%n", episode.getEpisodeId(), episode.getEpisodeName(), episode.getFilmId().getFilmName(),
                        durationStr, simpleDateFormat.format(episode.getReleaseDate()),
                        (episode.isStatus() ? "Đang phát" : "Ngừng phát"));
            }
            System.out.println(ANSI_CYAN +"                     -----------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
        }
    }

}