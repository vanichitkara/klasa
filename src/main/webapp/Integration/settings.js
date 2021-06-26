function loadInfo() {
    let xrh = new XMLHttpRequest();
    xrh.open('GET', '/student/getAllStudents', true);
    xrh.onload = function () {
        let name, email;
        if (this.status === 200) {
            const members = JSON.parse(this.responseText);
            for (let i = members.length - 1; i >= 0; i--) {
                if (members[i].loggedIn === true) {
                    name = members[i].fullName;
                    email = members[i].email;
                    break;
                }
            }
            document.getElementById('set-name').setAttribute('value', name);
            document.getElementById('set-email').setAttribute('value', email);
        }
    }
    xrh.send();
}

loadInfo();

