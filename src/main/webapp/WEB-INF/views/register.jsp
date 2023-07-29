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

    <title>Register</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>

<body>
<header>

<%@include file="header.jsp"%>

</header>

<div>
    <h2>Załóż konto</h2>
    <div class="login-page">
        <form:form method="POST" modelAttribute="user">
            <div class="form-group">
                <form:input path="username" placeholder="Email"/>
            </div>
            <div class="form-group">
                <form:input path="name" placeholder="Imię"/>
            </div>
            <div class="form-group">
                <form:input path="surname" placeholder="Nazwisko"/>
            </div>
            <div class="form-group">
                <form:input path="password" placeholder="Hasło" type="password"/>
            </div>
            <div>
            <form:errors path="username" element="div" class="error"/><br>
            <form:errors path="name" element="div" class="error"/><br>
            <form:errors path="surname" element="div" class="error"/><br>
            <form:errors path="password" element="div" class="error"/><br>
            </div>
            <div class="form-group--buttons" style="gap: 50px">
                <a href="#" class="btn">Zaloguj się</a>
                <button class="btn" type="submit">Załóż konto</button>
            </div>
        </form:form>
    </div>
</div>


<%@include file="footer.jsp" %>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>



