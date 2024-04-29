package cz.honza.kotlachy.pravidla.data

class Pozice(
    val sch: Array<Int> = ZAKLADNI_SACHOVNICE.toTypedArray(),

    var mbRoch: Boolean = true,
    var vbRoch: Boolean = true,
    var mcRoch: Boolean = true,
    var vcRoch: Boolean = true,
    /* Pole, na nemz stoji pesec tahnuvsi v predchozim tahu o 2,
         nebo 0 pokud se minule netahlo pescem o 2 */
    var mimoch: Int = 0,
    /* Je bily na tahu ?*/
    var bily: Boolean = true,
    /* počet tichých půltahů před začátkem partie */
    var ticho: Int = 0
    )


val ZAKLADNI_SACHOVNICE = listOf(
  //      a    b    c    d    e    f    g    h
    100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
    100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
    100,   4,   2,   3,   5,   6,   3,   2,   4, 100, // 1
    100,   1,   1,   1,   1,   1,   1,   1,   1, 100, // 2
    100,   0,   0,   0,   0,   0,   0,   0,   0, 100, // 3
    100,   0,   0,   0,   0,   0,   0,   0,   0, 100, // 4
    100,   0,   0,   0,   0,   0,   0,   0,   0, 100, // 5
    100,   0,   0,   0,   0,   0,   0,   0,   0, 100, // 6
    100,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1, 100, // 7
    100,  -4,  -2,  -3,  -5,  -6,  -3,  -2,  -4, 100, // 8
    100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
    100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
)

const val A1 = 21
const val B1 = 22
const val C1 = 23
const val D1 = 24
const val E1 = 25
const val F1 = 26
const val G1 = 27
const val H1 = 28
const val A2 = 31
const val H2 = 38
const val H6 = 78
const val A7 = 81
const val A8 = 88
const val B8 = 22
const val C8 = 23
const val D8 = 24
const val E8 = 25
const val F8 = 26
const val G8 = 27
const val H8 = 98

