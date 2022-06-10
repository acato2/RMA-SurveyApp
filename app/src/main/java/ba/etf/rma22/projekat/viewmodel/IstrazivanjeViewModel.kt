package ba.etf.rma22.projekat.viewmodel


import ba.etf.rma22.projekat.data.models.Istrazivanje
import ba.etf.rma22.projekat.data.repositories.IstrazivanjeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class IstrazivanjeViewModel {
    val scope = CoroutineScope(Job() + Dispatchers.Main)
    fun getIstrazivanjaByGodina(godina: Int,
                            onSuccess: (istrazivanja: List<Istrazivanje>) -> Unit,
                            onError: () -> Unit
    ){
        scope.launch{
            val istrazivanja = IstrazivanjeRepository.getIstrazivanjaByGodina(godina)
            when(istrazivanja){
                is List<Istrazivanje> -> onSuccess?.invoke(istrazivanja)
                else -> onError?.invoke()
            }
        }
    }
    fun getUpisanaIstrazivanja(istrazivanjaId:List<Int>, onSuccess: (istrazivanja: List<Istrazivanje>) -> Unit,
                                       onError: () -> Unit){
        scope.launch {
            val istrazivanja = IstrazivanjeRepository.getUpisanaIstrazivanja(istrazivanjaId)
            val nova = mutableListOf<Istrazivanje>()
            for(i in istrazivanja){
                if(istrazivanjaId.contains(i.id)){
                    nova.add(i)
                }
            }

            when(nova){
                is List<Istrazivanje> -> onSuccess?.invoke(nova)
                else -> onError?.invoke()
            }

        }


    }


}