package cz.honza.kotlachy.pravidla.data

class ZasobnikTahu(
    val hloubka: Int = 256,
    val limit: Int = hloubka * 256,
    val meze: Array<Int> = Array(hloubka, {0}),
    val tahy: Array<Int> = Array(limit, {0}),
    val ceny: Array<Int> = Array(limit, {0})
)
