package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model;

import com.orm.dsl.Table;

@Table
public class User {
    private Long id = null;
    private String password;
    private String email;


    public User() {
    }

    public User(Long id, String password, String email) {
        this.id = id;
        this.password = password;
        this.email = email;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}