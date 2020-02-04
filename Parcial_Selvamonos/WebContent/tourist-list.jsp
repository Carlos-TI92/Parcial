<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>User Management Application</title>
</head>
<body>
 <center>
  <h1>Tourist Management</h1>
        <h2>
         <a href="new">Add New Tourist</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">List All Tourist</a>
         
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Tourist</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Last Name</th>
                <th>Document</th>
                <th>Birth</th>
                <th>Origin</th>
                <th>Destination</th>
                <th>Hotel</th>
                <th>Cost</th>
                <th>Email</th>
                <th>Start</th>
                <th>End</th>
            </tr>
            <c:forEach var="tourist" items="${listTourist}">
                <tr>
                    <td><c:out value="${tourist.id}" /></td>
                    <td><c:out value="${tourist.name}" /></td>
                    <td><c:out value="${tourist.apellido}" /></td>
                    <td><c:out value="${tourist.documento}" /></td>
                    <td><c:out value="${tourist.nacimiento}" /></td>
                    <td><c:out value="${tourist.origen}" /></td>
                    <td><c:out value="${tourist.destino}" /></td>
                    <td><c:out value="${tourist.hotel}" /></td>
                    <td><c:out value="${tourist.costo}" /></td>
                    <td><c:out value="${tourist.email}" /></td>
                    <td><c:out value="${tourist.iniciotour}" /></td>
                    <td><c:out value="${tourist.fintour}" /></td>
                    <td>
                     <a href="edit?id=<c:out value='${tourist.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete?id=<c:out value='${tourist.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>