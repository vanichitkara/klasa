document.getElementById('loginIntegration').addEventListener('click', signIn);

function signIn() {

    let email = document.getElementById('email').value;
    let password = document.getElementById('password').value;


    xrh = new XMLHttpRequest();
    let query = '/student/signin/' + email + '/' + password;
    console.log(query);

    xrh.onload = function () {
        console.log("status: ");
        console.log(this.status);
    }
    xrh.open('GET', query, true);

    xrh.send();
}