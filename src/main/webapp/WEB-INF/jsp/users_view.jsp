<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%--fmt:setLocale value="${sessionScope._CURRENT_LOCALE}"/--%>
<fmt:setBundle basename="pagecontent" var="txt"/>

<%@ include file="inc/header.inc.jsp" %>

<div id="left">

    <%@ include file="inc/menu.inc.jsp" %>

</div>

<div id="mainmiddle">


    <h1><fmt:message key="content.users" bundle="${txt}"/></h1>

    <div class="block" style="min-width: 50%;">

        <table width="100%">
            <tbody>
            <tr class="header">
                <th><fmt:message key="content.addeddate" bundle="${txt}"/></th>
                <th><fmt:message key="content.login" bundle="${txt}"/></th>
                <th><fmt:message key="content.firstname" bundle="${txt}"/></th>
                <th><fmt:message key="content.lastname" bundle="${txt}"/></th>
                <th><fmt:message key="content.userrole" bundle="${txt}"/></th>
                <th><fmt:message key="content.lastlogin" bundle="${txt}"/></th>
                <th><fmt:message key="content.actions" bundle="${txt}"/></th>
            </tr>
            <c:forEach items="${requestScope.items}" var="item">
            <tr>
                <td><%--<fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${item.dateAdd}" />--%><fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${item.dateAdd}" /></td>
                <td>${item.login}</td>
                <td>${item.firstName}</td>
                <td>${item.lastName}</td>
                <td>${item.roleName}</td>
                <td><fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${item.lastLogin}" /></td>
                <td>
                    <input type="button" onclick="location.href='/controller?command=userdel&id=${item.id}';" value="<fmt:message key="content.action.delete" bundle="${txt}"/>">
                    <input type="button" onclick="location.href='/controller?command=useredit&id=${item.id}';" value="<fmt:message key="content.action.edit" bundle="${txt}"/>">
                </td>
            </tr>
            </c:forEach>
            </tbody></table>
    </div>

</div>