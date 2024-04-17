package cz.honza.kotlachy.pravidla.rutiny.generator

import cz.honza.kotlachy.pravidla.data.A2
import cz.honza.kotlachy.pravidla.data.Uloha
import org.junit.jupiter.api.Test

class PesecTest {

    @Test
    fun bilyPesecTest() {
        val uloha = Uloha()
        uloha.zasobnikTahu.push()
        bilyPesec(uloha, A2)
        assert(uloha.zasobnikTahu.meze[1] == 2)
        uloha.zasobnikTahu.pop()
    }
}