package cz.honza.kotlachy.pravidla.rutiny

import cz.honza.kotlachy.pravidla.data.A1
import cz.honza.kotlachy.pravidla.data.H8
import cz.honza.kotlachy.pravidla.data.Uloha

fun generujTahy(uloha: Uloha) {
    uloha.zasobnikTahu.push()
    if (uloha.pos.bily) {
        return generujBileTahy(uloha)
    } else {
        return generujBileTahy(uloha)
    }
}

private fun generujBileTahy(uloha: Uloha) {
    for (pole in A1 .. H8) {
        when (uloha.pos.sch[pole]) {
            1 -> bilyPesec(uloha)
        }
    }
}

private fun bilyPesec(uloha: Uloha) {

}