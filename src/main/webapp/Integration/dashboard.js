function setCalendarOnclicks() {
    let dateList = document.getElementById("dateList");
    let children = dateList.children;
    for (let i = 2; i < children.length; i++) {
        // console.log(children[i]);
        children[i].setAttribute("onclick", "loadDataOnTop(" + (i - 1) + ")");
    }
}

function loadDataOnTop(date) {

    document.getElementById("dateOfCalendar").innerHTML = date;

    console.log(date);
    let events = document.getElementById("listOfEventsOnTop");
    events.innerHTML = '';

    let requestAss = new XMLHttpRequest();
    requestAss.open('GET', '/getAllByDate/' + date, false);

    let requestRes = new XMLHttpRequest();
    requestRes.open('GET', '/resource/getAllByDate/' + date, false);

    let requestAno = new XMLHttpRequest();
    requestAno.open('GET', '/announcement/getAllByDate/' + date, false);

    requestAss.onload = function () {
        console.log("STATUS ASS");
        console.log(this.status);
        let assigns = JSON.parse(this.responseText);
        if (assigns.length == 0) return;
        let ass = '';
        for (const i in assigns) {
            ass = assigns[i].title;
        }
        console.log(ass);
        let timelink = document.createElement("ul");
        timelink.classList.add("list-inline");
        let time = document.createElement("li");
        time.classList.add("list-inline-item");
        let timelogo = document.createElement("i");
        timelogo.classList.add("fa");
        timelogo.classList.add("fa-clock-o");
        timelogo.setAttribute("aria-hidden", "true");

        let timedata = document.createTextNode(" 11:59");

        let body = document.createElement("p");
        let due = document.createTextNode("Assignment due:");
        let bold = document.createElement("b");
        let newline = document.createElement("br");
        let newline1 = document.createElement("br");
        let newline2 = document.createElement("br");

        let title = document.createTextNode(ass);

        // let white = document.createElement("p");
        // white.appendChild(document.createTextNode("&nbsp;"));

        events.appendChild(timelink);
        timelink.appendChild(time);
        time.appendChild(timelogo);
        // time.appendChild(white);
        // time.appendChild(document.createTextNode("&nbsp;"))
        time.appendChild(timedata);
        events.appendChild(body);
        body.appendChild(bold);
        bold.appendChild(due);
        body.appendChild(newline);
        body.appendChild(title);
        // body.appendChild(newline1);
        // body.appendChild(newline2);

    }

    requestAno.onload = function () {
        console.log("STATUS ANO");
        console.log(this.status);
        let annous = JSON.parse(this.responseText);
        if (annous.length == 0) return;
        let ann = '';
        let timeof = '';
        let prof = '';
        for (const i in annous) {
            ann = annous[i].announcement;
            timeof = annous[i].time;
            prof = annous[i].nameOfProfessor;
        }
        console.log(ann, timeof, prof);
        let timelink = document.createElement("ul");
        timelink.classList.add("list-inline");
        let time = document.createElement("li");
        time.classList.add("list-inline-item");
        let timelogo = document.createElement("i");
        timelogo.classList.add("fa");
        timelogo.classList.add("fa-clock-o");
        timelogo.setAttribute("aria-hidden", "true");

        let timedata = document.createTextNode(" " + timeof.substring(0, 5));

        let body = document.createElement("p");
        let bold = document.createElement("b");
        let due = document.createTextNode("Announcement ");
        let by = document.createTextNode("by ");
        let bold1 = document.createElement("b");
        let profname = document.createTextNode(prof);
        let newline = document.createElement("br");
        let title = document.createTextNode(ann);

        // let newline1 = document.createElement("br");
        // let newline2 = document.createElement("br");


        events.appendChild(timelink);
        timelink.appendChild(time);
        time.appendChild(timelogo);
        time.appendChild(timedata);
        events.appendChild(body);
        body.appendChild(bold);
        bold.appendChild(due);
        body.appendChild(by);
        body.appendChild(bold1);
        bold1.appendChild(profname);
        body.appendChild(newline);
        body.appendChild(title);
        // body.appendChild(newline1);
        // body.appendChild(newline2);

    }

    requestRes.onload = function () {
        console.log("STATUS RESO");
        console.log(this.status);
        let res = JSON.parse(this.responseText);
        if (res.length === 0) return;
        let reso = '';
        let timeof = '';
        let link = '';
        for (const i in res) {
            reso = res[i].resource;
            timeof = res[i].time;
            link = res[i].nameOfProfessor;
        }
        console.log(reso, timeof, link);
        let timelink = document.createElement("ul");
        timelink.classList.add("list-inline");
        let time = document.createElement("li");
        time.classList.add("list-inline-item");
        let timelogo = document.createElement("i");
        timelogo.classList.add("fa");
        timelogo.classList.add("fa-location-arrow");
        timelogo.setAttribute("aria-hidden", "true");


        let timedata = document.createTextNode(" " + link);

        let body = document.createElement("p");
        let bold = document.createElement("b");
        let due = document.createTextNode("New resource added");
        let newline = document.createElement("br");
        let title = document.createTextNode(reso);

        let timeq = document.createElement("li");
        timeq.classList.add("list-inline-item");
        let timelogoq = document.createElement("i");
        timelogoq.classList.add("fa");
        timelogoq.classList.add("fa-clock-o");
        timelogoq.setAttribute("aria-hidden", "true");

        let timedataq = document.createTextNode(" " + timeof.substring(0, 5));

        // let newline1 = document.createElement("br");
        // let newline2 = document.createElement("br");


        events.appendChild(timelink);
        timelink.appendChild(timeq);
        timeq.appendChild(timelogoq);
        timeq.appendChild(timedataq);
        timelink.appendChild(time);
        time.appendChild(timelogo);
        time.appendChild(timedata);
        events.appendChild(body);
        body.appendChild(bold);
        bold.appendChild(due);
        // body.appendChild(by);
        // body.appendChild(bold1);
        // bold1.appendChild(profname);
        body.appendChild(newline);
        body.appendChild(title);
    }

    requestAno.send();
    requestRes.send();
    requestAss.send();

}

setCalendarOnclicks();
let date_today = new Date();
loadDataOnTop(date_today.getDate());