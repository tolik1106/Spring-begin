<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout title="User registration">
    <h1 class="text-center text-uppercase">Login user</h1>
    <div class="jumbotron">
        <form:form id="formRegister" modelAttribute="user" method="post" action="login">
            <div class="form-group">
                <label for="login">Email</label>
                <form:input path="login" id="login" cssClass="form-control"/>
                <form:errors path="login" cssClass="form-control label-warning"/>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <form:password path="password" id="password" cssClass="form-control"/>
                <form:errors path="password" cssClass="form-control label-warning"/>
            </div>
            <div class="form-group">
                <label for="rePassword">Confirm password</label>
                <form:password path="rePassword" id="rePassword" cssClass="form-control"/>
                <form:errors cssClass="form-control label-warning"/>
            </div>
            <button type="submit" class="btn btn-success">Login</button>
            <a href="list" class="danger-link">Cancel</a>
        </form:form>
    </div>
</t:layout>
