package cz.honza.kotlachy.pravidla.rutiny.generator

import cz.honza.kotlachy.pravidla.data.H2
import cz.honza.kotlachy.pravidla.data.H6
import cz.honza.kotlachy.pravidla.data.Uloha

public fun bilyPesec(uloha: Uloha, pole: Int) {
    if (pole <= H6) {
        if (uloha.pos.sch[pole + 10] == 0) {
            zaradNormalniTah(uloha, pole, pole + 10)
            if (pole <= H2 && uloha.pos.sch[pole + 20] == 0) {
                zaradNormalniTah(uloha, pole, pole + 20)
            }
        }
        if (uloha.pos.sch[pole + 9] < 0)
            zaradNormalniTah(uloha, pole, pole + 9)
        if (uloha.pos.sch[pole + 11] < 0)
            zaradNormalniTah(uloha, pole, pole + 11)
    }
}