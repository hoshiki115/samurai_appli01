<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<% List<String> checkNames = (List<String>) session.getAttribute("checkNames"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>老後資金シミュレーション</title>
    </head>
    <body>
        <h1>シミュレーション結果削除の確認</h1>
        <form action="/oldAgeFundSimulation/DeleteResServlet" method="get">
            <p>以下の選択されたシミュレーション結果を削除しますか？</p>
            <c:forEach var="i" items="${checkNames}">
                <p>　　<c:out value="${i}" /></p>
            </c:forEach>
            <p>　　<input type="submit" value="OK"></p>
        </form>
    </body>
</html>