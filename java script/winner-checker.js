var sum = 0;

function getBox(number) {
    return document.getElementById(number).innerText;

}

function checkForWinner(move) {
    var result = false;
    if (checkRow(0, 1, 2, move) || checkRow(3, 4, 5, move) || checkRow(6, 7, 8, move) ||
        checkRow(0, 3, 6, move) || checkRow(1, 4, 7, move) || checkRow(2, 5, 8, move) ||
        checkRow(0, 4, 8, move) || checkRow(2, 4, 6, move)) {
        result = true;
    }
    return result;
}

function checkRow(a, b, c, move) {
    return  getBox(a) === move && getBox(b) === move && getBox(c) === move;
}

function checkDrawn() {
    sum = 0;
    for (var i = 0; i < 9; i++) {
        if (getBox(i) === "X") {
            sum++;
        } else if (getBox(i) === "O") {
            sum++;
        }
    }
    return sum;
}

function whoWin() {

    if (historyModule.getTimesOWon() > historyModule.getTimesXWon()) {

        alert("Won Player 'O'");
    } else if (historyModule.getTimesOWon() < historyModule.getTimesXWon()) {
        alert("Won Player 'X'");

    } else {
        alert("is Drawn");
    }
}
