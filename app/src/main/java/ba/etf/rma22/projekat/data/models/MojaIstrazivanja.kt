package ba.etf.rma22.projekat.data.models

import ba.etf.rma22.projekat.data.upisanaIstrazivanja

class MojaIstrazivanja {
    companion object {
        val upisanaIstrazivanja = ArrayList<Istrazivanje>(upisanaIstrazivanja())
        fun dodajUMojaIstrazivanja(istrazivanje : Istrazivanje){
            upisanaIstrazivanja.add(istrazivanje)
        }

    }
}