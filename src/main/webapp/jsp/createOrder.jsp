<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
    <style>
        #parent {
            display: table;
            width: 100%;
        }

        #additem {
            display: table-cell;
            text-align: center;
            vertical-align: middle;
        }

        #additem {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #additem td,
        #additem th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #additem tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        #additem tr:hover {
            background-color: #ddd;
        }

        #additem th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #4CAF50;
            color: white;
        }

        h1 {
            background-color: #4CAF50;
            color: white;
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Shipping System Create Order</title>
</head>

<body>
    <div id="parent" align="center">
        <form:form modelAttribute="orderAdd" id="additem">
            <h1>Order Ship</h1>
            <table id="addTable" align="center">
                <tr>
                    <td>Ship Name:</td>
                    <td>
                        <form:select path="ship" items="${shipList}" />
                    </td>
                </tr>
                <tr>
                    <td>Shipping Company:</td>
                    <td>
                        <form:select path="ShippingCompany" items="${companyList}" />
                    </td>
                </tr>
                <tr>
                    <td align="center" colspan="2"><input type="submit" value="Order Ship" /></td>
                </tr>
            </table>
            <a href="/">Home</a>
        </form:form>
    </div>
</body>

</html>