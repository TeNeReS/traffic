package arkhipov.traffic.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "records")
public class Record {
    public static final int RECORD_SEQ = 200000;

    @Id
    @SequenceGenerator(name = "record_seq", allocationSize = 1, initialValue = RECORD_SEQ)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "record_seq")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private LocalDateTime dateTime;
    private int uplink;
    private int downlink;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getUplink() {
        return uplink;
    }

    public void setUplink(int uplink) {
        this.uplink = uplink;
    }

    public int getDownlink() {
        return downlink;
    }

    public void setDownlink(int downlink) {
        this.downlink = downlink;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", userId=" + user.getId() +
                ", dateTime=" + dateTime +
                ", uplink=" + uplink +
                ", downlink="  + downlink +
                '}';
    }
}
