package cz.honza.kotlachy.pravidla.rutiny.generator

import cz.honza.kotlachy.pravidla.data.Uloha

private val offsetJezdce = arrayOf(19, 21, 12, 8, -19, -21, -12, -8)

fun napadenoBilymJezdcem(sch: Array<Int>, pole: Int) : Boolean {
    for (i in 0 .. offsetJezdce.size - 1) {
        val kam = pole + offsetJezdce[i]
        if (sch[kam]  == 2)
            return true
    }
    return false
}

fun napadenoCernymJezdcem(sch: Array<Int>, pole: Int) : Boolean {
    for (i in 0 .. offsetJezdce.size - 1) {
        val kam = pole + offsetJezdce[i]
        if (sch[kam]  == -2)
            return true
    }
    return false
}

fun bilyJezdec(uloha: Uloha, pole: Int) {
    for (i in 0 .. offsetJezdce.size - 1) {
        val kam = pole + offsetJezdce[i]
        if (uloha.pos.sch[kam]  <= 0)
            zaradNormalniTah(uloha, pole, kam)
    }
}

fun cernyJezdec(uloha: Uloha, pole: Int) {
    for (i in 0 .. offsetJezdce.size - 1) {
        val kam = pole + offsetJezdce[i]
        if (uloha.pos.sch[kam]  in 0 .. 6)
            zaradNormalniTah(uloha, pole, kam)
    }
}