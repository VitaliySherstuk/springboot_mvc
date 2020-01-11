<#import "/spring.ftl" as spring/>
<html>
    <head>
        <title>SpringMVC</title>
        <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
            <div class="find_section">
                <h3><@spring.message "inventory.add"/></h3>
                <form method="post" action="/inventory/car" onclick="return true">
                    <input class="find_section_element" id="car_make" name="make" type="text" placeholder="make"/>
                    <input class="find_section_element" id="car_model" name="model" type="text" placeholder="model"/>
                    <input class="find_section_element" id="car_year" name="year" type="text" placeholder="year"/>
                    <input class="find_section_element" id="car_cost" name="cost" type="text" placeholder="cost"/>
                    <input class="button_submit" id="submit" name="submit" type="submit" value="Add" placeholder="submit"/>
                </form>
            </div>

<#if isVisible??>
                <div>
                <h3 style="margin-left: 5%;"><@spring.message "inventory.your"/></h3>
                    <table class="table">
                        <tr>
                            <th></th>
                            <th>Make</th>
                            <th>Model</th>
                            <th>Year</th>
                            <th>Cost</th>
                            <th></th>
                            <th></th>
                        </tr>
                        <#list cars as car>
                            <tr align="center">
                                <#if car.img??>
                                    <td><img src="/photo/${car.img}" alt="car" style="width:40px; height:40px; margin:2%;"></td>
                                <#else>
                                <td></td>
                                </#if>

                                <td>${car.make}</td>
                                <td>${car.model}</td>
                                <td>${car.year}</td>
                                <td>${car.cost}</td>
                                <td>
                                    <form method="get" action="/settings/${car.id}" onclick="return true">
                                        <input class="button_edit" id="submit" name="update" type="submit" value="Update" placeholder="submit"/>
                                    </form>
                                </td>
                                <td>
                                    <form method="get" action="/cars/removed/${car.id}" onclick="return true">
                                        <input class="button_edit" id="submit" name="delete" type="submit" value="Delete" placeholder="submit"/>
                                    </form>
                                </td>
                            </tr>
                        </#list>
                    </table>
                </div>
</#if>
    </body>
</html>