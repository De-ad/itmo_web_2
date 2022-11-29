let coordinates = {
    x: null,
    y: null,
    r: null
};

function setCoordinates(){
    const X_val = $('#X_value').val();
    const Y_val = $('#Y_value').val();
    const R_val = $('#R_value').val();
    coordinates.x = X_val;
    coordinates.y = Y_val;
    coordinates.r = R_val;
}

function getCoordinates(){
    return coordinates;
}

function setCanvasCoordinates(x, y){
    const R_val = $('#R_value').val();
    coordinates.r = R_val;
    coordinates.y = y;
    coordinates.x = x;
}