package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ResultsDAO;
import model.InputCost;
import model.InputIncome;

@WebServlet("/DispResServlet")
public class DispResServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selectName = request.getParameter("simName");
        String selectNum = request.getParameter("num");
        ResultsDAO dao = new ResultsDAO();
        String [] inputValue = dao.findByName(selectName);
        
        InputIncome inputIncome = new InputIncome();
        inputIncome.setCurrentAge(inputValue[0]);
        inputIncome.setCurrentIncome(inputValue[1]);
        inputIncome.setRetireAge(inputValue[2]);
        inputIncome.setSeveranceIncome(inputValue[3]);
        inputIncome.setPensionAge(inputValue[4]);
        inputIncome.setPensionIncome(inputValue[5]);
        inputIncome.setCurrentSaving(inputValue[6]);
        inputIncome.setRegIncome(inputValue[7]);
        inputIncome.setRegIncomeAge(inputValue[8]);
        inputIncome.setOtherIncome(inputValue[9]);
        inputIncome.setOtherIncomeAge(inputValue[10]);
        inputIncome.setEndAge(inputValue[11]);
        
        InputCost inputCost = new InputCost();
        inputCost.setMonthlyCost(inputValue[12]);
        inputCost.setEveryYearCost(inputValue[13]);
        inputCost.setTimeLimitCost1(inputValue[14]);
        inputCost.setTimeLimitAge1(inputValue[15]);
        inputCost.setTimeLimitCost2(inputValue[16]);
        inputCost.setTimeLimitAge2(inputValue[17]);
        inputCost.setExpectedCost(inputValue[18]);
        inputCost.setExpectedAge(inputValue[19]);
        inputCost.setPlanCostF(inputValue[20]);
        
        HttpSession session = request.getSession();
        session.setAttribute("inputIncome", inputIncome);
        session.setAttribute("inputCost", inputCost);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/input.jsp");
        dispatcher.forward(request, response);
    }
}
