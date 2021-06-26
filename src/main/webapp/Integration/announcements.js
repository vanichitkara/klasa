function loadAllAnnouncments() {
    let xrh = new XMLHttpRequest();
    xrh.open('GET', '/announcement/getAllAnnounce', false);
    xrh.onload = function () {
        console.log("Status:");
        console.log(this.status);
        console.log(this.status);
        if (this.status === 200) {
            const data = JSON.parse(this.responseText);
            let output = '';
            for (const i in data) {
                console.log(data[i]);
                output += '<li class="list-group-item"><div class="d-flex media"><div class="media-body"> <div class="d-flex media" style="overflow:visible;"><div></div><div style="overflow:visible;" class="media-body"><div class="row"><div class="col-md-12"><h5></h5><p>';
                output += data[i].announcement;
                output += '<br><br><small class="text-muted">';
                output += data[i].date;
                output += ' at ' + data[i].time.substring(0, 5);
                output += ' by <b>' + data[i].nameOfProfessor + '</b>';
                output += '</small></p></div></div></div></div></div></div></li>';
                // console.log(output);
            }
            document.getElementById('announcementsList').innerHTML = output;
        }
    }
    xrh.send();
}

loadAllAnnouncments();

//SEARCH FILTER
document.getElementById('search-field').addEventListener('keyup', searchList);
function searchList() {
    let search = document.getElementById("search-field").value;
    console.log(search);
    let xrh = new XMLHttpRequest();
    xrh.open('GET', '/announcement/getAll/' + search, false);
    xrh.onload = function () {
        console.log("Status:");
        console.log(this.status);
        console.log(this.status);
        if (this.status === 200) {
            const data = JSON.parse(this.responseText);
            let output = '';
            for (const i in data) {
                console.log(data[i]);
                output += '<li class="list-group-item"><div class="d-flex media"><div class="media-body"> <div class="d-flex media" style="overflow:visible;"><div></div><div style="overflow:visible;" class="media-body"><div class="row" style="width: 797px;"><div class="col-10"><h5></h5><p>';
                output += data[i].announcement;
                output += '<br><br><small class="text-muted">';
                output += data[i].date;
                output += ' at ' + data[i].time.substring(0, 5);
                output += ' by <b>' + data[i].nameOfProfessor + '</b>';
                output += '</small></p></div></div></div></div></div></div></li>';
                // console.log(output);
            }
            document.getElementById('announcementsList').innerHTML = output;
        }
    }
    xrh.send();
}


// {/* <li class="list-group-item">
//     <div class="d-flex media">
//         <div class="media-body">
//             <div class="d-flex media" style="overflow:visible;">
//                 <div></div>
//                 <div style="overflow:visible;" class="media-body">
//                     <div class="row" style="width: 797px;">
//                         <div class="col-10">
//                             <h5></h5>
//                             <p>Assignment-7 added for submission (due on
//                                 28/06/21)<br>
//                                 <small class="text-muted">21/01/21 at 9:00am
//                                 </small>
//                             </p>
//                         </div>
//                     </div>
//                 </div>
//             </div>
//         </div>
//     </div>
// </li> */}