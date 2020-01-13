<#import "/spring.ftl" as spring/>
<html>
    <head>
        <title>SpringMVC</title>
        <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>

       <div class="login-form">
       <div>
            <#if wrongLogin??>
                <h3>${messageWrongLogin}</h3>
            </#if>
            <#if logout??>
                <h3>${message}</h3>
            </#if>
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
                                                    value="submit"><@spring.message "login.login"/></button></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td style="float: right"><a href="/registration"><@spring.message "login.registration"/></a></td>
                        </tr>
                    </table>

                </form>

            </div>
    </body>
</html>
