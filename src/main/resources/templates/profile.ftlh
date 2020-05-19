<#include "base.ftlh" />


<#macro content>
    <#import "spring.ftl" as spring />

    <div class="container-fluid page-container">
        <div class="row">
            <div class="col-6 offset-3">
                <div class="center round-border row">
                    <div class="col-6">
                        <#if profile_user.photo??>
                            <img src="${profile_user.getPhoto()}" class="photo">
                        </#if>
                    </div>
                    <div class="col info">
                        <h1>${profile_user.name}</h1>
                        <h3><@spring.message 'profile.page.birth.year'/>: ${profile_user.year}</h3>
                        <h3><@spring.message 'profile.page.city'/>: ${profile_user.city}</h3>
                        <h3><@spring.message 'profile.page.nickname'/>: ${profile_user.nickname}</h3>
                        <h3><@spring.message 'profile.page.name'/>: ${profile_user.name}</h3>
                        <h3><@spring.message 'profile.page.surname'/>: ${profile_user.surname}</h3>
                        <#if user.id==profile_user.id>
                        <form>
                            <button type="submit" class="btn btn-outline-primary" formaction="/editProfile"><@spring.message 'profile.page.edit.profile'/></button>
                        </form>
                        <form>
                                <button type="submit" class="btn btn-outline-primary" formaction="/addArticle"><@spring.message 'profile.page.add.article'/></button>
                        </form>
                        </#if>
                        <form>
                            <a type="submit" class="btn btn-outline-primary" href="/articles/${profile_user.id}"><@spring.message 'profile.page.go.to.articles'/></a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</#macro>

<@display_page />
