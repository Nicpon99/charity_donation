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

<section class="form--steps" id="summary">

  <div class="form--steps-container">



    <div class="summary">

      <h3>Podsumowanie Twojej darowizny</h3>

      <div style="text-align: left">
        <h3>Oddajesz:</h3>
        <ul>
          <li class="icon-bag">
            ${selectedQuantity} worki darów (<c:forEach items="${selectedCategories}" var="category" varStatus="loop">
              <c:choose>
                <c:when test="${loop.last == false}">
                  ${category.name},
                </c:when>
                <c:when test="${loop.last == true}">
                  ${category.name}
                </c:when>
              </c:choose>
            </c:forEach>
            )
          </li>
          <li class="icon-hand">
            Dla fundacji "${selectedInstitution.name}"
          </li>
        </ul>
        <div class="col">
           <h3>Adres odbioru:</h3>
        </div>
        <div>
          <ul>
            <li>
              ${donationWithAddressAndPickUpData.street} ${donationWithAddressAndPickUpData.homeNumber}
              <c:if test="${!donationWithAddressAndPickUpData.getFlatNumber().isEmpty()}">
                / ${donationWithAddressAndPickUpData.flatNumber}
              </c:if>
            </li>
            <li>
              ${donationWithAddressAndPickUpData.city}
            </li>
            <li>
              ${donationWithAddressAndPickUpData.zipCode}
            </li>
            <li>
              ${donationWithAddressAndPickUpData.phoneNumber}
            </li>
          </ul>
        </div>
        <div class="col">
          <h3>Termin odbioru:</h3>
        </div>
        <div>
          <ul>
            <li>
              ${donationWithAddressAndPickUpData.pickUpDate}
            </li>
            <li>
              ${donationWithAddressAndPickUpData.pickUpTime}
            </li>
            <li>
              <c:choose>
                <c:when test="${!donationWithAddressAndPickUpData.getPickUpComment().isEmpty()}">
                  ${donationWithAddressAndPickUpData.pickUpComment}
                </c:when>
                <c:when test="${donationWithAddressAndPickUpData.getPickUpComment().isEmpty()}">
                  Brak uwag
                </c:when>
              </c:choose>
            </li>
          </ul>
        </div>
        <a class="btn" href="http://localhost:8080/donation/form/4#form4">Wstecz</a>
        <a class="btn" href="http://localhost:8080/donation/save">Potwierdzam</a>
      </div>
    </div>
  </div>
</section>


</div>

</section>

<%@include file="footer.jsp" %>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>



