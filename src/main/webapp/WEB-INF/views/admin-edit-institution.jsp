<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>

<head lang="pl">
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>

    <title>Admin institutions</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>

<%@include file="admin-header.jsp" %>

<section class="help">

    <h2>Edytuj instytucję</h2>

    <div class="form-section">
        <form:form method="POST" modelAttribute="institution" action="/admin/institutions/update">
            <form:hidden path="id" value="${institution.id}"/>
            <h3 class="form-group">
                Nazwa
            </h3>
            <div class="form-group">
                <form:input path="name" value="${institution.name}"/>
            </div>
            <h3 class="form-group">
                Opis
            </h3>
            <div class="form-group">
                <form:textarea path="description" cols="50" rows="4" value="${institution.description}"/>
            </div>
            <br>

            <br>
            <div class="form-group">
                <button type="submit" class="btn" style="color: green">Zapisz</button>
            </div>
            <ul>
                <form:errors path="name" element="li" class="error"/>
                <form:errors path="description" element="li" class="error"/>
            </ul>
        </form:form>
    </div>
</section>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>


