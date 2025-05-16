package entity;

import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String password;
    private String mail;
    private int activate_code;
    private boolean activate;

    public User(String name, String password, String mail, int activate_code, boolean activate) {
        this.name = name;
        this.password = password;
        this.mail = mail;
        this.activate_code = activate_code;
        this.activate = activate;
    }

    public User(int id, String name, String password, String mail, int activate_code, boolean activate) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.mail = mail;
        this.activate_code = activate_code;
        this.activate = activate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getActivate_code() {
        return activate_code;
    }

    public void setActivate_code(int activate_code) {
        this.activate_code = activate_code;
    }

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
