package entity;

public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private int count;
    private User user;

    public Product(int id, String name, String description, double price, int count, User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.count = count;
        this.user = user;
    }

    public Product(String name, String description, double price, int count, User user) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.count = count;
        this.user = user;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
