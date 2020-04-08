<#include "base.ftlh" />


<#macro content>
    <#import "spring.ftl" as spring />

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
                        <h3><@spring.message 'profile.page.birth.year'/>: ${user.year}</h3>
                        <h3><@spring.message 'profile.page.city'/>: ${user.city}</h3>
                        <h3><@spring.message 'profile.page.nickname'/>: ${user.nickname}</h3>
                        <h3><@spring.message 'profile.page.name'/>: ${user.name}</h3>
                        <h3><@spring.message 'profile.page.surname'/>: ${user.surname}</h3>

                        <form>
                            <button type="submit" class="btn btn-outline-primary" formaction="/editProfile"><@spring.message 'profile.page.edit.profile'/></button>
                        </form>
                            <br />
                            <form>
                                <button type="submit" class="btn btn-outline-primary" formaction="/addArticle"><@spring.message 'profile.page.add.article'/></button>
                            </form>
                        <form>
                            <a type="submit" class="btn btn-outline-primary" href="/articles?id=${user.id}"><@spring.message 'profile.page.go.to.articles'/></a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</#macro>

<@display_page />
