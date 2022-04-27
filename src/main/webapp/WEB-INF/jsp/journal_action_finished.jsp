<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%--fmt:setLocale value="${sessionScope._CURRENT_LOCALE}"--%>
<fmt:setBundle basename="pagecontent" var="txt"/>
<fmt:setBundle basename="messages" var="msg"/>

<%@ include file="inc/header.inc.jsp" %>

    <div id="left">

    <%@ include file="inc/menu.inc.jsp" %>

</div>

<div id="mainmiddle">

    <h1><fmt:message key="content.journal" bundle="${txt}"/>${course.name}</h1>
    <fmt:message key="${actionresult}" bundle="${msg}"/> <a href="/controller?command=journal&id=${course.id}"><fmt:message key="misc.actioncontinue" bundle="${txt}"/></a>
    <%@ include file="inc/footer.inc.jsp" %>

</div>