package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ResultsDAO;


@WebServlet("/EditComServlet")
public class EditComServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selectName = request.getParameter("name");
        ResultsDAO dao = new ResultsDAO();
        String comment = dao.findByNameCom(selectName);
        System.out.println(selectName);
        System.out.println(comment);
    }
}