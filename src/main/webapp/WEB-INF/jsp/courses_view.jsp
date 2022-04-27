<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%--fmt:setLocale value="${sessionScope._CURRENT_LOCALE}"/--%>
<fmt:setBundle basename="pagecontent" var="txt"/>

<%@ include file="inc/header.inc.jsp" %>

<div align="center">

    <h1><fmt:message key="content.courses" bundle="${txt}"/></h1>

    <div class="block" style="min-width: 50%;">

        <table width="100%">
            <tbody>
            <tr class="header">
                <th><fmt:message key="content.addeddate" bundle="${txt}"/></th>
                <th><fmt:message key="content.coursename" bundle="${txt}"/></th>
                <th><fmt:message key="content.teacher" bundle="${txt}"/></th>
            </tr>
            <c:forEach items="${requestScope.courses}" var="item">
            <tr>
                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${item.dateAdd}" /></td>
                <td>${item.name}</td>
                <td>${item.teacherFirstName} ${item.teacherLastName}</td>
            </tr>
            </c:forEach>
            </tbody></table>
    </div>

</div>