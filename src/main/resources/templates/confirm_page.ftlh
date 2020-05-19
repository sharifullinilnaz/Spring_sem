<#include "base.ftlh" />


<#macro content>
    <div class="container-fluid page-container">
        <div class="row">
            <div class="col-11" style="margin-top: 15%">
                <#if isConfirmed == true>
                    <h1 class="center">Подтверждено!</h1>
                <#else>
                    <h1 class="center">Что-то пошло не так(((</h1>
                </#if>

            </div>
        </div>
    </div>


</#macro>

<@display_page />
