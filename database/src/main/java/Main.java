import dao.UserDao;
import entity.User;

public class Main {
    public static void main(String[] args) {
        User user = new User("rusik","123","rus@g",1,true);
        UserDao userDao = UserDao.getInstance();
        userDao.save(user);
    }
}
