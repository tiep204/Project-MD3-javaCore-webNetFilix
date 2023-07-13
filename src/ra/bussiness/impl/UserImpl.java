package ra.bussiness.impl;

import ra.bussiness.design.IUser;
import ra.bussiness.entity.User;
import ra.config.Constanst;
import ra.config.Validation;
import ra.data.FileImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserImpl implements IUser<User, Integer> {
    public static UserImpl userImpl = new UserImpl();
    private static User userLogin;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";

    @Override
    public boolean create(User user) {
        List<User> userList = readFromFile();
        if (userList == null) {
            userList = new ArrayList<>();
        }
        userList.add(user);
        return writeToFile(userList);
    }

    @Override
    public boolean update(User user) {
        List<User> userList = readFromFile();
        if (userList == null) {
            return false;
        } else {
            boolean check = false;
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getUserId() == user.getUserId()) {
                    userList.set(i, user);
                    check = true;
                    break;
                }
            }
            boolean result = writeToFile(userList);
            if (check && result) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean delete(Integer id) {
        List<User> userList = readFromFile();
        for (User user : userList) {
            if (user.getUserId() == id) {
                if (user.isPemisition()) {
                    return false; // Người dùng có quyền không thể bị thay đổi trạng thái
                }
                user.setUserStatus(!user.isUserStatus()); // Đảo ngược trạng thái của người dùng
                return writeToFile(userList); // Trả về kết quả ghi vào file trực tiếp
            }
        }
        return false; // Không tìm thấy người dùng với id tương ứng
    }


    @Override
    public boolean writeToFile(List<User> list) {
        FileImpl<User> userFile = new FileImpl<>();
        return userFile.writeDataToFile(list, Constanst.USER_URL_FILE);
    }

    @Override
    public List<User> readFromFile() {
        FileImpl<User> userFile = new FileImpl<>();
        return userFile.readDataFromFile(Constanst.USER_URL_FILE);
    }

    @Override
    public User inputData(Scanner sc) {
        List<User> userList = readFromFile();
        if (userList == null) {
            userList = new ArrayList<>();
        }
        User user = new User();
        user.setUserId(userList.size() + 1);
        System.out.println("Mời bạn nhập Họ Tên: ");
        user.setFullName(Validation.getString());
        boolean isValidPhoneNumber = false;
        boolean isValidEmail = false;
        boolean isValidUsername = false;
        boolean isValidPassword = false;
        while (!isValidPhoneNumber) {
            System.out.println("Mời bạn nhập số điện thoại: ");
            String phoneNumber = Validation.getString();
            isValidPhoneNumber = Validation.validatePhoneNumber(phoneNumber);
            if (isValidPhoneNumber) {
                boolean isPhoneNumberExists = Validation.checkPhoneNumberExists(userList, phoneNumber);
                if (isPhoneNumberExists) {
                    System.err.println("Số điện thoại đã tồn tại. Vui lòng nhập lại.");
                    isValidPhoneNumber = false;
                } else {
                    user.setPhoneNumber(phoneNumber);
                }
            } else {
                System.err.println("Số điện thoại không hợp lệ. Vui lòng nhập lại.");
            }
        }
        while (!isValidEmail) {
            System.out.println("Mời bạn nhập email: ");
            String email = Validation.getString();
            isValidEmail = Validation.validateEmail(email);
            if (isValidEmail) {
                boolean isEmailExists = Validation.checkEmailExists(userList, email);
                if (isEmailExists) {
                    System.err.println("Email đã tồn tại. Vui lòng nhập lại.");
                    isValidEmail = false;
                } else {
                    user.setEmail(email);
                }
            } else {
                System.err.println("Email không hợp lệ. Vui lòng nhập lại.");
            }
        }
        System.out.println("Mời bạn nhập tuổi:");
        int age;
        do {
            age = Validation.getInteger();
            if (Validation.validateAge(age)) {
                break;
            } else {
                System.out.println("Tuổi phải lớn hơn 0. Mời nhập lại:");
            }
        } while (true);
        user.setAge(age);
        while (!isValidUsername) {
            System.out.println("Mời bạn nhập username: ");
            String username = Validation.getString();
            isValidUsername = Validation.validateUsername(username);
            if (isValidUsername) {
                boolean isUsernameExists = Validation.checkUsernameExists(userList, username);
                if (isUsernameExists) {
                    System.err.println("Username đã tồn tại. Vui lòng nhập lại.");
                    isValidUsername = false;
                } else {
                    user.setUsername(username);
                }
            } else {
                System.err.println("Username không hợp lệ. Vui lòng nhập lại.");
            }
        }
        while (!isValidPassword) {
            System.out.println("Mời bạn nhập mật khẩu: ");
            String password = Validation.getString();
            isValidPassword = Validation.validatePassword(password);

            if (isValidPassword) {
                System.out.println("Mời bạn nhập lại mật khẩu: ");
                String confirmPassword = Validation.getString();

                if (password.equals(confirmPassword)) {
                    user.setPassword(password);
                } else {
                    System.err.println("Mật khẩu không khớp. Vui lòng nhập lại.");
                    isValidPassword = false;
                }
            } else {
                System.err.println("Mật khẩu không hợp lệ. Vui lòng nhập lại.");
            }
        }
        user.setCreateDate(new Date());
        user.setAccount(true);
        user.setPemisition(false);
        user.setUserStatus(true);
        return user;
    }

    @Override
    public void displayData() {
        List<User> userList = readFromFile();
        if (userList != null) {
            System.out.println(ANSI_CYAN +"  ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
            System.out.println(ANSI_YELLOW +"                                                    *****************************Danh sách người dùng***********************************"+ ANSI_RESET);
            System.out.println(ANSI_CYAN +"  ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
            System.out.printf(ANSI_YELLOW +"   %-10s %-25s %-15s %-35s %-10s %-20s %-25s %-15s %-15s %-20s\n",
                    "ID", "Họ tên", "Số điện thoại", "Email", "Tuổi", "Tên đăng nhập", "Ngày tạo", "Tài khoản", "Quyền", "Trạng thái");
            System.out.println(ANSI_CYAN +"  ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            for (User user : userList) {
                String formattedDate = format.format(user.getCreateDate());
                System.out.printf("   %-10d %-25s %-15s %-35s %-10d %-20s %-25s %-15s %-15s %-20s\n",
                        user.getUserId(), user.getFullName(), user.getPhoneNumber(), user.getEmail(),
                        user.getAge(), user.getUsername(), formattedDate, (user.isAccount() ? "Thường" : "Vip"),
                        (user.isPemisition() ? "admin" : "user"), (user.isUserStatus() ? "unlock" : "block"));
            }
            System.out.println(ANSI_CYAN +"  ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ ANSI_RESET);
        } else {
            System.out.println("Danh sách user trống");
        }
    }

    @Override
    public User checkLogin(String name, String pass) {
        List<User> list = readFromFile();
        for (User user : list) {
            if (user.getUsername().equals(name) && user.getPassword().equals(pass)) {
                userLogin = user;
                return userLogin;
            }
        }
        return null;
    }

    @Override
    public List<User> findbyUserName(String name) {
        List<User> userList = readFromFile();
        List<User> userListByName = new ArrayList<>();
        for (User user : userList) {
            if (user.getUsername().contains(name)) {
                userListByName.add(user);
            }
        }
        return userListByName;
    }
    public User userLogin(){
        return userLogin;
    }

    public void showAllProfile() {
        if (userLogin != null) {
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("******************Thông tin cá nhân của bạn****************");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("ID            : " + userLogin.getUserId());
            System.out.println("Họ tên        : " + userLogin.getFullName());
            System.out.println("Số điện thoại : " + userLogin.getPhoneNumber());
            System.out.println("Email         : " + userLogin.getEmail());
            System.out.println("Tuổi          : " + userLogin.getAge());
            System.out.println("Tên đăng nhập : " + userLogin.getUsername());
            String pattern = "dd-M-yyyy hh:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            System.out.println("Ngày tạo      : " + simpleDateFormat.format(userLogin.getCreateDate()));
            System.out.println("Tài khoản     : " + (userLogin.isAccount() ? "Thường" : "VIP"));
            System.out.println("Quyền         : " + (userLogin.isPemisition() ? "Admin" : "User"));
            System.out.println("Trạng thái    : " + (userLogin.isUserStatus() ? "Mở" : "Đóng"));
            System.out.println("--------------------------------------------------------------------------------");
        } else {
            System.out.println("Người dùng đăng nhập không tồn tại.");
        }
    }

    public void changeEmail() {
        boolean isValidEmail = false;
        System.out.println("Mời bạn nhập Email cũ: ");
        String oldEmail = Validation.getString();
        System.out.println("Mời bạn nhập Mật khẩu: ");
        String password = Validation.getString();
        if (oldEmail.equals(userLogin.getEmail()) && password.equals(userLogin.getPassword())) {
            do {
                System.out.println("Mời bạn nhập Email mới: ");
                String newEmail = Validation.getString();
                isValidEmail = Validation.validateEmail(newEmail);
                if (isValidEmail) {
                    userLogin.setEmail(newEmail);
                    System.out.println("Email đã được thay đổi thành công.");
                    break;
                } else {
                    System.out.println("Email không hợp lệ. Vui lòng nhập lại.");
                }
            } while (true);
        } else {
            System.out.println("Email cũ hoặc mật khẩu không khớp với của người dùng đang đăng nhập.");
        }
    }

    public void changePhoneNumber() {
        boolean isValidPhoneNumber = false;
        System.out.println("Mời bạn nhập phoneNumber cũ: ");
        String odlPhoneNumber = Validation.getString();
        System.out.println("Mời bạn nhập Mật khẩu: ");
        String password = Validation.getString();
        if (odlPhoneNumber.equals(userLogin.getEmail()) && password.equals(userLogin.getPassword())) {
            do {
                System.out.println("Mời bạn nhập phoneNumber mới: ");
                String newPhoneNumber = Validation.getString();
                isValidPhoneNumber = Validation.validatePhoneNumber(newPhoneNumber);
                if (isValidPhoneNumber) {
                    userLogin.setPhoneNumber(newPhoneNumber);
                    System.out.println("PhoneNumber đã được thay đổi thành công.");
                    break;
                } else {
                    System.out.println("PhoneNumber không hợp lệ. Vui lòng nhập lại.");
                }
            } while (true);
        } else {
            System.out.println("PhoneNumber cũ hoặc mật khẩu không khớp với của người dùng đang đăng nhập.");
        }
    }

    public void changePassword() {
        boolean isValidPassword = false;
        System.out.println("Mời bạn nhập mật khẩu cũ ");
        String oldPass = Validation.getString();
        if (oldPass.equals(userLogin.getPassword())) {
            do {
                System.out.println("Mời bạn nhập password mới");
                String newPass = Validation.getString();
                isValidPassword = Validation.validatePassword(newPass);
                if (isValidPassword) {
                    userLogin.setPassword(newPass);
                    System.out.println("Bạn đã đổi password thành công");
                    break;
                } else {
                    System.out.println("Mật khẩu không lệ.Vui lòng nhập lại");
                }
            } while (true);
        } else {
            System.out.println("password không chính xác");
        }
    }

    public void lockAccount() {
        System.out.println("Bạn chắc chắn muốn khóa tài khoản chưa");
        System.out.println("1.Rồi                           2.Chưa");
        System.err.println("Lưu ý: khi khóa tài khoản bạn sẽ không tự động mở được mà phải liên hệ với admin để mở");
        int choice = Validation.getInteger();
        if (choice == 1) {
            userLogin.setUserStatus(false);
            userLogin = null;
            System.err.println("Bạn đã tự khóa tài khoản của mình");

        }
    }

    public void forgotPassword() {
        List<User> userList = userImpl.readFromFile();
        System.out.println("Mời bạn nhập username: ");
        String username = Validation.getString();
        System.out.println("Mời bạn nhập số điện thoại hoặc email để xác thực");
        String contactInfo = Validation.getString();
        for (User user : userList) {
            if (user.getUsername().equals(username) && (user.getEmail().equals(contactInfo) || user.getPhoneNumber().equals(contactInfo))) {
                if (user != null) {
                    System.out.println("Nhập mật khẩu mới: ");
                    String newPassword = Validation.getString();
                    while (!Validation.validatePassword(newPassword)) {
                        System.out.println("Mật khẩu không hợp lệ. Vui lòng nhập lại.");
                        newPassword = Validation.getString();
                    }
                    System.out.println("Nhập lại mật khẩu mới: ");
                    String confirmNewPassword = Validation.getString();
                    while (!newPassword.equals(confirmNewPassword)) {
                        System.out.println("Mật khẩu không khớp. Vui lòng nhập lại.");
                        confirmNewPassword = Validation.getString();
                    }
                    user.setPassword(newPassword);
                    update(user);
                    System.out.println("Mật khẩu đã được thay đổi thành công.");
                } else {
                    System.out.println("Thông tin xác thực không chính xác. Vui lòng thử lại.");
                }
            }
        }
    }
}