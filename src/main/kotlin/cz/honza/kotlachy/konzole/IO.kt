package cz.honza.kotlachy.konzole

import cz.honza.kotlachy.pravidla.data.ZAKLADNI_POSTAVENI
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
    val tahy = generujTahy(ZAKLADNI_POSTAVENI)
    for (i in 0..tahy.size - 1) {
        println("Tah $i. ${tahy[i]}")
    }
}

fun command(line: String) {
    when (line) {
        "sa" -> vypis(ZAKLADNI_POSTAVENI)
        "na" -> napoveda()
        "tg" -> testujGenerator()
    }
}
