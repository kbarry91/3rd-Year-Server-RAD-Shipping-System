<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
    <style>
        #customtable {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #customtable td,
        #customtable th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #customtable tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        #customtable tr:hover {
            background-color: #ddd;
        }

        #customtable th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #4CAF50;
            color: white;
        }
    </style>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Shipping System All Orders</title>
</head>

<body>
    <div align="center">
        <h1>All Orders</h1>

        <table id="customtable">
            <tr>
                <th>Order Number</th>
                <th>Shipping Company Name</th>
                <th>Ship Name</th>
                <th>Order Date</th>
            </tr>
            <c:forEach items="${orders}" var="orders">
                <tr>
                    <td>${orders.oid}</td>
                    <td>${orders.shippingCompany.name}</td>
                    <td>${orders.ship.name}</td>
                    <td>${orders.date}</td>
                </tr>
            </c:forEach>
        </table>

        <a href="/">Home</a>
    </div>
</body>

</html>