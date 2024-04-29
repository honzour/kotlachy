package cz.honza.kotlachy.pravidla.rutiny.generator

import cz.honza.kotlachy.pravidla.data.Uloha

private val offsetStrelce = arrayOf(11, 9, -9, -11)

fun bilyStrelec(uloha: Uloha, pole: Int) {
    dlouhaBilaFigura(uloha, pole, offsetStrelce)
}

fun cernyStrelec(uloha: Uloha, pole: Int) {
    dlouhaCernaFigura(uloha, pole, offsetStrelce)
}