<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%--fmt:setLocale value="${sessionScope._CURRENT_LOCALE}"/--%>
<fmt:setBundle basename="pagecontent" var="txt"/>

<%@ include file="inc/header.inc.jsp" %>

<div id="left">

    <%@ include file="inc/menu.inc.jsp" %>

</div>

<div id="mainmiddle">

    <h1><fmt:message key="content.courses" bundle="${txt}"/></h1>

    <div class="block" style="min-width: 50%;">
        
        <form method="post" action="/controller">
            <input type="hidden" name="command" value="coursesadd">
            <table width="100%">
            <tr class="header"><td colspan="2"><fmt:message key="content.course.addnewcourse" bundle="${txt}"/></td></tr>
            <tr>
                <td width="100%"><input type="text" name="name" placeholder="<fmt:message key="content.coursename" bundle="${txt}"/>" style="width: 100%;"></td>
                <td><input type="submit" value="<fmt:message key="content.action.add" bundle="${txt}"/>"></td>
            </tr>
            </table>
        </form>
        
    </div>

    <div class="block" style="min-width: 50%;">

        <table width="100%">
            <tbody>
            <tr class="header">
                <th><fmt:message key="content.addeddate" bundle="${txt}"/></th>
                <th><fmt:message key="content.coursename" bundle="${txt}"/></th>
                <th><fmt:message key="content.teacher" bundle="${txt}"/></th>
                <th><fmt:message key="content.students" bundle="${txt}"/></th>
                <th><fmt:message key="content.actions" bundle="${txt}"/></th>
            </tr>
            <c:forEach items="${requestScope.courses}" var="item">
            <tr>
                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${item.dateAdd}" /></td>
                <td>${item.name}</td>
                <td>${item.teacherFirstName} ${item.teacherLastName}</td>
                <td>${item.studentsCount}</td>
                <td>
                    <c:if test="${sessionScope._USER_DATA.id eq item.teacherId}">
                    <input type="button" onclick="location.href='/controller?command=coursesdelete&id=${item.id}';" value="<fmt:message key="content.action.delete" bundle="${txt}"/>">
                    <input type="button" onclick="location.href='/controller?command=coursesedit&id=${item.id}';" value="<fmt:message key="content.action.edit" bundle="${txt}"/>">
                        <c:if test="${item.studentsCount > 0}">
                    <input type="button" onclick="location.href='/controller?command=journal&id=${item.id}';" value="<fmt:message key="content.action.viewjournal" bundle="${txt}"/>">
                        </c:if>
                    </c:if>
                </td>
            </tr>
            </c:forEach>
            </tbody></table>
    </div>

</div>