<#macro content></#macro>

<#macro display_page>
    <html  lang="en" >
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="/css/mystyle.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
        <script type="text/javascript" src="/js/validate.js" charset="utf-8" lang="en"></script>
        <script src="/js/bootstrap.min.js"></script>
        <script src="/js/bootstrap.bundle.js"></script>
        <script type="text/javascript" src="/js/counter.js"></script>

        <title> TKB </title>
    </head>

    <script>
        function sendFile() {
            let formData = new FormData();
            let files = ($('#file'))[0]['files'];
            [].forEach.call(files, function (file, i, files) {
                formData.append("file", file);
            });

            $.ajax({
                type: "POST",
                url: "/files",
                data: formData,
                processData: false,
                contentType: false
            })
                .done(function (response) {
                    let fileUrl = 'http://localhost/files/' + response;
                })
                .fail(function () {
                    alert('Error')
                });
        }
    </script>

    <body>
    <div class="container-fluid top-line-container" >
        <div class="row">
            <div class="col-1">
                <img src="/photos/logo.png" class="logo">
            </div>
            <div class="col-2 offset-8">
                <div class="dropdown">
                    <button type="button" class="btn btn-primary dropdown-toggle top-line-btn" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Menu</button>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="/articles">Articles</a>
                        <a class="dropdown-item" href="mailto:89172610217ilnaz2000@mail.ru">Write support</a>
                        <a class="dropdown-item" href="/news">News</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <@content />
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>

    </html>
</#macro>