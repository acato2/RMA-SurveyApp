package ba.etf.rma22.projekat.data.repositories

import ba.etf.rma22.projekat.data.models.Pitanje
import ba.etf.rma22.projekat.data.svaPitanja

object PitanjeAnketaRepository {
    fun getPitanja(nazivAnkete:String,nazivIstrazivanje: String):List<Pitanje>{
        return svaPitanja(nazivAnkete,nazivIstrazivanje)
    }
}