<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home page JSP</title>


    <style>
    table, th, td {
      border: 1px solid black;
      border-collapse: collapse;
    }
    </style>

</head>
<body>

<h1>Pozdrav iz zemlje ${ordNo} - ${name}!</h1>

<form action ="home" method="post">
 Enter order number :           <input type ="text" name = "sf_order">
 Enter name of Safari Country : <input type ="text" name = "sf_name">  <br>
 <input type="submit">
</form>


<table >
  <c:forEach items="${safari_cntr}" var="cntr">
    <tr>
      <td><c:out value="${cntr.name}" /></td>
      <td><c:out value="${cntr.ordNo}" /></td>
    </tr>
  </c:forEach>
</table>


</body>
</html>