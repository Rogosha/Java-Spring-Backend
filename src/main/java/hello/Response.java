package hello;

import hello.Models.Users;

public class Response {
    private String status;

    private Users user;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public Response(String status, Users user) {
        this.status = status;
        this.user = user;
    }

    public Response() {
    }
}
