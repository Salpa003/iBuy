package servlet;

import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;
import util.PathToJsp;

import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private UserService service = UserService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(PathToJsp.create("registration")).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String mail = req.getParameter("mail");
        String password = req.getParameter("password");
        int id = service.save(new User(name,password,mail)).get();

        req.setAttribute("name",name);
        req.setAttribute("password",password);
        req.setAttribute("mail",mail);
        req.setAttribute("id",id);
        req.getRequestDispatcher(PathToJsp.create("AkkCreate")).forward(req,resp);
    }
}
