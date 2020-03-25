<#include "base.ftlh" />
    <#macro content>
        <div class="container-fluid page-container">
            <div class="row">
                <div class="col-6 offset-3">
                    <div class="round-border center">
                        <h1> Edit profile </h1>
                        <form method="post" enctype="multipart/form-data">
                            <div class="row border-paddings">
                                <div class="col">
                                    <div class="form-group">
                                        <label>Name:</label>
                                        <input type="text" name="name" class="form-control" placeholder="First name">
                                    </div>
                                    <div class="form-group">
                                        <label>Surname:</label>
                                        <input type="text" name="surname" class="form-control" placeholder="Second name">
                                    </div>
                                    <div class="form-group">
                                        <label>City:</label>
                                        <input type="text" name="city" class="form-control" placeholder="City">
                                    </div>
<#--                                    <div class="form-group">-->
<#--                                        <label>Email:</label>-->
<#--                                        <input type="email" name="email" class="form-control" placeholder="Your email">-->
<#--                                    </div>-->
                                    <div class="form-group">
                                        <label>Nickname:</label>
                                        <input type="text" name="nickname" class="form-control" placeholder="Nickname">
                                    </div>
                                    <div class="center">
                                        <button type="submit" class="btn btn-outline-primary" value="save">Save</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </#macro>

<@display_page />