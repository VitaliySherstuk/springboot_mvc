<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>SpringMVC</title>
        <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
       <div class="login-form">
        <form method='post' name='RegistrationForm' action="/registration">
            <table>
                <tr>
                    <td>User:</td>
                    <td><input type='text' name='name' value=''></td>
                </tr>
                <c:if test="${name_error}">
                                        <tr>

                                            <h6 style="color: red;">${name}</h6>
                </tr>
                                    </c:if>
                <tr>
                    <td>Password:</td>
                    <td><input type='password' name='password'/></td>
                </tr>
                <c:if test="${password_error}">
                                                           <tr>

                                                                <h6 style="color: red;">${password}</h6>
                </tr>
                                                        </c:if>

                <tr>
                    <td>Phone:</td>
                    <td><input type='phone' name='phone'/></td>

                </tr>
                <c:if test="${phone_error}">
                <tr>


                                            <h6 style="color: red;">${phone}</h6>
                </tr>
                                    </c:if>
                <tr><input id="submit" name="submit" type="submit"/></tr>
            </table>
        </form>
        </div>
    </body>
</html>
