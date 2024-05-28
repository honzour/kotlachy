package cz.honza.kotlachy.pravidla.data

class Uloha {
    lateinit var pos: Pozice
    lateinit var zasobnikTahu: ZasobnikTahu
    lateinit var partie: MutableList<DataPartie>
    var indexDoPartie: Int = -1

    constructor() {
        init()
    }

    fun init() {
        pos = Pozice()
        zasobnikTahu = ZasobnikTahu()
        partie = mutableListOf()
        indexDoPartie = -1
    }
}