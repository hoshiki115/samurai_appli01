<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.SaveResult, java.util.List" %>
<% List<SaveResult> saveList = (List<SaveResult>) request.getAttribute("saveList"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>老後資金シミュレーション</title>
    </head>
    <body>
        <h1>シミュレーション結果管理</h1>
        <p>　　　　結果を表示したいシミュレーション名称をクリックしてください</p>
        <p>※保存できる件数は10件まで</p>
        <table border="1" style="border-collapse: collapse">
            <tr>
                <td>　削除　</td>
                <td>　No.　</td>
                <td>　シミュレーション名称　</td>
                <td>　　保存日　　</td>
                <td>　　　　コメント　　　　</td>
            </tr>
            <c:forEach var="i" items="${saveList}" varStatus="j">
                <tr>
                    <th><input type="checkbox" name="name"></th>
                    <td>　<c:out value="${j.index + 1}" /></td>
                    <td>　<c:out value="${i.getSimName()}" />　</td>
                    <td>　<c:out value="${i.getSaveDate()}" />　</td>
                    <td>　<c:out value="${i.getSimCom()}" />　</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <form action="/oldAgeFundSimulation/Delete" method="get">
            <p>　<input type="submit" value="削除">　　<c:out value="${'削除したいものの□にチェックマークを付けて「削除」をクリックしてください'}" /></p>
        </form>
        <form action="/oldAgeFundSimulation/InputServlet" method="get">
            <p>　　　　　　　　　　　　　　　　<input type="submit" value="入力画面に戻る">　　　　　　　　　　　
            <a href="/oldAgeFundSimulation/Top">＜＜ TOPに戻る</a></p>
        </form>
    </body>
</html>