package cz.honza.kotlachy.konzole

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    var line: String
    do {
        println("Napiš něco, 'ko' je konec, 'na' nápověda.")
        line = scanner.nextLine()
        command(line)
    } while (line != "ko")
}

