package cz.honza.kotlachy.pravidla.rutiny.generator

import cz.honza.kotlachy.pravidla.data.Uloha

private val offsetStrelce = arrayOf(11, 9, -9, -11)

fun bilyStrelec(uloha: Uloha, pole: Int) {
    dlouhaBilaFigura(uloha, pole, offsetStrelce)
}

fun cernyStrelec(uloha: Uloha, pole: Int) {
    dlouhaCernaFigura(uloha, pole, offsetStrelce)
}

fun napadenoBilouSikmou(sch: Array<Int>, pole: Int) : Boolean {
    for (offset in offsetStrelce) {
        var odkud = pole
        do {
            odkud += offset
            if (sch[odkud] == 3 || sch[odkud] == 5) {
                return true;
            }
        } while (sch[odkud] == 0)
    }
    return false;
}

fun napadenoCernouSikmou(sch: Array<Int>, pole: Int) : Boolean {
    for (offset in offsetStrelce) {
        var odkud = pole
        do {
            odkud += offset
            if (sch[odkud] == -3 || sch[odkud] == -5) {
                return true;
            }
        } while (sch[odkud] == 0)
    }
    return false;
}