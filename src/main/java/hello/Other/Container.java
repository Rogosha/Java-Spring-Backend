package hello.Other;

import hello.Models.UsersLogs;

import java.time.LocalDateTime;

public class Container {
    private Iterable<UsersLogs> usersLogs;
    private LocalDateTime timeSpend;

    public Iterable<UsersLogs> getUsersLogs() {
        return usersLogs;
    }

    public void setUsersLogs(Iterable<UsersLogs> usersLogs) {
        this.usersLogs = usersLogs;
    }

    public LocalDateTime getTimeSpend() {
        return timeSpend;
    }

    public void setTimeSpend(LocalDateTime timeSpend) {
        this.timeSpend = timeSpend;
    }

    public Container() {
    }
}
