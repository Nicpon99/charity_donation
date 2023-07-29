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


  <div class="slogan container container--90" style="justify-content: center">
    <div class="slogan--item">
      <h1>
        Dziękujemy za utworzenie konta. Na Twojego maila przesłaliśmy wiadomość z powitaniem Cię w naszej aplikacji.<br>
        <a href="http://localhost:8080/login" class="btn">Zaloguj się</a>
      </h1>
    </div>
    <br>
  </div>

</header>


<%@include file="footer.jsp" %>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>



