package ba.etf.rma22.projekat.data.repositories

import ba.etf.rma22.projekat.data.models.Istrazivanje
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object IstrazivanjeRepository {
    suspend fun getIstrazivanjaByGodina(godina: Int): List<Istrazivanje>{
        return withContext(Dispatchers.IO){
            var response = ApiAdapter.retrofit.getIstrazivanjaByGodina(1)
            return@withContext response
        }

    }
    suspend fun getUpisanaIstrazivanja(istrazivanjaId:List<Int>):List<Istrazivanje>{
        return withContext(Dispatchers.IO) {
            val istrazivanja = IstrazivanjeIGrupaRepository.getIstrazivanja(1)
            return@withContext istrazivanja!!
        }

    }


}