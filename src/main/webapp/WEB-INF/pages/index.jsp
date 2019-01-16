<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h2>Idea's list</h2>
<a href="/new"><input type="button" value="Create new idea"/></a>
<br>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Caption</th>
        <th>Text</th>
        <th>Likes/Dislikes</th>
    </tr>
    <c:forEach items="${list}" var="item">
        <tr>
            <td><c:out value="${item.id}"/></td>
            <td><c:out value="${item.caption}"/></td>
            <td><c:out value="${item.content}"/></td>
            <td><c:out value="${item.likes}"/>/<c:out value="${item.dislikes}"/></td>
            <td>
                <span><a href="/update?id=${item.id}">edit</a></span>
                <span><a href="/delete?id=${item.id}">delete</a></span>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
