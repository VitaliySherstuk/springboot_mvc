<#import "/spring.ftl" as spring/>
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
                <#if name_error??>
                                        <tr>

                                            <h6 style="color: red;">${name}</h6>
                </tr>
                                    </#if>
                <tr>
                    <td>Password:</td>
                    <td><input type='password' name='password'/></td>
                </tr>
                <#if password_error??>
                    <tr>
                        <h6 style="color: red;">${password}</h6>
                    </tr>
                </#if>

                <tr>
                    <td>Phone:</td>
                    <td><input type='phone' name='phone'/></td>

                </tr>
                <#if phone_error??>
                <tr>


                                            <h6 style="color: red;">${phone}</h6>
                </tr>
                                    </#if>
                <tr><input id="submit" name="submit" type="submit"/></tr>
            </table>
        </form>
        </div>
    </body>
</html>
