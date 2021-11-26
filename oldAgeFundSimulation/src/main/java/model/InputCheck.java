package model;

import java.util.ArrayList;
import java.util.List;

public class InputCheck {

    public static List<String> inputCheck(InputIncome inputIncome, InputCost inputCost) {
        // 入力値を配列に格納
        String [] paramName = InputArray.inputArrayParamName();
        String [] paramValue = InputArray.inputArrayParamValue(inputIncome, inputCost);
        int [] intParamValue = new int [21];
        List<String> errorList = new ArrayList<String>();
        
        // 入力値が空欄の場合のエラー
        for(int i=0; i<10; i++) {
            if(paramValue[i] == "") {
                errorList.add(paramName[i] + "が入力されていません");
                intParamValue[i] = 0;
            } else {
                intParamValue[i] = Integer.parseInt(paramValue[i]);
            }
        }
        // 必要とする入力値が空欄の場合のエラー
        for(int i=10; i<15; i++) {
            if(paramValue[i+5] != "") {
                if(Integer.parseInt(paramValue[i+5]) > 0 && paramValue[i] == "") {
                    errorList.add(paramName[i] + "が入力されていません");
                    intParamValue[i] = 0;
                } else {
                    intParamValue[i] = Integer.parseInt(paramValue[i]);
                }
            } else {
                intParamValue[i] = 0;
            }
        }
        // 残りの入力値を整数に変換
        for(int i=15; i<21; i++) {
            if(paramValue[i] != "") {
                intParamValue[i] = Integer.parseInt(paramValue[i]);
            } else {
                intParamValue[i] = 0;
            }
        }
        
        // 入力値がマイナスの場合のエラー
        for(int i=0; i<21; i++) {
            if(intParamValue[i] < 0) {
                errorList.add(paramName[i] + "は0あるいは正の値を入力してください");
            }
        }
        
        // 入力値がその他の場合のエラー
        if(intParamValue[0] < 40 || intParamValue[0] >= 100) { //現在の年齢の制約
                errorList.add(paramName[0] + "は40以上かつ100より小さい値を入力してください");
        }
        if(intParamValue[7] > 100 || intParamValue[7] <= intParamValue[0]) { //シミュレーション終了年齢の制約
            errorList.add(paramName[7] + "は100以下かつ" + paramName[0] + "より大きい値を入力してください");
        }
        if(intParamValue[2] < intParamValue[0] || intParamValue[2] > intParamValue[7]) { //定年年齢の制約
            errorList.add(paramName[2] + "は現在の年齢以上かつシミュレーション終了年齢以下の値を入力してください");
        }
        if(intParamValue[4] < intParamValue[0] || intParamValue[4] > intParamValue[7]) { //年金受給年齢の制約
            errorList.add(paramName[4] + "は現在の年齢以上かつシミュレーション終了年齢以下の値を入力してください");
        }
        if(intParamValue[15] > 0 && (intParamValue[10] <= intParamValue[2] || intParamValue[10] > intParamValue[7])) { //定期的な手取り年収がある年齢の制約
            errorList.add(paramName[10] + "は定年年齢より大きくかつシミュレーション終了年齢以下の値を入力してください");
        }
        for(int i=11; i<15; i++) {
            if(intParamValue[i+5] > 0 && (intParamValue[i] < intParamValue[0] || intParamValue[i] > intParamValue[7])) { // その他の制約
            errorList.add(paramName[i] + "は現在の年齢以上かつシミュレーション終了年齢以下の値を入力してください");
            }
        }
        
        return errorList;
    }
}