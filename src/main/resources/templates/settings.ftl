<#import "/spring.ftl" as spring/>
<html>
    <head>
        <title>SpringMVC</title>
        <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
        <#include "header.ftl">
        <div>
            <table class="table">
                <tr>
                    <th>Make</th>
                    <th>Model</th>
                    <th>Year</th>
                    <th>Cost</th>
                    <th>New cost</th>
                    <th>Upload</th>
                </tr>
                <#list cars as car>
                    <tr align="center">
                        <td>${car.make}</td>
                        <td>${car.model}</td>
                        <td>${car.year}</td>
                        <td>${car.cost}</td>
                        <td>
                            <div class="find_section">
                                <form method="post" action="/settings/${id}/cost" onclick="return true">
                                    <input class="find_section_element" id="car_cost" name="cost" type="text" placeholder="cost"/>
                                    <input class="button_edit" id="submit" name="submit" type="submit" placeholder="submit"/>
                                </form>
                            </div>
                        </td>
                        <td>
                            <form method="post" action="/settings/uploadImg/${car.id}" enctype="multipart/form-data">
                                <input type="file" name="file"/>
                                <input type="submit" value="Upload"/>
                            </form>
                        </td>
                    </tr>
                </#list>
                <#if result??>
                    <tr><td><h6>Car was updated.</h6></td></tr>
                </#if>
            </table>
        </div>
    </body>
</html>
