<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<fmt:setLocale value="${localeString}"/>
<fmt:setBundle basename="pagecontent" var="txt"/>

<div class="menu">

    <div class="block">
        <h3><fmt:message key="menuitem.header" bundle="${txt}"/></h3>
        <div class="content">
            <ul>
                <c:forEach items="${sessionScope._USER_ACCESS}" var="command">
                    <c:if test="${command.menuItem}">
                    <li><a href="/library_ee?command=${command.name}"><fmt:message key="menuitem.${command.name}" bundle="${txt}"/></a></li>
                    </c:if>
                </c:forEach>
                    <li><a href="/library_ee?command=logout"><fmt:message key="content.signout" bundle="${txt}"/> [${sessionScope._USER_DATA.login}]</a></li>
            </ul>
        </div>
    </div>

</div>
