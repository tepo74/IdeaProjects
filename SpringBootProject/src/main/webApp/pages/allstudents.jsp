<%@page import="java.util.Collection"%>
<%@page import="com.IgorT.Service.StudentService"%>
<%@page import="com.IgorT.Entity.Student"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home page JSP</title>
</head>
    <body bgcolor="gray">
    <h1> - Studenti - </h1>


 <table fgcolor ="black">
        <c:forEach items="${cs}" var ="s">
                <tr>
                       <td>${s.id}</td>
                       <td>${s.name}</td>
                       <td>${s.course}</td>
                </tr>
        </c:forEach>
 </table>
    </body>
</html>