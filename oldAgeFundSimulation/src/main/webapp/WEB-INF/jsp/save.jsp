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
            <p>シミュレーション</P>
            <p>　名称（10文字以内）【必須】：<input type="text" name="simName"></p>
            <p>　　　コメント（50文字以内）：<textarea style="vertical-align:top"rows="2" cols="22" name="simCom"></textarea></p>
            <p>　　　　　　　　　　　<input type="submit" value="保存">　　　　　
            <a href="/oldAgeFundSimulation/InputResServlet">＜＜ キャンセル</a></p>
        </form>
        <c:if test="${errorMsg != null}">
            <p style="color: red"><c:out value="${errorMsg}" /></p>
        </c:if>
     </body>
</html>