<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script type="application/javascript" src="/js/jquery-3.4.1.min.js"></script>
    <title>Document</title>
</head>
<body>
<script type="application/javascript">
    function f() {
        $.ajax({
            url: "/sms/send",
            data: {"phone": $("#query").val()},

            success: function (data) {
                if (data.phone.length === 11) {
                    $("#result").html("");
                    $("#result").append("We send you sms");
                } else {
                    $("#result").html("Enter a valid phone number");
                }
            }
        })
    }
</script>
<input type="text" id="query" name="query">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="button" value="send" onclick="f()">
<h2 id="result"></h2>

</body>
</html>