package cz.honza.kotlachy.pravidla.rutiny.generator

import cz.honza.kotlachy.pravidla.data.*

private val offsetKrale = arrayOf(11, 10, 9, 1, -1, -9, -10, -11)

fun bilyKral(uloha: Uloha, pole: Int) {
    for (i in offsetKrale.indices) {
        val kam = pole + offsetKrale[i]
        if (uloha.pos.sch[kam] <= 0 ) {
            zaradNormalniTah(uloha, pole, kam)
        }
    }
    if (pole == E1
        && uloha.pos.sch[H1] == 4
        && uloha.pos.mbRoch
        && uloha.pos.sch[F1] == 0
        && uloha.pos.sch[G1] == 0
        && !napadeno(uloha, E1, false)
        && !napadeno(uloha, F1, false)
        && !napadeno(uloha, G1, false)
    ) {
        // nmrcv00000000000 (rosada)
        zaradTah(uloha, /*10100 */ 20)
    }

    if (pole == E1
        && uloha.pos.sch[A1] == 4
        && uloha.pos.vbRoch
        && uloha.pos.sch[B1] == 0
        && uloha.pos.sch[C1] == 0
        && uloha.pos.sch[D1] == 0
        && !napadeno(uloha, E1, false)
        && !napadeno(uloha, D1, false)
        && !napadeno(uloha, C1, false)
    ) {
        // nmrcv00000000000 (rosada)
        zaradTah(uloha, /*10101 */ 21)
    }
}

fun cernyKral(uloha: Uloha, pole: Int) {
    for (i in offsetKrale.indices) {
        val kam = pole + offsetKrale[i]
        if (uloha.pos.sch[kam] in 0 .. 6 ) {
            zaradNormalniTah(uloha, pole, kam)
        }
    }
    if (pole == E8
        && uloha.pos.sch[H8] == -4
        && uloha.pos.mcRoch
        && uloha.pos.sch[F8] == 0
        && uloha.pos.sch[G8] == 0
        && !napadeno(uloha, E8, true)
        && !napadeno(uloha, F8, true)
        && !napadeno(uloha, G8, true)
    ) {
        // nmrcv00000000000 (rosada)
        zaradTah(uloha, /*10110 */ 22)
    }

    if (pole == E8
        && uloha.pos.sch[A8] == -4
        && uloha.pos.mbRoch
        && uloha.pos.sch[B8] == 0
        && uloha.pos.sch[C8] == 0
        && uloha.pos.sch[D8] == 0
        && !napadeno(uloha, E8, true)
        && !napadeno(uloha, D8, true)
        && !napadeno(uloha, C8, true)
    ) {
        // nmrcv00000000000 (rosada)
        zaradTah(uloha, /*10111 */ 23)
    }
}