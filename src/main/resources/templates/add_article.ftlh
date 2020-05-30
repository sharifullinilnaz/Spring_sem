<#include "base.ftlh"/>
    <#macro content>
        <#import "spring.ftl" as spring />
        <div class="container-fluid page-container">
            <div class="row">
                <div class="col-6 offset-3">
                    <div class="center round-border">
                        <div class="h1"><@spring.message 'addArticle.page.new.article'/></div>
                        <div class="border-paddings">
                            <form method="post" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label><@spring.message 'addArticle.page.title'/>:</label>
                                    <input type="text" name="name" class="form-control" placeholder="<@spring.message 'addArticle.page.name.of.article'/>">
                                </div>
                                <div class="form-group">
                                    <label><@spring.message 'addArticle.page.geolocation'/>:</label>
                                    <input type="text" name="geolocation" class="form-control" placeholder="<@spring.message 'addArticle.page.geolocation'/>">
                                </div>
                                <div class="form-group">
                                    <label><@spring.message 'addArticle.page.photo'/>:</label>
                                    <input onclick="sendFile()" type="hidden"  disabled="true" class="btn btn-outline-primary" value="Ok">
                                    <input type="file" id="file" class="photo" name="file">
                                </div>
                                <div class="form-group">
                                    <label><@spring.message 'addArticle.page.text'/>:</label>
                                    <textarea class="form-control" rows="10" name="text"></textarea>
                                </div>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                <div class="center">
                                    <button type="submit" class="btn btn-outline-primary" value="save"><@spring.message 'addArticle.page.save'/></button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </#macro>
<@display_page />