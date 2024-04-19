package cz.honza.kotlachy.pravidla.rutiny.generator

import cz.honza.kotlachy.pravidla.data.H2
import cz.honza.kotlachy.pravidla.data.H6
import cz.honza.kotlachy.pravidla.data.Uloha

fun bilyPesec(uloha: Uloha, pole: Int) {
    if (pole > H6) {
        promenaBilehoPesce(uloha, pole)
    } else {
        bilymPescemVpred(uloha, pole)
        bilymPescemBer(uloha, pole)
        bilymPescemMimochodem(uloha, pole)
    }
}

fun promenaBilehoPesce(uloha: Uloha, pole: Int) {

}

fun bilymPescemMimochodem(uloha: Uloha, pole: Int) {
}
fun bilymPescemVpred(uloha: Uloha, pole: Int) {
    if (uloha.pos.sch[pole + 10] == 0) {
        zaradNormalniTah(uloha, pole, pole + 10)
        if (pole <= H2 && uloha.pos.sch[pole + 20] == 0) {
            zaradNormalniTah(uloha, pole, pole + 20)
        }
    }
}

fun bilymPescemBer(uloha: Uloha, pole: Int) {
    if (uloha.pos.sch[pole + 9] < 0)
        zaradNormalniTah(uloha, pole, pole + 9)
    if (uloha.pos.sch[pole + 11] < 0)
        zaradNormalniTah(uloha, pole, pole + 11)
}