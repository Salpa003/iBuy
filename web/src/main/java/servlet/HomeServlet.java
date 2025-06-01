package servlet;

import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;
import util.PathToJsp;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private UserService service = UserService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
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
      if (user == null)
          req.getRequestDispatcher(PathToJsp.create("login")).forward(req,resp);
      else {
          req.setAttribute("user",user);
          req.setAttribute("name",user.getName());
          req.setAttribute("mail",user.getMail());
          req.getRequestDispatcher(PathToJsp.create("home")).forward(req, resp);
      }
    }
}
