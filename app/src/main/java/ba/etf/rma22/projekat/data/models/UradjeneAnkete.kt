package ba.etf.rma22.projekat.data.models

import ba.etf.rma22.projekat.data.allAnkete
import ba.etf.rma22.projekat.data.doneAnkete
import ba.etf.rma22.projekat.data.myAnkete

class UradjeneAnkete {
    companion object Uradjene {
        var uradjeneAnkete=ArrayList<Anketa>(doneAnkete())
        fun dodajUUradjeneAnkete(anketa: Anketa){
            uradjeneAnkete.add(anketa)
        }
        var sveAnketePlusUradjene=ArrayList<Anketa>()
        var sveAnkete=ArrayList<Anketa>(allAnkete())
        fun obrisiStaruAnketu(anketa: Anketa){
            for(a in sveAnkete){
                if(!a.equals(anketa)){
                    sveAnketePlusUradjene.add(a)
                }
            }
        }
        fun dodajNovuAnketu(anketa : Anketa){
            sveAnketePlusUradjene.add(anketa)
        }
    }

}