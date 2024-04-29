package cz.honza.kotlachy.pravidla.rutiny.generator

import cz.honza.kotlachy.pravidla.data.Uloha

private val offsetKrale = arrayOf(11, 10, 9, 1, -1, -9, -10, -11)

fun bilyKral(uloha: Uloha, pole: Int) {
    for (i in offsetKrale.indices) {
        val kam = pole + offsetKrale[i]
        if (uloha.pos.sch[kam] <= 0 ) {
            zaradNormalniTah(uloha, pole, kam)
        }
    }
    // TODO rošáda
}

fun cernyKral(uloha: Uloha, pole: Int) {
    for (i in offsetKrale.indices) {
        val kam = pole + offsetKrale[i]
        if (uloha.pos.sch[kam] in 0 .. 6 ) {
            zaradNormalniTah(uloha, pole, kam)
        }
    }
    // TODO rošáda
}