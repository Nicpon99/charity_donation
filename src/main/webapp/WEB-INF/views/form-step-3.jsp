<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head lang="pl">
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>

    <title>Formularz-Dar</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>


<%@include file="header-form.jsp" %>

<section class="form--steps" id="form3">

    <div class="form--steps-instructions">
        <h3>Ważne!</h3>
        <p class="active">
            Wybierz jedną, do której trafi Twoja przesyłka.
        </p>
    </div>

    <div class="form--steps-container">

        <div class="form--steps-counter">
            Krok 3/4
        </div>


        <section class="form-section">
            <div class="form--steps-container">
                <div class="form-group">
                    <h3>Wybierz organizację, ktorej chcesz pomóc:</h3>
                    <form:form method="POST" modelAttribute="donation" action="http://localhost:8080/donation/form/3"
                               class="form--steps">
                    <div class="steps">
                        <c:forEach items="${institutions}" var="institution">
                            <div style="text-align: left">
                                <form:radiobutton path="institution" value="${institution.id}"/>${institution.name}<br>
                                    ${institution.description}
                                <br>
                            </div>
                        </c:forEach>

                        <br>
                        <form:errors path="institution" element="div" class="error"/>
                        <br>
                        <a class="btn" href="http://localhost:8080/donation/form/2#form2">Wstecz</a>
                        <button class="btn" type="submit">Dalej</button>
                    </div>
                </div>
                </form:form>
            </div>
    </div>
</section>


</div>

</section>

<%@include file="footer.jsp" %>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>

