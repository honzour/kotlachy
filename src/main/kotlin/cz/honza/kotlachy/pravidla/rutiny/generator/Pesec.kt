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
    if (pole + 10 == 0) {
        for (co in 0..3)
            zaradBilouPromenu(uloha, pole, pole + 10, co)
    }
    if (pole + 11 < 0) {
        for (co in 0..3)
            zaradBilouPromenu(uloha, pole, pole + 11, co)
    }
    if (pole + 9 < 0) {
        for (co in 0..3)
            zaradBilouPromenu(uloha, pole, pole + 9, co)
    }
}

fun bilymPescemMimochodem(uloha: Uloha, pole: Int) {
    if (uloha.pos.mimoch == pole + 1) {
        zaradMimochodem(uloha, pole, pole + 11)
    } else {
        if (uloha.pos.mimoch == pole - 1) {
            zaradMimochodem(uloha, pole, pole + 9)
        }
    }
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