package ra.presentation;

import ra.bussiness.impl.FilmImpl;
import ra.config.Validation;

public class MenuViewsFilm {
    static FilmImpl film = new FilmImpl();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void viewsFilm() {
        boolean check = true;
        do {
            System.out.println(ANSI_CYAN + "                                                            +--------------------------------------------------+" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "                                                            +****************Hiển thị phim ********************+" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "                                                            +--------------------------------------------------+" + ANSI_RESET);
            System.out.println("                                                            |              1. Hiển thị phim mới                |" + ANSI_RESET);
            System.out.println("                                                            |              2. Hiển thị phim theo thể loại      |" + ANSI_RESET);
            System.out.println("                                                            |              3. Hiển thị phim lẻ                 |" + ANSI_RESET);
            System.out.println("                                                            |              4. Hiển thị phim bộ                 |" + ANSI_RESET);
            System.out.println("                                                            |              5. Tìm kiếm phim theo quốc gia      |" + ANSI_RESET);
            System.out.println("                                                            |              6. Thoát                            |" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "                                                            +-------------------------------------------------+" + ANSI_RESET);
            System.out.print(ANSI_CYAN + "                                                                           Sự lựa chọn của bạn: ");
            System.out.println(ANSI_CYAN + "                                                            +-------------------------------------------------+" + ANSI_RESET);

            int choice = Validation.getInteger();
            switch (choice) {
                case 1:
                    System.out.println(ANSI_CYAN + "                                                            +--------------------------------------------------+" + ANSI_RESET);
                    System.out.println(ANSI_YELLOW + "                                                            +****************Hiển thị phim ********************+" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            +--------------------------------------------------+" + ANSI_RESET);
                    System.out.println(ANSI_YELLOW + "                                                            |              1. Hiển thị phim mới                |" + ANSI_RESET);
                    System.out.println("                                                            |              2. Hiển thị phim theo thể loại      |" + ANSI_RESET);
                    System.out.println("                                                            |              3. Hiển thị phim lẻ                 |" + ANSI_RESET);
                    System.out.println("                                                            |              4. Hiển thị phim bộ                 |" + ANSI_RESET);
                    System.out.println("                                                            |              5. Tìm kiếm phim theo quốc gia      |" + ANSI_RESET);
                    System.out.println("                                                            |              6. Thoát                            |" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            +-------------------------------------------------+" + ANSI_RESET);
                    System.out.print(ANSI_CYAN + "                                                                           Sự lựa chọn của bạn: ");
                    System.out.println(ANSI_CYAN + "                                                            +-------------------------------------------------+" + ANSI_RESET);
                    newFilm();
                    break;
                case 2:
                    System.out.println(ANSI_CYAN + "                                                            +--------------------------------------------------+" + ANSI_RESET);
                    System.out.println(ANSI_YELLOW + "                                                            +****************Hiển thị phim ********************+" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            +--------------------------------------------------+" + ANSI_RESET);
                    System.out.println("                                                            |              1. Hiển thị phim mới                |" + ANSI_RESET);
                    System.out.println(ANSI_YELLOW + "                                                            |              2. Hiển thị phim theo thể loại      |" + ANSI_RESET);
                    System.out.println("                                                            |              3. Hiển thị phim lẻ                 |" + ANSI_RESET);
                    System.out.println("                                                            |              4. Hiển thị phim bộ                 |" + ANSI_RESET);
                    System.out.println("                                                            |              5. Tìm kiếm phim theo quốc gia      |" + ANSI_RESET);
                    System.out.println("                                                            |              6. Thoát                            |" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            +-------------------------------------------------+" + ANSI_RESET);
                    System.out.print(ANSI_CYAN + "                                                                           Sự lựa chọn của bạn: ");
                    System.out.println(ANSI_CYAN + "                                                            +-------------------------------------------------+" + ANSI_RESET);
                    showFimlorCatalog();
                    break;
                case 3:
                    System.out.println(ANSI_CYAN + "                                                            +--------------------------------------------------+" + ANSI_RESET);
                    System.out.println(ANSI_YELLOW + "                                                            +****************Hiển thị phim ********************+" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            +--------------------------------------------------+" + ANSI_RESET);
                    System.out.println("                                                            |              1. Hiển thị phim mới                |" + ANSI_RESET);
                    System.out.println("                                                            |              2. Hiển thị phim theo thể loại      |" + ANSI_RESET);
                    System.out.println(ANSI_YELLOW + "                                                            |              3. Hiển thị phim lẻ                 |" + ANSI_RESET);
                    System.out.println("                                                            |              4. Hiển thị phim bộ                 |" + ANSI_RESET);
                    System.out.println("                                                            |              5. Tìm kiếm phim theo quốc gia      |" + ANSI_RESET);
                    System.out.println("                                                            |              6. Thoát                            |" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            +-------------------------------------------------+" + ANSI_RESET);
                    System.out.print(ANSI_CYAN + "                                                                           Sự lựa chọn của bạn: ");
                    System.out.println(ANSI_CYAN + "                                                            +-------------------------------------------------+" + ANSI_RESET);
                    showMovies();
                    break;
                case 4:
                    System.out.println(ANSI_CYAN + "                                                            +--------------------------------------------------+" + ANSI_RESET);
                    System.out.println(ANSI_YELLOW + "                                                            +****************Hiển thị phim ********************+" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            +--------------------------------------------------+" + ANSI_RESET);
                    System.out.println("                                                            |              1. Hiển thị phim mới                |" + ANSI_RESET);
                    System.out.println("                                                            |              2. Hiển thị phim theo thể loại      |" + ANSI_RESET);
                    System.out.println("                                                            |              3. Hiển thị phim lẻ                 |" + ANSI_RESET);
                    System.out.println(ANSI_YELLOW + "                                                            |              4. Hiển thị phim bộ                 |" + ANSI_RESET);
                    System.out.println("                                                            |              5. Tìm kiếm phim theo quốc gia      |" + ANSI_RESET);
                    System.out.println("                                                            |              6. Thoát                            |" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            +-------------------------------------------------+" + ANSI_RESET);
                    System.out.print(ANSI_CYAN + "                                                                           Sự lựa chọn của bạn: ");
                    System.out.println(ANSI_CYAN + "                                                            +-------------------------------------------------+" + ANSI_RESET);
                    showSeriMovies();
                    break;
                case 5:
                    System.out.println(ANSI_CYAN + "                                                            +--------------------------------------------------+" + ANSI_RESET);
                    System.out.println(ANSI_YELLOW + "                                                            +****************Hiển thị phim ********************+" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            +--------------------------------------------------+" + ANSI_RESET);
                    System.out.println("                                                            |              1. Hiển thị phim mới                |" + ANSI_RESET);
                    System.out.println("                                                            |              2. Hiển thị phim theo thể loại      |" + ANSI_RESET);
                    System.out.println("                                                            |              3. Hiển thị phim lẻ                 |" + ANSI_RESET);
                    System.out.println("                                                            |              4. Hiển thị phim bộ                 |" + ANSI_RESET);
                    System.out.println(ANSI_YELLOW + "                                                            |              5. Tìm kiếm phim theo quốc gia      |" + ANSI_RESET);
                    System.out.println("                                                            |              6. Thoát                            |" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            +-------------------------------------------------+" + ANSI_RESET);
                    System.out.print(ANSI_CYAN + "                                                                           Sự lựa chọn của bạn: ");
                    System.out.println(ANSI_CYAN + "                                                            +-------------------------------------------------+" + ANSI_RESET);
                    showNation();
                    break;
                case 6:
                    System.out.println(ANSI_CYAN + "                                                            +--------------------------------------------------+" + ANSI_RESET);
                    System.out.println(ANSI_YELLOW + "                                                            +****************Hiển thị phim ********************+" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            +--------------------------------------------------+" + ANSI_RESET);
                    System.out.println("                                                            |              1. Hiển thị phim mới                |" + ANSI_RESET);
                    System.out.println("                                                            |              2. Hiển thị phim theo thể loại      |" + ANSI_RESET);
                    System.out.println("                                                            |              3. Hiển thị phim lẻ                 |" + ANSI_RESET);
                    System.out.println("                                                            |              4. Hiển thị phim bộ                 |" + ANSI_RESET);
                    System.out.println("                                                            |              5. Tìm kiếm phim theo quốc gia      |" + ANSI_RESET);
                    System.out.println(ANSI_YELLOW + "                                                            |              6. Thoát                            |" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            +-------------------------------------------------+" + ANSI_RESET);
                    System.out.print(ANSI_CYAN + "                                                                           Sự lựa chọn của bạn: ");
                    System.out.println(ANSI_CYAN + "                                                            +-------------------------------------------------+" + ANSI_RESET);
                    check = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1-6");
            }
        } while (check);
    }

    public static void newFilm() {
        film.newFilm();
    }

    public static void showFimlorCatalog() {
        film.byFilmCatalog();
    }

    public static void showMovies() {
        film.showMovies();
    }

    public static void showSeriMovies() {
        film.showSeriMovies();
    }

    public static void showNation() {
        film.byNation();
    }
}