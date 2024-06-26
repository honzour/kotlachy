package cz.honza.kotlachy.pravidla.rutiny.generator

import cz.honza.kotlachy.pravidla.data.A1
import cz.honza.kotlachy.pravidla.data.A8
import cz.honza.kotlachy.pravidla.data.B1
import cz.honza.kotlachy.pravidla.data.B8
import cz.honza.kotlachy.pravidla.data.C1
import cz.honza.kotlachy.pravidla.data.C8
import cz.honza.kotlachy.pravidla.data.D1
import cz.honza.kotlachy.pravidla.data.D8
import cz.honza.kotlachy.pravidla.data.E1
import cz.honza.kotlachy.pravidla.data.E8
import cz.honza.kotlachy.pravidla.data.F1
import cz.honza.kotlachy.pravidla.data.F8
import cz.honza.kotlachy.pravidla.data.G1
import cz.honza.kotlachy.pravidla.data.G8
import cz.honza.kotlachy.pravidla.data.H1
import cz.honza.kotlachy.pravidla.data.H8
import cz.honza.kotlachy.pravidla.data.Uloha

private val offsetKrale = arrayOf(11, 10, 9, 1, -1, -9, -10, -11)

fun bilyKral(uloha: Uloha, pole: Int) {
    for (i in offsetKrale.indices) {
        val kam = pole + offsetKrale[i]
        if (uloha.pos.sch[kam] <= 0) {
            zaradNormalniTah(uloha, pole, kam)
        }
    }
    if (pole == E1
        && uloha.pos.sch[H1] == 4
        && uloha.pos.mbRoch
        && uloha.pos.sch[F1] == 0
        && uloha.pos.sch[G1] == 0
        && !napadeno(uloha.pos.sch, E1, false)
        && !napadeno(uloha.pos.sch, F1, false)
        && !napadeno(uloha.pos.sch, G1, false)
    ) {
        // nmrcv00000000000 (rosada)
        zaradTah(uloha, /*11100 */ 28 shl 11)
    }

    if (pole == E1
        && uloha.pos.sch[A1] == 4
        && uloha.pos.vbRoch
        && uloha.pos.sch[B1] == 0
        && uloha.pos.sch[C1] == 0
        && uloha.pos.sch[D1] == 0
        && !napadeno(uloha.pos.sch, E1, false)
        && !napadeno(uloha.pos.sch, D1, false)
        && !napadeno(uloha.pos.sch, C1, false)
    ) {
        // nmrcv00000000000 (rosada)
        zaradTah(uloha, /*11101 */ 29 shl 11)
    }
}

fun cernyKral(uloha: Uloha, pole: Int) {
    for (i in offsetKrale.indices) {
        val kam = pole + offsetKrale[i]
        if (uloha.pos.sch[kam] in 0..6) {
            zaradNormalniTah(uloha, pole, kam)
        }
    }
    if (pole == E8
        && uloha.pos.sch[H8] == -4
        && uloha.pos.mcRoch
        && uloha.pos.sch[F8] == 0
        && uloha.pos.sch[G8] == 0
        && !napadeno(uloha.pos.sch, E8, true)
        && !napadeno(uloha.pos.sch, F8, true)
        && !napadeno(uloha.pos.sch, G8, true)
    ) {
        // nmrcv00000000000 (rosada)
        zaradTah(uloha, /*11110 */ 30 shl 11)
    }

    if (pole == E8
        && uloha.pos.sch[A8] == -4
        && uloha.pos.mbRoch
        && uloha.pos.sch[B8] == 0
        && uloha.pos.sch[C8] == 0
        && uloha.pos.sch[D8] == 0
        && !napadeno(uloha.pos.sch, E8, true)
        && !napadeno(uloha.pos.sch, D8, true)
        && !napadeno(uloha.pos.sch, C8, true)
    ) {
        // nmrcv00000000000 (rosada)
        zaradTah(uloha, /*11111 */ 31 shl 11)
    }
}

fun napadenoBilymKralem(sch: Array<Int>, pole: Int): Boolean {
    for (i in offsetKrale.indices) {
        val kam = pole + offsetKrale[i]
        if (sch[kam] == 6) {
            return true
        }
    }
    return false
}

fun napadenoCernymKralem(sch: Array<Int>, pole: Int): Boolean {
    for (i in offsetKrale.indices) {
        val kam = pole + offsetKrale[i]
        if (sch[kam] == -6) {
            return true
        }
    }
    return false
}