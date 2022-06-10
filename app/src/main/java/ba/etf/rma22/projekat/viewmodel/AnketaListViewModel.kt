package ba.etf.rma22.projekat.viewmodel

import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.data.models.AnketaTaken
import ba.etf.rma22.projekat.data.repositories.AnketaRepository
import ba.etf.rma22.projekat.data.repositories.TakeAnketaRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class AnketaListViewModel {
    val scope = CoroutineScope(Job() + Dispatchers.Main)

    fun getAll( onSuccess: (ankete: List<Anketa>) -> Unit,
                onError: () -> Unit,offset:Int){
        scope.launch{
            val result =AnketaRepository.getAll(offset)
            when (result) {
                is List<Anketa> -> onSuccess?.invoke(result)
                else-> onError?.invoke()
            }
        }
    }
    fun getAll(onSuccess: (ankete: List<Anketa>) -> Unit,
               onError: () -> Unit){
        scope.launch {
            val result=AnketaRepository.getAll()
            when (result) {
                is List<Anketa> -> onSuccess?.invoke(result)
                else-> onError?.invoke()
            }
        }
    }

    fun getMyAnkete(onSuccess: (ankete: List<Anketa>) -> Unit,
                    onError: () -> Unit){
        scope.launch{
            val result =AnketaRepository.getUpisane()
            when (result) {
                is List<Anketa> -> onSuccess?.invoke(result)
                else-> onError?.invoke()
            }
        }
    }
    fun getDone(onSuccess: (ankete: List<Anketa>) -> Unit,
                onError: () -> Unit){
        scope.launch{
            val result =AnketaRepository.getDone()
            when (result) {
                is MutableList<Anketa> -> onSuccess?.invoke(result)
                else-> onError?.invoke()
            }
        }
    }
    fun getFuture(onSuccess: (ankete: List<Anketa>) -> Unit,
                  onError: () -> Unit){
        scope.launch{
            val result =AnketaRepository.getFuture()
            when (result) {
                is MutableList<Anketa> -> onSuccess?.invoke(result)
                else-> onError?.invoke()
            }
        }
    }
   fun getNotTaken(onSuccess: (ankete: List<Anketa>) -> Unit,
                    onError: () -> Unit){
        scope.launch{
            val result =AnketaRepository.getNotTaken()
            when (result) {
                is List<Anketa> -> onSuccess?.invoke(result)
                else-> onError?.invoke()
            }
        }
    }

    fun getPoceteAnkete(onSuccess: (ank: List<AnketaTaken>) -> Unit,
                        onError: () -> Unit) {
        scope.launch {
            val ankete = TakeAnketaRepository.getPoceteAnkete()
            when(ankete){
                is List<AnketaTaken> -> onSuccess?.invoke(ankete)
                else -> onError?.invoke()
            }
        }

    }
    fun zapocniAnketu(anketa: Int, onSuccess: () -> Unit, onError: () -> Unit) {
        scope.launch {
            TakeAnketaRepository.zapocniAnketu(anketa)
            onSuccess.invoke()

        }
    }
    fun getUpisane(onSuccess: (ankete : List<Anketa>) -> Unit, onError: () -> Unit) {
        scope.launch {
            val response = AnketaRepository.getUpisane()
            when(response){
                is List<Anketa> -> onSuccess?.invoke(response)
                else -> onError?.invoke()
            }

        }
    }

    fun getPoceteAnketeApp2(anketa: Anketa, onSuccess: (rezultat: Boolean, anketa: Anketa) -> Unit,
                            onError: () -> Unit) {
        scope.launch {
            val rezultat = TakeAnketaRepository.getPoceteAnkete2()
            when(rezultat){
                is Boolean-> onSuccess?.invoke(rezultat, anketa)
                else -> onError?.invoke()
            }
        }

    }


}