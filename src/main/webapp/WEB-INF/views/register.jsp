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

    <%@include file="header.jsp" %>

</header>

<div>
    <h2>Załóż konto</h2>
    <div class="login-page">
        <form:form method="POST" modelAttribute="user">
            <div class="form-group">
                <form:input path="username" placeholder="Email" id="username"/>
            </div>
            <div class="form-group">
                <form:input path="name" placeholder="Imię" id="name"/>
            </div>
            <div class="form-group">
                <form:input path="surname" placeholder="Nazwisko" id="surname"/>
            </div>
            <div class="form-group">
                <form:input path="password" placeholder="Hasło" type="password" id="pass1"/>
            </div>
            <div class="form-group">
                <input type="password" id="pass2" placeholder="Powtórz hasło">
            </div>
            <div>
                <ul>
                    <form:errors path="username" element="li" class="error"/><br>
                    <form:errors path="name" element="li" class="error"/><br>
                    <form:errors path="surname" element="li" class="error"/><br>
                    <form:errors path="password" element="li" class="error"/><br>
                </ul>
            </div>
            <div class="form-group--buttons" style="display: block" id="button">
                <button class="btn" type="submit">Załóż konto</button>
            </div>
            <div id="error-message" style="display: none" class="error">
                Wpisane hasła nie są takie same
            </div>
        </form:form>
    </div>
</div>


<%@include file="footer.jsp" %>

<script src="<c:url value="/resources/js/app.js"/>"></script>
<script src="<c:url value="/resources/js/check-password.js"/>"></script>
</body>
</html>



