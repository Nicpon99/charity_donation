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

  <title>Admin users</title>

  <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>

<%@include file="header-admin.jsp"%>

<section class="help">

  <h2>UŻYTKOWNICY</h2>

  <ul class="help--slides-items">
    <c:forEach items="${users}" var="user">
      <li>
        <div class="col">
          <div class="title">${user.username}</div><br>
          <div class="title">Imię: ${user.name}</div><br>
          <div class="title">Nazwisko: ${user.surname}</div>
        </div>
        <div class="col">
          <br>
          <br>
          <a href="http://localhost:8080/admin/users/edit/${user.id}"
             class="btn" style="color: blue">Edytuj</a>
          <a href="http://localhost:8080/admin/users/delete/${user.id}"
             class="btn" style="color: red">Usuń</a>
          <c:choose>
            <c:when test="${user.enabled == 1}">
              <a href="http://localhost:8080/admin/users/block/${user.id}"
                 class="btn" style="color: red">Zablokuj</a>
            </c:when>
            <c:when test="${user.enabled == 0}">
              <a href="http://localhost:8080/admin/users/block/${user.id}"
                 class="btn" style="color: green">Odblokuj</a>
            </c:when>
          </c:choose>
        </div>
      </li>
    </c:forEach>
  </ul>
</section>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>


