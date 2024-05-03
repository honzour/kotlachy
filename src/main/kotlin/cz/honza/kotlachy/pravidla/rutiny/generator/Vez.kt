package cz.honza.kotlachy.pravidla.rutiny.generator

import cz.honza.kotlachy.pravidla.data.Uloha

private val offsetVeze = arrayOf(10, 1, -1, -10)

fun bilaVez(uloha: Uloha, pole: Int) {
    dlouhaBilaFigura(uloha, pole, offsetVeze)
}

fun cernaVez(uloha: Uloha, pole: Int) {
    dlouhaCernaFigura(uloha, pole, offsetVeze)
}

fun napadenoBilouRovnou(uloha: Uloha, pole: Int) : Boolean {
    for (offset in offsetVeze) {
        var odkud = pole
        do {
            odkud += offset
            if (uloha.pos.sch[odkud] == 4 || uloha.pos.sch[odkud] == 5) {
                return true;
            }
        } while (uloha.pos.sch[odkud] == 0)
    }
    return false;
}

fun napadenoCernouRovnou(uloha: Uloha, pole: Int) : Boolean {
    for (offset in offsetVeze) {
        var odkud = pole
        do {
            odkud += offset
            if (uloha.pos.sch[odkud] == -4 || uloha.pos.sch[odkud] == -5) {
                return true;
            }
        } while (uloha.pos.sch[odkud] == 0)
    }
    return false;
}