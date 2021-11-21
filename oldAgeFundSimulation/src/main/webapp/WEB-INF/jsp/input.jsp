<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.InputIncome,model.InputCost,model.InputCheck,model.InputArray" %>
<% InputIncome imputIncome = (InputIncome) session.getAttribute("inputIncome");
InputCost imputCost = (InputCost) session.getAttribute("inputCost");
InputCheck inputCheck = (InputCheck) session.getAttribute("errorCheck");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>老後資金シミュレーション</title>
</head>
<body>
    <h3>あなたの現状について教えてください</h3>
    <form action="/oldAgeFundSimulation/InputResServlet" method="get">
    　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　
    <input type="submit" value="入力値全クリア">
    </form>
    
    <form action="/oldAgeFundSimulation/InputResServlet" method="post">
    <p>収入の部</p>
    <p>　　　現在の年齢：<input type="number" name="currentAge" value="${inputIncome.currentAge}">歳　　
            定年は何歳？：<input type="number" name="retireAge" value="${inputIncome.retireAge}">歳　　
            年金受給は何歳？：<input type="number" name="pensionAge" value="${inputIncome.pensionAge}">歳</p>
    <p>　　　手取り年収：<input type="number" name="currentIncome" value="${inputIncome.currentIncome}">万円/年　　　
            退職金：<input type="number" name="severanceIncome" value="${inputIncome.severanceIncome}">万円　
            年金受給額（年）：<input type="number" name="pensionIncome" value="${inputIncome.pensionIncome}">万円/年</p>
    <p>　　現在の預貯金：<input type="number" name="currentSaving" value="${inputIncome.currentSaving}">万円</p>
    <p>　　定年後の収入：</p>
    <p>　　　　　　定期的な手取り年収（再就職、フリーランス等）：　　　<input type="number" name="regIncomeAge" value="${inputIncome.regIncomeAge}">歳まで　　　　　　　　
        <input type="number" name="regIncome" value="${inputIncome.regIncome}">万円/年</p>
    <p>　　　　　　その他収入（株式売却等）：　　　　　　　　　　　　　<input type="number" name="otherIncomeAge" value="${inputIncome.otherIncomeAge}">歳で　　　　　　　　　
        <input type="number" name="otherIncome" value="${inputIncome.otherIncome}">万円/年</p>
    <p>支出の部</p>
    <p>　　必要な生活費</p>
    <p>　　　　　　毎月必ず発生する費用：　　　　　　　　　　　　　　　<input type="number" name="monthlyCost" value="${inputCost.monthlyCost}">万円/月　×12＝
    　　　　　　　　　　　　　　万円/年</p>
    <p>　　　　　　（例：食費・生活必需品・住居費・水道光熱費・通信費・交通費・月払い保険料・その他）</p>
    <p>　　　　　　毎年必ず発生する費用：　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　
        <input type="number" name="everyYearCost" value="${inputCost.everyYearCost}">万円/年</p>
    <p>　　　　　　（例：税金・年払い保険料・交際費・その他）</p>
    <p>　　　　　　期限付きで毎年発生する費用１：　　　　　　　　　　　<input type="number" name="timeLimitAge1" value="${inputCost.timeLimitAge1}">歳まで　　　　　　　　
        <input type="number" name="timeLimitCost1" value="${inputCost.timeLimitCost1}">万円/年</p>
    <p>　　　　　　（例：教育費・年払い保険料・ローン返済・その他）</p>
    <p>　　　　　　期限付きで毎年発生する費用２：　　　　　　　　　　　<input type="number" name="timeLimitAge2" value="${inputCost.timeLimitAge2}">歳まで　　　　　　　　
        <input type="number" name="timeLimitCost2" value="${inputCost.timeLimitCost2}">万円/年</p>
    <p>　　特別費</p>
    <p>　　　　　　期限付きで予定する費用：　　　　　　　　　　　　　　<input type="number" name="expectedAge" value="${inputCost.expectedAge}">歳までに　　　　　　　
        <input type="number" name="expectedCost" value="${inputCost.expectedCost}">万円</p>
    <p>　　　　　　（例：リフォーム・子供の結婚祝い・イベント・その他）</p>
    <p>　　　　　　毎年予定する費用：　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　
        <input type="number" name="planCostF" value="${inputCost.planCostF}">万円/年</p>
    <p>　　　　　　（例：娯楽・旅行・イベント・その他）</p><br>
    <p>　　シミュレーション終了年齢：<input type="number" name="endAge" value="${inputIncome.endAge}">歳まで　　　　　
    <input type="submit" value="シミュレーション結果の表示">　　　　　　　　　　　　　　　
    <a href="/oldAgeFundSimulation/Top">＜＜ TOPに戻る</a></p>
    
    <p>エラーメッセージ</p>
    <c:if test="${errorList != null}">
        <c:forEach var="errorList" items="${errorList}">
            　　${errorList} <br>
        </c:forEach>
    </c:if>
    </form>
</body>
</html>