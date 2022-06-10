package ba.etf.rma22.projekat.data.repositories


import ba.etf.rma22.projekat.data.models.AnketaTaken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

object TakeAnketaRepository {

    suspend fun zapocniAnketu(idAnkete:Int): AnketaTaken? {
        return withContext(Dispatchers.IO){
            val acc = AccountRepository()
            try {
                return@withContext ApiAdapter.retrofit.zapocniAnketu(acc.getHash(), idAnkete)
            } catch (e: Exception) {
                return@withContext null
            }
        }

    }
    suspend fun getPoceteAnkete():List<AnketaTaken>?{
        return withContext(Dispatchers.IO){
            val acc = AccountRepository()
            try {
                val rezultat = ApiAdapter.retrofit.getPoceteAnkete(acc.getHash())
                if (rezultat.isEmpty())
                    return@withContext null
                return@withContext rezultat
            }catch (e:Exception){
                return@withContext null
            }
        }

    }

    suspend fun getPoceteAnkete2(): Boolean {
        return withContext(Dispatchers.IO) {
            val acc = AccountRepository()
            val pokrenuteAnkete = ApiAdapter.retrofit.getPoceteAnkete(acc.getHash())
            var imaGa = false
            for(pAnketa in pokrenuteAnkete){
                if(pAnketa.AnketumId == AnketaRepository.pokrenutaAnketa.id){
                    AnketaRepository.anketaTaken = pAnketa
                    imaGa = true
                    break
                }
            }
            if(!imaGa){
                val anketa = ApiAdapter.retrofit.zapocniAnketu(acc.getHash(),AnketaRepository.pokrenutaAnketa.id)
                AnketaRepository.anketaTaken = anketa
            }
            return@withContext true
        }
    }


}