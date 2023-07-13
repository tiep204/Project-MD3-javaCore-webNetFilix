package ra.presentation;

import ra.bussiness.entity.User;
import ra.config.Message;
import ra.config.Validation;

import java.util.Scanner;

public class AdminManagerment {
    public static User user;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void AdminManagerment(Scanner sc) {
        boolean checl = true;
        do {
            System.out.println(ANSI_CYAN +      "                                                            **********************************************************" + ANSI_RESET);
            System.out.println(ANSI_YELLOW +    "                                                            *                    Admin Managerment                   *" + ANSI_RESET);
            System.out.println(ANSI_CYAN +      "                                                            *--------------------------------------------------------*" + ANSI_RESET);
            System.out.println(                 "                                                            *                   1. Quản lý Danh mục                  *");
            System.out.println(                 "                                                            *                   2. Quản lý phim                      *");
            System.out.println(                 "                                                            *                   3. Quản lý user                      *");
            System.out.println(                 "                                                            *                   4. Đăng xuất                         *");
            System.out.println(                 "                                                            *                                                        *");
            System.out.println(ANSI_CYAN +      "                                                            *                   Sự lựa chọn của bạn:                 *" + ANSI_RESET);
            System.out.println(ANSI_CYAN +      "                                                            **********************************************************" + ANSI_RESET);
            int choice = Validation.getInteger();
            switch (choice) {
                case 1:
                    System.out.println(ANSI_CYAN +      "                                                            **********************************************************" + ANSI_RESET);
                    System.out.println(ANSI_YELLOW +    "                                                            *                   1. Quản lý Danh mục                  *" + ANSI_RESET);
                    System.out.println(                 "                                                            *                   2. Quản lý phim                      *");
                    System.out.println(                 "                                                            *                   3. Quản lý user                      *");
                    System.out.println(                 "                                                            *                   4. Đăng xuất                         *");
                    System.out.println(                 "                                                            *                                                        *");
                    System.out.println(ANSI_CYAN +      "                                                            *                   Sự lựa chọn của bạn:                 *" + ANSI_RESET);
                    System.out.println(ANSI_CYAN +      "                                                            **********************************************************" + ANSI_RESET);
                    CatalogManagerment.catalogManagerment(sc);
                    break;
                case 2:
                    System.out.println(ANSI_CYAN +      "                                                            **********************************************************" + ANSI_RESET);
                    System.out.println(                 "                                                            *                   1. Quản lý Danh mục                  *");
                    System.out.println(ANSI_YELLOW +    "                                                            *                   2. Quản lý phim                      *" + ANSI_RESET);
                    System.out.println(                 "                                                            *                   3. Quản lý user                      *");
                    System.out.println(                 "                                                            *                   4. Đăng xuất                         *");
                    System.out.println(                 "                                                            *                                                        *");
                    System.out.println(ANSI_CYAN +      "                                                            *                   Sự lựa chọn của bạn:                 *" + ANSI_RESET);
                    System.out.println(ANSI_CYAN +      "                                                            **********************************************************" + ANSI_RESET);
                    FilmManagerment.filmManagerment();
                    break;
                case 3:
                    System.out.println(ANSI_CYAN +      "                                                            **********************************************************" + ANSI_RESET);
                    System.out.println(                 "                                                            *                   1. Quản lý Danh mục                  *");
                    System.out.println(                 "                                                            *                   2. Quản lý phim                      *" );
                    System.out.println(ANSI_YELLOW +    "                                                            *                   3. Quản lý user                      *"+ ANSI_RESET);
                    System.out.println(                 "                                                            *                   4. Đăng xuất                         *");
                    System.out.println(                 "                                                            *                                                        *");
                    System.out.println(ANSI_CYAN +      "                                                            *                   Sự lựa chọn của bạn:                 *" + ANSI_RESET);
                    System.out.println(ANSI_CYAN +      "                                                            **********************************************************" + ANSI_RESET);
                    UserMenu.userManagerment();
                    break;
                case 4:
                    System.out.println(ANSI_CYAN+      "                                                            **********************************************************"+ ANSI_RESET);
                    System.out.println(                "                                                            *                   1. Quản lý Danh mục                  *");
                    System.out.println(                "                                                            *                   2. Quản lý phim                      *");
                    System.out.println(                "                                                            *                   3. Quản lý user                      *");
                    System.out.println(ANSI_YELLOW+    "                                                            *                   4. Đăng xuất                         *"+ ANSI_RESET);
                    System.out.println(                "                                                            *                                                        *");
                    System.out.println(ANSI_CYAN+      "                                                            *                   Sự lựa chọn của bạn:                 *"+ ANSI_RESET);
                    System.out.println(ANSI_CYAN+      "                                                            **********************************************************"+ ANSI_RESET);
                    System.out.println("");
                    user = null;
                    checl = false;
                    break;
                default:
                    System.err.println(Message.EXIT_CHOICE_MENUADMIN);
            }
        } while (checl);
    }
}