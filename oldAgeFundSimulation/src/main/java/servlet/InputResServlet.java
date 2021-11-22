package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.InputCheck;
import model.InputCost;
import model.InputIncome;

@WebServlet("/InputResServlet")
public class InputResServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // 入力値を取得
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String currentAge = request.getParameter("currentAge");
        String currentIncome = request.getParameter("currentIncome");
        String retireAge = request.getParameter("retireAge");
        String severanceIncome = request.getParameter("severanceIncome");
        String pensionAge = request.getParameter("pensionAge");
        String pensionIncome = request.getParameter("pensionIncome");
        String currentSaving = request.getParameter("currentSaving");
        String regIncome = request.getParameter("regIncome");
        String regIncomeAge = request.getParameter("regIncomeAge");
        String otherIncome = request.getParameter("otherIncome");
        String otherIncomeAge = request.getParameter("otherIncomeAge");
        String endAge = request.getParameter("endAge");
        
        String monthlyCost = request.getParameter("monthlyCost");
        String everyYearCost = request.getParameter("everyYearCost");
        String timeLimitCost1 = request.getParameter("timeLimitCost1");
        String timeLimitAge1 = request.getParameter("timeLimitAge1");
        String timeLimitCost2 = request.getParameter("timeLimitCost2");
        String timeLimitAge2 = request.getParameter("timeLimitAge2");
        String expectedCost = request.getParameter("expectedCost");
        String expectedAge = request.getParameter("expectedAge");
        String planCostF = request.getParameter("planCostF");
        
        InputIncome inputIncome = new InputIncome(currentAge, currentIncome, retireAge, severanceIncome, pensionAge,
                pensionIncome, currentSaving, regIncome, regIncomeAge, otherIncome, otherIncomeAge, endAge);
        InputCost inputCost = new InputCost(monthlyCost, everyYearCost, timeLimitCost1, timeLimitAge1,
                timeLimitCost2, timeLimitAge2, expectedCost, expectedAge, planCostF);
        
        // 入力値をチェック
        List<String> errorList = InputCheck.inputCheck(inputIncome,inputCost);
        
        // 入力値をセッションスコープに保存  
        HttpSession session = request.getSession();
        session.setAttribute("inputIncome", inputIncome);
        session.setAttribute("inputCost", inputCost);
        
        // エラーメッセージをリクエストスコープに保存
        request.setAttribute("errorList", errorList);
        
        // 入力画面にフォワード
        if(errorList != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/input.jsp");
            dispatcher.forward(request, response);
        }
    }
}