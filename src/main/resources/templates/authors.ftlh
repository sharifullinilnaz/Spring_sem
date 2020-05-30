<#include "baseSearch.ftlh" />

<#macro content>
    <script type="text/javascript">
        function search(page) {
            var p = document.getElementById("countOnPage");
            var size = p.options[p.selectedIndex].value;
            if ($("#pattern").val().length > 1) {
                $.ajax({
                    url: "/authors/search",
                    data: {
                        "query": $("#pattern").val(),
                        "page": page - 1,
                        "size": size
                    },
                    dataType: "json",
                    success: function (msg) {
                        if (msg.users.length > 0) {
                            $("#response").html("");
                            $("#pageNumber").html("");
                            for (var i = 0; i < msg.users.length; i++) {
                                $("#response").append("<tr>\n" +
                                    "<th scope=\"row\">"+ msg.users[i].city + "</th>\n" +
                                    "<td>" + msg.users[i].nickname +"</td>\n" +
                                    "<td>" + msg.users[i].name +"</td>\n" +
                                    "<td><form>\n" +
                                    "<input type=\"button\" class=\"btn btn-primary top-line-btn\" value=\"Open Profile\" onClick='location.href=\"/profile/"+ msg.users[i].id +"\"'>\n" +
                                    "</form></td>\n" +
                                    "</tr>");
                            }
                            for (var i = 1; i <= msg.count; i++) {
                                $("#pageNumber").append("<button  style='margin-left: 5px' type=\"submit\" class=\"btn btn-outline-primary\" onclick=\"search(" + i + ")\"> " + i + "</button>");
                            }
                        } else {
                            $("#response").html("Поиск не дал результатов");
                        }
                    }
                })
            }
        }
    </script>
    <div class="container-fluid page-container">
        <div class="row">
            <div class="col-11">
                <h1 class="center">Поиск пользователя</h1>
                </br>
                </br>
                <div class="col-5 offset-4">
                    <div class="form-group">
                        <input type="text" name="name" id="pattern" class="form-control" placeholder="Введите имя">
                    </div>
                    <h4>Количество ответов на странице</h4>
                    <div class="form-group">
                        <select class="custom-select custom-select-sm" id="countOnPage" name="size">
                            <option selected value=2>2</option>
                            <option value=3>3</option>
                            <option value=5>5</option>
                            <option value=10>10</option>
                        </select>
                    </div>
                    <div class="center">
                        <button style="width: 50%" type="submit" class="btn btn-outline-primary" onclick="search(1)">Поиск</button>
                    </div>
                </div>
                </br>
                <div class="row">
                    <div class="col-6 offset-3">
                        <table class="table table-bordered">
                            <thead class="thead-default">
                            <tr class="grey-background">
                                <th>Город</th>
                                <th>Никнейм</th>
                                <th>Имя</th>
                                <th>Ссылка на профиль</th>
                            </tr>
                            </thead>
                            <tbody id="response">
                            </tbody>
                        </table>
                        <div id="pageNumber">
                            <button  type="submit" class="btn btn-outline-primary" onclick="search(1)">1</button>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</#macro>

<@display_page />