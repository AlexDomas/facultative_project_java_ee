<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/mytaglib.tld" prefix="mytag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<fmt:setLocale value="${localeString}"/>
<fmt:setBundle basename="pagecontent" var="txt"/>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
      
        <link href="/static/css/login.css" rel="stylesheet">
        <script src="/static/js/show_hide.js"></script>
        <title><fmt:message key="header.title" bundle="${txt}"/></title>
        
        
    </head>
    <body>
        <div style="width: 100%;" align="center">
            <div style="width: 1256px;" align="left" id="container">

                <h1><fmt:message key="header.title" bundle="${txt}"/></h1>
                <div>
                    <ul class="menu-hor" style="float: right;">
                        <li><a href="/controller?command=coursesview"><fmt:message key="content.courses" bundle="${txt}"/></a></li>
                            <c:if test="${empty sessionScope._USER_DATA}">
                            <li><a href="/controller?command=login"><fmt:message key="content.signin" bundle="${txt}"/></a></li>
                            </c:if>
                            <c:if test="${not empty sessionScope._USER_DATA}">
                            <li><a href="/controller?command=logout"><fmt:message key="content.signout" bundle="${txt}"/> [${sessionScope._USER_DATA.login}]</a></li>
                            </c:if>
                        <li><a href="/controller?command=register"><fmt:message key="content.register" bundle="${txt}"/></a></li>
                        <li><mytag:selectLocale/></li>
                    </ul>
                </div>

                <div id="content">
                    ${errorMsg}
                    <br/>
                    ${wrongAction}
                    <br/>
                    ${nullPage}
                    <br/>