package ra.presentation;

import ra.bussiness.entity.Catalog;
import ra.bussiness.entity.Episode;
import ra.bussiness.entity.Film;
import ra.bussiness.impl.EpisodeImpl;
import ra.bussiness.impl.FilmImpl;
import ra.config.Validation;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ra.presentation.CatalogManagerment.catalogList;

public class FilmManagerment {
    private static FilmImpl filmImpl = new FilmImpl();
    private static EpisodeImpl episode = new EpisodeImpl();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void filmManagerment() {
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        do {
            System.out.println(ANSI_CYAN + "                                                            **********************************************************" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "                                                            *--------------------FilmManagerment---------------------*" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*" + ANSI_RESET);
            System.out.println("                                                            *               1. Thêm phim                             *");
            System.out.println("                                                            *               2. Sửa phim                              *");
            System.out.println("                                                            *               3. Tìm kiếm phim theo tên                *");
            System.out.println("                                                            *               4. Tìm kiếm phim theo quốc gia           *");
            System.out.println("                                                            *               5. Tìm kiếm phim theo năm phát hành      *");
            System.out.println("                                                            *               6. Tìm kiếm phim theo tên danh mục       *");
            System.out.println("                                                            *               7. Hiển thị toàn bộ phim                 *");
            System.out.println("                                                            *               8. Tìm kiếm theo id                      *");
            System.out.println("                                                            *               9. Update trạng thái phim                *");
            System.out.println("                                                            *               10. Quản lý tập phim                     *");
            System.out.println("                                                            *               11. Thoát                                *");
            System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "                                                            *   Sự lựa chọn của bạn:                                 *" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "                                                            **********************************************************" + ANSI_RESET);
            int choice = Validation.getInteger();
            switch (choice) {
                case 1:
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************" + ANSI_RESET);
                    System.out.println("                                                            *--------------------FilmManagerment---------------------*");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*" + ANSI_RESET);
                    System.out.println(ANSI_YELLOW + "                                                            *               1. Thêm phim                             *" + ANSI_RESET);
                    System.out.println("                                                            *               2. Sửa phim                              *");
                    System.out.println("                                                            *               3. Tìm kiếm phim theo tên                *");
                    System.out.println("                                                            *               4. Tìm kiếm phim theo quốc gia           *");
                    System.out.println("                                                            *               5. Tìm kiếm phim theo năm phát hành      *");
                    System.out.println("                                                            *               6. Tìm kiếm phim theo tên danh mục       *");
                    System.out.println("                                                            *               7. Hiển thị toàn bộ phim                 *");
                    System.out.println("                                                            *               8. Tìm kiếm theo id                      *");
                    System.out.println("                                                            *               9. Update trạng thái phim                *");
                    System.out.println("                                                            *               10. Quản lý tập phim                     *");
                    System.out.println("                                                            *               11. Thoát                                *");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            *   Sự lựa chọn của bạn:                                 *" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************" + ANSI_RESET);
                    create(sc);
                    break;
                case 2:
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************" + ANSI_RESET);
                    System.out.println("                                                            *--------------------FilmManagerment---------------------*");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*" + ANSI_RESET);
                    System.out.println("                                                            *               1. Thêm phim                             *");
                    System.out.println(ANSI_YELLOW + "                                                            *               2. Sửa phim                              *" + ANSI_RESET);
                    System.out.println("                                                            *               3. Tìm kiếm phim theo tên                *");
                    System.out.println("                                                            *               4. Tìm kiếm phim theo quốc gia           *");
                    System.out.println("                                                            *               5. Tìm kiếm phim theo năm phát hành      *");
                    System.out.println("                                                            *               6. Tìm kiếm phim theo tên danh mục       *");
                    System.out.println("                                                            *               7. Hiển thị toàn bộ phim                 *");
                    System.out.println("                                                            *               8. Tìm kiếm theo id                      *");
                    System.out.println("                                                            *               9. Update trạng thái phim                *");
                    System.out.println("                                                            *               10. Quản lý tập phim                     *");
                    System.out.println("                                                            *               11. Thoát                                *");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            *   Sự lựa chọn của bạn:                                 *" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************" + ANSI_RESET);
                    findAll();
                    update();
                    break;
                case 3:
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************" + ANSI_RESET);
                    System.out.println("                                                            *--------------------FilmManagerment---------------------*");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*" + ANSI_RESET);
                    System.out.println("                                                            *               1. Thêm phim                             *");
                    System.out.println("                                                            *               2. Sửa phim                              *");
                    System.out.println(ANSI_YELLOW + "                                                            *               3. Tìm kiếm phim theo tên                *" + ANSI_RESET);
                    System.out.println("                                                            *               4. Tìm kiếm phim theo quốc gia           *");
                    System.out.println("                                                            *               5. Tìm kiếm phim theo năm phát hành      *");
                    System.out.println("                                                            *               6. Tìm kiếm phim theo tên danh mục       *");
                    System.out.println("                                                            *               7. Hiển thị toàn bộ phim                 *");
                    System.out.println("                                                            *               8. Tìm kiếm theo id                      *");
                    System.out.println("                                                            *               9. Update trạng thái phim                *");
                    System.out.println("                                                            *               10. Quản lý tập phim                     *");
                    System.out.println("                                                            *               11. Thoát                                *");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            *   Sự lựa chọn của bạn:                                 *" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************" + ANSI_RESET);
                    searchByName();
                    break;
                case 4:
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************" + ANSI_RESET);
                    System.out.println("                                                            *--------------------FilmManagerment---------------------*");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*" + ANSI_RESET);
                    System.out.println("                                                            *               1. Thêm phim                             *");
                    System.out.println("                                                            *               2. Sửa phim                              *");
                    System.out.println("                                                            *               3. Tìm kiếm phim theo tên                *");
                    System.out.println(ANSI_YELLOW + "                                                            *               4. Tìm kiếm phim theo quốc gia           *" + ANSI_RESET);
                    System.out.println("                                                            *               5. Tìm kiếm phim theo năm phát hành      *");
                    System.out.println("                                                            *               6. Tìm kiếm phim theo tên danh mục       *");
                    System.out.println("                                                            *               7. Hiển thị toàn bộ phim                 *");
                    System.out.println("                                                            *               8. Tìm kiếm theo id                      *");
                    System.out.println("                                                            *               9. Update trạng thái phim                *");
                    System.out.println("                                                            *               10. Quản lý tập phim                     *");
                    System.out.println("                                                            *               11. Thoát                                *");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            *   Sự lựa chọn của bạn:                                 *" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************" + ANSI_RESET);
                    searchByNation();
                    break;
                case 5:
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************" + ANSI_RESET);
                    System.out.println("                                                            *--------------------FilmManagerment---------------------*");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*" + ANSI_RESET);
                    System.out.println("                                                            *               1. Thêm phim                             *");
                    System.out.println("                                                            *               2. Sửa phim                              *");
                    System.out.println("                                                            *               3. Tìm kiếm phim theo tên                *");
                    System.out.println("                                                            *               4. Tìm kiếm phim theo quốc gia           *");
                    System.out.println(ANSI_YELLOW + "                                                            *               5. Tìm kiếm phim theo năm phát hành      *" + ANSI_RESET);
                    System.out.println("                                                            *               6. Tìm kiếm phim theo tên danh mục       *");
                    System.out.println("                                                            *               7. Hiển thị toàn bộ phim                 *");
                    System.out.println("                                                            *               8. Tìm kiếm theo id                      *");
                    System.out.println("                                                            *               9. Update trạng thái phim                *");
                    System.out.println("                                                            *               10. Quản lý tập phim                     *");
                    System.out.println("                                                            *               11. Thoát                                *");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            *   Sự lựa chọn của bạn:                                 *" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************" + ANSI_RESET);
                    searchYear();
                    break;
                case 6:
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************" + ANSI_RESET);
                    System.out.println("                                                            *--------------------FilmManagerment---------------------*");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*" + ANSI_RESET);
                    System.out.println("                                                            *               1. Thêm phim                             *");
                    System.out.println("                                                            *               2. Sửa phim                              *");
                    System.out.println("                                                            *               3. Tìm kiếm phim theo tên                *");
                    System.out.println("                                                            *               4. Tìm kiếm phim theo quốc gia           *");
                    System.out.println("                                                            *               5. Tìm kiếm phim theo năm phát hành      *");
                    System.out.println(ANSI_YELLOW + "                                                            *               6. Tìm kiếm phim theo tên danh mục       *" + ANSI_RESET);
                    System.out.println("                                                            *               7. Hiển thị toàn bộ phim                 *");
                    System.out.println("                                                            *               8. Tìm kiếm theo id                      *");
                    System.out.println("                                                            *               9. Update trạng thái phim                *");
                    System.out.println("                                                            *               10. Quản lý tập phim                     *");
                    System.out.println("                                                            *               11. Thoát                                *");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            *   Sự lựa chọn của bạn:                                 *" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************" + ANSI_RESET);
                    finByCatalogName();
                    break;
                case 7:
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************" + ANSI_RESET);
                    System.out.println("                                                            *--------------------FilmManagerment---------------------*");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*" + ANSI_RESET);
                    System.out.println("                                                            *               1. Thêm phim                             *");
                    System.out.println("                                                            *               2. Sửa phim                              *");
                    System.out.println("                                                            *               3. Tìm kiếm phim theo tên                *");
                    System.out.println("                                                            *               4. Tìm kiếm phim theo quốc gia           *");
                    System.out.println("                                                            *               5. Tìm kiếm phim theo năm phát hành      *");
                    System.out.println("                                                            *               6. Tìm kiếm phim theo tên danh mục       *");
                    System.out.println(ANSI_YELLOW + "                                                            *               7. Hiển thị toàn bộ phim                 *" + ANSI_RESET);
                    System.out.println("                                                            *               8. Tìm kiếm theo id                      *");
                    System.out.println("                                                            *               9. Update trạng thái phim                *");
                    System.out.println("                                                            *               10. Quản lý tập phim                     *");
                    System.out.println("                                                            *               11. Thoát                                *");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            *   Sự lựa chọn của bạn:                                 *" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************" + ANSI_RESET);
                    findAll();
                    break;
                case 8:
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************" + ANSI_RESET);
                    System.out.println("                                                            *--------------------FilmManagerment---------------------*");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*" + ANSI_RESET);
                    System.out.println("                                                            *               1. Thêm phim                             *");
                    System.out.println("                                                            *               2. Sửa phim                              *");
                    System.out.println("                                                            *               3. Tìm kiếm phim theo tên                *");
                    System.out.println("                                                            *               4. Tìm kiếm phim theo quốc gia           *");
                    System.out.println("                                                            *               5. Tìm kiếm phim theo năm phát hành      *");
                    System.out.println("                                                            *               6. Tìm kiếm phim theo tên danh mục       *");
                    System.out.println("                                                            *               7. Hiển thị toàn bộ phim                 *");
                    System.out.println(ANSI_YELLOW + "                                                            *               8. Tìm kiếm theo id                      *" + ANSI_RESET);
                    System.out.println("                                                            *               9. Update trạng thái phim                *");
                    System.out.println("                                                            *               10. Quản lý tập phim                     *");
                    System.out.println("                                                            *               11. Thoát                                *");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            *   Sự lựa chọn của bạn:                                 *" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************" + ANSI_RESET);
                    findById();
                    break;
                case 9:
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************" + ANSI_RESET);
                    System.out.println("                                                            *--------------------FilmManagerment---------------------*");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*" + ANSI_RESET);
                    System.out.println("                                                            *               1. Thêm phim                             *");
                    System.out.println("                                                            *               2. Sửa phim                              *");
                    System.out.println("                                                            *               3. Tìm kiếm phim theo tên                *");
                    System.out.println("                                                            *               4. Tìm kiếm phim theo quốc gia           *");
                    System.out.println("                                                            *               5. Tìm kiếm phim theo năm phát hành      *");
                    System.out.println("                                                            *               6. Tìm kiếm phim theo tên danh mục       *");
                    System.out.println("                                                            *               7. Hiển thị toàn bộ phim                 *");
                    System.out.println("                                                            *               8. Tìm kiếm theo id                      *");
                    System.out.println(ANSI_YELLOW + "                                                            *               9. Update trạng thái phim                *" + ANSI_RESET);
                    System.out.println("                                                            *               10. Quản lý tập phim                     *");
                    System.out.println("                                                            *               11. Thoát                                *");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            *   Sự lựa chọn của bạn:                                 *" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************" + ANSI_RESET);
                    deleteStatusFilm();
                    break;
                case 10:
                    EpisodeManagerment.episodeManagerment();
                    break;
                case 11:
                    check = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1-11");
            }
        } while (check);
    }

    public static void create(Scanner sc) {
        System.out.println("Mời bạn nhập số lượng phim muốn thêm mới: ");
        int number = Validation.getInteger();
        for (int i = 0; i < number; i++) {
            Film film = new Film();
            System.out.println("Thông tin phim thứ:  " + (i + 1));
            film = filmImpl.inputData(sc);
            boolean check = filmImpl.create(film);
            Validation.soutMess(check);
        }
    }

    public static void findAll() {
        filmImpl.displayData();
    }

    public static void update() {
        List<Film> filmList = filmImpl.readFromFile();
        System.out.println("Mời bạn nhập vào ID phim bạn muốn cập nhật: ");
        int id = Validation.getInteger();
        boolean found = false;
        for (Film film : filmList) {
            if (film.getFilmId() == id) {
                found = true;
                System.out.println("Bạn có muốn cập nhật tên phim không?");
                System.out.println("1. Có");
                System.out.println("2. Không");
                int choice = Validation.getInteger();
                if (choice == 1) {
                    System.out.println("Mời bạn nhập tên phim muốn cập nhật: ");
                    film.setFilmName(Validation.getString());
                }
                System.out.println("Bạn có muốn cập nhật tiêu đề không?");
                System.out.println("1. Có");
                System.out.println("2. Không");
                int choice1 = Validation.getInteger();
                if (choice1 == 1) {
                    System.out.println("Mời bạn nhập tiêu đề muốn cập nhật: ");
                    film.setFilmTitle(Validation.getString());
                }
                System.out.println("Bạn có muốn cập nhật mô tả không: ");
                System.out.println("1. Có");
                System.out.println("2. Không");
                int choice2 = Validation.getInteger();
                if (choice2 == 1) {
                    System.out.println("Mời bạn nhập mô tả mà bạn muốn cập nhật: ");
                    film.setDecription(Validation.getString());
                }
                System.out.println("Bạn có muốn cập nhật loại phim không: ");
                System.out.println("1. Có");
                System.out.println("2. Không");
                int choice3 = Validation.getInteger();
                if (choice3 == 1) {
                    boolean isValidChoice = false;
                    do {
                        System.out.println("Mời bạn chọn loại phim ");
                        System.out.println("1. Phim bộ");
                        System.out.println("2. Phim lẻ");
                        int choice4 = Validation.getInteger();
                        switch (choice4) {
                            case 1:
                                film.setFilmType(true);
                                film.setDuration(null);
                                isValidChoice = true;
                                break;
                            case 2:
                                film.setFilmType(false);
                                System.out.println("Mời bạn nhập thời lượng của phim (ví dụ: 2h30): ");
                                String durationStr = Validation.getString();
                                Duration duration = Validation.parseDuration(durationStr);
                                film.setDuration(duration);
                                isValidChoice = true;
                                break;
                            default:
                                System.err.println("Vui lòng chọn từ 1-2");
                        }
                    } while (!isValidChoice);
                }
                System.out.println("Bạn có muốn cập nhật tên quốc gia không: ");
                System.out.println("1. Có");
                System.out.println("2. Không");
                int choice5 = Validation.getInteger();
                if (choice5 == 1) {
                    System.out.println("Mời bạn nhập quốc gia mà bạn muốn cập nhật: ");
                    film.setFilmNation(Validation.getString());
                }
                System.out.println("Bạn có muốn cập nhật ngôn ngữ  không: ");
                System.out.println("1. Có");
                System.out.println("2. Không");
                int choice6 = Validation.getInteger();
                if (choice6 == 1) {
                    System.out.println("Mời bạn nhập ngôn ngữ mà bạn muốn cập nhật: ");
                    film.setFilmLanguage(Validation.getString());
                }
                System.out.println("Bạn có muốn cập nhật loại phim dành cho ai không: ");
                System.out.println("1. Có");
                System.out.println("2. Không");
                int choice7 = Validation.getInteger();
                if (choice7 == 1) {
                    boolean isValidChoiceBrowse = false;
                    do {
                        System.out.println("Mời bạn chọn phim dành cho: ");
                        System.out.println("1.Người lớn");
                        System.out.println("2.Trẻ em");
                        int choice8 = Validation.getInteger();
                        switch (choice8) {
                            case 1:
                                film.setFilmBrowse(true);
                                isValidChoiceBrowse = true;
                                break;
                            case 2:
                                film.setFilmBrowse(false);
                                isValidChoiceBrowse = true;
                                break;
                            default:
                                System.err.println("Vui lòng chọn từ 1-2");
                        }
                    } while (!isValidChoiceBrowse);
                }
                System.out.println("Bạn có muốn cập nhật năm phát hành không: ");
                System.out.println("1. Có");
                System.out.println("2. Không");
                int choice9 = Validation.getInteger();
                if (choice9 == 1) {
                    System.out.println("Mời bạn nhập năm phat hanh mà bạn muốn cập nhật: ");
                    film.setFilmYearRelease(Validation.validateYear());
                }
                System.out.println("Bạn có muốn cập nhật đạo diễn không: ");
                System.out.println("1. Có");
                System.out.println("2. Không");
                int choice0 = Validation.getInteger();
                if (choice0 == 1) {
                    System.out.println("Mời bạn nhập đạo diễn mà bạn muốn cập nhật: ");
                    film.setFilmDirector(Validation.getString());
                }
                System.out.println("Bạn có muốn cập lại toàn bộ danh mục không: ");
                System.out.println("1. Có");
                System.out.println("2. Không");
                int ca = Validation.getInteger();
                if (ca == 1) {
                    System.out.println("Mời bạn nhập danh mục mà bạn muốn cập nhật: ");
                    film.setCatalogList(Validation.addListCatalog(catalogList));
                }
                System.out.println("Bạn có muốn cập lại toàn bộ diễn viên không: ");
                System.out.println("1. Có");
                System.out.println("2. Không");
                int ca1 = Validation.getInteger();
                if (ca1 == 1) {
                    System.out.println("Mời bạn nhập diễn viên mà bạn muốn cập nhật: ");
                    film.setPerformer(Validation.addPerformer());
                }
                System.out.println("Bạn có muốn cập trạng thái phim không: ");
                System.out.println("1. Có");
                System.out.println("2. Không");
                int ca11 = Validation.getInteger();
                if (ca11 == 1) {
                    System.out.println("Mời bạn nhập quốc gia mà bạn muốn cập nhật: ");
                    System.out.println("1.Hoạt động                 2.không hoạt động");
                    int choioi = Validation.getInteger();
                    switch (choioi) {
                        case 1:
                            film.setFilmStatus(true);
                            break;
                        case 2:
                            film.setFilmStatus(false);
                            break;
                        default:
                            System.err.println("Vui lòng chọn từ 1-2");
                    }
                    break;
                }
                filmImpl.update(film);
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy phim với ID đã nhập.");
        } else {
            filmImpl.writeToFile(filmList);
            System.out.println("Cập nhật phim thành công.");
        }
    }

    public static void searchByName() {
        System.out.println("Mời bạn nhập tên phim: ");
        String name = Validation.getString();
        List<Film> films = filmImpl.findByFilmName(name);
        if (films == null) {
            System.out.println("Không có phim này");
        } else {
            System.out.println(ANSI_CYAN + "      -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "                                                          *****************************Danh sách phim***********************************" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "      -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------" + ANSI_RESET);
            System.out.printf(ANSI_YELLOW + "      %-10s %-25s %-40s %-45s %-20s %-20s %-25s\n", "ID", "Tên phim", "Tiêu đề", "Thể loại", "Loại Phim", "Năm phát hành", "Trạng thái" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "      -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------" + ANSI_RESET);
            for (Film film : films) {
                List<Catalog> catalogList = film.getCatalogList();
                String catalogNames = "";
                for (Catalog catalog : catalogList) {
                    catalogNames += catalog.getCatalogName() + ", ";
                }
                catalogNames = catalogNames.substring(0, catalogNames.length() - 2); // Loại bỏ dấu phẩy cuối cùng
                System.out.printf("      %-10d %-25s %-40s %-45s %-20s %-20d %-25s\n",
                        film.getFilmId(), film.getFilmName(), film.getFilmTitle(),
                        catalogNames, (film.isFilmType() ? "Phim bộ" : "Phim lẻ"), film.getFilmYearRelease(), (film.isFilmStatus() ? "Đang phát hành" : "Ngừng phát hành"));
            }
            System.out.println(ANSI_CYAN + "      -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------" + ANSI_RESET);
        }
    }

    public static void searchByNation() {
        System.out.println("Mời bạn nhập tên quốc gia bạn muốn tìm kiếm: ");
        String nation = Validation.getString();
        List<Film> films = filmImpl.findByFilmNation(nation);
        if (films == null) {
            System.out.println("không có quốc gia này");
        } else {
            System.out.println(ANSI_CYAN + "      -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "                                                          *****************************Danh sách phim***********************************" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "      -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------" + ANSI_RESET);
            System.out.printf(ANSI_YELLOW + "      %-10s %-25s %-40s %-45s %-20s %-20s %-25s\n", "ID", "Tên phim", "Tiêu đề", "Thể loại", "Loại Phim", "Năm phát hành", "Trạng thái" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "      -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------" + ANSI_RESET);
            for (Film film : films) {
                List<Catalog> catalogList = film.getCatalogList();
                String catalogNames = "";
                for (Catalog catalog : catalogList) {
                    catalogNames += catalog.getCatalogName() + ", ";
                }
                catalogNames = catalogNames.substring(0, catalogNames.length() - 2); // Loại bỏ dấu phẩy cuối cùng
                System.out.printf("      %-10d %-25s %-40s %-45s %-20s %-20d %-25s\n",
                        film.getFilmId(), film.getFilmName(), film.getFilmTitle(),
                        catalogNames, (film.isFilmType() ? "Phim bộ" : "Phim lẻ"), film.getFilmYearRelease(), (film.isFilmStatus() ? "Đang phát hành" : "Ngừng phát hành"));
            }
            System.out.println(ANSI_CYAN + "      -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------" + ANSI_RESET);
        }
    }

    public static void searchYear() {
        System.out.println("Mời bạn nhập năm phát hành của phim");
        int year = Validation.getInteger();
        List<Film> films = filmImpl.findByFilmYear(year);
        if (films == null) {
            System.out.println("không có phim nào phát hành năm " + year);
        } else {
            System.out.println(ANSI_CYAN + "      -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "                                                          *****************************Danh sách phim***********************************" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "      -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------" + ANSI_RESET);
            System.out.printf(ANSI_YELLOW + "      %-10s %-25s %-40s %-45s %-20s %-20s %-25s\n", "ID", "Tên phim", "Tiêu đề", "Thể loại", "Loại Phim", "Năm phát hành", "Trạng thái" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "      -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------" + ANSI_RESET);
            for (Film film : films) {
                List<Catalog> catalogList = film.getCatalogList();
                String catalogNames = "";
                for (Catalog catalog : catalogList) {
                    catalogNames += catalog.getCatalogName() + ", ";
                }
                catalogNames = catalogNames.substring(0, catalogNames.length() - 2); // Loại bỏ dấu phẩy cuối cùng
                System.out.printf("      %-10d %-25s %-40s %-45s %-20s %-20d %-25s\n",
                        film.getFilmId(), film.getFilmName(), film.getFilmTitle(),
                        catalogNames, (film.isFilmType() ? "Phim bộ" : "Phim lẻ"), film.getFilmYearRelease(), (film.isFilmStatus() ? "Đang phát hành" : "Ngừng phát hành"));
            }
            System.out.println(ANSI_CYAN + "      -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------" + ANSI_RESET);
        }
    }

    public static void findById() {
        System.out.println("Mời bạn nhập ID phim: ");
        int id = Validation.getInteger();
        Film film = filmImpl.findByid(id);
        if (film == null) {
            System.out.println("Không tìm thấy phim với ID đã nhập.");
        } else {
            List<Episode> episodeList = new ArrayList<>();
            Duration totalDuration = Duration.ZERO;
            for (Episode e : episode.readFromFile()) {
                if (e.getFilmId().getFilmId() == film.getFilmId()) {
                    episodeList.add(e);
                    totalDuration = totalDuration.plus(e.getDuration());
                }
            }
            if (film.isFilmType()){
                film.setDuration(totalDuration.dividedBy(episodeList.size()));
            }
            System.out.println(ANSI_CYAN +"--------------------------------------------------------------------"+ ANSI_RESET);
            System.out.println(ANSI_CYAN +"*****************************phim***********************************"+ ANSI_RESET);
            System.out.println(ANSI_CYAN +"--------------------------------------------------------------------"+ ANSI_RESET);
            System.out.println(ANSI_YELLOW +"ID           : "+ ANSI_RESET + film.getFilmId());
            System.out.println(ANSI_YELLOW +"Tên phim     : " + ANSI_RESET+ film.getFilmName());
            System.out.println(ANSI_YELLOW +"Tiêu đề      : " + ANSI_RESET+ film.getFilmTitle());
            System.out.println(ANSI_YELLOW +"Mô tả        : "+ ANSI_RESET + film.getDecription());
            Duration duration = film.getDuration();
            String formattedDuration = formatDuration(duration);
            System.out.println(ANSI_YELLOW +"Thời lượng   : "+ ANSI_RESET+ formattedDuration);
            System.out.println(ANSI_YELLOW +"Thể loại     :"+ ANSI_RESET);
            for (Catalog catalog : film.getCatalogList()) {
                System.out.println("               - " + catalog.getCatalogName());
            }
            System.out.println(ANSI_YELLOW +"Quốc gia      : "+ ANSI_RESET + film.getFilmNation());
            System.out.println(ANSI_YELLOW +"Ngôn ngữ      : "+ ANSI_RESET + film.getFilmLanguage());
            System.out.println(ANSI_YELLOW +"Loại phim     : "+ ANSI_RESET + (film.isFilmType() ? "Phim bộ" : "Phim lẻ"));
            System.out.println(ANSI_YELLOW +"Đạo diễn      : "+ ANSI_RESET + film.getFilmDirector());
            System.out.println(ANSI_YELLOW +"Phim dành cho : "+ ANSI_RESET + (film.isFilmBrowse() ? "Người lớn" : "Trẻ em"));
            System.out.println(ANSI_YELLOW +"Diễn viên     :"+ ANSI_RESET);
            for (String performer : film.getPerformer()) {
                System.out.println("               - " + performer);
            }
            System.out.println(ANSI_YELLOW +"Năm phát hành : "+ ANSI_RESET + film.getFilmYearRelease());
            System.out.println(ANSI_YELLOW +"Trạng thái    : "+ ANSI_RESET + (film.isFilmStatus() ? "Đang phát" : "Ngừng phát"));
            System.out.println(ANSI_YELLOW +"Tập phim      : "+ ANSI_RESET);
            for (Episode e : episodeList) {
                System.out.println("                -" + e.getEpisodeName());
            }

            System.out.println(ANSI_CYAN+"--------------------------------------------------------------------"+ANSI_RESET);
        }
    }

    private static String formatDuration(Duration duration) {
        if (duration == null) {
            return "thời lượng trống";
        }
        long hours = duration.toHours();
        long minutes = duration.toMinutes() - hours * 60;
        long seconds = duration.getSeconds() - hours * 3600 - minutes * 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public static void finByCatalogName() {
        System.out.println("Mời bạn nhập tên danh mục");
        String name = Validation.getString();
        List<Film> films = filmImpl.findByCatalogName(name);
        if (films == null) {
            System.out.println("không có phim nào có danh mục này ");
        } else {
            System.out.println(ANSI_CYAN + "      -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "                                                          *****************************Danh sách phim***********************************" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "      -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------" + ANSI_RESET);
            System.out.printf(ANSI_YELLOW + "      %-10s %-25s %-40s %-45s %-20s %-20s %-25s\n", "ID", "Tên phim", "Tiêu đề", "Thể loại", "Loại Phim", "Năm phát hành", "Trạng thái" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "      -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------" + ANSI_RESET);
            for (Film film : films) {
                List<Catalog> catalogList = film.getCatalogList();
                String catalogNames = "";
                for (Catalog catalog : catalogList) {
                    catalogNames += catalog.getCatalogName() + ", ";
                }
                catalogNames = catalogNames.substring(0, catalogNames.length() - 2); // Loại bỏ dấu phẩy cuối cùng
                System.out.printf("      %-10d %-25s %-40s %-45s %-20s %-20d %-25s\n",
                        film.getFilmId(), film.getFilmName(), film.getFilmTitle(),
                        catalogNames, (film.isFilmType() ? "Phim bộ" : "Phim lẻ"), film.getFilmYearRelease(), (film.isFilmStatus() ? "Đang phát hành" : "Ngừng phát hành"));
            }
            System.out.println(ANSI_CYAN + "      -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------" + ANSI_RESET);
        }
    }

    public static void deleteStatusFilm() {
        System.out.println("Mời bạn nhập vào id phim bạn muốn ngừng phát/phát");
        int id = Validation.getInteger();
        boolean check = filmImpl.delete(id);
        if (check) {
            System.out.println("bạn đã ngừng/mở chiếu chiếu thành công");
        } else {
            System.err.println("ngừng chiếu không thành công");
        }
    }
}