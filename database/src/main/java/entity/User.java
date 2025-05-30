package entity;

import java.util.Objects;
import java.util.Set;

public class User {
    private int id;
    private String name;
    private String password;
    private String mail;

    private Set<Product> products;

    public User(int id, String name, String password, String mail) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.mail = mail;
        this.products = products;
    }

    public User(String name, String password, String mail) {
        this.name = name;
        this.password = password;
        this.mail = mail;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
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
