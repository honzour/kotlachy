package cz.honza.kotlachy.pravidla.rutiny.generator

import cz.honza.kotlachy.pravidla.data.Uloha

fun napadeno(uloha: Uloha, pole: Int, bilym: Boolean): Boolean {
    if (bilym) {
        val r =
            napadenoBilymPescem(uloha, pole) ||
            napadenoBilymJezdcem(uloha, pole) ||
            napadenoBilouSikmou(uloha, pole) ||
            napadenoBilouRovnou(uloha, pole) ||
            napadenoBilymKralem(uloha, pole)
        return r
    } else {
        val r =
            napadenoCernymPescem(uloha, pole) ||
                    napadenoCernymJezdcem(uloha, pole) ||
                    napadenoCernouSikmou(uloha, pole) ||
                    napadenoCernouRovnou(uloha, pole) ||
                    napadenoCernymKralem(uloha, pole)
        return r
    }
}
