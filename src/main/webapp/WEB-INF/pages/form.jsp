<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout title="Add new Idea">
    <h1 class="text-center text-uppercase">Adding new idea</h1>
    <div class="jumbotron">
        <form:form id="formCreate" modelAttribute="idea" method="post" action="/new">
            <div class="form-group">
                <label for="captionId">Caption</label>
                <form:input path="caption" id="captionId" cssClass="form-control"/>
            </div>
            <div class="form-group">
                <label for="contentId">Text</label>
                <form:textarea path="content" id="contentId" cssClass="form-control"/>
            </div>
            <form:hidden path="id"/>
            <button type="submit" class="btn btn-success">Save</button>
            <a href="list" class="danger-link">Cancel</a>
        </form:form>
    </div>
</t:layout>

