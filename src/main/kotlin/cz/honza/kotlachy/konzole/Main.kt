package cz.honza.kotlachy.konzole

import cz.honza.kotlachy.pravidla.data.Uloha
import java.util.Scanner

fun main() {
    val uloha = Uloha()
    val scanner = Scanner(System.`in`)
    var line: String
    do {
        println("Napiš něco, 'ko' je konec, 'na' nápověda.")
        line = scanner.nextLine()
        command(line, uloha)
    } while (line != "ko")
}
