package ra.presentation;

import ra.bussiness.impl.FilmImpl;
import ra.bussiness.impl.HistoryImpl;
import ra.bussiness.impl.UserImpl;
import ra.config.Validation;

public class UserMenu {
    static UserImpl userIpml = new UserImpl();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        userManagerment();
    }
    public static void userManagerment() {
        boolean check = true;
        do {
            System.out.println(ANSI_CYAN + "                                                            **********************************************************"+ ANSI_RESET);
            System.out.println(ANSI_YELLOW +"                                                            *----------------------Quản lý User----------------------*"+ ANSI_RESET);
            System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*"+ ANSI_RESET);
            System.out.println("                                                            *              1. Hiển thị danh sách user                *");
            System.out.println("                                                            *              2. Block/unlock user                      *");
            System.out.println("                                                            *              3. Quản lý lịch sử xem phim của user      *");
            System.out.println("                                                            *              4. Thoát                                  *");
            System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*"+ ANSI_RESET);
            System.out.println(ANSI_CYAN + "                                                            *   Sự lựa chọn của bạn:                                 *"+ ANSI_RESET);
            System.out.println(ANSI_CYAN + "                                                            **********************************************************"+ ANSI_RESET);

            int choice = Validation.getInteger();
            switch (choice) {
                case 1:
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************"+ ANSI_RESET);
                    System.out.println("                                                            *----------------------Quản lý User----------------------*");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*"+ ANSI_RESET);
                    System.out.println(ANSI_YELLOW +"                                                            *              1. Hiển thị danh sách user                *"+ANSI_RESET);
                    System.out.println("                                                            *              2. Block/unlock user                      *");
                    System.out.println("                                                            *              3. Quản lý lịch sử xem phim của user      *");
                    System.out.println("                                                            *              4. Thoát                                  *");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            *   Sự lựa chọn của bạn:                                 *"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************"+ ANSI_RESET);
                    findAll();
                    break;
                case 2:
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************"+ ANSI_RESET);
                    System.out.println("                                                            *----------------------Quản lý User----------------------*");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*"+ ANSI_RESET);
                    System.out.println("                                                            *              1. Hiển thị danh sách user                *");
                    System.out.println(ANSI_YELLOW +"                                                            *              2. Block/unlock user                      *"+ ANSI_RESET);
                    System.out.println("                                                            *              3. Quản lý lịch sử xem phim của user      *");
                    System.out.println("                                                            *              4. Thoát                                  *");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            *   Sự lựa chọn của bạn:                                 *"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************"+ ANSI_RESET);
                    findAll();
                    deleteStatus();
                    break;
                case 3:
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************"+ ANSI_RESET);
                    System.out.println("                                                            *----------------------Quản lý User----------------------*");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*"+ ANSI_RESET);
                    System.out.println("                                                            *              1. Hiển thị danh sách user                *");
                    System.out.println("                                                            *              2. Block/unlock user                      *");
                    System.out.println(ANSI_YELLOW +"                                                            *              3. Quản lý lịch sử xem phim của user      *"+ ANSI_RESET);
                    System.out.println("                                                            *              4. Thoát                                  *");
                    System.out.println(ANSI_CYAN + "                                                            *--------------------------------------------------------*"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            *   Sự lựa chọn của bạn:                                 *"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN + "                                                            **********************************************************"+ ANSI_RESET);
                    showHistory();
                    break;
                case 4:
                    check = false;
                    break;
                default:
                    System.err.println("Vui lòng nhập từ 1-3");
            }
        } while (check);
    }

    public static void findAll() {
        userIpml.displayData();
    }

    public static void deleteStatus() {
        System.out.println("Mời bạn nhập vào id người dùng bạn muốn block/unlock");
        int id = Validation.getInteger();
        boolean check = userIpml.delete(id);
        if (check) {
            System.out.println("bạn đã block thành công");
        } else {
            System.err.println("block không thành công");
        }
    }
    public static void showHistory(){
        findAll();
        System.out.println();
        HistoryImpl history = new HistoryImpl();
        history.displayData();
    }
}