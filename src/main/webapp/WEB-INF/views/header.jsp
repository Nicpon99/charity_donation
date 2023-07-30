<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="container container">
    <ul class="nav--actions">
        <sec:authorize access="isAnonymous()">
            <li><a href="http://localhost:8080/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
            <li><a href="http://localhost:8080/register/user" class="btn btn--small btn--highlighted">Załóż konto</a></li>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <li><a href="http://localhost:8080/logout" class="btn btn--small btn--without-border">Wyloguj</a></li>
            <li><a href="http://localhost:8080/account/donations" class="btn btn--small btn--highlighted">Mój profil</a></li>
        </sec:authorize>
    </ul>

    <ul>
        <li><a href="http://localhost:8080" class="btn btn--without-border active">Start</a></li>
        <li><a href="http://localhost:8080/#steps" class="btn btn--without-border">O co chodzi?</a></li>
        <li><a href="http://localhost:8080/#about-us" class="btn btn--without-border">O nas</a></li>
        <li><a href="http://localhost:8080/#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
        <li><a href="http://localhost:8080/#contact" class="btn btn--without-border">Kontakt</a></li>
    </ul>
</nav>
