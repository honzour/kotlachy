package cz.honza.kotlachy.pravidla.rutiny

import cz.honza.kotlachy.pravidla.data.Pozice

fun generujTahy(pos: Pozice) : Array<Int> {
    if (pos.bily) {
        return generujBileTahy()
    } else {
        return generujBileTahy()
    }
}

private fun generujBileTahy() : Array<Int> {
    val tahy = Array(10) { 0 }
    return tahy
}