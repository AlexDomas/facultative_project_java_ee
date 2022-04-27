<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%--fmt:setLocale value="${sessionScope._CURRENT_LOCALE}"/--%>
<fmt:setBundle basename="pagecontent" var="txt"/>

<%@ include file="inc/header.inc.jsp" %>

<div id="left">

    <%@ include file="inc/menu.inc.jsp" %>

</div>

<div id="mainmiddle">

    <fmt:message key="mainpage.username" bundle="${txt}"/>: <b>${_USER_DATA.login}</b>, <fmt:message key="mainpage.role" bundle="${txt}"/>: <b>${_USER_DATA.roleName}</b><br>
    ${_USER_DATA.firstName}
    ${_USER_DATA.lastName}

</div>

<%@ include file="inc/footer.inc.jsp" %>