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

<section class="form--steps" id="form4">

    <div class="form--steps-instructions">
        <h3>Ważne!</h3>
        <p class="active">
            Podaj adres oraz termin odbioru rzeczy przez kuriera:
        </p>
    </div>

    <div class="form--steps-container">

        <div class="form--steps-counter">
            Krok 4/4
        </div>


        <section class="form-section">
            <div class="form--steps-container">
                <div class="form-section--columns">
                    <h3>Podaj adres oraz termin odbioru rzeczy przez kuriera:</h3>
                    <form:form method="POST" modelAttribute="donation" action="http://localhost:8080/donation/form/4"
                               class="form--steps">
                    <div class="steps">
                        <div class="col">
                            <label style="font-weight: bold" , style="text-align: left">
                                Adres odbioru
                            </label>
                            <div class="form-group" style="text-align: left">
                                <div>
                                    Ulica
                                    <form:input path="street"/>
                                </div>
                                <div>
                                    Numer domu
                                    <form:input path="homeNumber"/>
                                </div>
                                <div>
                                    Numer mieszkania (opcjonalnie)
                                    <form:input path="flatNumber"/>
                                </div>
                                <div>
                                    Miasto
                                    <form:input path="city"/>
                                </div>
                                <div>
                                    Kod pocztowy
                                    <form:input path="zipCode" placeholder="00-000"/>
                                </div>
                                <div>
                                    Numer telefonu
                                    <form:input path="phoneNumber"/>
                                </div>
                            </div>
                        </div>

                        <br>
                        <br>
                        <br>

                        <div class="col">
                            <label style="font-weight: bold" , style="text-align: left">
                                Termin odbioru
                            </label>
                            <div class="form-group" style="text-align: left">
                                <div>
                                    Data
                                    <form:input path="pickUpDate" placeholder="dd-mm-yyyy"/>
                                </div>
                                <div>
                                    Godzina
                                    <form:input path="pickUpTime" placeholder="HH:mm"/>
                                </div>
                                <div>
                                    Uwagi dla klienta
                                    <form:textarea path="pickUpComment" rows="6" cols="15"/>
                                </div>
                            </div>
                        </div>

                        <br>
                        <ul>
                        <form:errors path="street" element="li" class="error"/>
                        <form:errors path="homeNumber" element="li" class="error"/>
                        <form:errors path="flatNumber" element="li" class="error"/>
                        <form:errors path="city" element="li" class="error"/>
                        <form:errors path="zipCode" element="li" class="error"/>
                        <form:errors path="phoneNumber" element="li" class="error"/>
                        <form:errors path="pickUpDate" element="li" class="error"/>
                        <form:errors path="pickUpTime" element="li" class="error"/>
                        </ul>
                        <br>
                        <a class="btn" href="http://localhost:8080/donation/form/3#form3">Wstecz</a>
                        <button class="btn" type="submit">Dalej</button>
                    </div>
                </div>
                </form:form>
            </div>
        </section>


    </div>

</section>

<%@include file="footer.jsp" %>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>


