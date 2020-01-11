<#import "/spring.ftl" as spring/>
<html>
    <head>
        <title>header</title>
        <meta charset="UTF-8" content="text/html;charset=UTF-8">
        <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
        <div class="header">
            <div class="category_link">
                <p><a href="/home"><@spring.message "header.home"/></a></p>
            </div>
            <div class="category_link">
                <p><a href="/cars"><@spring.message "header.cars"/></a></p>
            </div>
            <div class="category_link">
                <p><a href="/inventory"><@spring.message "header.inventory"/></a></p>
            </div>
            <div class="category_link">
                    <select name="lang" onchange="location = this.value;">
                        <option value="">lang</option>
                        <option value="?lang=en">English</option>
                        <option value="?lang=ru">Русский</option>
                    </select>
            </div>
            <div style="float:right">
                <form  action="/logout" method="post">
                    <button style="float:right;" type="submit"><@spring.message "header.logout"/></button>
                </form>
                <#if userNameStatus??>
                    <div class="user_name_block">${userName}</div>
                </#if>
            </div>
        </div>
    <body>
</html>