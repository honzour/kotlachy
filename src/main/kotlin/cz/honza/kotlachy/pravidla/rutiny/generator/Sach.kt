package cz.honza.kotlachy.pravidla.rutiny.generator

import cz.honza.kotlachy.pravidla.data.A1
import cz.honza.kotlachy.pravidla.data.H8
import cz.honza.kotlachy.pravidla.data.Pozice

fun napadeno(sch: Array<Int>, pole: Int, bilym: Boolean): Boolean {
    if (bilym) {
        val r =
            napadenoBilymPescem(sch, pole) ||
            napadenoBilymJezdcem(sch, pole) ||
            napadenoBilouSikmou(sch, pole) ||
            napadenoBilouRovnou(sch, pole) ||
            napadenoBilymKralem(sch, pole)
        return r
    } else {
        val r =
            napadenoCernymPescem(sch, pole) ||
                    napadenoCernymJezdcem(sch, pole) ||
                    napadenoCernouSikmou(sch, pole) ||
                    napadenoCernouRovnou(sch, pole) ||
                    napadenoCernymKralem(sch, pole)
        return r
    }
}

fun sach(pos: Pozice, bilemu: Boolean? = null, poleKrale: Int? = null) : Boolean {
    val b = bilemu ?: pos.bily
    val pole = poleKrale ?: nalezKamen(pos.sch, if (b) 6 else -6)
    if (pole == null) {
        return false
    }
    return napadeno(pos.sch, pole, !b)
}

fun nalezKamen(sch: Array<Int>, kamen: Int) : Int? {
    for (pole in A1 .. H8) {
        if (sch[pole] == kamen) {
            return pole
        }
    }
    return null
}
