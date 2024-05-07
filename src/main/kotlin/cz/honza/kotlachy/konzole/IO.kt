package cz.honza.kotlachy.konzole

import cz.honza.kotlachy.notace.tah2str
import cz.honza.kotlachy.pravidla.data.*
import cz.honza.kotlachy.pravidla.rutiny.generator.generujTahy
import cz.honza.kotlachy.pravidla.rutiny.generator.napadeno
import cz.honza.kotlachy.pravidla.rutiny.generator.smazTahy
import kotlin.system.measureTimeMillis

fun napoveda() {
    println(
"""
na - nápověda
ko - konec
sa - výpis aktuální pozice
tg - testuj generátor tahů
tc - testuj rychost rutin
""")
}

val uloha = Uloha()

fun testujGenerator() {
    generujTahy(uloha)
    for (i in uloha.zasobnikTahu.meze[uloha.zasobnikTahu.hloubka - 1] .. uloha.zasobnikTahu.meze[uloha.zasobnikTahu.hloubka] - 1) {
        println("Tah ${i + 1}. ${tah2str(uloha.zasobnikTahu.tahy[i])}")
    }
    smazTahy(uloha)
}

fun testujCas() {
    val tmpUloha = Uloha(
        pos = Pozice(
            sch = TESTOVACI_SACHOVNICE1.toTypedArray()
        )
    )
    var suma: Long = 0
    val generator = measureTimeMillis {
        for (j in 0..1000000) {
            generujTahy(tmpUloha)
            for (i in tmpUloha.zasobnikTahu.meze[tmpUloha.zasobnikTahu.hloubka - 1]
                    ..tmpUloha.zasobnikTahu.meze[tmpUloha.zasobnikTahu.hloubka] - 1) {
                suma += tmpUloha.zasobnikTahu.tahy[i]
            }
            smazTahy(tmpUloha)
        }
    }
    val napadeni = measureTimeMillis {
        for (j in 0..1000000) {
            for (i in A1 .. H8) {
                if (napadeno(tmpUloha, i, true)) suma++
                if (napadeno(tmpUloha, i, false)) suma--
            }
        }
    }
    println("Generátor $generator ms,\n" +
            "napadeni je $napadeni ms\n" +
            "suma $suma")
}

fun command(line: String) {
    when (line) {
        "sa" -> vypis(Pozice())
        "na" -> napoveda()
        "tg" -> testujGenerator()
        "tc" -> testujCas()
    }
}
