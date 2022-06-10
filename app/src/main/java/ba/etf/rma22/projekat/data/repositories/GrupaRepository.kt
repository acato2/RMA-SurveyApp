package ba.etf.rma22.projekat.data.repositories


import ba.etf.rma22.projekat.data.models.Grupa
import ba.etf.rma22.projekat.data.models.Istrazivanje
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object GrupaRepository {
   suspend fun getGroupsByIstrazivanje(nazivIstrazivanja : String):List<Grupa>{
       return withContext(Dispatchers.IO){
           var svaIstrazivanja = ApiAdapter.retrofit.getIstrazivanja(1)
           var idIstrazivanja : Int = 0
           for(istrazivanje in svaIstrazivanja){
               if(istrazivanje.naziv.equals(nazivIstrazivanja)){
                   idIstrazivanja=istrazivanje.id
               }
           }
           var response = ApiAdapter.retrofit.getGrupeZaIstrazivanje(idIstrazivanja)
           return@withContext response
       }
   }

}