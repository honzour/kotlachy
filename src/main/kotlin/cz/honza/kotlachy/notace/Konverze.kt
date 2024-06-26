package cz.honza.kotlachy.notace

import cz.honza.kotlachy.konzole.int2kamen
import cz.honza.kotlachy.pravidla.data.A1
import cz.honza.kotlachy.pravidla.data.A2
import cz.honza.kotlachy.pravidla.data.A7
import cz.honza.kotlachy.pravidla.data.A8
import cz.honza.kotlachy.pravidla.data.Uloha

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
fun tah2str(uloha: Uloha, tah: Int) : String {
    if (tah shr 14 == 3) {
        // rošády a proměny
        if ((tah shr 13) and 1 == 1) {
            return if ((tah shr 11) and 1 == 1) "O-O-O" else "O-O"
        } else {
            // nmrcppoookkk0000
            var odkud = (tah shr 7) and 7
            var kam = (tah shr 4) and 7
            var co = int2kamen(((tah shr 10) and 3) + 2)
            if ((tah shr 12) and 1 == 0) {
                odkud += A7
                kam += A8
            } else {
                odkud += A2
                kam += A1
            }
            odkud -= A1
            kam -= A1
            val odkudX = 'a' + odkud % 10
            val odkudY = odkud / 10 + 1

            val kamX = 'a' + kam % 10
            val kamY = kam / 10 + 1
            val bere = if (Math.abs(odkud - kam) == 10) '-' else 'x'

            return "$odkudX$odkudY$bere$kamX$kamY$co"
        }
    } else {
        // normální a mimochodem
        val kam = (tah and 127) - A1
        val odkud = ((tah shr 7) and 127) - A1

        val odkudX = 'a' + odkud % 10
        val odkudY = odkud / 10 + 1

        val kamX = 'a' + kam % 10
        val kamY = kam / 10 + 1
        val bere = if (tah shr 15 == 1 || uloha.pos.sch[kam + A1] != 0) 'x' else '-'
        if (uloha.pos.sch[odkud + A1] in -1 .. 1) {
            return "$odkudX$odkudY$bere$kamX$kamY"
        } else {
            return "${int2kamen(Math.abs(uloha.pos.sch[odkud + A1]))}$odkudX$odkudY$bere$kamX$kamY"
        }
    }
}
