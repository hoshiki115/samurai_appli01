package model;

import java.io.Serializable;

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
    public InputIncome(String currentAge, String currentIncome, String retireAge, String severanceIncome,
            String pensionAge, String pensionIncome, String currentSaving, String regIncome,
            String regIncomeAge, String otherIncome, String otherIncomeAge, String endAge) {
        this.currentAge = currentAge;
        this.currentIncome = currentIncome;
        this.retireAge = retireAge;
        this.severanceIncome = severanceIncome;
        this.pensionAge = pensionAge;
        this.pensionIncome = pensionIncome;
        this.currentSaving = currentSaving;
        this.regIncome = regIncome;
        this.regIncomeAge = regIncomeAge;
        this.otherIncome = otherIncome;
        this.otherIncomeAge = otherIncomeAge;
        this.endAge = endAge;
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