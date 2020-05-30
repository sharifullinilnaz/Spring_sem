<#include "baseSearch.ftlh" />

<#macro content>
<script type="application/javascript" xmlns="http://www.w3.org/1999/html">
    function f() {
        if ($("#query").val().length === 11) {
            $("#result").html("");
            $("#result").append("We send you sms");
        } else {
            $("#result").html("Enter a valid phone number");
        }
        $.ajax({
            url: "/sms/send",
            data: {"phone": $("#query").val()},

            success: function (data) {

            }
        })
    }
</script>
<div class="container-fluid page-container">
    <div class="row">
        <div class="col-11">
            <h1 class="center">Узнать роль своей записи через номер телефона</h1>
            </br>
            </br>
            <div class="col-5 offset-4">
                <div class="form-group">
                    <input class="form-control" type="text" id="query" name="query">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    </br>
                    <button class="btn btn-outline-primary" value="send" onclick="f()">Отправить</button>
                    <h2 id="result"></h2>
                </div>
            </div>
        </div>
    </div>
</div>


</#macro>

<@display_page />