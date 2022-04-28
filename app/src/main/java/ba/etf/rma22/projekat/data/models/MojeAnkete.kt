package ba.etf.rma22.projekat.data.models

import ba.etf.rma22.projekat.data.allAnkete
import ba.etf.rma22.projekat.data.myAnkete

class MojeAnkete {
    companion object Moje {
        var odradjenaUpisana: Int = 0
        var mojeAnkete=ArrayList<Anketa>(myAnkete())
        fun dodajUMojeAnkete(anketa: Anketa){
            mojeAnkete.add(anketa)
        }
        //metoda za unit testove,vracanje na pocetno stanje
        fun vratiNaPocetno(){
            mojeAnkete.clear()
            mojeAnkete.addAll(myAnkete())
        }
        fun obrisiStaruAnketu(anketa : Anketa){
            mojeAnkete.remove(anketa)
        }
        fun dodajNovuAnketu(anketa : Anketa){
            mojeAnkete.add(anketa)
        }


    }
}