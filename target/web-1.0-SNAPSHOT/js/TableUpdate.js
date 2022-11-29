
function addRow(str){
    const json = JSON.parse(JSON.stringify(str));
    let x = "<td>" + json.x + "</td>";
    let y = "<td>" + json.y + "</td>";
    let r = "<td>" + json.r + "</td>";
    let result = "<td>" + json.result + "</td>";
    let currentTime = "<td>" + json.currentTime + "</td>";
    let executionTime = "<td>" + json.executionTime + "</td>";
    return "<tr>" + x + y + r + result + currentTime + executionTime + "</tr>";
}