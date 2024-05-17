package cz.honza.kotlachy.pravidla.data

class ZasobnikTahu(
    var hloubka: Int = 0,
    val maxHloubka: Int = 256,
    val limit: Int = maxHloubka * 256,
    val meze: Array<Int> = Array(maxHloubka + 1) {0},
    val tahy: Array<Int> = Array(limit) {0},
    val propocet: Array<DataPartie> = Array(maxHloubka) {DataPartie()}
) {
    fun push() {
        if (hloubka >= maxHloubka) {
            throw IllegalArgumentException("hloubka > maxHloubka")
        }
        hloubka++
        meze[hloubka] = meze[hloubka - 1]
    }

    fun pop() {
        if (hloubka <= 0) {
            throw IllegalArgumentException("hloubka < 0")
        }
        meze[hloubka] = 0
        hloubka--
    }
}
