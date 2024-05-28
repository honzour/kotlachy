package cz.honza.kotlachy.konzole

import cz.honza.kotlachy.notace.tah2str
import cz.honza.kotlachy.pravidla.data.*
import cz.honza.kotlachy.pravidla.rutiny.generator.generujPripustneTahy
import cz.honza.kotlachy.pravidla.rutiny.generator.generujPseudolegalniTahy
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
np - nová partie
""")
}

fun tahni(uloha: Uloha) {
    generujPripustneTahy(uloha)
    val tah = uloha.zasobnikTahu.tahy[0];
    val tahString = tah2str(uloha, tah)
    smazTahy(uloha)
    tahniVPartii(uloha, tah)

    println(tahString)
    vypis(uloha.pos)
}

fun tahni(uloha: Uloha, tah: String) {
    generujPripustneTahy(uloha)
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
    generujPripustneTahy(uloha)
    for (i in uloha.zasobnikTahu.meze[uloha.zasobnikTahu.hloubka - 1] .. uloha.zasobnikTahu.meze[uloha.zasobnikTahu.hloubka] - 1) {
        println("Tah ${i + 1}. ${tah2str(uloha, uloha.zasobnikTahu.tahy[i])}")
    }
    smazTahy(uloha)
}

fun testujCas() {
    val tmpUloha = Uloha()
    tmpUloha.pos = Pozice(sch = TESTOVACI_SACHOVNICE1.toTypedArray())

    var suma: Long = 0
    val generator = measureTimeMillis {
        for (j in 0..1000000) {
            generujPseudolegalniTahy(tmpUloha)
            for (i in tmpUloha.zasobnikTahu.meze[tmpUloha.zasobnikTahu.hloubka - 1]..<tmpUloha.zasobnikTahu.meze[tmpUloha.zasobnikTahu.hloubka]) {
                suma += tmpUloha.zasobnikTahu.tahy[i]
            }
            smazTahy(tmpUloha)
        }
    }
    val napadeni = measureTimeMillis {
        for (j in 0..1000000) {
            for (i in A1 .. H8) {
                if (napadeno(tmpUloha.pos.sch, i, true)) suma++
                if (napadeno(tmpUloha.pos.sch, i, false)) suma--
            }
        }
    }
    println("Generátor $generator ms,\n" +
            "napadeni je $napadeni ms\n" +
            "suma $suma")
}

private fun novaPartie(uloha: Uloha) {
    uloha.init()
}

private fun novaKralovskaKoncovka(uloha: Uloha) {
    uloha.init()
}

private fun novaKoncovka(uloha: Uloha) {
    uloha.init()
}

private fun novaStredniHra(uloha: Uloha) {
    uloha.init()
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
        "np" -> novaPartie(uloha)
        "ns" -> novaStredniHra(uloha)
        "nk" -> novaKoncovka(uloha)
        "nK" -> novaKralovskaKoncovka(uloha)
        else -> tahni(uloha, line)
    }
}
