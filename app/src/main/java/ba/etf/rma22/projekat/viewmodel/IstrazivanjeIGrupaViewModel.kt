package ba.etf.rma22.projekat.viewmodel


import ba.etf.rma22.projekat.data.models.Grupa
import ba.etf.rma22.projekat.data.models.Istrazivanje
import ba.etf.rma22.projekat.data.repositories.AccountRepository
import ba.etf.rma22.projekat.data.repositories.ApiAdapter
import ba.etf.rma22.projekat.data.repositories.IstrazivanjeIGrupaRepository
import kotlinx.coroutines.*

class IstrazivanjeIGrupaViewModel {
    val scope = CoroutineScope(Job() + Dispatchers.Main)

    fun getIstrazivanja(onSuccess: (ankete: List<Istrazivanje>) -> Unit,
               onError: () -> Unit, offset:Int){
        scope.launch{
            val result = IstrazivanjeIGrupaRepository.getIstrazivanja(offset)
            when (result) {
                is List<Istrazivanje> -> onSuccess?.invoke(result)
                else-> onError?.invoke()
            }
        }
    }
    fun getIstrazivanja(onSuccess: (ankete: List<Istrazivanje>) -> Unit,
                        onError: () -> Unit){
        scope.launch{
            val result = IstrazivanjeIGrupaRepository.getIstrazivanja()
            when (result) {
                is List<Istrazivanje> -> onSuccess?.invoke(result)
                else-> onError?.invoke()
            }
        }
    }
    fun getGrupe(onSuccess: (ankete: List<Grupa>) -> Unit,
                               onError: () -> Unit){
        scope.launch {
            val result = IstrazivanjeIGrupaRepository.getGrupe()
            when (result) {
                is List<Grupa> -> onSuccess?.invoke(result)
                else -> onError?.invoke()
            }
        }
    }


    fun getGrupeZaIstrazivanje(onSuccess: (ankete: List<Grupa>) -> Unit,
                               onError: () -> Unit,idIstrazivanja:Int){
        scope.launch {
            var sveGrupe = ApiAdapter.retrofit.getGrupe()
            var pomocni = mutableListOf<Grupa>()
            for(grupa in sveGrupe){
                if(grupa.istrazivanjeId==idIstrazivanja){
                    pomocni.add(grupa)
                }
            }
            when (pomocni) {
                is List<Grupa> -> onSuccess?.invoke(pomocni)
                else -> onError?.invoke()
            }
        }
    }

    suspend fun upisiUGrupu(idGrupa:Int):Boolean{
        return withContext(Dispatchers.IO) {
            val odgovor = ApiAdapter.retrofit.upisiUGrupu(idGrupa, AccountRepository.acHash)
            var rezultat = true
            return@withContext rezultat
        }
    }
    suspend fun getUpisaneGrupe(onSuccess: (grupe: List<Grupa>) -> Unit,
                                onError: () -> Unit){
        return withContext(Dispatchers.IO) {
            scope.launch {
                val odgovor = ApiAdapter.retrofit.getUpisaneGrupe(AccountRepository.acHash)
                when(odgovor){
                    is List<Grupa> -> onSuccess?.invoke(odgovor)
                    else -> onError?.invoke()

                }
            }
        }
    }



}