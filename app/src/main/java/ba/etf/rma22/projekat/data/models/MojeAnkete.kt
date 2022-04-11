package ba.etf.rma22.projekat.data.models

import ba.etf.rma22.projekat.data.myAnkete

class MojeAnkete {
    companion object Moje {
        var mojeAnkete=ArrayList<Anketa>(myAnkete())
        fun dodajUMojeAnkete(anketa: Anketa){
            mojeAnkete.add(anketa)
        }
        //metoda za unit testove,vracanje na pocetno stanje
        fun vratiNaPocetno(){
            mojeAnkete.clear()
            mojeAnkete.addAll(myAnkete())
        }
    }
}