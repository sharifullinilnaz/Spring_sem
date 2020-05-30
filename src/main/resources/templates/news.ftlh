<#include "base.ftlh" />


<#macro content>
    <div class="container-fluid page-container">
        <div class="row">
            <div class="col-11">
                <h1 class="center">Last news</h1>
                </br>
                </br>

                <div class="col-11 offset-2 articles">
                    <#list news as n >
                        <div class="row">
                            <div class="col-5">
                                <img src="${n.photoPath}" class="news-photo">
                            </div>
                            <div class="col-6">
                                <h1>${n.title}</h1>
                                <div class="bordered text-div articles-text">
                                    <div> ${n.text}</div>
                                </div>
                                <div class=row>
                                    <div class="offset-7">
                                        <h6>${n.date}</h6>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <br/><br/>
                    </#list>
                </div>
            </div>
        </div>
    </div>

</#macro>

<@display_page />