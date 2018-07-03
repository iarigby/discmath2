package sample;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private String name;

    public User() {

    }

    public User(String name) {

    }
}
