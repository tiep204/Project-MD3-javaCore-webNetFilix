package ra.config;

import ra.bussiness.impl.UserImpl;


public class Message {
    /////////////////////////////RUN////////////////////////////
    static UserImpl userImpl = new UserImpl();
    public static final String MENUNETFFIX = "*************************NETFLIX****************************\n" +
            "1. Đăng nhập\n" +
            "2. Đăng ký \n" +
            "3. Thoát\n" +
            "Sự lựa chọn của bạn: ";
    public static final String CHOICE_MENU_NETFFIX = "Vui lòng chọn từ 1-3";
    public static final String ENTER_USERNAME = "Nhập vào tên đăng nhập";
    public static final String ENTER_PASSWORD = "Nhập vào mật khẩu: ";
    public static final String LOGIN_FALL = "Đăng nhập thất bại\n" +
            "1.Đăng nhập lại\n" +
            "2.Đăng ký\n" +
            "3.Quên mật khẩu\n" +
            "4.Thoat\n" +
            "Sự lựa chọn của bạn:\n ";
    ///////////////////ADMIN MANAGERMENT/////////////////////////////
    public static final String MENU_ADMIN = "********************Admin Managerment********************\n" +
            "1.Quản lý Danh mục\n" +
            "2.Quản lý phim\n" +
            "3.Quản lý user\n" +
            "4.Đăng xuất\n" +
            "Sự lựa chọn của bạn: ";
    public static final String EXIT_CHOICE_MENUADMIN = "Vui lòng chọn từ 1-5";
    //////////////////////////userManagerment////////////////////////////////
    public static final String MENU_USER_MANAGERMENT = "*************Xin chao " + userImpl.userLogin().getUsername() + "*************\n" +
            "1.Show Toàn bộ phim\n" +
            "2.Hiển thị phim..\n" +
            "3.Search phim theo tên\n" +
            "4.Danh sách phim của bạn đã like\n" +
            "5.Hiển thị lịch sử\n" +
            "6.Tài khoản\n" +
            "7.Xem phim\n" +
            "8.Đăng xuât\n" +
            "9.Thoát\n" +
            "Sự lựa chọn của bạn: ";
    public static final String EXIT_CHOICE_MENU_USER = "Vui lòng chọn từ 1-8";
    public static final String CHOICE_ID_FILM = "Mời bạn chọn ID phim bạn muốn xem : ";
    public static final String NOT_ID_FILM = "Không tìm thấy phim với ID đã nhập.";
    public static final String CHOI_WATCH_FILM = "1.Tạm dừng/Tiếp tuc                       2.Like/unlike                 3.Thoát";
    public static final String OUT_WATCH_FILM = "Bạn đã thoát khỏi xem phim.";
    public static final String CHOICE_WATCH_1_3 = "Vui lòng chọn từ 1-3";
    public static final String STOP_FILM = "Đã tạm dừng xem phim.";
    public static final String RUN_FILM = "Đã tiếp tục xem phim.";
    //////////////////////////////////ACCOUNT MENU/////////////////////////////////////////
    public static final String MENU_ACCOUNT = "*****************Tài khoản**********************\n"+
            "1.Hiển thị thông tin cá nhân\n"+
            "2.Thay đổi Email\n"+
            "3.Thay đổi Số điện thoại\n"+
            "4.Đổi mật khẩu\n"+
            "5.Nâng cấp tài khoản\n"+
            "6.khóa tài khoản\n"+
            "7.Quay lại\n"+
            "Sự lựa chọn của bạn";
}