package hello.Models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "usersblocking")
public class UsersBlocking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "UserID", referencedColumnName = "id", unique = true, nullable = false)
    private Users user;

    @Column(name = "BlockingReason", length = 200)
    private String blockingReason;


    public int getId() {
        return id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getBlockingReason() {
        return blockingReason;
    }

    public void setBlockingReason(String blockingReason) {
        this.blockingReason = blockingReason;
    }

    public UsersBlocking(Users user, String blockingReason) {
        this.user = user;
        this.blockingReason = blockingReason;
    }

    public UsersBlocking() {
    }
}
