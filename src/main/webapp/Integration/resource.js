function loadResource() {
    console.log("function runs")
    let request = new XMLHttpRequest();
    request.open('GET', '/resource/getAll', false);

    request.onload = function () {
        console.log("STATUS");
        console.log(this.status);
        let data = JSON.parse(this.responseText);
        let output = '';
        for (const i in data) {
            console.log(data[i]);
            output += '<tr><td>' + data[i].sno + '</td><td>' + data[i].resource + '</td><td>' + data[i].date + '</td><td><a href=' + data[i].nameOfProfessor + '>' + data[i].nameOfProfessor + '</a></td></tr>'

        }
        document.getElementById('resourceList').innerHTML = output;
    }
    request.send();
}

loadResource();


//SEARCH FILTER
document.getElementById('search-field').addEventListener('keyup', searchList);
function searchList() {
    let search = document.getElementById("search-field").value;
    console.log(search);
    let request = new XMLHttpRequest();
    request.open('GET', '/resource/getAll/' + search, false);

    request.onload = function () {
        let data = JSON.parse(this.responseText);
        let output = '';
        for (const i in data) {
            console.log(data[i]);
            output += '<tr><td>' + data[i].sno + '</td><td>' + data[i].resource + '</td><td>' + data[i].date + '</td><td><a href=' + data[i].nameOfProfessor + '>' + data[i].nameOfProfessor + '</a></td></tr>'

        }
        document.getElementById('resourceList').innerHTML = output;
    }
    request.send();
}



//
//<tr>
//                                            <td>1</td>
//                                            <td>Course Book</td>
//                                            <td>24/06/21</td>
//                                            <td><a href="#">Course Book</a></td>
//                                        </tr>