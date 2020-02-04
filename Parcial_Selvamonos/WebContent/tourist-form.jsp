<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>Tourist Management Application</title>
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
  <c:if test="${user != null}">
   <form action="update" method="post">
        </c:if>
        <c:if test="${tourist == null}">
   <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
             <h2>
              <c:if test="${tourist != null}">
               Edit tourist
              </c:if>
              <c:if test="${tourist == null}">
               Add New tourist
              </c:if>
             </h2>
            </caption>
          <c:if test="${tourist != null}">
           <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
          </c:if>            
            <tr>
                <th>Tourist Name: </th>
                <td>
                 <input type="text" name="name" size="45"
                   value="<c:out value='${tourist.name}' />"
                  />
                </td>
            </tr>
            <tr>
                <th>Tourist Last Name: </th>
                <td>
                 <input type="text" name="apellido" size="45"
                   value="<c:out value='${tourist.apellido}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>Document: </th>
                <td>
                 <input type="text" name="documento" size="15"
                   value="<c:out value='${tourist.documento}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>Birth: </th>
                <td>
                 <input type="date" name="nacimiento" size="15"
                   value="<c:out value='${tourist.nacimiento}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>Origin: </th>
                <td>
                 <input type="text" name="origen" size="20"
                   value="<c:out value='${tourist.origen}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>Destination: </th>
                <td>
                 <input type="text" name="destino" size="20"
                   value="<c:out value='${tourist.destino}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>Hotel: </th>
                <td>
                 <input type="text" name="hotel" size="20"
                   value="<c:out value='${tourist.hotel}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>Cost: </th>
                <td>
                 <input type="int" name="costo" size="15"
                   value="<c:out value='${tourist.costo}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>Email: </th>
                <td>
                 <input type="text" name="email" size="30"
                   value="<c:out value='${tourist.email}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>Start: </th>
                <td>
                 <input type="date" name="iniciotour" size="15"
                   value="<c:out value='${tourist.iniciotour}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>End: </th>
                <td>
                 <input type="date" name="fintour" size="15"
                   value="<c:out value='${tourist.fintour}' />"
                 />
                </td>
            </tr>
            <tr>
             <td colspan="2" align="center">
              <input type="submit" value="Save" />
             </td>
            </tr>
        </table>
        </form>
    </div> 
</body>
</html>