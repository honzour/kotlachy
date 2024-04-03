package cz.honza.kotlachy.pravidla.data

class Pozice {
    var sch = arrayOf<Int>()
    var roch = 0  /* binarne 00...00vmVM */
    /* V,v - moznost velke rosady bileho a cerneho
       M,m - totez s malou  */
    var mimoch = 0  /* Pole, na nemz stoji pesec tahnuvsi v predchozim tahu o 2,
         nebo 0 pokud se minule netahlo pescem o 2 */
    var bily = true    /* Je bily na tahu ?*/
    /* počet tichých půltahů před začátkem partie */
    var ticho = 0
}

val ZAKLADNI_SACHOVNICE = arrayOf(
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

val ZAKLADNI_POSTAVENI = Pozice().apply {
    sch = ZAKLADNI_SACHOVNICE
}

const val A1 = 21