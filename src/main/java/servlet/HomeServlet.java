package servlet;

import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProductService;
import util.JspPath;

import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    ProductService productService = ProductService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        потом сделаю "наверное"
//        int page = 1;
//        int productsPerPage = 10;
//
//        String pageParam = req.getParameter("page");
//        if (pageParam != null) {
//            page = Integer.parseInt(pageParam);
//        }
//
//        int startIndex = (page - 1) * productsPerPage;
//        int endIndex = Math.min(startIndex + productsPerPage, productService.getAll().size());
//
//        List<Product> pageProducts = productService.getAll().subList(startIndex, endIndex);
//
//        req.setAttribute("products", pageProducts);
//        req.setAttribute("currentPage", page);
//        req.setAttribute("totalPages", (int) Math.ceil(productService.getAll().size() / (double) productsPerPage));
//
//        req.getRequestDispatcher(JspPath.createPath("home")).forward(req, resp);


    }
}
