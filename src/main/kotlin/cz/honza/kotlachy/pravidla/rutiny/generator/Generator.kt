package cz.honza.kotlachy.pravidla.rutiny.generator

import cz.honza.kotlachy.pravidla.data.*
import cz.honza.kotlachy.pravidla.rutiny.tahy.tahniVPropoctu
import cz.honza.kotlachy.pravidla.rutiny.tahy.tahniZpetVPropoctu

fun generujPseudolegalniTahy(uloha: Uloha) {
    uloha.zasobnikTahu.push()
    if (uloha.pos.bily) {
        generujBileTahy(uloha)
    } else {
        generujCerneTahy(uloha)
    }
}

fun generujPripustneTahy(uloha: Uloha) {
    generujPseudolegalniTahy(uloha)
    smazNepripustneTahy(uloha)
}

fun smazTahy(uloha: Uloha) {
    uloha.zasobnikTahu.pop()
}

private fun smazNepripustneTahy(uloha: Uloha) {
    with (uloha.zasobnikTahu) {
        for (i in meze[hloubka - 1] .. meze[hloubka]) {
            tahniVPropoctu(uloha, tahy[i])
            tahniZpetVPropoctu(uloha)
        }
    }
}


private fun generujBileTahy(uloha: Uloha) {
    for (pole in A1..H8) {
        when (uloha.pos.sch[pole]) {
            1 -> bilyPesec(uloha, pole)
            2 -> bilyJezdec(uloha, pole)
            3 -> bilyStrelec(uloha, pole)
            4 -> bilaVez(uloha, pole)
            5 -> bilaDama(uloha, pole)
            6 -> bilyKral(uloha, pole)
        }
    }
}

private fun generujCerneTahy(uloha: Uloha) {
    for (pole in A1..H8) {
        when (uloha.pos.sch[pole]) {
            -1 -> cernyPesec(uloha, pole)
            -2 -> cernyJezdec(uloha, pole)
            -3 -> cernyStrelec(uloha, pole)
            -4 -> cernaVez(uloha, pole)
            -5 -> cernaDama(uloha, pole)
            -6 -> cernyKral(uloha, pole)
        }
    }
}

fun zaradTah(uloha: Uloha, tah: Int) {
    with(uloha.zasobnikTahu) {
        tahy[meze[hloubka]] = tah
        meze[hloubka]++
    }
}

fun zaradNormalniTah(uloha: Uloha, odkud: Int, kam: Int) {
    zaradTah(uloha, (odkud shl 7) or kam)
}

fun dlouhaBilaFigura(uloha: Uloha, pole: Int, offset: Array<Int>) {
    for (i in offset.indices) {
        var kam = pole + offset[i]
        while (true) {
            if (uloha.pos.sch[kam] <= 0) {
                zaradNormalniTah(uloha, pole, kam)
                if (uloha.pos.sch[kam] == 0) {
                    kam += offset[i]
                } else {
                    break
                }
            } else {
                break
            }
        }
    }
}

fun dlouhaCernaFigura(uloha: Uloha, pole: Int, offset: Array<Int>) {
    for (i in offset.indices) {
        var kam = pole + offset[i]
        while (true) {
            if (uloha.pos.sch[kam] in 0..6) {
                zaradNormalniTah(uloha, pole, kam)
                if (uloha.pos.sch[kam] == 0) {
                    kam += offset[i]
                } else {
                    break
                }
            } else {
                break
            }
        }
    }
}
