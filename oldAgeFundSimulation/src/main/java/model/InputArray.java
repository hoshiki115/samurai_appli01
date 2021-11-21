package model;

public class InputArray {
    public static String [] inputArrayParamName() {
        String [] paramName = new String [21];
        paramName[0] = "現在の年齢";
        paramName[1] = "手取り年収";
        paramName[2] = "定年年齢";
        paramName[3] = "退職金";
        paramName[4] = "年金受給年齢";
        paramName[5] = "年金受給額";
        paramName[6] = "現在の預貯金";
        paramName[10] = "定期的な手取り年収がある年齢";
        paramName[15] = "定期的な手取り年収";
        paramName[11] = "その他収入を受け取る年齢";
        paramName[16] = "その他収入";
        paramName[7] = "シミュレーション終了年齢";
        paramName[8] = "毎月必ず発生する費用";
        paramName[9] = "毎年必ず発生する費用";
        paramName[12] = "期限付きで毎年発生する費用１の年齢";
        paramName[17] = "期限付きで毎年発生する費用１";
        paramName[13] = "期限付きで毎年発生する費用２の年齢";
        paramName[18] = "期限付きで毎年発生する費用２";
        paramName[14] = "期限付きで予定する費用の年齢";
        paramName[19] = "期限付きで予定する費用";
        paramName[20] = "毎年予定する費用";
        return paramName;
    }
    public static String [] inputArrayParamValue(InputIncome inputIncome, InputCost inputCost) {
        String [] paramValue = new String [21];
        paramValue[0] = inputIncome.getCurrentAge();
        paramValue[1] = inputIncome.getCurrentIncome();
        paramValue[2] = inputIncome.getRetireAge();
        paramValue[3] = inputIncome.getSeveranceIncome();
        paramValue[4] = inputIncome.getPensionAge();
        paramValue[5] = inputIncome.getPensionIncome();
        paramValue[6] = inputIncome.getCurrentSaving();
        paramValue[10] = inputIncome.getRegIncomeAge();
        paramValue[15] = inputIncome.getRegIncome();
        paramValue[11] = inputIncome.getOtherIncomeAge();
        paramValue[16] = inputIncome.getOtherIncome();
        paramValue[7] = inputIncome.getEndAge();
        paramValue[8] = inputCost.getMonthlyCost();
        paramValue[9] = inputCost.getEveryYearCost();
        paramValue[12] = inputCost.getTimeLimitAge1();
        paramValue[17] = inputCost.getTimeLimitCost1();
        paramValue[13] = inputCost.getTimeLimitAge2();
        paramValue[18] = inputCost.getTimeLimitCost2();
        paramValue[14] = inputCost.getExpectedAge();
        paramValue[19] = inputCost.getExpectedCost();
        paramValue[20] = inputCost.getPlanCostF();
        return paramValue;
    }
}