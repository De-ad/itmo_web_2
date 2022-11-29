function sendFormRequest(){
    cleanCanvas();
    draw();
    setCoordinates();
    sendRequest(getCoordinates());
}

function sendCanvasRequest(coordinates){
    cleanCanvas();
    draw();
    cleanError();
    const X_val = coordinates.x;
    const Y_val = coordinates.y;
    const R_val = coordinates.r;
    const canvas = document.getElementById("plot");
    const ctx = canvas.getContext('2d');
    if (validate(X_val, Y_val, R_val)){
        {
            $.ajax({
                url: "controller",
                method: "POST",
                data: {'X_val': X_val, "Y_val" : Y_val, "R_val": R_val},
                success: function (Json) {
                    document.querySelector('#table > tbody').innerHTML += addRow(Json);
                }
            });
        }
    }
    else{
        console.log("validation failed");
    }
}

function sendRequest(coordinates){
    cleanError();
    const X_val = coordinates.x;
    const Y_val = coordinates.y;
    const R_val = coordinates.r;
    const canvas = document.getElementById("plot");
    const ctx = canvas.getContext('2d');
    if (validate(X_val, Y_val, R_val)){
        drawDot(X_val, Y_val, R_val, ctx);
        {
            $.ajax({
                url: "controller",
                method: "POST",
                data: {'X_val': X_val, "Y_val" : Y_val, "R_val": R_val},
                success: function (Json) {
                    document.querySelector('#table > tbody').innerHTML += addRow(Json);
                }
            });
        }
    }
    else{
        console.log("validation failed");
    }
}
function cleanContext(){
    $.ajax({
        url: "controller",
        method: "POST",
        data: {"context": "clean" },
        success: function () {
            console.log("Context was cleaned");
        }
    });
}

function cleanError(){
    document.querySelector("#X_error").innerHTML ="";
    document.querySelector("#Y_error").innerHTML ="";
    document.querySelector("#R_error").innerHTML ="";
}

function clean(){
    document.querySelector('#table > tbody').innerHTML = "";
    const canvas = document.getElementById("plot");
    const ctx = canvas.getContext('2d');
    cleanContext();
    ctx.clearRect(0, 0, width, height);
    draw();
}

