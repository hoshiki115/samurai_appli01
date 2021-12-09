<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.SaveResult, java.util.List" %>
<% List<SaveResult> saveList = (List<SaveResult>) request.getAttribute("saveList"); 
int msg = (int)session.getAttribute("msg"); 
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>老後資金シミュレーション</title>
    </head>
    <body>
        <h1>シミュレーション結果管理</h1>
        <c:if test="${msg == 1}">
            <p style="color: red">　　<c:out value="保存された結果はありません" /></p>
        </c:if>
        <c:if test="${msg == 2 || msg == 5}">
            <p>　　<c:out value="結果を表示したいシミュレーション名称をクリックしてください" /></p>
        </c:if>
        <c:if test="${msg == 3}">
            <p style="color: red">　　<c:out value="保存件数が10件を超えます" /></p>
            <p style="color: red">　　<c:out value="不要なものを削除してから「入力画面に戻る」をクリックし、シミュレーション結果を保存し直してください" /></p>
        </c:if>
        <c:if test="${msg == 4}">
            <p style="color: blue">　　<c:out value="シミュレーション結果が正常に保存されました" /></p>
            <p>　　<c:out value="結果を表示したいシミュレーション名称をクリックしてください" /></p>
        </c:if>
        <form action="/oldAgeFundSimulation/DeleteResServlet" method="post">
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
                        <th><input type="checkbox" name="name" value="${i.getSimName()}"></th>
                        <td>　<c:out value="${j.index + 1}" /></td>
                        <c:choose>
                            <c:when test="${msg == 3}">
                                <td>　<c:out value="${i.getSimName()}" />　</td>
                            </c:when>
                            <c:otherwise>
                                <td>　<a href="/oldAgeFundSimulation/DispResServlet" id="${i.getSimName()}">${i.getSimName()}</a></td>
                            </c:otherwise>
                        </c:choose>
                        <td>　<c:out value="${i.getSaveDate()}" />　</td>
                        <td>　<c:out value="${i.getSimCom()}" />　</td>
                    </tr>
                </c:forEach>
            </table>
            <br>
            <c:if test="${msg == 2 || msg == 3 || msg ==4 || msg == 5}">
                <p>　<input type="submit" value="削除">　　<c:out value="${'削除したいものの□にチェックマークを付けて「削除」をクリックしてください'}" /></p>
            </c:if>
        </form>
        <c:if test="${msg == 4 || msg == 5}">
            <form action="/oldAgeFundSimulation/InputServlet" method="get">
                <p>　　　　　　　　　　　　　　　　<input type="submit" value="入力画面に戻る">　　　　　　　　　　　
            </form>
        </c:if>
        <p>　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　<a href="/oldAgeFundSimulation/Top">＜＜ TOPに戻る</a></p>
    </body>
</html>