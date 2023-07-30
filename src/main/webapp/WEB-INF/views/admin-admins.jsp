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

    <title>Admin admins</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>

<%@include file="admin-header.jsp"%>

<section class="help">

    <h2>ADMINISTRATORZY</h2>

    <ul class="help--slides-items">
        <c:forEach items="${admins}" var="admin">
            <li>
                <div class="col">
                    <div class="title">${admin.username}</div><br>
                    <div class="title">Imię: ${admin.name}</div><br>
                    <div class="title">Nazwisko: ${admin.surname}</div>
                </div>
                <div class="col">
                    <br>
                    <br>
                    <a href="http://localhost:8080/admin/admins/edit/${admin.id}"
                       class="btn" style="color: blue">Edytuj</a>
                    <c:if test="${principalAdminId != admin.id}">
                    <a href="http://localhost:8080/admin/admins/delete/${admin.id}"
                       class="btn" style="color: red">Usuń</a>
                    </c:if>
                </div>
            </li>
        </c:forEach>
    </ul>
    <br>
    <a href="http://localhost:8080/admin/admins/add" class="btn" style="color: green">Dodaj nowego administratora</a>
</section>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>

