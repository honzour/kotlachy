package cz.honza.kotlachy.pravidla.rutiny.generator

import cz.honza.kotlachy.pravidla.data.*


/* Format TTah1::data:   def.: Nenormalni tah je
1) rosada
2) promena pesce
3) brani mimochodem
  def.: Normalni tah je kazdy tah, ktery neni nenormalni.
   Zbesily format TTah1.data je dusledkem me snahy o malou velikost TTah1
   a efektivni rutiny zejmena pro normalni tahy. (Nebot se s timto typem
   pocita v rekurzi a normalni tahy jsou skoro vsechny)
   binarne  1234567812345678
            nmoooooookkkkkkk (normalni tah a brani mimochodem)
            nmrcv00000000000 (rosada)
            nmrcppoookkk0000 (promena pesce)
n - Je to nenormalni tah ?
  Pokud ne (tj. tah je normalni), je m=0 (MUSI byt 0) a ooooooo a kkkkkkk
   ma vyznam poli odkud a kam se tahne.
  Pokud ano (tj. tah je nenormalni):
   m - Je to rosada nebo promena pesce ?
    Pokud ne (tj. je to brani mimochodem) ma ooooooo a kkkkkkk take vyse
     uvedeny vyznam.
   Pokud ano:
    r - Je to rosada ?
     Pokud ano, potom
      c: je to rosada cerneho ? v: je to velka rosada ?
     Pokud ne (tj. je to promena pesce)
      c: je to promena cerneho pesce ?
      pp: v co se pesec meni 0=kun, 1=strelec, 2=vez, 3=dama
      ooo: cislo, ktere se musi pricist k A7 (je-li to promena bileho pesce)
       nebo A2 (je-li to promena cerneho pesce), abychom dostali pole,
       odkud pesec tahne
      kkk: totiz s polem promeny, jen misto A7 (resp. A2) se bere  A8
       (resp A1)
*/

fun generujTahy(uloha: Uloha) {
    uloha.zasobnikTahu.push()
    if (uloha.pos.bily) {
        generujBileTahy(uloha)
    } else {
        generujCerneTahy(uloha)
    }
}

fun smazTahy(uloha: Uloha) {
    uloha.zasobnikTahu.pop()
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
