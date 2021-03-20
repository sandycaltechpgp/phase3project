<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Setup Products</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/components/admin-header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/components/admin-topbar.jsp"></jsp:include>

<form action="adminsearchprod" method="post">
    Product name:
    <input type="text" name="searchpname" />
    Category Name:
    <input type="text" name="searchcname"  />
    <input type="submit" value="ok" />
</form>

Total Products: ${list.size()} &nbsp;&nbsp;
<table border=1 cellspacing=2 cellpadding=4>
    <tr>
        <td><b>Product</b></td>
        <td><b>Price</b></td>
        <td><b>Added On</b></td>
        <td><b>Category</b></td>
        <td></td>
    </tr>
    <c:forEach items="${list}" var="item">
        <tr>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td>${item.dateAdded}</td>
            <td>${item.category}</td>
            <td>
                <a href="admineditproduct?id=${item.ID}">Edit</a> | <a
                    href="admindeleteproduct?id=${item.ID}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="/WEB-INF/view/components/admin-footer.jsp"></jsp:include>
</body>
</html>