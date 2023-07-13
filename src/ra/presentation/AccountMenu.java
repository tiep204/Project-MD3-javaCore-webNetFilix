package ra.presentation;

import ra.bussiness.impl.UserImpl;
import ra.config.Message;
import ra.config.Validation;

import java.util.Scanner;

public class AccountMenu {
    public static UserImpl user = new UserImpl();
    public static void account() {
        boolean check = true;
        do {
            /*System.out.println(Message.MENU_ACCOUNT);*/
            System.out.println("*****************Tài khoản**********************\n"+
                    "1.Hiển thị thông tin cá nhân\n"+
                    "2.Thay đổi Email\n"+
                    "3.Thay đổi Số điện thoại\n"+
                    "4.Đổi mật khẩu\n"+
                    "5.Nâng cấp tài khoản\n"+
                    "6.khóa tài khoản\n"+
                    "7.Quay lại\n"+
                    "Sự lựa chọn của bạn");
            int choice = Validation.getInteger();
            switch (choice) {
                case 1:
                    showprofile();
                    break;
                case 2:
                    changeEmail();
                    break;
                case 3:
                    changePhoneNumber();
                    break;
                case 4:
                    changePassword();
                    break;
                case 5:
                    System.err.println("Hệ thông hiện đang bảo trì vui lòng quay trở lại sau");
                    break;
                case 6:
                    lockAccount();
                    break;
                case 7:
                    check = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1-7");
            }
        } while (check);
    }

    public static void changeEmail() {
        user.changeEmail();
    }
    public static void changePhoneNumber(){
        user.changePhoneNumber();
    }
    public static void changePassword(){
        user.changePassword();
    }
    public static void lockAccount(){
        user.lockAccount();
    }
    public static void showprofile(){
        user.showAllProfile();
    }
}