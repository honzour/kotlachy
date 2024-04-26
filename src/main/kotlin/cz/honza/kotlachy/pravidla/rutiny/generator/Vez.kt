package cz.honza.kotlachy.pravidla.rutiny.generator

import cz.honza.kotlachy.pravidla.data.Uloha

private val offsetVeze = arrayOf(10, 1, -1, -10)

fun bilaVez(uloha: Uloha, pole: Int) {
    dlouhaBilaFigura(uloha, pole, offsetVeze)
}