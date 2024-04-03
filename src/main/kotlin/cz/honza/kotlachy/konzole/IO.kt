package cz.honza.kotlachy.konzole

import cz.honza.kotlachy.pravidla.data.ZAKLADNI_POSTAVENI

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

}

fun command(line: String) {
    when (line) {
        "sa" -> vypis(ZAKLADNI_POSTAVENI)
        "na" -> napoveda()
        "tg" -> testujGenerator()
    }
}
