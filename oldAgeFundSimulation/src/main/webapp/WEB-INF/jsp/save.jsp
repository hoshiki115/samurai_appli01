<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String errorMsg = (String) request.getAttribute("errorMsg"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>老後資金シミュレーション</title>
    </head>
    <body>
        <h1>シミュレーション結果の保存</h1>
        <form action="/oldAgeFundSimulation/ResManageServlet" method="post">
            <p>　　　　シミュレーション名称（必須）：<input type="text" name="simName"></p>
            <p>　　　　コメント：<input type="text" name="simCom"></p>
            <p>　　　　　　　　　　　　<input type="submit" value="保存"></p>
        </form>
        <c:if test="${errorMsg != null}">
            <c:out value="${errorMsg}" />
        </c:if>
     </body>
</html>