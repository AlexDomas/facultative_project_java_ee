<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%--fmt:setLocale value="${sessionScope._CURRENT_LOCALE}"/--%>
<fmt:setBundle basename="pagecontent" var="txt"/>

<%@ include file="inc/header.inc.jsp" %>

<div id="left">

    <%@ include file="inc/menu.inc.jsp" %>

</div>

<div id="mainmiddle">


    <div class="block" style="min-width: 50%;">

        <table width="100%">
            <tr class="header">
                <th><fmt:message key="content.addeddate" bundle="${txt}"/></th>
                <th><fmt:message key="content.coursename" bundle="${txt}"/></th>
                <th><fmt:message key="content.teacher" bundle="${txt}"/></th>
                <th><fmt:message key="content.subscribeflag" bundle="${txt}"/></th>
                <th><fmt:message key="content.mark" bundle="${txt}"/></th>
                <th><fmt:message key="content.actions" bundle="${txt}"/></th>
            </tr>
            <c:forEach items="${requestScope.courses}" var="item">
                <td>${item.dateAdd}</td>
                <td>${item.name}</td>
                <td>${item.teacherFirstName} ${item.teacherLastName}</td>
                <td>${item.subscribe}</td>
                <td>
                    <c:if test="${item.mark ne 0}">
                        ${item.mark}
                    </c:if>
                </td>
                <td>
                    <c:if test="${not item.subscribe}">
                    <input type="button" onclick="location.href='/controller?command=selectcoursessubscribe&id=${item.id}';" value="<fmt:message key="content.action.subsctibe" bundle="${txt}"/>">
                    </c:if>
                    <c:if test="${item.subscribe}">
                        <c:if test="${item.mark eq 0}">
                        <input type="button" onclick="location.href='/controller?command=selectcoursesunsubscribe&id=${item.id}';" value="<fmt:message key="content.action.unsubsctibe" bundle="${txt}"/>">
                        </c:if>
                    </c:if>
                    <c:if test="${not empty item.note}">
                    <input type="button" onclick="showHideTr('row${item.id}');" value="<fmt:message key="content.action.viewnote" bundle="${txt}"/>">
                    </c:if>
                </td>
            </tr>
                <c:if test="${not empty item.note}">
            <tr style="display: none;" id="row${item.id}">
                <td colspan="6" class="note">${item.note}</td>
            </tr>
                </c:if>

            </c:forEach>
            </tbody></table>
    </div>

</div>