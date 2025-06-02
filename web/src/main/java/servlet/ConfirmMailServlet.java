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

@WebServlet("/confirmMail")
public class ConfirmMailServlet extends HttpServlet {
    private UserService service = UserService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Integer id = null;
        if (cookies!=null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("id")){
                    id = Integer.parseInt(cookie.getValue());
                    break;
                }
            }
        }
        if (id==null) {
            System.out.println("Empty");
        }
        Optional<User> maybeUser = service.get(id);
        if (maybeUser.isPresent()) {
            User user = maybeUser.get();
            System.out.println(user);
            req.setAttribute("mail",user.getMail());
            req.getRequestDispatcher(PathToJsp.create("confirmMail")).forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Integer id = null;
        if (cookies!=null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("id")){
                    id = Integer.parseInt(cookie.getValue());
                    break;
                }
            }
        }
        if (id==null) {
            System.out.println("Empty");
        }
        Optional<User> maybeUser = service.get(id);
        if (maybeUser.isPresent()) {
            User user = maybeUser.get();
            int code = Integer.parseInt(req.getParameter("code"));
            boolean isActivate = service.activate(id,code);
            req.setAttribute("user",user);
            if (isActivate) {
                Cookie cookie = new Cookie("id",null);
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
                req.getRequestDispatcher(PathToJsp.create("AkkCreate")).forward(req,resp);
            } else {
                req.setAttribute("errorMessage","Не правильный код");
                req.setAttribute("mail",user.getMail());
                req.getRequestDispatcher(PathToJsp.create("confirmMail")).forward(req,resp);
            }
        }
    }
}
