package cz.honza.kotlachy.pravidla.rutiny.tahy

import cz.honza.kotlachy.pravidla.data.DataPartie
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
fun tahniVPartii(uloha: Uloha, tah: Int? = null) {
    val data =
        if (tah == null) {
            uloha.partie[uloha.indexDoPartie]
        } else {
            DataPartie(
                tah = tah,
                mbRochPred = uloha.pos.mbRoch,
                vbRochPred = uloha.pos.vbRoch,
                mcRochPred = uloha.pos.mcRoch,
                vcRochPred = uloha.pos.vcRoch,
                mimochPred = uloha.pos.mimoch,
                sebranyKamen = 0,
                nevratnaZmena = false
            )
        }
    val t = data.tah
    uloha.pos.mimoch = 0
    if ((t shr 15) and 1 == 0) {
        //  nmoooooookkkkkkk
        val odkud = (t shr 7) and 127
        val kam = t and 127
        data.sebranyKamen = uloha.pos.sch[kam]
        data.nevratnaZmena =
            uloha.pos.sch[odkud] == 1
                    || uloha.pos.sch[odkud] == -1
                    || uloha.pos.sch[kam] != 0
        uloha.pos.sch[kam] = uloha.pos.sch[odkud]
        uloha.pos.sch[odkud] = 0
    }
    uloha.pos.bily = !uloha.pos.bily

    uloha.indexDoPartie++;
    if (tah != null) {
        while (uloha.partie.size > uloha.indexDoPartie) {
            uloha.partie.removeAt(uloha.indexDoPartie)
        }
        uloha.partie.add(data)
    }
}
