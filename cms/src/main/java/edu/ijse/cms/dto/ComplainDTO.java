package edu.ijse.cms.dto;

public class ComplainDTO {
    private int complainId;
    private String userName;
    private String userEmail;
    private String subject;
    private String message;
    private String status;
    private String createdAt;

    // Constructor
    public ComplainDTO(int complainId, String userName, String userEmail, String subject, String message, String status, String createdAt) {
        this.complainId = complainId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.subject = subject;
        this.message = message;
        this.status = status;
        this.createdAt = createdAt;
    }

    // Empty constructor (optional)
    public ComplainDTO() {
    }

    // Getters and Setters
    public int getComplainId() {
        return complainId;
    }

    public void setComplainId(int complainId) {
        this.complainId = complainId;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
