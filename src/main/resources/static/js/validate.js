function validateRegistration() {


    var firstName = $('#first-name');
    var secondName = $('#second-name');
    var email = $('#email');
    var nick = $('#nick');
    var year = $('#year');
    var city = $('#city');
    var password1 = $('#password1');
    var password2 = $('#password2');
    var firstNameValid = $('#first-name-valid');
    var secondNameValid = $('#second-name-valid');
    var emailValid = $('#email-valid');
    var nickValid = $('#nick-valid');
    var yearValid = $('#year-valid');
    var cityValid = $('#city-valid');
    var password1Valid = $('#password1-valid');
    var password2Valid = $('#password2-valid');
    var submit = $('#submit');

    if (validationOfName(firstName, firstNameValid) && validationOfName(secondName, secondNameValid) && validationYear(year, yearValid)  && validationCity(city, cityValid) &&  validationOfEmail(email, emailValid) && validationNick(nick, nickValid) && validationOfPassword1(password1, password1Valid) && validationOfPassword2(password1, password2, password2Valid)) {
        submit.attr('disabled', false);
    } else {
        submit.attr('disabled', true);
    }

}

function validateEditProfile() {


    var firstName = $('#first-name');
    var secondName = $('#second-name');
    var email = $('#email');
    var nick = $('#nick');
    var city = $('#city');
    var firstNameValid = $('#first-name-valid');
    var secondNameValid = $('#second-name-valid');
    var emailValid = $('#email-valid');
    var nickValid = $('#nick-valid');
    var cityValid = $('#city-valid');
    var submit = $('#submit');

    if (validationOfName(firstName, firstNameValid) && validationOfName(secondName, secondNameValid) && validationCity(city, cityValid) &&  validationOfEmail(email, emailValid) && validationNick(nick, nickValid) ) {
        submit.attr('disabled', false);
    } else {
        submit.attr('disabled', true);
    }

}

function validationOfEmail(login, validEmail) {
    var pattern = /^[A-Za-z0-9_-]+@[a-z0-9-]+\.[a-z]{2,6}$/;
    if (login.val().length < 1) {
        validEmail.text("Email can't be null");
        return false;
    } else if (pattern.test(login.val())) {
        validEmail.text("");
        return true;
    } else {
        validEmail.text("Incorrect email");
        return false;
    }
}

function validationOfName(name, nameValid) {
    var name_pattern = /^([A-Z][a-z]+)$/;
    if (name.val().length < 1){
        nameValid.text("Name can't be null");
        return false;
    } else if (name_pattern.test(name.val())) {
        nameValid.text("");
        return true;
    } else {
        nameValid.text("The name should consist only of letters and begin with a capital letter");
        return false;
    }

}

function validationNick(nick, nickValid) {
    var nick_pattern = /^[A-Za-z0-9_]+$/;
    if (nick.val().length < 1) {
        nickValid.text("Nickname can't be null");
        return false;
    } else if (nick_pattern.test(nick.val())) {
        nickValid.text("");
        return true;
    } else {
        nickValid.text("Nickname should contain only letters, numbers and '_'.");
        return false;
    }
}

function validationOfPassword1(password, passwordValid) {
    if (password.val().length <= 7) {
        passwordValid.text("Password must be longer than 7 characters");
        return false;
    } else {
        passwordValid.text("");
        return true;
    }
}

function validationOfPassword2(password1, password2, passwordValid) {
    if (password1.val() !== password2.val()) {
        passwordValid.text("Passwords do not match");
        return false;
    } else {
        passwordValid.text("");
        return true;
    }
}

function validationCity(city, cityValid) {
    if (city.val().length < 1) {
        cityValid.text("City can't be null");
        return false;
    } else {
        cityValid.text("");
        return true;
    }

}

function validationYear(year, yearValid) {
    var nick_pattern = /^(19\d{2})|(20\d{2})$/;
    if (year.val().length < 1) {
        yearValid.text("Year can't be null");
        return false;
    } else if (nick_pattern.test(year.val())) {
        yearValid.text("");
        return true;
    } else {
        yearValid.text(" Year must be from 1900 to 2019");
        return false;
    }
}