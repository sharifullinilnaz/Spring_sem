<#include "base.ftlh" />


<#macro content>
    <div class="container-fluid page-container">
        <div class="row">
            <div class="col-6 offset-3">
                <div class="center round-border row">
                    <div class="col-6">
                        <#if user.photoPath??>
                            <img src="${user.photoPath!}" class="photo">
                        </#if>
                    </div>
                    <div class="col info">
                        <h1>${user.name}</h1>
                        <h3>Year of birth: ${user.year}</h3>
                        <h3>City: ${user.city}</h3>
                        <h3>Nickname: ${user.nickname}</h3>
                        <h3>Name: ${user.name}</h3>
                        <h3>Surname: ${user.surname}</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>

</#macro>

<@display_page />
