<#include "base.ftlh" />
    <#macro content>
        <div class="container-fluid page-container">
            <div class="row">
                <div class="col-4 offset-4">
                    <div class="center round-border">
                        <div class="h1">Registration</div>
                        <div class="border-paddings">
                            <form method="post" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label>Name:</label>
                                    <input type="text" name="name" oninput="validateRegistration()" id="first-name" class="form-control" placeholder="First name">
                                    <small id="first-name-valid" class="form-text valid"></small>
                                </div>
                                <div class="form-group">
                                    <label>Surname:</label>
                                    <input type="text" name="surname" oninput="validateRegistration()" id="second-name" class="form-control" placeholder="Second name">
                                    <small id="second-name-valid" class="form-text valid"></small>
                                </div>
                                <div class="form-group">
                                    <label>Year:</label>
                                    <input type="text" id="year" class="form-control" oninput="validateRegistration()" id="date" name="year" max="2019-3-11">
                                    <small id="year-valid" class="form-text valid"></small>
                                </div>
                                <div class="form-group">
                                    <label>City:</label>
                                    <input type="text" name="city" class="form-control" id="city" oninput="validateRegistration()" placeholder="City">
                                    <small id="city-valid" class="form-text valid"></small>
                                </div>
                                <div class="form-group">
                                    <label>Email:</label>
                                    <input type="email" name="email" id="email" oninput="validateRegistration()" class="form-control" placeholder="Your email">
                                    <small id="email-valid" class="form-text valid"></small>
                                </div>
                                <div class="form-group">
                                    <label>Nickname:</label>
                                    <input type="text" name="nickname" id="nick" oninput="validateRegistration()" class="form-control" placeholder="Nickname">
                                    <small id="nick-valid" class="form-text valid"></small>
                                </div>
                                <div class="form-group">
                                    <label>Password:</label>
                                    <input type="password" name="password" oninput="validateRegistration()" id="password1" class="form-control" placeholder="Password">
                                    <small id="password1-valid" class="form-text valid"></small>
                                </div>
                                <div class="form-group">
                                    <label>Repeat password :</label>
                                    <input type="password" name="password_again" oninput="validateRegistration()" id="password2" class="form-control" placeholder="Password again">
                                    <small id="password2-valid" class="form-text valid"></small>
                                </div>
                                <div class="form-group">
                                    <label>Photo :</label>
                                    <input type="file" name="photo" oninput="validateRegistration()"  class="form-control" placeholder="Photo">
                                </div>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                <div class="center">
                                    <button type="submit" id="submit" disabled="true" class="btn btn-outline-primary" value="save">Register</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </#macro>

<@display_page />
