<!DOCTYPE html>
<#import "/spring.ftl" as spring/>
<html>
    <head>
        <title>SpringMVC</title>
        <meta charset="UTF-8" content="text/html;charset=UTF-8">
        <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
    <#include "header.ftl">
    <div>
        <div class="transport_section">
            <h2 align="center"><@spring.message "home.category"/></h2>
            <div class="category">
                <a href="/cars">
                    <span>
                        <img src="/resources/img/auto.png" alt="CAR"/>
                    </span>
                </a>
                <h4 align="center"><@spring.message "home.car"/></h4>
            </div>
            <div class="category">
                <a href="">
                    <span>
                        <img src="/resources/img/lorry.png" alt="LORRY"/>
                    </span>
                </a>
                <h4 align="center"><@spring.message "home.lorry"/></h4>
            </div>
            <div class="category">
                <a href="">
                    <span>
                        <img src="/resources/img/motto.png" alt="BIKE"/>
                    </span>
                </a>
                <h4 align="center"><@spring.message "home.bike"/></h4>
            </div>
            <div class="category">
                <a href="/inventory">
                    <span>
                        <img src="/resources/img/inv.png" alt="My Inventory"/>
                    </span>
                </a>
                <h4 align="center"><@spring.message "home.inventory"/></h4>
            </div>
        </div>
    </div>

    </body>
</html>
