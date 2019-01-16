<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add new idea</title>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
</head>
<body>
<div>
<form:form id="/new" method="post" modelAttribute="idea">
    <label for="caption">Caption</label>
    <form:input path="caption"/>

    <label for="content">Content</label>
    <form:input path="content"/>
    <input type="submit" value="Create"/>
</form:form>
</div>
</body>
</html>
