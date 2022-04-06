package ba.etf.rma22.projekat.data.repositories

import ba.etf.rma22.projekat.data.allIstrazivanja
import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.data.models.Istrazivanje

object IstrazivanjeRepository {
    fun getIstrazivanjeByGodina(godina: Int) : List<Istrazivanje>{
        val poGodini = ArrayList<Istrazivanje>()
        for(istrazivanje in allIstrazivanja()){
            if(godina==istrazivanje.godina){
                poGodini.add(istrazivanje)
            }
        }
        return poGodini
    }
    fun getAll() : List<Istrazivanje>{
       return allIstrazivanja()
    }

    /*fun getUpisani(godina : Int) : List<Istrazivanje>{

    }*/

}