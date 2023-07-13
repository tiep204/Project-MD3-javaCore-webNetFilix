package ra.bussiness.impl;

import ra.bussiness.design.IFilm;
import ra.bussiness.entity.Catalog;
import ra.bussiness.entity.Film;
import ra.config.Constanst;
import ra.config.Validation;
import ra.data.FileImpl;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ra.presentation.CatalogManagerment.catalogList;


public class FilmImpl implements IFilm<Film, Integer> {
    public static FileImpl file = new FileImpl();
    public static CatalogImpl catalog = new CatalogImpl();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";

    @Override
    public boolean create(Film film) {
        List<Film> filmList = readFromFile();
        if (filmList == null) {
            filmList = new ArrayList<>();
        }
        filmList.add(film);
        boolean result = writeToFile(filmList);
        return result;
    }

    @Override
    public boolean update(Film film) {
        List<Film> filmList = readFromFile();
        boolean found = false;
        for (int i = 0; i < filmList.size(); i++) {
            if (filmList.get(i).getFilmId() == film.getFilmId()) {
                filmList.set(i, film);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy phim trong danh sách.");
            return false;
        }
        return writeToFile(filmList);
    }
    public void  xoa(int id){
        List<Film> films = readFromFile();
        for (Film p : films) {
            if (p.getFilmId()==id){
                films.remove(p);
                System.out.println("Xóa thành công "+id);
                return;
            }
        }
        System.out.println("Không tìm thấy id");
    }

    @Override
    public boolean delete(Integer id) {
        List<Film> filmList = readFromFile();
        boolean check = false;
        for (Film film : filmList) {
            if (film.getFilmId() == id) {
                if (film.isFilmStatus()) {
                    film.setFilmStatus(false);
                } else {
                    film.setFilmStatus(true);
                }
                check = true; // Cập nhật giá trị check khi thay đổi trạng thái phim
            }
        }
        boolean result = writeToFile(filmList);
        return result && check; // Trả về kết quả sau khi cập nhật giá trị check
    }

    @Override
    public boolean writeToFile(List<Film> list) {
        FileImpl<Film> filmFile = new FileImpl<>();
        return filmFile.writeDataToFile(list, Constanst.FILM_URL_FILE);
    }

    @Override
    public List<Film> readFromFile() {
        FileImpl<Film> filmFile = new FileImpl<>();
        return filmFile.readDataFromFile(Constanst.FILM_URL_FILE);
    }

    @Override
    public Film inputData(Scanner sc) {
        List<Film> films = readFromFile();
        if (films == null) {
            films = new ArrayList<>();
        }
        Film film = new Film();
        film.setFilmId(films.size() + 1);
        film.setCatalogList(Validation.addListCatalog(catalogList));
        System.out.println("Mời bạn nhập têm phim");
        film.setFilmName(Validation.checkFilmName());
        System.out.println("Mời bạn nhập tiêu đề  của phim ");
        film.setFilmTitle(Validation.getString());
        System.out.println("Mời bạn nhập mổ tả phim ");
        film.setDecription(Validation.getString());
        boolean isValidChoice = false;
        do {
            System.out.println("Mời bạn chọn loại phim ");
            System.out.println("1. Phim bộ");
            System.out.println("2. Phim lẻ");
            int choice = Validation.getInteger();
            switch (choice) {
                case 1:
                    film.setFilmType(true);
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
        System.out.println("Mời bạn nhập quốc gia của phim");
        film.setFilmNation(Validation.getString());
        System.out.println("Mời bạn nhập ngôn ngữ: ");
        film.setFilmLanguage(Validation.getString());
        boolean isValidChoiceBrowse = false;
        do {
            System.out.println("Mời bạn chọn phim dành cho: ");
            System.out.println("1.Người lớn");
            System.out.println("2.Trẻ em");
            int choice = Validation.getInteger();
            switch (choice) {
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
        film.setFilmYearRelease(Validation.validateYear());
        System.out.println("Mời bạn nhập đạo diễn");
        film.setFilmDirector(Validation.getString());
        film.setPerformer(Validation.addPerformer());
        film.setFilmStatus(true);
        return film;
    }


    @Override
    public void displayData() {
        List<Film> filmList = readFromFile();
        if (filmList != null) {
            System.out.println(ANSI_CYAN + "      -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
            System.out.println(ANSI_YELLOW +"                                                          *****************************Danh sách phim***********************************"+ ANSI_RESET);
            System.out.println(ANSI_CYAN + "      -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
            System.out.printf(ANSI_YELLOW +"      %-10s %-25s %-40s %-45s %-20s %-20s %-25s\n","ID", "Tên phim", "Tiêu đề", "Thể loại", "Loại Phim", "Năm phát hành", "Trạng thái"+ ANSI_RESET);
            System.out.println(ANSI_CYAN + "      -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
            for (Film film : filmList) {
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
            System.out.println(ANSI_CYAN + "      -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
        } else {
            System.out.println("Danh sách phim trống");
        }
    }

    public void displayDataFilmMenuUser() {
        List<Film> filmList = readFromFile();
        if (filmList != null) {
            System.out.println(ANSI_CYAN + "      -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
            System.out.println(ANSI_YELLOW +"                                                          *****************************Danh sách phim***********************************"+ ANSI_RESET);
            System.out.println(ANSI_CYAN + "      -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
            System.out.printf(ANSI_YELLOW +"      %-10s %-25s %-40s %-45s %-20s %-20s %-25s\n","ID", "Tên phim", "Tiêu đề", "Thể loại", "Loại Phim", "Năm phát hành", "Trạng thái"+ ANSI_RESET);
            System.out.println(ANSI_CYAN + "      -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
            for (Film film : filmList) {
                if (film.isFilmStatus()) {
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
            }
            System.out.println(ANSI_CYAN + "      -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
        } else {
            System.out.println("Danh sách phim trống");
        }
    }

    @Override
    public List<Film> findByFilmName(String name) {
        List<Film> filmList = readFromFile();
        List<Film> films = new ArrayList<>();
        for (Film f : filmList) {
            if (f.getFilmName().contains(name)) {
                films.add(f);
            }
        }
        return films;
    }

    public List<Film> findByFilmNation(String nation) {
        List<Film> list = readFromFile();
        List<Film> list1 = new ArrayList<>();
        for (Film film : list) {
            if (film.getFilmNation().contains(nation)) {
                list1.add(film);
            }
        }
        return list1;
    }

    public List<Film> findByFilmYear(int year) {
        List<Film> list = readFromFile();
        List<Film> list1 = new ArrayList<>();
        for (Film film : list) {
            if (film.getFilmYearRelease() == year) {
                list1.add(film);
            }
        }
        return list1;
    }

    public Film findByid(int id) {
        for (Film film : readFromFile()) {
            if (film.getFilmId() == id) {
                return film;
            }
        }
        return null;
    }

    public List<Film> findByCatalogName(String name) {
        List<Film> list = readFromFile();
        List<Film> result = new ArrayList<>();
        for (Film film : list) {
            List<Catalog> catalogList = film.getCatalogList();
            for (Catalog cat : catalogList) {
                if (cat.getCatalogName().contains(name)) {
                    result.add(film);
                }
            }
        }
        return result;
    }


    public void newFilm() {
        List<Film> filmList = readFromFile();
        if (filmList != null) {
            System.out.println(ANSI_CYAN+"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
            System.out.println(ANSI_YELLOW +"                                              *****************************Danh sách phim mới***********************************"+ ANSI_RESET);
            System.out.println(ANSI_CYAN+"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
            System.out.printf(ANSI_YELLOW +"      %-10s %-25s %-40s %-50s %-20s %-20s\n","ID", "Tên phim", "Tiêu đề", "Thể loại", "Quốc gia", "Loại Phim"+ ANSI_RESET);
            for (Film film : filmList) {
                if (film.isFilmStatus() && film.getFilmYearRelease() == 2023) {
                    List<Catalog> catalogList = film.getCatalogList();
                    String catalogNames = "";
                    for (Catalog catalog : catalogList) {
                        catalogNames += catalog.getCatalogName() + ", ";
                    }
                    catalogNames = catalogNames.substring(0, catalogNames.length() - 2); // Loại bỏ dấu phẩy cuối cùng
                    System.out.printf("      %-10d %-25s %-40s %-50s %-20s %-20s \n",
                            film.getFilmId(), film.getFilmName(), film.getFilmTitle(),
                            catalogNames, film.getFilmNation(),
                            (film.isFilmType() ? "Phim bộ" : "Phim lẻ"));
                }
            }
            System.out.println(ANSI_CYAN+"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
        } else {
            System.out.println("Danh sách phim trống");
        }
    }

    public void byFilmCatalog() {
        System.out.println("Mời bạn nhập tên thể loại");
        String name = Validation.getString();
        List<Film> films = findByCatalogName(name);
        if (films == null) {
            System.out.println("không có phim nào có thể loại này ");
        } else {
            System.out.println(ANSI_CYAN+"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
            System.out.println(ANSI_YELLOW +"                                              *****************************Danh sách phim***********************************"+ ANSI_RESET);
            System.out.println(ANSI_CYAN+"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
            System.out.printf(ANSI_YELLOW +"      %-10s %-25s %-40s %-50s %-20s %-20s\n","ID", "Tên phim", "Tiêu đề", "Thể loại", "Quốc gia", "Loại Phim"+ ANSI_RESET);
            for (Film film : films) {
                if (film.isFilmStatus()) {
                    List<Catalog> catalogList = film.getCatalogList();
                    String catalogNames = "";
                    for (Catalog catalog : catalogList) {
                        catalogNames += catalog.getCatalogName() + ", ";
                    }
                    catalogNames = catalogNames.substring(0, catalogNames.length() - 2); // Loại bỏ dấu phẩy cuối cùng
                    System.out.printf("      %-10d %-25s %-40s %-50s %-20s %-20s \n",
                            film.getFilmId(), film.getFilmName(), film.getFilmTitle(),
                            catalogNames, film.getFilmNation(),
                            (film.isFilmType() ? "Phim bộ" : "Phim lẻ"));
                }
            }
            System.out.println(ANSI_CYAN+"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
        }
    }

    public void showMovies() {
        List<Film> filmList = readFromFile();
        if (filmList != null) {
            System.out.println(ANSI_CYAN+"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
            System.out.println(ANSI_YELLOW +"                                              *****************************Danh sách phim***********************************"+ ANSI_RESET);
            System.out.println(ANSI_CYAN+"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
            System.out.printf(ANSI_YELLOW +"      %-10s %-25s %-40s %-50s %-20s %-20s\n","ID", "Tên phim", "Tiêu đề", "Thể loại", "Quốc gia", "Loại Phim"+ ANSI_RESET);
            for (Film film : filmList) {
                if (film.isFilmStatus() && !film.isFilmType()) {
                    List<Catalog> catalogList = film.getCatalogList();
                    String catalogNames = "";
                    for (Catalog catalog : catalogList) {
                        catalogNames += catalog.getCatalogName() + ", ";
                    }
                    catalogNames = catalogNames.substring(0, catalogNames.length() - 2); // Loại bỏ dấu phẩy cuối cùng
                    System.out.printf("      %-10d %-25s %-40s %-50s %-20s %-20s \n",
                            film.getFilmId(), film.getFilmName(), film.getFilmTitle(),
                            catalogNames, film.getFilmNation(),
                            (film.isFilmType() ? "Phim bộ" : "Phim lẻ"));
                }
            }
            System.out.println(ANSI_CYAN+"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
        } else {
            System.out.println("Danh sách phim trống");
        }
    }

    public void showSeriMovies() {
        List<Film> filmList = readFromFile();
        if (filmList != null) {
            System.out.println(ANSI_CYAN+"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
            System.out.println(ANSI_YELLOW +"                                              *****************************Danh sách phim mới***********************************"+ ANSI_RESET);
            System.out.println(ANSI_CYAN+"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
            System.out.printf(ANSI_YELLOW +"      %-10s %-25s %-40s %-50s %-20s %-20s\n","ID", "Tên phim", "Tiêu đề", "Thể loại", "Quốc gia", "Loại Phim"+ ANSI_RESET);
            for (Film film : filmList) {
                if (film.isFilmStatus() && film.isFilmType()) {
                    List<Catalog> catalogList = film.getCatalogList();
                    String catalogNames = "";
                    for (Catalog catalog : catalogList) {
                        catalogNames += catalog.getCatalogName() + ", ";
                    }
                    catalogNames = catalogNames.substring(0, catalogNames.length() - 2); // Loại bỏ dấu phẩy cuối cùng
                    System.out.printf("      %-10d %-25s %-40s %-50s %-20s %-20s \n",
                            film.getFilmId(), film.getFilmName(), film.getFilmTitle(),
                            catalogNames, film.getFilmNation(),
                            (film.isFilmType() ? "Phim bộ" : "Phim lẻ"));
                }
            }
            System.out.println(ANSI_CYAN+"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
        } else {
            System.out.println("Danh sách phim trống");
        }
    }

    public void byNation() {
        System.out.println("Mời bạn nhập tên Quốc gia");
        String name = Validation.getString();
        List<Film> films = findByFilmNation(name);
        if (films == null) {
            System.out.println("không có phim nào của quốc gia này ");
        } else {
            System.out.println(ANSI_CYAN+"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
            System.out.println(ANSI_YELLOW +"                                              *****************************Danh sách phim mới***********************************"+ ANSI_RESET);
            System.out.println(ANSI_CYAN+"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
            System.out.printf(ANSI_YELLOW +"      %-10s %-25s %-40s %-50s %-20s %-20s\n","ID", "Tên phim", "Tiêu đề", "Thể loại", "Quốc gia", "Loại Phim"+ ANSI_RESET);
            for (Film film : films) {
                if (film.isFilmStatus()) {
                    List<Catalog> catalogList = film.getCatalogList();
                    String catalogNames = "";
                    for (Catalog catalog : catalogList) {
                        catalogNames += catalog.getCatalogName() + ", ";
                    }
                    catalogNames = catalogNames.substring(0, catalogNames.length() - 2); // Loại bỏ dấu phẩy cuối cùng
                    System.out.printf("      %-10d %-25s %-40s %-50s %-20s %-20s \n",
                            film.getFilmId(), film.getFilmName(), film.getFilmTitle(),
                            catalogNames, film.getFilmNation(),
                            (film.isFilmType() ? "Phim bộ" : "Phim lẻ"));
                }
            }
            System.out.println(ANSI_CYAN+"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
        }
    }

    public void searchByName() {
        System.out.println("Mời bạn nhập tên phim bạn muốn tìm kiến: ");
        String name = Validation.getString();
        List<Film> films = findByFilmName(name);
        if (films == null) {
            System.out.println("không có phim nào của quốc gia này ");
        } else {
            System.out.println(ANSI_CYAN+"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
            System.out.println(ANSI_YELLOW +"                                              *****************************Danh sách phim mới***********************************"+ ANSI_RESET);
            System.out.println(ANSI_CYAN+"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
            System.out.printf(ANSI_YELLOW +"      %-10s %-25s %-40s %-50s %-20s %-20s\n","ID", "Tên phim", "Tiêu đề", "Thể loại", "Quốc gia", "Loại Phim"+ ANSI_RESET);
            for (Film film : films) {
                if (film.isFilmStatus()) {
                    List<Catalog> catalogList = film.getCatalogList();
                    String catalogNames = "";
                    for (Catalog catalog : catalogList) {
                        catalogNames += catalog.getCatalogName() + ", ";
                    }
                    catalogNames = catalogNames.substring(0, catalogNames.length() - 2); // Loại bỏ dấu phẩy cuối cùng
                    System.out.printf("      %-10d %-25s %-40s %-50s %-20s %-20s \n",
                            film.getFilmId(), film.getFilmName(), film.getFilmTitle(),
                            catalogNames, film.getFilmNation(),
                            (film.isFilmType() ? "Phim bộ" : "Phim lẻ"));
                }
            }
            System.out.println(ANSI_CYAN+"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
        }
    }
}