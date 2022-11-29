const validateX = (value) => {
    let correctValues = ["-1", "-2", "-3","0","1", "2", "3", "4", "5"].map(Number);
    if ((value.toString().trim() === "") || isNaN(Number(value))){
        return false;
    }
    const x = parseFloat(value);
    return (correctValues.includes(x));
}

const validateY = (value) => {
    if ((value.toString().trim() === "") || isNaN(Number(value))){
        return false;
    }
    const x = parseFloat(value);
    return !(x < -3 || x > 5);
}

const validateR = (value) => {
    if ((value.toString().trim() === "") || isNaN(Number(value))){
        return false;
    }
    const x = parseFloat(value);
    return !(x < 2 || x > 5);
}
function validate(x, y, r){
    if (!validateX(x)){document.querySelector("#X_error").innerHTML += "X should be inside int[ -1 ... 5]"}
    if (!validateY(y)){document.querySelector("#Y_error").innerHTML += "Y should be between -3 and 5"}
    if (!validateR(r)){ document.querySelector("#R_error").innerHTML += "R should be between 2 and 5"}
    return validateX(x) && validateY(y) && validateR(r);
}

