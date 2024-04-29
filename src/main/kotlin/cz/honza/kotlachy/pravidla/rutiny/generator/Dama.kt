package cz.honza.kotlachy.pravidla.rutiny.generator

import cz.honza.kotlachy.pravidla.data.Uloha

private val offsetDamy = arrayOf(11, 10, 9, 1, -1, -9, -10, -11)
fun bilaDama(uloha: Uloha, pole: Int) {
    dlouhaBilaFigura(uloha, pole, offsetDamy)
}

fun cernaDama(uloha: Uloha, pole: Int) {
    dlouhaCernaFigura(uloha, pole, offsetDamy)
}