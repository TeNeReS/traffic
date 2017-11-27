package arkhipov.traffic.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    public static final int USER_SEQ = 100000;

    @Id
    @SequenceGenerator(name = "user_seq", allocationSize = 1, initialValue = USER_SEQ)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_seq")
    private Integer id;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List <Record> records;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", records=" + records.size() +
                '}';
    }
}
