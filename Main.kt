package tictactoe

import java.util.Scanner

val scanner = Scanner(System.`in`)
var turnX = true
var round = 0
var field = MutableList(3) { MutableList(3) { ' ' } }

fun main() {
    play()
}

fun wins(ch: Char): Boolean {
    return ch == field[0][0] && ch == field[0][1] && ch == field[0][2] ||
            ch == field[1][0] && ch == field[1][1] && ch == field[1][2] ||
            ch == field[2][0] && ch == field[2][1] && ch == field[2][2] ||
            ch == field[0][0] && ch == field[1][0] && ch == field[2][0] ||
            ch == field[0][1] && ch == field[1][1] && ch == field[2][1] ||
            ch == field[0][2] && ch == field[1][2] && ch == field[2][2] ||
            ch == field[0][0] && ch == field[1][1] && ch == field[2][2] ||
            ch == field[2][0] && ch == field[1][1] && ch == field[0][2]
}

fun showField() {
    println("---------")
    println("| ${field[0].joinToString(" ")} |")
    println("| ${field[1].joinToString(" ")} |")
    println("| ${field[2].joinToString(" ")} |")
    println("---------")
}

fun play() {
    showField()
    while (true) {
        val x = scanner.next().first()
        val y = scanner.next().first()
        if (!x.isDigit() || !y.isDigit()) {
            println("You should enter numbers!")
        } else {
            val i = x.digitToInt() - 1
            val j = y.digitToInt() - 1
            if (i !in 0..2 || j !in 0..2) {
                println("Coordinates should be from 1 to 3!")
            } else if (field[i][j] != ' ') {
                println("This cell is occupied! Choose another one!")
            } else {
                val ch = if (turnX) 'X' else 'O'
                field[i][j] = ch
                showField()
                if (wins(ch)) {
                    println("$ch wins")
                    break
                } else {
                    round++
                    if (round < 9) {
                        turnX = !turnX
                    } else {
                        println("Draw")
                        break
                    }
                }
            }
        }
    }
}