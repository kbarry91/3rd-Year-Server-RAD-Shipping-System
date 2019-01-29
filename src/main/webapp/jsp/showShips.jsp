<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
    <title>Shipping System All Ships</title>
</head>

<body>
    <div align="center">
        <h1>All Ships</h1>

        <table id="customtable">
            <tr>
                <th>Name</th>
                <th>Passengers</th>
                <th>Cost</th>
                <th>Length(Metres)</th>
                <th>Shipping Company</th>
            </tr>
            <c:forEach items="${ships}" var="ships">
                <tr>
                    <td>${ships.name}</td>
                    <td>${ships.passengers}</td>
                    <td>${ships.cost}</td>
                    <td>${ships.metres}</td>
                    <td>${ships.shippingCompany.name}</td>
                </tr>
            </c:forEach>
        </table>

        <a href="/">Home</a>
    </div>
</body>

</html>