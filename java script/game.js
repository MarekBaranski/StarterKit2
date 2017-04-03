var player;
var play = 1;
str = '';
var start = 0;
var move;
var pointsO = 0;
var pointsX = 0;
var drawn = 0;

function checkPlayer() {
    str = '';
    var checks = document.getElementsByName('player');

    for (i = 0; i < 2; i++) {
        if (checks[i].checked === true) {

            str += checks[i].value + "";

        }

    }

    setInfo("zaczyna player: " + str);
    document.turn = str;
    return str;

}

function startGame() {
    setInfo("first choose sign and press 'Start Game'");
    for (var i = 0; i < 9; i++) {
        clearBox(i);
    }

    sum = 0;
    //  clearChecked();

    checkPlayer();


    if (str === "O") {

        document.turn = "O";

    } else {
        document.turn = "X";
    }
    document.winner = null;


}


function nextMove(field) {
    if (document.winner !== null) {

        alert(document.winner + " already won the game!");
    } else if (field.innerText === "") {
        field.innerText = document.turn;
        switchTurn();
    } else {
        alert("That field is already used!");
    }


}


function switchTurn() {

    checkDrawn();
    if (checkForWinner(document.turn)) {
        alert("Congratulations, " + document.turn + "! You win");
        document.winner = document.turn;
        if (document.winner === "O") {
            historyModule.oWon();
            document.getElementById("scoreO").innerHTML = "Score for <b>'O'</b>: " + historyModule.getTimesOWon();
        } else {
            historyModule.xWon();
            document.getElementById("scoreX").innerHTML = "Score for <b>'X'</b>: " + historyModule.getTimesXWon();
        }
    } else if (sum === 9) {

        alert("Drawn!");
        historyModule.wasDraw();
        document.getElementById("drawn").innerHTML = "Number of <b>'Drawn'</b>: " + historyModule.getTimesWasDraw();

    } else if (document.turn === "X") {
        document.turn = "O";
        setInfo("Now " + document.turn + " turn!");
    } else {
        document.turn = "X";
        setInfo("Now " + document.turn + " turn!");
    }

}

function setInfo(inf) {
    document.getElementById('info').innerText = inf;

}

function clearBox(number) {
    document.getElementById(number).innerText = null;

}

function clearChecked() {
    var radioFalse = document.getElementsByName('player');

    for (i = 0; i < 2; i++) {
        if (radioFalse[i].checked === true) {

            radioFalse[i].checked = false;

        }

    }
}
