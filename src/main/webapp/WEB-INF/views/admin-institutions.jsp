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

<%@include file="header-admin.jsp"%>

<section class="help">

    <h2>INSTYTUCJE</h2>

    <ul class="help--slides-items">
        <c:forEach items="${institutions}" var="institution">
            <li>
                <div class="col">
                    <div class="title">${institution.name}</div>
                    <div class="description">${institution.description}</div>
                </div>
                <div class="col">
                    <a href="http://localhost:8080/admin/institutions/edit/${institution.id}"
                       class="btn" style="color: blue">Edytuj</a>
                    <a href="http://localhost:8080/admin/institutions/delete/${institution.id}"
                       class="btn" style="color: red">Usuń</a>
                </div>
            </li>
        </c:forEach>
    </ul>
    <br>
    <a href="http://localhost:8080/admin/institutions/add" class="btn" style="color: green">Dodaj nową instytucję</a>
</section>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>
