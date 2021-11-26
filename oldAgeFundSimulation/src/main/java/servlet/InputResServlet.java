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

import model.Calc;
import model.InputCheck;
import model.InputCost;
import model.InputIncome;

@WebServlet("/InputResServlet")
public class InputResServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // 入力値を取得
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        InputIncome inputIncome = new InputIncome(request);
        InputCost inputCost = new InputCost(request);
        
        // 入力値をチェック
        List<String> errorList = InputCheck.inputCheck(inputIncome, inputCost);
        
        // 入力値をセッションスコープに保存  
        HttpSession session = request.getSession();
        session.setAttribute("inputIncome", inputIncome);
        session.setAttribute("inputCost", inputCost);
        
        // エラーメッセージをリクエストスコープに保存
        request.setAttribute("errorList", errorList);
        
        // エラーがある場合、入力画面にフォワード
        if(errorList.size() != 0) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/input.jsp");
            dispatcher.forward(request, response);
        } else {
            // エラーがない場合、入力値からグラフ表示用の値を計算
            int [][] outputArray = Calc.calc(inputIncome, inputCost);
            
            // 計算した値をリクエストスコープに保存
            request.setAttribute("outputArray", outputArray);
            
            // 結果画面にフォワード
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
            dispatcher.forward(request, response);
        }
    }
}