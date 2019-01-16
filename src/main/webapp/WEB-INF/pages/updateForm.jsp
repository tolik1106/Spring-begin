<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update idea</title>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
</head>
<body>
<div>
    <form:form id="/update" method="post" modelAttribute="newIdea">
        <label for="caption">Caption</label>
        <form:input path="caption"/>

        <label for="content">Content</label>
        <form:input path="content"/>
        <input type="submit" value="Update  "/>
    </form:form>
</div>
<div>
    <a href="/"><input type="button" value="Back"></a>
</div>
</body>
</html>
