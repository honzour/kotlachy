package cz.honza.kotlachy.konzole

import cz.honza.kotlachy.pravidla.data.Pozice
import cz.honza.kotlachy.pravidla.data.Uloha
import cz.honza.kotlachy.pravidla.rutiny.generujTahy
import cz.honza.kotlachy.pravidla.rutiny.smazTahy

fun napoveda() {
    println(
"""
na - nápověda
ko - konec
sa - výpis aktuální pozice
tg - testuj generátor tahů
""")
}

val uloha = Uloha()

fun testujGenerator() {
    generujTahy(uloha)
    for (i in uloha.zasobnikTahu.meze[uloha.zasobnikTahu.hloubka - 1] .. uloha.zasobnikTahu.meze[uloha.zasobnikTahu.hloubka] - 1) {
        println("Tah $i. ${uloha.zasobnikTahu.tahy[i]}")
    }
    smazTahy(uloha)
}

fun command(line: String) {
    when (line) {
        "sa" -> vypis(Pozice())
        "na" -> napoveda()
        "tg" -> testujGenerator()
    }
}
