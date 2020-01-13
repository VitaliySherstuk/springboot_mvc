<#import "/spring.ftl" as spring/>
<html>
    <head>
        <title>Order</title>
        <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
       <#include "header.ftl">
       <div class="car_card">
            <div>
                <table>
                <tr>
                <td>
                <div style="width:50%; float:left;">
                    <#if car.img??>
                        <img src="/photo/${car.img}" alt="car" style="width:200px; height:200px; margin:2%;">
                        <form action="/orders/download/${car.id}" method="get">
                            <button type="submit">Download</button>
                        </form>
                    </#if>
                </div>
                </td>
                <td>
                <div>
                    <div class="car_card_text"><b><p>${car.make}</p></div>
                    <div class="car_card_text"><b><p>${car.model}</p></div>
                    <div class="car_card_text"><b><p>${car.year}</p></div>
                </div>
                </td>
                </tr>
                </table>
            </div>
            <div>
                <div style="width:50%; float: left;">${user.phone}</div>
                <div>${user.name}</div>
            </div>
            <div class="car_card_text_cost"><b>${car.cost}$</div>
       </div>
    </body>
</html>