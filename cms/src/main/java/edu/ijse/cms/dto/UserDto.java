package edu.ijse.cms.dto;

public class UserDto {
    private String userId;
    private String userName;
    private String userEmail;
    private String userRoll;
    private String password;
    private String confirmPassword;

    public UserDto() {

    }

    public UserDto(String userId, String userName, String userEmail, String userRoll, String password, String confirmPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userRoll = userRoll;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserRoll() {
        return userRoll;
    }

    public void setUserRoll(String userRoll) {
        this.userRoll = userRoll;
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
}
