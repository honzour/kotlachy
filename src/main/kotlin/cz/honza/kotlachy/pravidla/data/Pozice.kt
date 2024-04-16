package cz.honza.kotlachy.pravidla.data

class Pozice(
    val sch: Array<Int> = ZAKLADNI_SACHOVNICE.toTypedArray(),
    /* binarne 00...00vmVM */
    /* V,v - moznost velke rosady bileho a cerneho
       M,m - totez s malou  */
    var roch: Int = 0,
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
    100,   0,   0,   0,   0,   0,   0,   0,   0, 100, // 3
    100,   0,   0,   0,   0,   0,   0,   0,   0, 100, // 3
    100,   0,   0,   0,   0,   0,   0,   0,   0, 100, // 3
    100,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1, 100, // 2
    100,   4,   2,   3,   5,   6,   3,   2,   4, 100, // 1
    100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
    100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
)

const val A1 = 21
const val H2 = 38
const val H6 = 78
const val H8 = 98