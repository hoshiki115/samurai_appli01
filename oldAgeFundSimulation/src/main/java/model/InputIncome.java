package model;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class InputIncome implements Serializable {
    
    private String currentAge; // 現在の年齢
    private String currentIncome; // 手取り年収
    private String retireAge; // 定年年齢（現在の仕事の終了予定年齢）
    private String severanceIncome; // 退職金
    private String pensionAge; // 年金受給年齢
    private String pensionIncome; // 年金受給額（年）
    private String currentSaving; // 現在の預貯金
    private String regIncome; // 定期的な手取り年収（再就職、フリーランス等）
    private String regIncomeAge; // 定期的な手取り年収ある年齢
    private String otherIncome; // その他収入（株式売却等）
    private String otherIncomeAge; // その他収入を受け取る年齢
    private String endAge; // シミュレーション終了年齢
    
    public InputIncome() {}
    public InputIncome(HttpServletRequest request) {
        this.currentAge = request.getParameter("currentAge");
        this.currentIncome = request.getParameter("currentIncome");
        this.retireAge = request.getParameter("retireAge");
        this.severanceIncome = request.getParameter("severanceIncome");
        this.pensionAge = request.getParameter("pensionAge");
        this.pensionIncome = request.getParameter("pensionIncome");
        this.currentSaving = request.getParameter("currentSaving");
        this.regIncome = request.getParameter("regIncome");
        this.regIncomeAge = request.getParameter("regIncomeAge");
        this.otherIncome = request.getParameter("otherIncome");
        this.otherIncomeAge = request.getParameter("otherIncomeAge");
        this.endAge = request.getParameter("endAge");
    }
    
    public String getCurrentAge() { return currentAge; }
    public String getCurrentIncome() { return currentIncome; }
    public String getRetireAge() { return retireAge; }
    public String getSeveranceIncome() { return severanceIncome; }
    public String getPensionAge() { return pensionAge; }
    public String getPensionIncome() { return pensionIncome; }
    public String getCurrentSaving() { return currentSaving; }
    public String getRegIncome() { return regIncome; }
    public String getRegIncomeAge() { return regIncomeAge; }
    public String getOtherIncome() { return otherIncome; }
    public String getOtherIncomeAge() { return otherIncomeAge; }
    public String getEndAge() { return endAge; }
}