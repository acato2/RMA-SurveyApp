package ba.etf.rma22.projekat.viewmodel

import ba.etf.rma22.projekat.data.models.Pitanje
import ba.etf.rma22.projekat.data.repositories.PitanjeAnketaRepository
import ba.etf.rma22.projekat.data.svaPitanja

class PitanjeAnketaViewModel {
    fun getPitanja(nazivAnkete:String,nazivIstrazivanje: String):List<Pitanje>{
        return PitanjeAnketaRepository.getPitanja(nazivAnkete,nazivIstrazivanje)
    }
}