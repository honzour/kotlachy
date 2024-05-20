package cz.honza.kotlachy.pravidla.rutiny.tahy

import cz.honza.kotlachy.pravidla.data.A1
import cz.honza.kotlachy.pravidla.data.A2
import cz.honza.kotlachy.pravidla.data.A7
import cz.honza.kotlachy.pravidla.data.A8
import cz.honza.kotlachy.pravidla.data.C1
import cz.honza.kotlachy.pravidla.data.C8
import cz.honza.kotlachy.pravidla.data.D1
import cz.honza.kotlachy.pravidla.data.D8
import cz.honza.kotlachy.pravidla.data.DataPartie
import cz.honza.kotlachy.pravidla.data.E1
import cz.honza.kotlachy.pravidla.data.E8
import cz.honza.kotlachy.pravidla.data.F1
import cz.honza.kotlachy.pravidla.data.F8
import cz.honza.kotlachy.pravidla.data.G1
import cz.honza.kotlachy.pravidla.data.G8
import cz.honza.kotlachy.pravidla.data.H1
import cz.honza.kotlachy.pravidla.data.H8
import cz.honza.kotlachy.pravidla.data.Uloha

/*
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
 */
/**
 * Pokud je tah null, bere se z partie.
 */

fun tahniVPartiiZpet(uloha: Uloha) {
    if (uloha.indexDoPartie < 0) {
        return
    }
    val data = uloha.partie[uloha.indexDoPartie]
    uloha.indexDoPartie--

    tahniZpet(uloha, data)
}


fun tahniZpet(uloha: Uloha, data: DataPartie) {
    val t = data.tah

    // Normální tah
    if ((t shr 15) and 1 == 0) {
        normalniTahZpet(uloha, t, data.sebranyKamen)
    } else {
        if ((t shr 14) and 1 == 0) {
            mimochodemZpet(uloha, t)
        } else {
            if ((t shr 13) and 1 == 1) {
                rosadaZpet(uloha, t)
            } else {
                promenaZpet(uloha, t, data.sebranyKamen)
            }
        }
    }

    uloha.pos.bily = !uloha.pos.bily

    with (uloha.pos) {
        mimoch = data.mimochPred
        mbRoch = data.mbRochPred
        vbRoch = data.vbRochPred
        mcRoch = data.mcRochPred
        vcRoch = data.vcRochPred
    }
}

private fun normalniTahZpet(uloha: Uloha, t: Int, co: Int) {
    val odkud = (t shr 7) and 127
    val kam = t and 127

    uloha.pos.sch[odkud] = uloha.pos.sch[kam]
    uloha.pos.sch[kam] = co
}

private fun mimochodemZpet(uloha: Uloha, t: Int) {
    val odkud = (t shr 7) and 127
    val kam = t and 127

    uloha.pos.sch[odkud] = uloha.pos.sch[kam]
    uloha.pos.sch[kam] = 0
    uloha.pos.sch[uloha.pos.mimoch] = if (uloha.pos.bily) 1 else -1
}

private fun rosadaZpet(uloha: Uloha, t: Int) {
    val cerna = (t shr 12) and 1 == 1
    val velka = (t shr 11) and 1 == 1
    if (cerna) {
        if (velka) {
            with (uloha.pos) {
                sch[E8] = 0
                sch[A8] = 0
                sch[C8] = -6
                sch[D8] = -4
            }
        } else {
            with (uloha.pos) {
                sch[E8] = 0
                sch[H8] = 0
                sch[G8] = -6
                sch[F8] = -4
            }
        }
        uloha.pos.mcRoch = false
        uloha.pos.vcRoch = false
    } else {
        if (velka) {
            with(uloha.pos) {
                sch[E1] = 0
                sch[A1] = 0
                sch[C1] = 6
                sch[D1] = 4
            }
        } else {
            with(uloha.pos) {
                sch[E1] = 0
                sch[H1] = 0
                sch[G1] = 6
                sch[F1] = 4
            }
        }
    }
}

private fun promenaZpet(uloha: Uloha, t: Int, sebrano: Int) {
// nmrcppoookkk0000
    if (uloha.pos.bily) {
        val odkud = ((t shr 7) and 7) + A7
        val kam = ((t shr 4) and 7) + A8
        uloha.pos.sch[odkud] = -1
        uloha.pos.sch[kam] = sebrano
    } else {
        val odkud = ((t shr 7) and 7) + A2
        val kam = ((t shr 4) and 7) + A1
        uloha.pos.sch[odkud] = 1
        uloha.pos.sch[kam] = sebrano
    }
}
