package ra.config;

import ra.bussiness.entity.Catalog;
import ra.bussiness.entity.Episode;
import ra.bussiness.entity.Film;
import ra.bussiness.entity.User;
import ra.bussiness.impl.EpisodeImpl;
import ra.bussiness.impl.FilmImpl;
import ra.bussiness.impl.UserImpl;

import java.time.Duration;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.Year;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import static ra.presentation.CatalogManagerment.catalogList;

public class Validation {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    private static final String ERROR_ALERT = "===>> Định dạng không hợp lệ, hoặc ngoài phạm vi! Vui lòng thử lại....";
    private static final String EMPTY_ALERT = "===>> Trường nhập vào không thể để trống! Vui lòng thử lại....";
    /*========================================Input Method Start========================================*/

    /**
     * getString()  Return a String value from the user.
     */
    public static String getString() {
        while (true) {
            String result = getInput();
            if (result.equals("")) {
                System.err.println(EMPTY_ALERT);
                continue;
            }
            return result;
        }
    }

    /**
     * getChar()  Return a Character value from the user.
     */
    public static char getChar() {
        return getString().charAt(0);
    }

    /**
     * getBoolean()  Return a Boolean value from the user.
     */
    public static boolean getBoolean() {
        String result = getString();
        return result.equalsIgnoreCase("true");
    }

    /**
     * getByte()  Return a Byte value from the user.
     */
    public static byte getByte() {
        while (true) {
            try {
                return Byte.parseByte(getString());
            } catch (NumberFormatException errException) {
                System.err.println(ERROR_ALERT);
            }
        }
    }

    /**
     * getShort()  Return a Short value from the user.
     */
    public static short getShort() {
        while (true) {
            try {
                return Short.parseShort(getString());
            } catch (NumberFormatException errException) {
                System.err.println(ERROR_ALERT);
            }
        }
    }

    /**
     * getInteger()  Return a Integer value from the user.
     */
    public static int getInteger() {
        while (true) {
            try {
                return Integer.parseInt(getString());
            } catch (NumberFormatException errException) {
                System.err.println(ERROR_ALERT);
            }
        }
    }

    /**
     * getLong()  Return a Long value from the user.
     */
    public static long getLong() {
        while (true) {
            try {
                return Long.parseLong(getString());
            } catch (NumberFormatException errException) {
                System.err.println(ERROR_ALERT);
            }
        }
    }

    /**
     * getFloat()  Return a Float value from the user.
     */
    public static float getFloat() {
        while (true) {
            try {
                return Float.parseFloat(getString());
            } catch (NumberFormatException errException) {
                System.err.println(ERROR_ALERT);
            }
        }
    }

    /**
     * getDouble()  Return a Double value from the user.
     */
    public static double getDouble() {
        while (true) {
            try {
                return Double.parseDouble(getString());
            } catch (NumberFormatException errException) {
                System.err.println(ERROR_ALERT);
            }
        }
    }
    /*========================================Input Method End========================================*/

    /**
     * getInput()  Return any String value from the user.
     */
    private static String getInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    /**
     * pressAnyKey()  Press any key to continue....
     */
    public static void pressAnyKey() {
        getInput();
    }

    public static boolean checkEmail(String email) {
        UserImpl userImpl = new UserImpl();
        List<User> userList = userImpl.readFromFile();
        boolean check = false;
        for (User us : userList) {
            if (us.getEmail().equals(email)) {
                check = true;
                break;
            }
        }
        return check;
    }

    public static boolean checkphonenumber(String phone) {
        UserImpl userImpl = new UserImpl();
        List<User> userList = userImpl.readFromFile();
        boolean check = false;
        for (User us : userList) {
            if (us.getPhoneNumber() == phone) {
                check = true;
                break;
            }
        }
        return check;
    }

    public static void soutMess(boolean boo) {
        if (boo) {
            System.out.println("Thành công");
        } else {
            System.out.println("Không thành công!!!");
        }
    }

    public static String checkFilmName() {
        FilmImpl film = new FilmImpl();
        List<Film> filmList = film.readFromFile();
        String filmName;
        if (filmList == null) {
            return getString();
        }
        do {
            filmName = getString();
            boolean check = false;
            for (Film f : filmList) {
                if (f.getFilmName().equals(filmName)) {
                    check = true;
                    break;
                }
            }
            if (check) {
                System.out.println("Tên đã tồn tại, vui lòng nhập lại tên phim mới");
            } else {
                break;
            }
        } while (true);

        return filmName;
    }

    public static String checkEpisodeName(int filmId) {
        EpisodeImpl episode = new EpisodeImpl();
        List<Episode> episodeList = episode.readFromFile();
        String episodeName;

        do {
            episodeName = Validation.getString();
            boolean check = false;
            for (Episode e : episodeList) {
                if (e.getFilmId().getFilmId() == filmId && e.getEpisodeName().equals(episodeName)) {
                    check = true;
                    break;
                }
            }
            if (check) {
                System.out.println("Tên đã tồn tại, vui lòng nhập lại tên tập phim mới");
            } else if (!episodeName.startsWith("Tập")) {
                System.out.println("Tên tập phim phải bắt đầu bằng 'Tập'");
            } else {
                break;
            }
        } while (true);

        return episodeName;
    }

    public static List<String> addPerformer() {
        List<String> performer = new ArrayList<>();
        do {
            System.out.println("Mời bạn nhập tên diễn viên: ");
            String listperformer = getString();
            boolean check = true;
            for (String per : performer) {
                if (per.equals(listperformer)) {
                    check = true;
                    break;
                }
            }
            if (check) {
                performer.add(listperformer);
            } else {
                System.err.println("Tên đã tồn tại vui lòng nhập tên khác: ");
            }
            System.out.println("Bạn có muốn thêm diễn viên khác không");
            System.out.println("1. có                         2.không");
            System.out.println("");
            int choice = getInteger();
            if (choice != 1) {
                break;
            }
        } while (true);
        return performer;
    }

    public static List<Catalog> addListCatalog(List<Catalog> catalogList) {
        List<Catalog> selectedCatalogs = new ArrayList<>();
        boolean addMoreCatalog = false;
        do {
            System.out.println(ANSI_CYAN +  "                                                ----------------------------------------------------------------------------------"+ ANSI_RESET);
            System.out.println(ANSI_YELLOW +"                                                ******************************Danh Sách Danh Mục**********************************"+ ANSI_RESET);
            System.out.println(ANSI_CYAN +  "                                                ----------------------------------------------------------------------------------"+ ANSI_RESET);
            System.out.printf(              "                                                                  %-35s %-40s \n", "Id danh mục", "Tên danh mục");
            System.out.println( ANSI_CYAN + "                                                ----------------------------------------------------------------------------------"+ ANSI_RESET);
            for (Catalog catalog : catalogList) {
                if (catalog.isCatalogStatus()) {
                    System.out.printf("                                                                  %-35s %-40s \n", catalog.getCatalogId(), catalog.getCatalogName());
                }
            }
            System.out.println( ANSI_CYAN + "                                                ----------------------------------------------------------------------------------"+ ANSI_RESET);

            int selectedId;
            do {
                System.out.print("Nhập ID của thể loại: ");
                selectedId = Validation.getInteger();
                if (selectedId < 1 || selectedId > catalogList.size()) {
                    System.err.println("ID không hợp lệ. Vui lòng chọn lại.");
                } else {
                    Catalog selectedCatalog = catalogList.get(selectedId - 1);
                    if (!selectedCatalog.isCatalogStatus()) {
                        System.err.println("Thể loại không hợp lệ. Vui lòng chọn lại.");
                        selectedId = -1; // Đánh dấu ID không hợp lệ để yêu cầu nhập lại
                    } else if (selectedCatalogs.contains(selectedCatalog)) {
                        System.err.println("Thể loại đã tồn tại. Vui lòng chọn lại.");
                        selectedId = -1; // Đánh dấu ID đã tồn tại để yêu cầu nhập lại
                    } else {
                        selectedCatalogs.add(selectedCatalog);
                    }
                }
            } while (selectedId < 1 || selectedId > catalogList.size());

            System.out.println("Bạn có muốn thêm thể loại khác không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int choice = Validation.getInteger();
            if (choice == 1) {
                addMoreCatalog = true;
            } else {
                addMoreCatalog = false;
            }
        } while (addMoreCatalog);
        return selectedCatalogs;
    }


    public static Duration parseDuration(String durationStr) {
        long hours = 0;
        long minutes = 0;
        long seconds = 0;

        Pattern pattern = Pattern.compile("(?:(\\d+)h)?(?:(\\d+)m)?(?:(\\d+)s)?");
        Matcher matcher = pattern.matcher(durationStr);

        if (matcher.matches()) {
            if (matcher.group(1) != null) {
                hours = Long.parseLong(matcher.group(1));
            }
            if (matcher.group(2) != null) {
                minutes = Long.parseLong(matcher.group(2));
            }
            if (matcher.group(3) != null) {
                seconds = Long.parseLong(matcher.group(3));
            }
        }

        return Duration.ofHours(hours).plusMinutes(minutes).plusSeconds(seconds);
    }


    public static int validateYear() {
        System.out.println("Mời bạn chọn năm phát hành: ");
        int filmYearRelease;
        int currentYear = Year.now().getValue();
        do {
            filmYearRelease = Validation.getInteger();
            if (filmYearRelease > currentYear) {
                System.err.println("Năm phát hành không được vượt quá năm hiện tại. Vui lòng chọn lại.");
            }
        } while (filmYearRelease > currentYear);
        return filmYearRelease;
    }

    public static boolean checkPhoneNumberExists(List<User> userList, String phoneNumber) {
        return userList.stream().anyMatch(u -> u.getPhoneNumber().equals(phoneNumber));
    }

    public static boolean checkEmailExists(List<User> userList, String email) {
        return userList.stream().anyMatch(u -> u.getEmail().equals(email));
    }

    public static boolean checkUsernameExists(List<User> userList, String username) {
        return userList.stream().anyMatch(u -> u.getUsername().equals(username));
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        // Kiểm tra độ dài và định dạng số điện thoại
        String regex = "0\\d{9}"; // Số điện thoại có số 0 ở đầu và có tổng cộng 10 chữ số
        return phoneNumber.matches(regex);
    }

    public static boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9]+@gmail\\.com$";
        return email.matches(emailRegex);
    }

    public static boolean validateUsername(String username) {
        // Kiểm tra độ dài tên đăng nhập
        return username.length() >= 6;
    }

    public static boolean validateAge(int age) {
        return age > 0;
    }

    public static boolean validatePassword(String password) {
        // Kiểm tra độ dài và định dạng mật khẩu
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,50}$";
        return password.matches(regex);
    }
}