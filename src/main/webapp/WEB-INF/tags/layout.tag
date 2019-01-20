<%@tag pageEncoding="UTF-8" description="Base layout" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="title" type="java.lang.String" required="true"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/resources/assets/css/bootstrap.min.css" />" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/resources/assets/css/styles.css"/>" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Oxygen:400,300,700' rel='stylesheet' type='text/css'>
    <title><c:out value="${title}"/></title>
</head>
<body>

<header class="navbar navbar-default">
    <div class="container">
        <ul class="nav navbar-nav navbar-left">
            <li>
                <a href="/list"><span class="glyphicon glyphicon-list-alt"></span> Ideas list</a>
            </li>
            <li>
                <a href="/new"><span class="glyphicon glyphicon-plus"></span> Add idea </a>
            </li>
        </ul>
    </div>
</header>

<div class="container">
    <jsp:doBody/>
</div>

<footer class="panel-footer">
    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center">&copy; Zhitar Anatoliy</div>
        </div>
    </div>
</footer>

<script src="<c:url value="/resources/assets/js/jquery-3.3.1.js"/>"></script>
<script src="<c:url value="/resources/assets/js/bootstrap.min.js"/>"></script>
</body>

</html>
