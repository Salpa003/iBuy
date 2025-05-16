package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.JspPath;

import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private String cookie_user_key="ROBOT_NUMBER";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookie_user_key)){
                    req.getRequestDispatcher(JspPath.createPath("home")).forward(req, resp);
                }
            }
        } else
        req.getRequestDispatcher(JspPath.createPath("login")).forward(req, resp);
    }
}
