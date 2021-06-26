document.getElementById('createAccount').addEventListener('click', createNewAccount);

function createNewAccount() {
    let name = document.getElementById('name').value;
    let email = document.getElementById('email').value;
    let password = document.getElementById('password').value;

    let param = JSON.stringify({
        "fullName": name,
        "email": email,
        "password": password
        // "isLoggedIn": true
    });

    xrh = new XMLHttpRequest();
    xrh.open('POST', '/student/add', true);
    xrh.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

    xrh.onload = function () {
        console.log("status: ");
        console.log(this.status);
        if (this.status === 201) {
            console.log("successfully created a new account");
            // window.location.href = "./dashboard.html";
        }
    };

    xrh.send(param);
}
