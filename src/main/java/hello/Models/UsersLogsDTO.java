package hello.Models;

import java.time.LocalDateTime;

public class UsersLogsDTO {
    private int id;

    private Integer user;

    private LocalDateTime logInTime;

    private LocalDateTime logOutTime;

    private String crashReason;

    private  Boolean softwareCrash;

    private Boolean systemCrash;

    public UsersLogsDTO(int id, Integer user, LocalDateTime logInTime, LocalDateTime logOutTime, String crashReason, Boolean softwareCrash, Boolean systemCrash) {
        this.id = id;
        this.user = user;
        this.logInTime = logInTime;
        this.logOutTime = logOutTime;
        this.crashReason = crashReason;
        this.softwareCrash = softwareCrash;
        this.systemCrash = systemCrash;
    }

    public UsersLogsDTO() {
    }

    public int getId() {
        return id;
    }

    public Integer getUser() {
        return user;
    }

    public LocalDateTime getLogInTime() {
        return logInTime;
    }

    public LocalDateTime getLogOutTime() {
        return logOutTime;
    }

    public String getCrashReason() {
        return crashReason;
    }

    public Boolean getSoftwareCrash() {
        return softwareCrash;
    }

    public Boolean getSystemCrash() {
        return systemCrash;
    }
}
