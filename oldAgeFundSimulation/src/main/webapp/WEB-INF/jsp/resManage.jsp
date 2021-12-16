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
        <c:if test="${msg != 1}">
        <form name="delConfirm" action="/oldAgeFundSimulation/EditComServlet" method="get">
            <p>※保存できる件数は10件まで</p>
            <table border="1" style="border-collapse: collapse">
                <tr>
                    <td bgcolor=”#00ffff”>　削除　</td>
                    <td bgcolor=”#00ff00”>　No.　</td>
                    <td bgcolor=”#00ff00”>　シミュレーション名称　</td>
                    <td bgcolor=”#00ff00” align="center">保存日</td>
                    <td bgcolor=”#00ff00” align="center" style="border-right: none;">　　　　コメント　　　　</td>
                    <td bgcolor=”#00ff00” style="border-left: none;"></td>
                </tr>
                <c:forEach var="i" items="${saveList}" varStatus="j">
                    <tr>
                        <th bgcolor=”#fffafa”><input type="checkbox" name="name" value="${i.getSimName()}"></th>
                        <c:choose>
                            <c:when test="${msg == 4 && j.count == 1}">
                                <td>　<font color="blue"><c:out value="${j.count}" /></font></td>
                            </c:when>
                            <c:otherwise>
                                <td>　<c:out value="${j.count}" /></td>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${msg == 3}">
                                <td>　<c:out value="${i.getSimName()}" />　</td>
                            </c:when>
                            <c:when test="${msg == 4 && j.count == 1}">
                                <td>　<a href="/oldAgeFundSimulation/DispResServlet?simName=${i.getSimName()}&num=${j.count}">
                                    <font color="blue">${i.getSimName()}</font></a></td>
                            </c:when>
                            <c:otherwise>
                                <td>　<a href="/oldAgeFundSimulation/DispResServlet?simName=${i.getSimName()}&num=${j.count}">
                                    <font color="magenta">${i.getSimName()}</font></a></td>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${msg == 4 && j.count == 1}">
                                <td>　<font color="blue"><c:out value="${i.getSaveDate()}" /></font>　</td>
                                <td style="border-right: none;">　<font color="blue"><c:out value="${i.getSimCom()}" /></font></td>
                            </c:when>
                            <c:otherwise>
                                <td>　<c:out value="${i.getSaveDate()}" />　</td>
                                <td style="border-right: none;">　<c:out value="${i.getSimCom()}" /></td>
                            </c:otherwise>
                        </c:choose>
                        <td style="border-left: none;"><input type="image" src="https://img.icons8.com/windows/32/000000/edit--v1.png" alt="編集" 
                            name="${i.getSimName()}"></td>
                    </tr>
                </c:forEach>
            </table>
            <br>
            <c:if test="${msg == 2 || msg == 3 || msg ==4 || msg == 5}">
                <p>　<input name="btn" type="submit" value="削除">　　<c:out value="${'削除したいものの□にチェックマークを付けて「削除」をクリックしてください'}" /></p>
            </c:if>
        </form>
        </c:if>
        <c:if test="${msg == 4 || msg == 5}">
            <form action="/oldAgeFundSimulation/InputServlet" method="get">
                <p>　　　　　　　　　　　　　　　　<input type="submit" value="入力画面に戻る">　　　　　　　　　　　
            </form>
        </c:if>
        <p>　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　<a href="/oldAgeFundSimulation/Top">＜＜ TOPに戻る</a></p>
        <script>
            document.delConfirm.btn.addEventListener('click', function() {
                result = window.confirm('削除してもよいですか？');
                if(result) {
                    document.delConfirm.action = "/oldAgeFundSimulation/DeleteResServlet";
                } else {
                    document.delConfirm.action = "/oldAgeFundSimulation/ResManageServlet";
                }
            })
        </script>
    </body>
</html>