<#include "base.ftlh" />


<#macro content>
    <div class="container-fluid page-container">
        <div class="row">
            <div class="col-6 offset-3">
                <div class="center round-border row">
                    <div class="col-6">
                        <#if user.photo??>
                            <img src="${user.getPhoto()}" class="photo">
                        </#if>
                    </div>
                    <div class="col info">
                        <h1>${user.name}</h1>
                        <h3>Year of birth: ${user.year}</h3>
                        <h3>City: ${user.city}</h3>
                        <h3>Nickname: ${user.nickname}</h3>
                        <h3>Name: ${user.name}</h3>
                        <h3>Surname: ${user.surname}</h3>

                        <form>
                            <button type="submit" class="btn btn-outline-primary" formaction="/editProfile">Edit profile</button>
                        </form>
                            <br />
                            <form>
                                <button type="submit" class="btn btn-outline-primary" formaction="/addArticle">Add article</button>
                            </form>
                        <form>
                            <a type="submit" class="btn btn-outline-primary" href="/articles?id=${user.id}">Go to articles</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</#macro>

<@display_page />
