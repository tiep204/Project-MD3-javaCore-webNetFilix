package ra.presentation;

import ra.bussiness.entity.Film;
import ra.bussiness.entity.History;
import ra.bussiness.entity.User;
import ra.bussiness.impl.*;
import ra.config.Message;
import ra.config.Validation;

import java.time.Duration;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class UserMangerment {
    static FilmImpl filmIpml = new FilmImpl();
    static UserImpl userImpl = new UserImpl();
    static LikeImpl likeFilm = new LikeImpl();
    static Timer timer;
    static HistoryImpl historyImpl = new HistoryImpl();
    static long timeViews = 0;
    static User user;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        UserManagerment();
    }
    public static void UserManagerment() {
        boolean check = true;
        do {
            System.out.println(ANSI_CYAN +"                                                            +-------------------------------------------------------------+"+ ANSI_RESET);
            System.out.println(ANSI_YELLOW +"                                                            |      *****************Xin chào " + userImpl.userLogin().getUsername() + "*****************      |"+ ANSI_RESET);
            System.out.println(ANSI_CYAN +"                                                            +-------------------------------------------------------------+"+ ANSI_RESET);
            System.out.println("                                                            |                1. Show Toàn bộ phim                         |");
            System.out.println("                                                            |                2. Hiển thị phim...                          |");
            System.out.println("                                                            |                3. Search phim theo tên                      |");
            System.out.println("                                                            |                4. Danh sách phim của bạn đã like            |");
            System.out.println("                                                            |                5. Hiển thị lịch sử                          |");
            System.out.println("                                                            |                6. Tài khoản                                 |");
            System.out.println("                                                            |                7. Xem phim                                  |");
            System.out.println("                                                            |                8. Đăng xuất                                 |");
            System.out.println("                                                            |                                                             |");
            System.out.println(ANSI_CYAN +"                                                            +-------------------------------------------------------------+"+ ANSI_RESET);
            System.out.println(ANSI_CYAN +"                                                            |            Sự lựa chọn của bạn:                             |"+ ANSI_RESET);
            System.out.println(ANSI_CYAN +"                                                            +-------------------------------------------------------------+"+ ANSI_RESET);

            int choice = Validation.getInteger();
            switch (choice) {
                case 1:
                    System.out.println(ANSI_CYAN +"                                                            +-------------------------------------------------------------+"+ ANSI_RESET);
                    System.out.println(ANSI_YELLOW +"                                                            |                1. Show Toàn bộ phim                         |"+ ANSI_RESET);
                    System.out.println("                                                            |                2. Hiển thị phim...                          |");
                    System.out.println("                                                            |                3. Search phim theo tên                      |");
                    System.out.println("                                                            |                4. Danh sách phim của bạn đã like            |");
                    System.out.println("                                                            |                5. Hiển thị lịch sử                          |");
                    System.out.println("                                                            |                6. Tài khoản                                 |");
                    System.out.println("                                                            |                7. Xem phim                                  |");
                    System.out.println("                                                            |                8. Đăng xuất                                 |");
                    System.out.println("                                                            |                                                             |");
                    System.out.println(ANSI_CYAN +"                                                            +-------------------------------------------------------------+"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN +"                                                            |            Sự lựa chọn của bạn:                             |"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN +"                                                            +-------------------------------------------------------------+"+ ANSI_RESET);
                    getAllFilm();
                    break;
                case 2:
                    System.out.println(ANSI_CYAN +"                                                            +-------------------------------------------------------------+"+ ANSI_RESET);
                    System.out.println("                                                            |                1. Show Toàn bộ phim                         |");
                    System.out.println(ANSI_YELLOW +"                                                            |                2. Hiển thị phim...                          |"+ ANSI_RESET);
                    System.out.println("                                                            |                3. Search phim theo tên                      |");
                    System.out.println("                                                            |                4. Danh sách phim của bạn đã like            |");
                    System.out.println("                                                            |                5. Hiển thị lịch sử                          |");
                    System.out.println("                                                            |                6. Tài khoản                                 |");
                    System.out.println("                                                            |                7. Xem phim                                  |");
                    System.out.println("                                                            |                8. Đăng xuất                                 |");
                    System.out.println("                                                            |                                                             |");
                    System.out.println(ANSI_CYAN +"                                                            +-------------------------------------------------------------+"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN +"                                                            |            Sự lựa chọn của bạn:                             |"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN +"                                                            +-------------------------------------------------------------+"+ ANSI_RESET);
                    MenuViewsFilm.viewsFilm();
                    break;
                case 3:
                    System.out.println(ANSI_CYAN +"                                                            +-------------------------------------------------------------+"+ ANSI_RESET);
                    System.out.println("                                                            |                1. Show Toàn bộ phim                         |");
                    System.out.println("                                                            |                2. Hiển thị phim...                          |");
                    System.out.println(ANSI_YELLOW +"                                                            |                3. Search phim theo tên                      |"+ ANSI_RESET);
                    System.out.println("                                                            |                4. Danh sách phim của bạn đã like            |");
                    System.out.println("                                                            |                5. Hiển thị lịch sử                          |");
                    System.out.println("                                                            |                6. Tài khoản                                 |");
                    System.out.println("                                                            |                7. Xem phim                                  |");
                    System.out.println("                                                            |                8. Đăng xuất                                 |");
                    System.out.println("                                                            |                                                             |");
                    System.out.println(ANSI_CYAN +"                                                            +-------------------------------------------------------------+"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN +"                                                            |            Sự lựa chọn của bạn:                             |"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN +"                                                            +-------------------------------------------------------------+"+ ANSI_RESET);
                    searchByName();
                    break;
                case 4:
                    System.out.println(ANSI_CYAN +"                                                            +-------------------------------------------------------------+"+ ANSI_RESET);
                    System.out.println("                                                            |                1. Show Toàn bộ phim                         |");
                    System.out.println("                                                            |                2. Hiển thị phim...                          |");
                    System.out.println("                                                            |                3. Search phim theo tên                      |");
                    System.out.println(ANSI_YELLOW +"                                                            |                4. Danh sách phim của bạn đã like            |"+ ANSI_RESET);
                    System.out.println("                                                            |                5. Hiển thị lịch sử                          |");
                    System.out.println("                                                            |                6. Tài khoản                                 |");
                    System.out.println("                                                            |                7. Xem phim                                  |");
                    System.out.println("                                                            |                8. Đăng xuất                                 |");
                    System.out.println("                                                            |                                                             |");
                    System.out.println(ANSI_CYAN +"                                                            +-------------------------------------------------------------+"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN +"                                                            |            Sự lựa chọn của bạn:                             |"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN +"                                                            +-------------------------------------------------------------+"+ ANSI_RESET);
                    getAllLike();
                    break;
                case 5:
                    history();
                    break;
                case 6:
                    System.out.println(ANSI_CYAN +"                                                            +-------------------------------------------------------------+"+ ANSI_RESET);
                    System.out.println("                                                            |                1. Show Toàn bộ phim                         |");
                    System.out.println("                                                            |                2. Hiển thị phim...                          |");
                    System.out.println("                                                            |                3. Search phim theo tên                      |");
                    System.out.println("                                                            |                4. Danh sách phim của bạn đã like            |");
                    System.out.println("                                                            |                5. Hiển thị lịch sử                          |");
                    System.out.println(ANSI_YELLOW +"                                                            |                6. Tài khoản                                 |"+ ANSI_RESET);
                    System.out.println("                                                            |                7. Xem phim                                  |");
                    System.out.println("                                                            |                8. Đăng xuất                                 |");
                    System.out.println("                                                            |                                                             |");
                    System.out.println(ANSI_CYAN +"                                                            +-------------------------------------------------------------+"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN +"                                                            |            Sự lựa chọn của bạn:                             |"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN +"                                                            +-------------------------------------------------------------+"+ ANSI_RESET);
                    AccountMenu.account();
                    break;
                case 7:
                    System.out.println(ANSI_CYAN +"                                                            +-------------------------------------------------------------+"+ ANSI_RESET);
                    System.out.println("                                                            |                1. Show Toàn bộ phim                         |");
                    System.out.println("                                                            |                2. Hiển thị phim...                          |");
                    System.out.println("                                                            |                3. Search phim theo tên                      |");
                    System.out.println("                                                            |                4. Danh sách phim của bạn đã like            |");
                    System.out.println("                                                            |                5. Hiển thị lịch sử                          |");
                    System.out.println("                                                            |                6. Tài khoản                                 |");
                    System.out.println(ANSI_YELLOW +"                                                            |                7. Xem phim                                  |"+ ANSI_RESET);
                    System.out.println("                                                            |                8. Đăng xuất                                 |");
                    System.out.println("                                                            |                                                             |");
                    System.out.println(ANSI_CYAN +"                                                            +-------------------------------------------------------------+"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN +"                                                            |            Sự lựa chọn của bạn:                             |"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN +"                                                            +-------------------------------------------------------------+"+ ANSI_RESET);
                    watchFilm();
                    break;
                case 8:
                    System.out.println(ANSI_CYAN +"                                                            +-------------------------------------------------------------+"+ ANSI_RESET);
                    System.out.println("                                                            |                1. Show Toàn bộ phim                         |");
                    System.out.println("                                                            |                2. Hiển thị phim...                          |");
                    System.out.println("                                                            |                3. Search phim theo tên                      |");
                    System.out.println("                                                            |                4. Danh sách phim của bạn đã like            |");
                    System.out.println("                                                            |                5. Hiển thị lịch sử                          |");
                    System.out.println("                                                            |                6. Tài khoản                                 |");
                    System.out.println("                                                            |                7. Xem phim                                  |");
                    System.out.println(ANSI_YELLOW +"                                                            |                8. Đăng xuất                                 |"+ ANSI_RESET);
                    System.out.println("                                                            |                                                             |");
                    System.out.println(ANSI_CYAN +"                                                            +-------------------------------------------------------------+"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN +"                                                            |            Sự lựa chọn của bạn:                             |"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN +"                                                            +-------------------------------------------------------------+"+ ANSI_RESET);
                    user = null;
                    Run.main(new String[]{});
                    break;
                    default:
                    System.err.println(Message.EXIT_CHOICE_MENU_USER);
            }
        } while (check);
    }

    public static void history() {
        historyImpl.displayUserHistory();
    }

    public static void getAllFilm() {
        filmIpml.displayDataFilmMenuUser();
    }

    public static void searchByName() {
        filmIpml.searchByName();
    }

    public static void getAllLike() {
        likeFilm.displayData();
    }

    public static void watchFilm() {
        getAllFilm();
        System.out.println(Message.CHOICE_ID_FILM);
        int id = Validation.getInteger();
        Film film = filmIpml.findByid(id);
        if (film == null) {
            System.out.println(Message.NOT_ID_FILM);
        } else {
            if (film.isFilmType()){
                EpisodeImpl episodeImpl = new EpisodeImpl();
                episodeImpl.displayDataDetail(id);
                System.out.println("1. Xem phim                    2.Thoát");
                int co = Validation.getInteger( );
                if (co == 1){
                    System.out.println("Vui lòng chọn id tập phim để xem phim");
                    String tapPhim = Validation.getString();
                    System.err.println("Chức năng này chúng tôi đang phát triền vui lòng quay lại sau");
                }
            }else {
                System.out.println("Bạn đang xem " + film.getFilmName());
                boolean continueWatching = true;
                Duration duration = film.getDuration();
                History history = historyImpl.getHistoryByUIdAndFId(userImpl.userLogin().getUserId(), film.getFilmId());
                if (history == null){
                    history = new History();
                    history.setUserId(userImpl.userLogin());
                    history.setFilmId(film);

                }
                History newHistory = history;
                HistoryImpl service = new HistoryImpl();
                newHistory.setDateTime(new Date());
                rungingFilm(duration, newHistory); // Truyền đối tượng history vào phương thức rungingFilm
                do {
                    System.out.println(Message.CHOI_WATCH_FILM);
                    int choice = Validation.getInteger();
                    switch (choice) {
                        case 1:
                            pauseTimer();
                            break;
                        case 2:
                            boolean liked = likeFilm.toggleLikeFilm(userImpl.userLogin(), film);
                            if (!liked) {
                                System.out.println("Bạn đã like phim " + film.getFilmName());
                            } else {
                                System.out.println("Bạn đã bỏ like phim " + film.getFilmName());
                            }
                            break;
                        case 3:
                            newHistory.setWatchTime(Duration.ofSeconds(newHistory.getRunningTime())); // Lưu thời gian chạy vào đối tượng history
                            service.create(newHistory);
                            System.out.println(Message.OUT_WATCH_FILM);
                            continueWatching = false;
                            timer.cancel();
                            break;
                        default:
                            System.err.println(Message.CHOICE_WATCH_1_3);
                            break;
                    }
                } while (continueWatching);
            }
            }

    }


    private static AtomicBoolean pause = new AtomicBoolean(false);

    public static void rungingFilm(Duration duration, History history) {
        Duration filmDuration = duration;
        System.out.println(history.getFilmId().getFilmName());
        timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                if (!pause.get()) {
                    history.setRunningTime(history.getRunningTime() + 1);;
                    Duration elapsedDuration = Duration.ofSeconds(history.getRunningTime());
                    long hours = elapsedDuration.toHours();
                    long minutes = elapsedDuration.minusHours(hours).toMinutes();
                    long seconds = elapsedDuration.minusHours(hours).minusMinutes(minutes).getSeconds();
                    String formattedTime = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                    System.out.print("\r" + formattedTime);
                    if (history.getRunningTime() >= filmDuration.getSeconds()) {
                        System.out.println("\nHết phim.");
                        history.setWatchTime(Duration.ofSeconds(history.getRunningTime())); // Lưu thời gian chạy vào đối tượng history
                        timer.cancel(); // Hủy tác vụ timer
                    }
                }
            }
        };
        timer.schedule(task, 0, 1000);
    }

    public static void pauseTimer() {
        pause.set(!pause.get());
        if (pause.get()) {
            System.out.println(Message.STOP_FILM);
        } else {
            System.out.println(Message.RUN_FILM);
        }
    }
}