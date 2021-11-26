<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% int [][] outputArray = (int [][] )request.getAttribute("outputArray"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>老後資金シミュレーション</title>
    <style>
        #ex_chart {max-width:960px;max-height:720px;}
    </style>     
</head>
<body>
<h1>老後資金シミュレーション結果</h1>
        
        <c:forEach var="i" items="${outputArray[0]}">
        <c:out value="${i}" />
        </c:forEach>
        <br>
        <c:forEach var="j" items="${outputArray[1]}">
        <c:out value="${j}" />
        </c:forEach>
        <br>
        <c:forEach var="k" items="${outputArray[2]}">
        <c:out value="${k}" />
        </c:forEach>
        <br>
        <c:forEach var="l" items="${outputArray[3]}">
        <c:out value="${l}" />
        </c:forEach>
        <br>
        <c:forEach var="m" items="${outputArray[4]}">
        <c:out value="${m}" />
        </c:forEach>
        <br>
 
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
        <canvas id="ex_chart"></canvas>
        <script>

        <%-- var age = ${outputArray[0]};
        var income = ${outputArray[1]};
        var cost = ${outputArray[2]};
        var balance = ${outputArray[3]};
        var saving = ${outputArray[4]}; --%>
        
        var age = [58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70];
        var income = [600, 600, 600, 600, 600, 600, 600, 1100, 300, 300, 300, 300, 300];

        var ctx = document.getElementById('ex_chart');
        
        var data = {
            labels: age,
            datasets: [{
                label: '収入合計',
                data: income,
                borderColor: 'rgba(255, 100, 100, 1)',
                lineTension: 0,
                fill: false,
                borderWidth: 3
            }]
        };
        
        var options = {
            scales: {
                xAxes: [{
                    scaleLabel: {
                        display: true,
                        labelString: '年齢'
                    }
                }],
                yAxes: [{
                    ticks: {
                        min: 0
                        //beginAtZero: true
                    },
                    scaleLabel: {
                        display: true,
                        labelString: '万円'
                    }
                }]
            },
            title: {
                display: true,
                text: '老後資金シミュレーション'
            }
        };
        
        var ex_chart = new Chart(ctx, {
            type: 'line',
            data: data,
            options: options
        }); 
        </script>
        
        <form action="/oldAgeFundSimulation/InputServlet" method="get">
        <input type="submit" value="入力画面に戻る">　
        </form>
        <br>
        <form action="/oldAgeFundSimulation/CalResServlet" method="get">
        <p><input type="submit" value="シミュレーション結果を保存">　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　
        <a href="/oldAgeFundSimulation/Top">＜＜ TOPに戻る</a></p>
        </form>
        
</body>
</html>
