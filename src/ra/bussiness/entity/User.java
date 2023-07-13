package ra.bussiness.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private int userId;
    private String fullName;
    private String phoneNumber;
    private String email;
    private int age;
    private String username;
    private String password;
    private String confirmPassword;
    private Date createDate;
    private boolean account;
    private boolean pemisition;
    private boolean userStatus;

    public User() {
    }

    public User(int userId, String fullName, String phoneNumber, String email, int age, String username, String password, String confirmPassword, Date createDate, boolean account, boolean pemisition, boolean userStatus) {
        this.userId = userId;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.age = age;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.createDate = createDate;
        this.account = account;
        this.pemisition = pemisition;
        this.userStatus = userStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isAccount() {
        return account;
    }

    public void setAccount(boolean account) {
        this.account = account;
    }

    public boolean isPemisition() {
        return pemisition;
    }

    public void setPemisition(boolean pemisition) {
        this.pemisition = pemisition;
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }
}