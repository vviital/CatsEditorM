package by.grsu.cats.editor.servlets;

import by.grsu.cats.editor.beans.Cat;
import by.grsu.cats.editor.beans.CatsCollectionBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vviital on 5.3.16.
 */
public class ProfileController extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String removeCommand = req.getParameter("remove");
        String saveCommand = req.getParameter("save");
        CatsCollectionBean catsCollection = (CatsCollectionBean)req.getSession().getAttribute("catsCollection");
        Cat cat = (Cat) req.getSession().getAttribute("catBean");

        if ("remove".equals(removeCommand)) {
            catsCollection.tryRemove(cat.getHash());
            req.getSession().removeAttribute("catBean");
            resp.sendRedirect("index.jsp");
        } else if ("save".equals(saveCommand)) {
            if (cat.isValid()) {
                catsCollection.addCat(cat.clone());
                req.getSession().removeAttribute("catBean");
                resp.sendRedirect("index.jsp");
            } else {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("catProfile.jsp");
                req.getSession().removeAttribute("catBean");
                requestDispatcher.forward(req, resp);
            }
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
