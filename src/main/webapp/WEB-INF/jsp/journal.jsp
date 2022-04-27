<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%--fmt:setLocale value="${sessionScope._CURRENT_LOCALE}"/--%>
<fmt:setBundle basename="pagecontent" var="txt"/>

<%@ include file="inc/header.inc.jsp" %>

<div id="left">

    <%@ include file="inc/menu.inc.jsp" %>

</div>

<div id="mainmiddle">

    <h1><fmt:message key="content.journal" bundle="${txt}"/> ${course.name}</h1>

    <div class="block" style="min-width: 50%;">

        <table width="100%">
            <colgroup>
                <col style="width: 15%">
                <col style="width: 15%">
                <col style="width: 5%">
                <col style="width: 55%">
                <col style="width: 10%">
            </colgroup>
            <tbody>
            <tr class="header">
                <th><fmt:message key="content.lastname" bundle="${txt}"/></th>
                <th><fmt:message key="content.firstname" bundle="${txt}"/></th>
                <th><fmt:message key="content.mark" bundle="${txt}"/></th>
                <th><fmt:message key="content.notice" bundle="${txt}"/></th>
                <th><fmt:message key="content.actions" bundle="${txt}"/></th>
            </tr>
            <c:forEach items="${requestScope.students}" var="item">
            <tr>
                <td>${item.studentLastName}</td>
                <td>${item.studentFirstName}</td>
                <td>
                    <c:if test="${item.mark ne 0}">
                    ${item.mark}
                    </c:if>
                </td>
                <td>
                    <c:if test="${not empty item.note}">
                        ${item.note}
                    </c:if>
                </td>
                <td>
                    <input type="button" onclick="location.href='/controller?command=journaledit&id=${item.id}';" value="<fmt:message key="content.action.edit" bundle="${txt}"/>">
                </td>
            </tr>
            </c:forEach>
            </tbody></table>
    </div>

</div>