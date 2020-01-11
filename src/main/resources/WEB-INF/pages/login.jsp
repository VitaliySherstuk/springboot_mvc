<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <title>SpringMVC</title>
        <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>

       <div class="login-form">
       <div>
            <c:if test="${wrongLogin}">
                <h3>${messageWrongLogin}</h3>
            </c:if>
            <c:if test="${logout}">
                <h3>${message}</h3>
            </c:if>
       </div>
        <form method='post' name='loginForm' action="/login">
                    <table>
                        <tr>
                            <td><spring:message code="login.user"/></td>
                            <td><input type='text' name='username' value=''></td>
                        </tr>
                        <tr>
                            <td><spring:message code="login.password"/></td>
                            <td><input type='password' name='password'/></td>
                        </tr>
                        <tr>
                            <td colspan='2'><button name="submit" type="submit"
                                                    value="submit"><spring:message code="login.login"/></button></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td style="float: right"><a href="/registration"><spring:message code="login.registration"/></a></td>
                        </tr>
                    </table>

                </form>

            </div>
    </body>
</html>
