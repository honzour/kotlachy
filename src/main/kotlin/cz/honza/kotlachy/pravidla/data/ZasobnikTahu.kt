package cz.honza.kotlachy.pravidla.data

class ZasobnikTahu(
    var hloubka: Int = -1,
    val maxHloubka: Int = 256,
    val limit: Int = maxHloubka * 256,
    val meze: Array<Int> = Array(maxHloubka, {0}),
    val tahy: Array<Int> = Array(limit, {0}),
    val ceny: Array<Int> = Array(limit, {0})
) {
    fun push() {
        if (hloubka >= maxHloubka) {
            throw IllegalArgumentException("hloubka >= maxHloubka")
        }
        hloubka++
        meze[hloubka] = if (hloubka == 0) 0 else meze[hloubka - 1]
    }

    fun pop() {
        if (hloubka <= 0) {
            throw IllegalArgumentException("hloubka >= maxHloubka")
        }
        hloubka--
    }
}
