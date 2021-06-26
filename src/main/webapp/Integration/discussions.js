//GET THE STUDENT THAT IS CURRENTLY LOGGED IN
function getLoggedInStudent(){
    return new Promise( function (resolve, reject) {
        var xrh = new XMLHttpRequest();
        xrh.open('GET', '/student/getAllStudents', true);
        xrh.onload = function () {
            let output= '';
            if (this.status === 200) {
                const members = JSON.parse(this.responseText);
                for (let i = members.length - 1; i >= 0; i--) {
                    if (members[i].loggedIn === true) {
                        output = members[i].fullName;
                        break;
                    }
                }
            }
            resolve(output);
        }
        xrh.timeout = 250;
        xrh.send();
    });
}

//SHOW THE MESSAGE
function loadMessages() {
    getLoggedInStudent().then(nameOfSender => {
        var xrh = new XMLHttpRequest();
        let search = document.getElementById("search-field");
        xrh.open('GET', '/discussions/getAll', true);
        xrh.onload = function () {
            if (this.status === 200) {
                const members = JSON.parse(this.responseText);

                let output = '';
                for(let i = members.length - 1; i >= 0; i--) {
                    output +=
                        '<div class="row"">\n' +
                        '<div class="col">\n' +
                        '<ul class="list-group" id="list-discussion">\n' +
                        /*'<li class="list-group-item" style="margin: 5px 5px 0px 5px;">\n' +
                        '<div class="d-flex media">\n' +
                        '<div></div>\n' +
                        '<div class="media-body">\n' +
                        '<div class="d-flex media" style="overflow:visible;">\n' +
                        '<div></div>\n' +
                        '<div style="overflow:visible;" class="media-body">\n' +
                        '<div class="row" style="width: 787px;">\n' +
                        '<div class="col-10" style="width: 650px;">\n' +
                        '<h5></h5><label class="form-label">Priyasha</label>\n' +
                        '<p style="width: 500px;">I agree<br>\n' +
                        '<small class="text-muted">' + members[i].date + ' at ' +  members[i].time + '</small></p>\n' +
                        '</div>\n' +
                        '</div>\n' +
                        '</div>\n' +
                        '</div>\n' +
                        '</div>\n' +
                        '</div>\n' +
                        '</li>\n' +*/
                        '<li class="list-group-item" style="margin: 0px 5px;border-style: solid;" id="the-messages"><a><label class="form-label">' + nameOfSender + '</label>\n' +
                        '<div class="d-flex media">\n' +
                        '<div></div>\n' +
                        '<div class="media-body">\n' +
                        '<div class="d-flex media" style="overflow:visible;">\n' +
                        '<div></div>\n' +
                        '<div style="overflow:visible;" class="media-body">\n' +
                        '<div class="row">\n' +
                        '<div class="col-md-12">\n' +
                        '<p>' + members[i].input + '<br>\n' +
                        '<small class="text-muted">' + members[i].date + ' at ' +  members[i].time + '</small></p>\n' +
                        '</div>\n' +
                        '</div>\n' +
                        '</div>\n' +
                        '</div>\n' +
                        '</div>\n' +
                        '</div>\n' +
                        '</a></li>\n' +
                        '</ul>\n' +
                        '</div>\n' +
                        '</div>'
                }


                document.getElementById('message-to-send').innerHTML = output;
            }
        }
        xrh.send();
    });
}

loadMessages();

//POSTING NEW MESSAGES TO DB
document.getElementById('sendInput').addEventListener('click', addNewMessage);
function addNewMessage() {
    let input = document.getElementById('send-message').value;
    let xrh = new XMLHttpRequest();
    xrh.open('POST', '/discussions/addMessage', true);
    xrh.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    let params = JSON.stringify({
        "input": input
    });
    document.getElementById('send-message').value='';
    console.log(params);
    xrh.send(params);
    loadMessages();
}


//SEARCH FILTER
document.getElementById('search-field').addEventListener('keyup', searchList);
function searchList() {
    let xrh = new XMLHttpRequest();
    let search = document.getElementById("search-field").value;
    console.log(search);
    xrh.open('GET', '/discussions/getAll/' + search, true);
    getLoggedInStudent().then(nameOfSender => {
        xrh.onload = function () {
            if (this.status === 200) {
                const members = JSON.parse(this.responseText);

                let output = '';
                for(let i = members.length - 1; i >= 0; i--) {
                    output +=
                        '<div class="row" onload="scrollDown()">\n' +
                        '<div class="col">\n' +
                        '<ul class="list-group" id="list-discussion">\n' +
                        '<li class="list-group-item" style="margin: 0px 5px;border-style: solid;" id="the-messages"><a><label class="form-label">' + nameOfSender + '</label>\n' +
                        '<div class="d-flex media">\n' +
                        '<div></div>\n' +
                        '<div class="media-body">\n' +
                        '<div class="d-flex media" style="overflow:visible;">\n' +
                        '<div></div>\n' +
                        '<div style="overflow:visible;" class="media-body">\n' +
                        '<div class="row">\n' +
                        '<div class="col-md-12">\n' +
                        '<p>' + members[i].input + '<br>\n' +
                        '<small class="text-muted">' + members[i].date + ' at ' +  members[i].time + '</small></p>\n' +
                        '</div>\n' +
                        '</div>\n' +
                        '</div>\n' +
                        '</div>\n' +
                        '</div>\n' +
                        '</div>\n' +
                        '</a></li>\n' +
                        '</ul>\n' +
                        '</div>\n' +
                        '</div>'
                }


                document.getElementById('message-to-send').innerHTML = output;
            }
        }
        xrh.send();
    });
}
