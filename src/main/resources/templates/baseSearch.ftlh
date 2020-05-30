<#macro content></#macro>

<#macro display_page>
    <html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="/css/mystyle.css" rel="stylesheet" type="text/css">
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/bootstrap.bundle.js"></script>
        <script type="application/javascript" src="/js/jquery-3.4.1.min.js"></script>
        <title> TKB </title>

    </head>
    <#import "spring.ftl" as spring />
    <body>
    <div class="container-fluid top-line-container" >
        <div class="row">
            <div class="col-1">
                <img src="/photos/logo.png" class="logo">
            </div>
            <div class="col-2 offset-8">
                <div>
                    <form>
                        <input type="button" class="btn btn-primary top-line-btn" value="Main" onClick='location.href="/articles"'>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <@content />
    </body>
    </html>
</#macro>