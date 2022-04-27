<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%--fmt:setLocale value="${sessionScope._CURRENT_LOCALE}"/--%>
<fmt:setBundle basename="pagecontent" var="txt"/>

<%@ include file="inc/header.inc.jsp" %>

<div id="left">

    <%@ include file="inc/menu.inc.jsp" %>

</div>

<div id="mainmiddle">

    <!--<h1><fmt:message key="content.profile" bundle="${txt}"/></h1>-->

    <fmt:message key="mainpage.username" bundle="${txt}"/>: <b>${_USER_DATA.login}</b>, <fmt:message key="mainpage.role" bundle="${txt}"/>: <b>${_USER_DATA.roleName}</b><br>

    <div align="center">

        <div class="block" style="min-width: 50%;">

            <h3><fmt:message key="content.profile" bundle="${txt}"/></h3>



            <form method="post">
                <table border="0" cellspacing="0" cellpadding="0" width="100%">
                    <tbody>
                        <tr><td align="right"><input type="checkbox" name="not_change_pass" value="true" onclick="showHide(this.checked, 'p1id', 'p2id');" checked="">&nbsp;</td><td><fmt:message key="content.dnchpass" bundle="${txt}"/>.</td></tr>
                        <tr id="p1id" style="display: none;"><td align="right" valign="top"><fmt:message key="content.newpass" bundle="${txt}"/>:</td><td valign="top"><input type="password" name="password" size="20" maxlength="15" value=""></td></tr>
                        <tr id="p2id" style="display: none;"><td align="right" valign="top"><fmt:message key="content.passconfirmation" bundle="${txt}"/>: </td><td valign="top"><input type="password" name="confpass" size="20" maxlength="15" value=""></td></tr>
                        <tr><td align="right"><fmt:message key="content.firstname" bundle="${txt}"/>: </td><td><input type="text" name="first_name" value="${_USER_DATA.firstName}" placeholder="<fmt:message key="content.firstname" bundle="${txt}"/>"></td></tr>
                        <tr><td align="right"><fmt:message key="content.lastname" bundle="${txt}"/>: </td><td><input type="text" name="last_name" value="${_USER_DATA.lastName}" placeholder="<fmt:message key="content.lastname" bundle="${txt}"/>"></td></tr>
                                <%--<tr><td align="right" valign="top">Email:</td><td valign="top"><input type="text" name="email" size="20" maxlength="40" value="${_USER_DATA.email}"></td></tr>--%>
                        <tr><td align="right" valign="top"><fmt:message key="content.currentpass" bundle="${txt}"/>:</td><td valign="top"><input type="password" name="oldpass" size="20" maxlength="40" value=""></td></tr>
                        <tr><td colspan="2" align="right"><input type="submit" value="<fmt:message key="content.action.save" bundle="${txt}"/>"></td></tr>

                    </tbody>
                    </table>
            </form>
            
        </div>
    </div>

</div>

<%@ include file="inc/footer.inc.jsp" %>