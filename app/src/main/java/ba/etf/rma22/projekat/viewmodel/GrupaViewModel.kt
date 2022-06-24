package ba.etf.rma22.projekat.viewmodel


import ba.etf.rma22.projekat.data.models.Grupa
import ba.etf.rma22.projekat.data.repositories.AccountRepository
import ba.etf.rma22.projekat.data.repositories.GrupaRepository
import ba.etf.rma22.projekat.data.repositories.IstrazivanjeIGrupaRepository
import kotlinx.coroutines.*

class GrupaViewModel {
    val scope = CoroutineScope(Job() + Dispatchers.Main)
    fun getGroupsByIstrazivanje(onSuccess: (ankete: List<Grupa>) -> Unit,
                                onError: () -> Unit,nazivIstrazivanja : String){
            scope.launch{
                val result = GrupaRepository.getGroupsByIstrazivanje(nazivIstrazivanja)
                when (result) {
                    is List<Grupa> -> onSuccess?.invoke(result)
                    else-> onError?.invoke()
                }
            }

    }

    fun upisUGrupu(idGrupe: Int, onSuccess: (Boolean) -> Unit, onError: () -> Unit) {
        scope.launch {
            val upisan = IstrazivanjeIGrupaRepository.upisiUGrupu(idGrupe)
            when (upisan) {
                is Boolean -> onSuccess?.invoke(upisan)
                else -> onError?.invoke()
            }
        }
    }

    fun changeHash(hash: String,
                      onSuccess: () -> Unit,
                      onError: () -> Unit
    ){
        GlobalScope.launch{
            val accUpisan = AccountRepository.postaviHash(hash)
            when(accUpisan){
                is Boolean-> onSuccess?.invoke()
                else -> onError?.invoke()
            }
        }
    }


}