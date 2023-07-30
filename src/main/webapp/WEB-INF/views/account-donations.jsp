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

    <h2>MOJE DARY</h2>

    <table>
        <thead>
        <th>
            ID
        </th>
        <th>
            Kategorie
        </th>
        <th>
            Instytucja
        </th>
        <th>
            Ilość worków
        </th>
        <th>
            Status
        </th>
        <th>
            Data odbioru
        </th>
        </thead>
        <tbody>
        <c:forEach items="${donations}" var="donation">
            <tr>
                <td>
                        ${donation.id}
                </td>
                <td>
                    <ul>
                        <c:forEach items="${donation.categories}" var="category">
                            <li>
                                    ${category.name}
                            </li>
                        </c:forEach>
                    </ul>
                </td>
                <td>
                        ${donation.institution.name}
                </td>
                <td>
                        ${donation.quantity}
                </td>
                <td>
                    <c:choose>
                        <c:when test="${donation.pickUpStatus.equalsIgnoreCase('nieodebrany')}">
                            <div style="color: red">
                                    ${donation.pickUpStatus}
                            </div>
                        </c:when>
                        <c:when test="${donation.pickUpStatus.equalsIgnoreCase('odebrany')}">
                            <div style="color:green;">
                                    ${donation.pickUpStatus}
                            </div>
                        </c:when>
                    </c:choose>

                </td>
                <td style="white-space: nowrap;">
                    <c:choose>
                        <c:when test="${donation.pickUpConfirmed == null}">
                            -
                        </c:when>
                        <c:when test="${donation.pickUpConfirmed != null}">
                            ${donation.pickUpConfirmed}
                        </c:when>
                    </c:choose>
                </td>
                <td>
                    <a href="http://localhost:8080/account/donations/info/${donation.id}">Dane do odbioru</a>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${donation.pickUpStatus.equalsIgnoreCase('nieodebrany')}">
                            <div>
                                <a style="color: green"
                                   href="http://localhost:8080/account/donations/pickUp/${donation.id}">Potwierdź
                                    odbiór</a>
                            </div>
                        </c:when>
                        <c:when test="${donation.pickUpStatus.equalsIgnoreCase('odebrany')}">
                            <div>
                                <a style="color: red"
                                   href="http://localhost:8080/account/donations/pickUp/${donation.id}"
                                >Anuluj potwierdzenie odbioru</a>
                            </div>
                        </c:when>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


</section>


<%@include file="footer.jsp" %>

</body>
</html>
