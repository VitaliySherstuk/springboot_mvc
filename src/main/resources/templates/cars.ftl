<#import "/spring.ftl" as spring/>
<html>
    <head>
        <title>SpringMVC</title>
        <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
        <script src="/resources/js/order.js" type="text/javascript"></script>
    </head>
    <body>
        <#include "header.ftl">
        <div class="find_section">
            <h3>car search</h3>
            <form method="post" action="/cars/car" onclick="return true">
                <input class="find_section_element" id="car_make" name="make" type="text" placeholder="make"/>
                <input class="find_section_element" id="car_model" name="model" type="text" placeholder="model"/>
                <input class="find_section_element" id="car_year" name="year" type="text" placeholder="year"/>
                <input class="find_section_element" id="car_cost" name="cost" type="text" placeholder="min cost"/>
                <select name="order" class="find_section_element" style="width:8%;">
                    <option selected disabled>Order</option>
                    <option value="make">Make</option>
                    <option value="model">Model</option>
                    <option value="year">Year</option>
                    <option value="cost">Cost</option>
                </select>
                <input class="button_submit" id="submit" name="submit" type="submit" value="search" placeholder="submit"/>
            </form>
        </div>
    <#if isVisible??>
    <div>
           <table id="cars" class="table">
            <tr>
                <th></th>
                <th>Make</th>
                <th>Model</th>
                <th>Year</th>
                <th>Cost</th>
                <th></th>
            </tr>
            <#list cars as car>
                <tr align="center">
                    <td><img src="/photo/${car.img}" alt="car" style="width:40px; height:40px; margin:2%;"></td>
                    <td>${car.make}</td>
                    <td>${car.model}</td>
                    <td>${car.year}</td>
                    <td>${car.cost}</td>
                    <td>
                        <form method="get" action="/orders/car/${car.id}" onclick="return true">
                            <input class="button_edit" id="submit" name="submit" type="submit" value="buy"/>
                        </form>
                    </td>
                </tr>
            </#list>

           </table>
    </#if>
    </div>
    </body>
</html>
