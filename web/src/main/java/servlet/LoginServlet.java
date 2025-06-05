package servlet;

import exception.IncorrectPasswordException;
import exception.UserNotFoundException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;
import util.PathToJsp;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserService service = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(PathToJsp.create("login")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        try {
            int id = service.login(name, password);

            Cookie cookie = new Cookie("id", String.valueOf(id));
            cookie.setMaxAge(60 * 60 * 24 * 30);
            resp.addCookie(cookie);

           resp.sendRedirect("/home");
        } catch (IncorrectPasswordException e) {
            req.setAttribute("name", name);
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher(PathToJsp.create("login")).forward(req, resp);
        } catch (UserNotFoundException e) {
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher(PathToJsp.create("login")).forward(req, resp);
        }

    }
}
