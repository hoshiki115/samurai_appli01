package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ResultsDAO;

@WebServlet("/DeleteResServlet")
public class DeleteResServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        List<String> checkNames = new ArrayList<String>();
        String [] simNames = request.getParameterValues("name");
        for(int i = 0; i < simNames.length; i++) {
            checkNames.add(simNames[i]);
        }
        ResultsDAO dao = new ResultsDAO();
        boolean check = dao.delete(checkNames);
        int msg = 0;
        int saveNum = dao.count();
        if(saveNum == 0) {
            msg = 1; // 保存された結果がない場合
        } else {
            msg = 5; // 結果を表示したいシミュレーション名称をクリック（入力画面に戻るあり）
        }
        request.setAttribute("msg", msg);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/resManage.jsp");
        dispatcher.forward(request, response);
    }
}
