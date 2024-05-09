package cz.honza.kotlachy.pravidla.data

class Uloha(
    val pos: Pozice = Pozice(),
    val zasobnikTahu: ZasobnikTahu = ZasobnikTahu(),
    val partie: MutableList<DataPartie> = mutableListOf(),
    var indexDoPartie: Int = -1
)