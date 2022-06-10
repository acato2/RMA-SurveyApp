package ba.etf.rma22.projekat.data.repositories

import ba.etf.rma22.projekat.data.models.Pitanje
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


object PitanjeAnketaRepository {
    suspend fun getPitanja(idAnkete:Int): List<Pitanje>? {
        return withContext(Dispatchers.IO) {
            return@withContext ApiAdapter.retrofit.getPitanja(idAnkete)
        }
    }

    suspend fun getProgres(idAnketaTaken: Int): Int {
        return withContext(Dispatchers.IO) {
            //uzimamo id ankete
            var idPoceteAnkete = 0
            val poceteAnkete = TakeAnketaRepository.getPoceteAnkete()
            if(poceteAnkete!=null){
                for(anketa in poceteAnkete){
                    if(anketa.id==idAnketaTaken){
                        idPoceteAnkete=anketa.AnketumId
                    }
                }
            }
            //uzimamo pitanja te ankete
            val pitanja = getPitanja(idPoceteAnkete)
            val odgovori = OdgovorRepository.getOdgovoriAnketa(idPoceteAnkete)
            var postotak = ((odgovori.size.toDouble()+1)/(pitanja!!.size.toDouble()))
            var r = 0.2
            var progres = Math.round(postotak / r) * r
            progres*=100
            return@withContext progres.toInt()
        }
    }

}
