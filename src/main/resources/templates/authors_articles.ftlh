<#include "base.ftlh" />


<#macro content>

    <div class="container-fluid page-container">
    <div class="row">
        <div class="col-11">
            <#--            <h1 class="center"> ${author.nickname} articles</h1>-->
            </br>
            </br>
            <div class="col-8 offset-2 articles">
                <#list articles as a>
                    <div class="article row">
                        <div class="col-1">
                            <#--                            <img src="${author.photoPath}" class="small-user-photo3">-->
                            <img class="photo" src="${a.photoPath!}">
                        </div>
                        <div class="col-11">
                            <div class=row>
                                <#--                                <a href="/profile?id=${author.id}" class="text-div col-5">${author.nickname}</a> -->
                                <h6 class="text-div col-3">${a.name}</h6>
                            </div>
                            <div class="bordered text-div articles-text">
                                <div> ${a.text}</div>
                            </div>
                            <div class=row>

                                <div class="offset-10">
                                    <a type="submit"  href="/article/${a.id}" class="btn btn-primary top-line-btn to-main-btn">Read</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </#list>
            </div>
        </div>
    </div>

</#macro>

<@display_page />