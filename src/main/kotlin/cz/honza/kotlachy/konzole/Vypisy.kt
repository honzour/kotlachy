package cz.honza.kotlachy.konzole

import cz.honza.kotlachy.pravidla.data.A1
import cz.honza.kotlachy.pravidla.data.Pozice

fun vypis(pozice: Pozice) {
    for (radek in 0 .. 7) {
        for (sloupec in 0 .. 7) {
            print("${int2kamen(pozice.sch[A1 + 10 * radek + sloupec])} ")
        }
        println()
    }
    val bily = if (pozice.bily) "bílý" else "černý"
    val mb = if (pozice.mbRoch) "mb" else ""
    val vb = if (pozice.vbRoch) "vb" else ""
    val mc = if (pozice.mcRoch) "mc" else ""
    val vc = if (pozice.vcRoch) "vb" else ""
    println("$bily, mimoch: ${pozice.mimoch}, roch: $mb $vb $mc $vc")
}

fun int2kamen(kamen: Int) : Char {
    return when (kamen) {
        6 -> 'K';
        5 -> 'D';
        4 -> 'V';
        3 -> 'S';
        2 -> 'J';
        1 -> 'P';
        -6 -> 'k';
        -5 -> 'd';
        -4 -> 'v';
        -3 -> 's';
        -2 -> 'j';
        -1 -> 'p';
        0 -> '.'
        else -> ' '
    }
}