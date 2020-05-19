<#include "base.ftlh" />
    <#macro content>
        <style>
            #name, #city, #surname, #email, #nickname {
                width: 100%;
            }
        </style>
        <div class="container-fluid page-container">
            <div class="row">
                <div class="col-6 offset-3">
                    <div class="round-border center">
                        <h1> Edit profile </h1>
                        <@spring.bind "profileForm"/>
                        <form action="/editProfile" method="post" enctype="multipart/form-data">
                            <div class="row border-paddings">
                                <div class="col">
                                    <div class="form-group">
                                        <label>Name:</label>
                                        <@spring.formInput "profileForm.name", "id='name' "/>
                                        <@spring.showErrors "<br>","error"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Email:</label>
                                        <@spring.formInput "profileForm.email", "id='email' "/>
                                        <@spring.showErrors "<br>","error"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Surname:</label>
                                        <@spring.formInput "profileForm.surname", "id='surname' "/>
                                        <@spring.showErrors "<br>","error"/>
                                    </div>
                                    <div class="form-group">
                                        <label>City:</label>
                                        <@spring.formInput "profileForm.city", "id='city' "/>
                                        <@spring.showErrors "<br>","error"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Nickname:</label>
                                        <@spring.formInput "profileForm.nickname", "id='nickname' "/>
                                        <@spring.showErrors "<br>","error"/>
                                    </div>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                    <div class="center">
                                        <button id="submit" type="submit" class="btn btn-outline-primary" value="save">Save</button>
                                    </div>
<#--                                    <div class="form-group">-->
<#--                                        <label>Name:</label>-->
<#--                                        <input oninput="validateEditProfile()" id="first-name" type="text" name="name" class="form-control" placeholder="First name" value="${user.getName()}">-->
<#--                                        <small id="first-name-valid" class="form-text valid"></small>-->
<#--                                    </div>-->
<#--                                    <div class="form-group">-->
<#--                                        <label>Surname:</label>-->
<#--                                        <input oninput="validateEditProfile()" id="second-name" type="text" name="surname" class="form-control" placeholder="Second name" value="${user.getSurname()}">-->
<#--                                        <small id="second-name-valid" class="form-text valid"></small>-->
<#--                                    </div>-->
<#--                                    <div class="form-group">-->
<#--                                        <label>City:</label>-->
<#--                                        <input id="city" oninput="validateEditProfile()" type="text" name="city" class="form-control" placeholder="City" value="${user.getCity()}">-->
<#--                                        <small id="city-valid" class="form-text valid"></small>-->
<#--                                    </div>-->
<#--                                    <div class="form-group">-->
<#--                                        <label>Email:</label>-->
<#--                                        <input id="email" oninput="validateEditProfile()" type="email" name="email" class="form-control" placeholder="Your email" value="${user.getEmail()}">-->
<#--                                        <small id="email-valid" class="form-text valid"></small>-->
<#--                                    </div>-->
<#--                                    <div class="form-group">-->
<#--                                        <label>Nickname:</label>-->
<#--                                        <input id="nick" oninput="validateEditProfile()" type="text" name="nickname" class="form-control" placeholder="Nickname" value="${user.getNickname()}">-->
<#--                                        <small id="nick-valid" class="form-text valid"></small>-->
<#--                                    </div>-->
<#--                                    <div class="center">-->
<#--                                        <button id="submit" type="submit" class="btn btn-outline-primary" value="save">Save</button>-->
<#--                                    </div>-->

                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>


    </#macro>

<@display_page />