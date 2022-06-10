package ba.etf.rma22.projekat.data.repositories

import ba.etf.rma22.projekat.data.models.Grupa
import ba.etf.rma22.projekat.data.models.Istrazivanje
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


object IstrazivanjeIGrupaRepository {

    suspend fun getIstrazivanja():List<Istrazivanje>{
        return withContext(Dispatchers.IO) {
            var page1 = getIstrazivanja(1)
            var page2 = getIstrazivanja(2)
            var svaIstrazivanja = mutableListOf<Istrazivanje>()
            svaIstrazivanja.addAll(page1!!)
            svaIstrazivanja.addAll(page2!!)
            return@withContext svaIstrazivanja
        }
    }

    //sva istrazivanja
    suspend fun getIstrazivanja(offset:Int):List<Istrazivanje>{
        return withContext(Dispatchers.IO) {
            return@withContext ApiAdapter.retrofit.getIstrazivanja(offset)
        }
    }
    //sve grupe
    suspend fun getGrupe():List<Grupa>{
        return withContext(Dispatchers.IO) {
            return@withContext ApiAdapter.retrofit.getGrupe()
        }
    }
    //grupe na istrazivanju sa idIstrazivanje
    suspend fun getGrupeZaIstrazivanje(idIstrazivanja:Int):List<Grupa>{
        return withContext(Dispatchers.IO){
            var sveGrupe = ApiAdapter.retrofit.getGrupeZaIstrazivanje(idIstrazivanja)
            var pomocni = mutableListOf<Grupa>()
            for(grupa in sveGrupe){
                if(grupa.istrazivanjeId==idIstrazivanja){
                    pomocni.add(grupa)
                }
            }
            return@withContext pomocni
        }

    }


    suspend fun upisiUGrupu(idGrupa:Int):Boolean{
        return withContext(Dispatchers.IO) {
            val acc = AccountRepository()
            val odg = ApiAdapter.retrofit.upisiUGrupu(idGrupa, acc.getHash())
            var rez = true
            if(odg.message.contains("not found") || odg.message.contains("Ne postoji account"))
                rez = false
            return@withContext rez
        }
    }

    suspend fun getUpisaneGrupe():List<Grupa>{
        return withContext(Dispatchers.IO){
            val acc = AccountRepository()
            return@withContext ApiAdapter.retrofit.getUpisaneGrupe(acc.getHash())
        }

    }
}