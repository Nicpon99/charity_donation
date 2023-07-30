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

    <title>My account</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>

<header>
    <%@include file="header.jsp" %>
</header>


<section class="help">

    <h2>DANE DO ODBIORU DARU</h2>

    <table>
        <thead>
        <th>
            Data utworzenia
        </th>
        <th>
            Numer telefonu
        </th>
        <th>
            Ulica
        </th>
        <th>
            Numer domu
        </th>
        <th>
            Numer mieszkania
        </th>
        <th>
            Kod pocztowy
        </th>
        <th>
            Miasto
        </th>
        <th>
            Planowana data odbioru
        </th>
        <th>
            Planowana godzina odbioru
        </th>
        <th>
            Komentarz
        </th>
        </thead>
        <tbody>
        <tr>
            <td>
                ${donation.created}
            </td>
            <td>
                ${donation.phoneNumber}
            </td>
            <td>
                ${donation.street}
            </td>
            <td>
                ${donation.homeNumber}
            </td>
            <td>
                <c:choose>
                    <c:when test="${donation.flatNumber == null}">
                        -
                    </c:when>
                    <c:when test="${donation.flatNumber != null}">
                        ${donation.flatNumber}
                    </c:when>
                </c:choose>
            </td>
            <td>
                ${donation.zipCode}
            </td>
            <td>
                ${donation.city}
            </td>
            <td>
                ${donation.pickUpDate}
            </td>
            <td>
                ${donation.pickUpTime}
            </td>
            <td>
                <c:choose>
                    <c:when test="${donation.pickUpComment == null}">
                        -
                    </c:when>
                    <c:when test="${donation.pickUpComment != null}">
                        ${donation.pickUpComment}
                    </c:when>
                </c:choose>
            </td>
        </tr>

        </tbody>
    </table>


</section>


<%@include file="footer.jsp" %>

</body>
</html>

