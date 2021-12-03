<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<% ArrayList<Integer> ageList = (ArrayList<Integer>)request.getAttribute("ageList");
ArrayList<Integer> incomeList = (ArrayList<Integer>)request.getAttribute("incomeList");
ArrayList<Integer> costList = (ArrayList<Integer>)request.getAttribute("costList");
ArrayList<Integer> balanceList = (ArrayList<Integer>)request.getAttribute("balanceList");
ArrayList<Integer> savingList = (ArrayList<Integer>)request.getAttribute("savingList");
%>
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

        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
        <canvas id="ex_chart"></canvas>
        
        <script>
        var age = ${ageList};
        var income = ${incomeList};
        var cost = ${costList};
        var balance = ${balanceList};
        var saving = ${savingList};

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
            },
            {   label: '支出合計',
                data: cost,
                borderColor: 'rgba(100, 100, 255, 1)',
                lineTension: 0,
                fill: false,
                borderWidth: 3
            },
            {   label: '収支合計',
                data: balance,
                borderColor: 'rgba(100, 255, 100, 1)',
                lineTension: 0,
                fill: false,
                borderWidth: 3
            },
            {   label: '預貯金残高',
                data: saving,
                borderColor: 'rgba(255, 100, 255, 1)',
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
        <p>　　　　　　　　　　　　　　　　　　　　<input type="submit" value="シミュレーション結果を保存">　　　　　　　　　　　　　　　　　　　　　
        <a href="/oldAgeFundSimulation/Top">＜＜ TOPに戻る</a></p>
        </form>
        
</body>
</html>
