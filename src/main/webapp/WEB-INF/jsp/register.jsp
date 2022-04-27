<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%--fmt:setLocale value="${sessionScope._CURRENT_LOCALE}"/--%>
<fmt:setBundle basename="pagecontent" var="txt"/>
<%@ include file="inc/header.inc.jsp" %>

    <h1><fmt:message key="content.register" bundle="${txt}"/></h1>
    <div id="register_form">
        <span class="ts-ok"><fmt:message key="misc.register_notice" bundle="${txt}"/></span>
        <div align="center">

            <br>
            <div class="block" style="width: 350px;">
                <h3><fmt:message key="content.register" bundle="${txt}"/></h3>

                <form method="post" action="/controller">
                    <input type="hidden" name="command" value="register">
                    <input type="hidden" name="action" value="add">
                    <table>
                        <tbody><tr><td><fmt:message key="content.login" bundle="${txt}"/>: </td><td><input type="text" name="login" value="" placeholder="<fmt:message key="content.login" bundle="${txt}"/>"></td></tr>
                        <tbody><tr><td><fmt:message key="content.firstname" bundle="${txt}"/>: </td><td><input type="text" name="first_name" value="" placeholder="<fmt:message key="content.firstname" bundle="${txt}"/>"></td></tr>
                        <tbody><tr><td><fmt:message key="content.lastname" bundle="${txt}"/>: </td><td><input type="text" name="last_name" value="" placeholder="<fmt:message key="content.lastname" bundle="${txt}"/>"></td></tr>
                        <%--<tr><td>Email адрес: </td><td><input type="text" name="email" value=""></td></tr>
                        <tr><td>Подтверждение E-Mail: </td><td><input type="text" name="reg[confemail]" value=""></td></tr>--%>
                        <tr><td><fmt:message key="content.password" bundle="${txt}"/>: </td><td><input type="password" name="password" value="" placeholder="<fmt:message key="content.password" bundle="${txt}"/>"></td></tr>
                        <tr><td><fmt:message key="content.passwordconfirm" bundle="${txt}"/>: </td><td><input type="password" name="confpass" value="" placeholder="<fmt:message key="content.passwordconfirm" bundle="${txt}"/>"></td></tr>
                        <%--<tr><td colspan="2"><input type="checkbox" name="reg[terms]" id="terms" style="width: auto;"> <label for="terms">Я прочитал и согласен с <a style="text-decoration: underline; cursor: pointer;" onclick="_('terms_container').style.display='block';">правилами пользователя</a></label></td></tr>--%>
                        <tr><td colspan="2"><input type="submit" value="<fmt:message key="content.register" bundle="${txt}"/>" class="bg_btn" style="width: auto;"></td></tr>
                        </tbody></table>
                </form>

            </div>

        </div>

    </div>


<%@ include file="inc/footer.inc.jsp" %>

