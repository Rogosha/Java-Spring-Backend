package hello.Models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "userslogs")
public class UsersLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "id", nullable = false)
    private Users user;

    @Column(name = "LogInTime", nullable = false)
    private LocalDateTime logInTime;

    @Column(name = "LogOutTime", nullable = false)
    private LocalDateTime logOutTime;

    @Column(name = "CrashReason",length = 200)
    private String crashReason;

    @Column(name = "IsSoftwareCrash")
    private Boolean softwareCrash;

    @Column(name = "IsSystemCrash")
    private Boolean systemCrash;

    public int getId() {
        return id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public LocalDateTime getLogInTime() {
        return logInTime;
    }

    public void setLogInTime(LocalDateTime logInTime) {
        this.logInTime = logInTime;
    }

    public LocalDateTime getLogOutTime() {
        return logOutTime;
    }

    public void setLogOutTime(LocalDateTime logOutTime) {
        this.logOutTime = logOutTime;
    }

    public String getCrashReason() {
        return crashReason;
    }

    public void setCrashReason(String crashReason) {
        this.crashReason = crashReason;
    }

    public Boolean getSoftwareCrash() {
        return softwareCrash;
    }

    public void setSoftwareCrash(Boolean softwareCrash) {
        this.softwareCrash = softwareCrash;
    }

    public Boolean getSystemCrash() {
        return systemCrash;
    }

    public void setSystemCrash(Boolean systemCrash) {
        this.systemCrash = systemCrash;
    }

    public UsersLogs(Users user, LocalDateTime logInTime, LocalDateTime logOutTime, String crashReason, Boolean softwareCrash, Boolean systemCrash) {
        this.user = user;
        this.logInTime = logInTime;
        this.logOutTime = logOutTime;
        this.crashReason = crashReason;
        this.softwareCrash = softwareCrash;
        this.systemCrash = systemCrash;
    }

    public UsersLogs() {
    }
}
