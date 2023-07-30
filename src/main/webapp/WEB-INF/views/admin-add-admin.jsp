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

<%@include file="header-admin.jsp" %>

<section class="help">

  <h2>Dodaj administratora</h2>

  <div class="form-section">
    <form:form method="POST" modelAttribute="user">
      <h3 class="form-group">
        E-mail
      </h3>
      <div class="form-group">
        <form:input path="username" id="username"/>
      </div>
      <h3 class="form-group">
        Imię
      </h3>
      <div class="form-group">
        <form:input path="name" id="name"/>
      </div>
      <h3 class="form-group">
        Nazwisko
      </h3>
      <div class="form-group">
        <form:input path="surname" id="surname"/>
      </div>
      <h3 class="form-group">
        Hasło
      </h3>
      <div class="form-group">
        <form:input path="password" type="password" id="pass1"/>
      </div>
      <h3>Powtórz hasło</h3>
      <div class="form-group">
        <input type="password" id="pass2">
      </div>
      <br>
      <br>
      <div class="form-group--buttons" style="display: block" id="button">
        <button class="btn" type="submit">Zapisz</button>
      </div>
      <div id="error-message" style="display: none" class="error">
        Wpisane hasła nie są takie same
      </div>
      <ul>
        <form:errors path="username" element="li" class="error"/>
        <form:errors path="name" element="li" class="error"/>
        <form:errors path="surname" element="li" class="error"/>
        <form:errors path="password" element="li" class="error"/>
      </ul>
    </form:form>
  </div>
</section>

<script src="<c:url value="/resources/js/app.js"/>"></script>
<script src="<c:url value="/resources/js/check-password.js"/>"></script>
</body>
</html>
