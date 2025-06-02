package util;

import entity.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import service.UserService;

import java.util.Optional;

public final class UserUtil {
    private static UserService service = UserService.getInstance();
    public static User isPresentCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        User user = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("id".equals(cookie.getName())) {
                    String id = cookie.getValue();
                    Optional<User> maybeUser = service.get(Integer.parseInt(id));
                    if (maybeUser.isPresent()) {
                        user = maybeUser.get();
                        break;
                    }
                }
            }
        }
        return user;
    }
}
