package model;

public class StringToInt {
    public static int [] stringToInt(InputIncome inputIncome, InputCost inputCost) {
        // 入力値を配列に格納
        String [] paramValue = InputArray.inputArrayParamValue(inputIncome, inputCost);
        int [] intParamValue = new int [21];
        
        // 入力値を文字型から整数型配列に変換
        for(int i=0; i<21; i++) {
            if(paramValue[i] == "") {
                intParamValue[i] = 0;
            } else {
                intParamValue[i] = Integer.parseInt(paramValue[i]);
            }
        }
        return intParamValue;
    }
}