package cz.honza.kotlachy.pravidla.rutiny.generator

import cz.honza.kotlachy.pravidla.data.*

fun napadenoBilymPescem(uloha: Uloha, pole: Int) : Boolean {
    return uloha.pos.sch[pole - 11]  == 1 || uloha.pos.sch[pole - 9]  == 1
}

fun napadenoCernymPescem(uloha: Uloha, pole: Int) : Boolean {
    return uloha.pos.sch[pole + 11]  == -1 || uloha.pos.sch[pole + 9]  == -1
}

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
    if (uloha.pos.sch[pole + 10] == 0) {
        for (co in 0..3)
            zaradBilouPromenu(uloha, pole, pole + 10, co)
    }
    if (uloha.pos.sch[pole + 11] < 0) {
        for (co in 0..3)
            zaradBilouPromenu(uloha, pole, pole + 11, co)
    }
    if (uloha.pos.sch[pole + 9] < 0) {
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

fun cernyPesec(uloha: Uloha, pole: Int) {
    if (pole <= H2) {
        promenaCernehoPesce(uloha, pole)
    } else {
        cernymPescemVpred(uloha, pole)
        cernymPescemBer(uloha, pole)
        cernymPescemMimochodem(uloha, pole)
    }
}

fun promenaCernehoPesce(uloha: Uloha, pole: Int) {
    if (uloha.pos.sch[pole - 10] == 0) {
        for (co in 0..3)
            zaradCernouPromenu(uloha, pole, pole - 10, co)
    }
    if (uloha.pos.sch[pole - 11] < 0) {
        for (co in 0..3)
            zaradCernouPromenu(uloha, pole, pole - 11, co)
    }
    if (uloha.pos.sch[pole - 9] < 0) {
        for (co in 0..3)
            zaradCernouPromenu(uloha, pole, pole - 9, co)
    }
}

fun cernymPescemMimochodem(uloha: Uloha, pole: Int) {
    if (uloha.pos.mimoch == pole + 1) {
        zaradMimochodem(uloha, pole, pole - 9)
    } else {
        if (uloha.pos.mimoch == pole - 1) {
            zaradMimochodem(uloha, pole, pole - 11)
        }
    }
}
fun cernymPescemVpred(uloha: Uloha, pole: Int) {
    if (uloha.pos.sch[pole - 10] == 0) {
        zaradNormalniTah(uloha, pole, pole - 10)
        if (pole >= A7 && uloha.pos.sch[pole - 20] == 0) {
            zaradNormalniTah(uloha, pole, pole - 20)
        }
    }
}

fun cernymPescemBer(uloha: Uloha, pole: Int) {
    if (uloha.pos.sch[pole - 9] > 0)
        zaradNormalniTah(uloha, pole, pole - 9)
    if (uloha.pos.sch[pole - 11] > 0)
        zaradNormalniTah(uloha, pole, pole - 11)
}

fun zaradMimochodem(uloha: Uloha, odkud: Int, kam: Int) {
    zaradTah(uloha, ((odkud shl 7) or kam) or (1 shl 15))
}

fun zaradBilouPromenu(uloha: Uloha, odkud: Int, kam: Int, co: Int) {
    // nmrcppoookkk0000
    zaradTah(uloha, (3 shl 14) or (co shl 10) or ((odkud - A7) shl 7) or ((kam - A8) shl 4))
}

fun zaradCernouPromenu(uloha: Uloha, odkud: Int, kam: Int, co: Int) {
    zaradTah(uloha, (3 shl 14) or (1 shl 2) or (co shl 10) or ((odkud - A2) shl 7) or ((kam - A1) shl 4))
}