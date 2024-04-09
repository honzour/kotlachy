package cz.honza.kotlachy.konzole

import cz.honza.kotlachy.pravidla.data.Pozice
import cz.honza.kotlachy.pravidla.rutiny.generujTahy

fun napoveda() {
    println(
"""
na - nápověda
ko - konec
sa - výpis aktuální pozice
tg - testuj generátor tahů
""")
}

fun testujGenerator() {
    val tahy = generujTahy(Pozice())
    for (i in 0..tahy.size - 1) {
        println("Tah $i. ${tahy[i]}")
    }
}

fun command(line: String) {
    when (line) {
        "sa" -> vypis(Pozice())
        "na" -> napoveda()
        "tg" -> testujGenerator()
    }
}
