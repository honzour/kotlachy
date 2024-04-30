package cz.honza.kotlachy.pravidla.rutiny.generator

import cz.honza.kotlachy.pravidla.data.Uloha

/*
int Ohrozeno(const s8 *p, int bilym) /*bilym - ohrozuje to pole bily*/
/* p je pointer do sachovnice na zkoumané policko*/
{int j,k;

    if (bilym)
    {
        if (*(p-9)==1) return 1;/*pescem*/
        if (*(p-11)==1) return 1;/*pescem*/
        for(j=8;j<=15;j++)if (*(p+ofsety[j])==2) return 1;/*konem*/
        for(j=0;j<=7;j++)if (*(p+ofsety[j])==6) return 1;/*kralem*/
        for(j=0;j<=3;j++) /*vezi nebo damou po rade/sloupci*/
        {k=ofsety[j];
            while(1){if((*(p+k)==4)||(*(p+k)==5))return 1;if(*(p+k))break;k+=ofsety[j];}
        }
        for(j=4;j<=7;j++) /*strelcem nebo damou po diagonale*/
        {k=ofsety[j];
            while(1){if((*(p+k)==3)||(*(p+k)==5))return 1;if(*(p+k))break;k+=ofsety[j];}
        }
    } else /*cernym*/
    {
        if (*(p+9)==-1) return 1;/*pescem*/
        if (*(p+11)==-1) return 1;/*pescem*/
        for(j=8;j<=15;j++)if (*(p+ofsety[j])==-2) return 1;/*konem*/
        for(j=0;j<=7;j++)if (*(p+ofsety[j])==-6) return 1;/*kralem*/
        for(j=0;j<=3;j++) /*vezi nebo damou po rade/sloupci*/
        {k=ofsety[j];
            while(1){if((*(p+k)==-4)||(*(p+k)==-5))return 1;if(*(p+k))break;k+=ofsety[j];}
        }
        for(j=4;j<=7;j++) /*strelcem nebo damou po diagonale*/
        {k=ofsety[j];
            while(1){if((*(p+k)==-3)||(*(p+k)==-5))return 1;if(*(p+k))break;k+=ofsety[j];}
        }
    }
    return 0;
} */

fun napadeno(uloha: Uloha, pole: Int, bilym: Boolean): Boolean {
    if (bilym) {
        val r =
            napadenoBilymPescem(uloha, pole) ||
            napadenoBilymJezdcem(uloha, pole) ||
            napadenoBilouSikmou(uloha, pole) ||
            napadenoBilouRovnou(uloha, pole) ||
            napadenoBilymKralem(uloha, pole)
        return r
    } else {
        return false
    }
}
