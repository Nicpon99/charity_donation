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

  <title>Login</title>

  <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>

<body>
<header>

<%@include file="header.jsp"%>

</header>

<div>
  <h2>Zaloguj się</h2>
  <div class="login-page">
    <form method="POST">
      <div class="form-group">
      <input type="text" name="username" placeholder="Email">
      </div>
      <div class="form-group">
        <input name="password" type="password" placeholder="Hasło">
      </div>
      <div class="form-group">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <sec:csrfInput/>
      </div>
      <div class="form-group--buttons" style="gap: 50px">
        <a href="http://localhost:8080/register" class="btn">Załóż konto</a>
        <button class="btn" type="submit">Zaloguj się</button>
      </div>
    </form>
  </div>
</div>


<%@include file="footer.jsp" %>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>



