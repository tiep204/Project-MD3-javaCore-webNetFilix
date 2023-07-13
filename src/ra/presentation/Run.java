package ra.presentation;

import ra.bussiness.entity.User;
import ra.bussiness.impl.CatalogImpl;
import ra.bussiness.impl.UserImpl;
import ra.config.Message;
import ra.config.Validation;

import java.util.Scanner;

public class Run {
    private static CatalogImpl catalogIpml = new CatalogImpl();
    private static UserImpl userImpl = new UserImpl();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";


    public static void main(String[] args) {
    /*    User tiepAdmin = new User(1, "tiepdt", "0368721440", "dangtrantiep24@gmai.com", 20, "admin", "admin", "admin", new Date(), true, true, true);
        userImpl.create(tiepAdmin);*/
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(ANSI_CYAN + "                                                            +**********************************************************+" + ANSI_RESET);
            System.out.println(            "                                                            |                     1. Đăng nhập                         |");
            System.out.println(            "                                                            |                     2. Đăng ký                           |");
            System.out.println(            "                                                            |                     3. Thoát                             |");
            System.out.println(ANSI_CYAN + "                                                            |                                                          |" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "                                                            |                 Sự lựa chọn của bạn:                     |" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "                                                            +**********************************************************+" + ANSI_RESET);
            int choice = Validation.getInteger();
            switch (choice) {
                case 1:
                    login(sc);
                    break;
                case 2:
                    register(sc);
                    break;
                case 3:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.err.println(Message.CHOICE_MENU_NETFFIX);
            }
        } while (true);
    }

    public static void login(Scanner sc) {
        System.out.println(ANSI_CYAN +      "                                                            +**********************************************************+" + ANSI_RESET);
        System.out.println(ANSI_YELLOW +    "                                                            |                     1. Đăng nhập                         |" + ANSI_RESET);
        System.out.println(                 "                                                            |                     2. Đăng ký                           |");
        System.out.println(                 "                                                            |                     3. Thoát                             |");
        System.out.println(ANSI_CYAN +      "                                                            |                                                          |" + ANSI_RESET);
        System.out.println(ANSI_CYAN +      "                                                            |                 Sự lựa chọn của bạn:                     |" + ANSI_RESET);
        System.out.println(ANSI_CYAN +      "                                                            +**********************************************************+" + ANSI_RESET);
        do {
            System.out.println(Message.ENTER_USERNAME);
            String username = Validation.getString();
            System.out.println(Message.ENTER_PASSWORD);
            String password = Validation.getString();
            User user = userImpl.checkLogin(username, password);
            if (user != null) {
                if (user.isPemisition()) {
                    AdminManagerment.AdminManagerment(sc);
                } else {
                    UserMangerment.UserManagerment();
                }
                break;
            } else {
                System.out.println(ANSI_CYAN + "                                                            +--------------------------------------------------------+" + ANSI_RESET);
                System.out.println(ANSI_RED +  "                                                            |               Đăng nhập thất bại                       |" + ANSI_RESET);
                System.out.println(ANSI_CYAN + "                                                            +--------------------------------------------------------+" + ANSI_RESET);
                System.out.println(            "                                                            |               1. Đăng nhập lại                         |");
                System.out.println(            "                                                            |               2. Đăng ký                               |");
                System.out.println(            "                                                            |               3. Quên mật khẩu                         |");
                System.out.println(            "                                                            |               4. Thoát                                 |");
                System.out.println(ANSI_CYAN + "                                                            |               Sự lựa chọn của bạn:                     |" + ANSI_RESET);
                System.out.println(ANSI_CYAN + "                                                            +-------------------------------------------------------+" + ANSI_RESET);
                int choice = Validation.getInteger();
                if (choice == 1) {
                    login(sc);
                } else if (choice == 2) {
                    register(sc);
                } else if (choice == 3) {
                    forgotPassword();
                } else {
                    break;
                }
            }
        } while (true);
    }

    public static void register(Scanner sc) {
        System.out.println(ANSI_CYAN + "                                                            +**********************************************************+" + ANSI_RESET);
        System.out.println(            "                                                            |                     1. Đăng nhập                         |" );
        System.out.println(ANSI_YELLOW+"                                                            |                     2. Đăng ký                           |"+ ANSI_RESET);
        System.out.println(            "                                                            |                     3. Thoát                             |");
        System.out.println(ANSI_CYAN + "                                                            |                                                          |" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "                                                            |                 Sự lựa chọn của bạn:                     |" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "                                                            +**********************************************************+" + ANSI_RESET);
        User user = userImpl.inputData(sc);
        Validation.soutMess(userImpl.create(user));
    }

    public static void forgotPassword() {
        System.out.println(ANSI_CYAN + "                                                            +--------------------------------------------------------+" + ANSI_RESET);
        System.out.println(            "                                                            |               1. Đăng nhập lại                         |");
        System.out.println(            "                                                            |               2. Đăng ký                               |");
        System.out.println(ANSI_YELLOW+"                                                            |               3. Quên mật khẩu                         |"+ ANSI_RESET);
        System.out.println(            "                                                            |               4. Thoát                                 |");
        System.out.println(ANSI_CYAN + "                                                            |               Sự lựa chọn của bạn:                     |" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "                                                            +-------------------------------------------------------+" + ANSI_RESET);
        userImpl.forgotPassword();
    }
}