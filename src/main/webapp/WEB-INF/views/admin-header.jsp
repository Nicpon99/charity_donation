<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<header>
    <nav class="container container">
        <ul class="nav--actions">
                <li><a href="http://localhost:8080/logout" class="btn btn--small btn--highlighted">Wyloguj</a></li>
        </ul>
        <ul>
            <li><a href="http://localhost:8080" class="btn btn--without-border active">Start</a></li>
            <li><a href="http://localhost:8080/admin/institutions" class="btn btn--without-border">Instytucje</a></li>
            <li><a href="#" class="btn btn--without-border">O nas</a></li>
            <li><a href="#" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="#" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>
</header>
