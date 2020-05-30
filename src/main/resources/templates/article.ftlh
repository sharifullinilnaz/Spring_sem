<#include "base.ftlh" />

<#macro content>

    <div class="container-fluid page-container">
        <div class="row">
            <div class="col-5">
                <img class="photo" src="${article.photoPath!}">
                <div>${article.geolocation}</div>
            </div>
            <div class="col-6">
                <div class="center"><h2>${article.name}</h2></div>
                <div class="article-text bordered text-div">
                    ${article.text}
                </div>
                <div class="right-text">
                    <h6>${article.date}</h6>
                    <a href="/profile/${article.user.getId()}">Author: ${article.user.getNickname()}</a>
                </div>
            </div>
        </div>
        </br>
        <div class="row">
            <div class="col-11">
                <div class="bordered center comments-container">
                    <h2>Comments</h2>
                    <div>
                        <#list comments as c>
                            <div class="row">
                                <div class="col-1 ">
                                    <a class="text-div" href="/profile/${c.user.getId()}">${c.user.getNickname()}</a>
                                    <img src="${c.user.getPhoto()}" class="small-user-photo">
                                    <br/><br/>
                                </div>
                                <div class="col-11">
                                    <br/>
                                        <div class="bordered text-div comment-text">
                                            <div>  ${c.text} </div>
                                        </div>
                                        <div class="right-text">
                                            <h6>${c.date}</h6>
                                        </div>
                                </div>
                            </div>
                        </#list>
                    </div>
                </div>
            </div>
        </div>

        <#if user??>
            <div class="row">
                <div class="col-1 offset-1">
                </div>
                <div class="col-8">
                    <div class="text-div comment-text1">
                        <form method="post" enctype="multipart/form-data">
                            <div class="form-group">
                                <textarea class="form-control" oninput="counter(200)" id="input" name="text" rows="6"></textarea>
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    </div>
                    <div class="right-text">
                        <h6><span id="count">200</span> characters left</h6>
                        <button type="submit" class="btn btn-outline-primary" value="save">Send</button>
                    </div>
                    </form>
                </div>
            </div>
        </#if>

    </div>

</#macro>

<@display_page />