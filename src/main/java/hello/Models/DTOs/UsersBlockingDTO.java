package hello.Models.DTOs;

public class UsersBlockingDTO {
    private int id;

    private Integer user;

    private String blockingReason;

    public UsersBlockingDTO(int id, Integer users, String blockingReason) {
        this.id = id;
        this.user = users;
        this.blockingReason = blockingReason;
    }

    public UsersBlockingDTO() {
    }

    public int getId() {
        return id;
    }

    public Integer getUser() {
        return user;
    }

    public String getBlockingReason() {
        return blockingReason;
    }
}
