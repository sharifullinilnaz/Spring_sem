<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/mystyle.css" type="text/css">
    <script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="/js/validate.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/bootstrap.bundle.js"></script>
    <title> TKB </title>
</head>

<body>
<#import "spring.ftl" as spring />
<div class="container-fluid top-line-container">
    <div class="row">
        <div class="col-1 offset-8">
            <form method="GET" action="/signUp">
                <button type="submit" class="btn btn-primary top-line-btn"><@spring.message 'signIn.page.registration.button'/></button>
            </form>
        </div>
        <div class="col-1 ">
            <form method="GET" action="/articles">
                <button type="submit" class="btn btn-primary top-line-btn"><@spring.message 'signIn.page.main.button'/></button>
            </form>
        </div>
        <div class="col-2">
            <div class="dropdown">
                <button type="button" class="btn btn-primary dropdown-toggle top-line-btn" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><@spring.message 'signIn.page.enter.button'/></button>
                <div class="dropdown-menu">
                    <form method="post" action="" enctype="multipart/form-data">
                        <div class="form-group">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                            <label>Email:</label>
                            <input type="text"  id="login" class="form-control" name="email" placeholder="<@spring.message 'signIn.page.enter.email'/>">
                        </div>
                        <div class="form-group">
                            <label><@spring.message 'signIn.page.password'/>:</label>
                            <input type="password"  id="password"  class="form-control" name="password" placeholder="<@spring.message 'signIn.page.password'/>">
                        </div>
                        <label>
                            <input type="checkbox" name="remember-me" checked><@spring.message 'signIn.page.remember.me'/>
                        </label>
                        <button type="submit" id="submit" value="save" class="btn btn-outline-primary"><@spring.message 'signIn.page.enter.button'/></button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container-fluid page-container">
    <div class="row">
        <div class="col-5">
            <img src="/photos/logo.png" id="main-page-image">
        </div>
        <div class="col-6">
            <div class="h1 center">Tourist knowledge box</div>
            <div class="text-div"><@spring.message 'signIn.page.description'/></div>
            <br/>
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="/photos/carousel-1.jpg" class="d-block w-100">
                    </div>
                    <div class="carousel-item">
                        <img src="/photos/carousel-2.jpg" class="d-block w-100">
                    </div>
                    <div class="carousel-item">
                        <img src="/photos/carousel-3.jpg" class="d-block w-100">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>


    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>

</html>
