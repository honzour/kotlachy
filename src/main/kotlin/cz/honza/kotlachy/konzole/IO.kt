package cz.honza.kotlachy.konzole

import cz.honza.kotlachy.notace.tah2str
import cz.honza.kotlachy.pravidla.data.*
import cz.honza.kotlachy.pravidla.rutiny.generator.generujTahy
import cz.honza.kotlachy.pravidla.rutiny.generator.napadeno
import cz.honza.kotlachy.pravidla.rutiny.generator.smazTahy
import cz.honza.kotlachy.pravidla.rutiny.tahy.tahniVPartii
import cz.honza.kotlachy.pravidla.rutiny.tahy.tahniVPartiiZpet
import kotlin.system.measureTimeMillis

fun napoveda() {
    println(
"""
na - nápověda
ko - konec
sa - výpis aktuální pozice
ta - táhni
tz - táhni zpět
tg - testuj generátor tahů
tc - testuj rychost rutin
""")
}

fun tahni(uloha: Uloha) {
    generujTahy(uloha)
    val tah = uloha.zasobnikTahu.tahy[0];
    val tahString = tah2str(uloha, tah)
    smazTahy(uloha)
    tahniVPartii(uloha, tah)

    println(tahString)
    vypis(uloha.pos)
}

fun tahni(uloha: Uloha, tah: String) {
    generujTahy(uloha)
    var spravnyTah: Int? = null
    for (i in uloha.zasobnikTahu.meze[uloha.zasobnikTahu.hloubka - 1] .. uloha.zasobnikTahu.meze[uloha.zasobnikTahu.hloubka] - 1) {
        val t = uloha.zasobnikTahu.tahy[i]
        val tahString = tah2str(uloha, t)
        if (tahString == tah) {
            spravnyTah = t
        }
    }

    smazTahy(uloha)
    if (spravnyTah != null) {
        tahniVPartii(uloha, spravnyTah)
        vypis(uloha.pos)
    } else {
        println("Chybný tah nebo příkaz")
    }
}

fun testujGenerator(uloha: Uloha) {
    generujTahy(uloha)
    for (i in uloha.zasobnikTahu.meze[uloha.zasobnikTahu.hloubka - 1] .. uloha.zasobnikTahu.meze[uloha.zasobnikTahu.hloubka] - 1) {
        println("Tah ${i + 1}. ${tah2str(uloha, uloha.zasobnikTahu.tahy[i])}")
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

fun command(line: String, uloha: Uloha) {
    when (line) {
        "ko" -> println("Končím")
        "sa" -> vypis(uloha.pos)
        "na" -> napoveda()
        "tg" -> testujGenerator(uloha)
        "tc" -> testujCas()
        "ta" -> tahni(uloha)
        "tz" -> {
            tahniVPartiiZpet(uloha)
            vypis(uloha.pos)
        }
        else -> tahni(uloha, line)
    }
}
