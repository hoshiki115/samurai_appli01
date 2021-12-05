package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ResultsDAO;
import model.GetSaveResLogic;
import model.InputCost;
import model.InputIncome;
import model.PostSaveResLogic;
import model.SaveResult;

@WebServlet("/ResManageServlet")
public class ResManageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TEST
        ResultsDAO dao = new ResultsDAO();
        int saveNum = dao.count();
        System.out.println(saveNum);
        
        // 保存されたシミュレーション結果を取得して、リクエストスコープに保存
        GetSaveResLogic getSaveResLogic = new GetSaveResLogic();
        List<SaveResult> saveList = getSaveResLogic.execute();
        request.setAttribute("saveList", saveList);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/resManage.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        // シミュレーション名称の入力をチェック
        String simName = request.getParameter("simName");
        if(simName == "" || simName == null) {
            request.setAttribute("errorMsg", "シミュレーション名称が入力されていません");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/save.jsp");
            dispatcher.forward(request, response);
        }
        // 保存日を取得
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy'年'MM'月'dd'日'");
        String saveDate = sdf.format(date);
        
        String simCom = request.getParameter("simCom");
        
        SaveResult saveResult = new SaveResult(simName, saveDate, simCom);
        
        HttpSession session = request.getSession();
        InputIncome inputIncome = (InputIncome) session.getAttribute("inputIncome");
        InputCost inputCost = (InputCost) session.getAttribute("inputCost");
        
        // シミュレーション結果を登録
        PostSaveResLogic postSaveResLogic = new PostSaveResLogic();
        postSaveResLogic.execute(saveResult, inputIncome, inputCost);
        
        // 保存されたシミュレーション結果を取得して、リクエストスコープに保存
        GetSaveResLogic getSaveResLogic = new GetSaveResLogic();
        List<SaveResult> saveList = getSaveResLogic.execute();
        request.setAttribute("saveList", saveList);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/resManage.jsp");
        dispatcher.forward(request, response);
    }
}
