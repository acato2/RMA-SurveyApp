package ba.etf.rma22.projekat.viewmodel


import ba.etf.rma22.projekat.data.models.AnketaTaken
import ba.etf.rma22.projekat.data.repositories.TakeAnketaRepository
import kotlinx.coroutines.*

class TakeAnketaViewModel {
    val scope = CoroutineScope(Job() + Dispatchers.Main)

    fun zapocniAnketu(onSuccess: (anketaTaken:AnketaTaken) -> Unit,
                               onError: () -> Unit,idAnkete:Int){
        scope.launch {
            val result = TakeAnketaRepository.zapocniAnketu(idAnkete)
            when (result) {
                is AnketaTaken -> {
                    onSuccess.invoke(result)
                }
                else-> onError.invoke()
            }
            }
        }
    fun getPoceteAnkete(onSuccess: (anketeTaken:List<AnketaTaken>) -> Unit,
                                onError: () -> Unit) {
        scope.launch {
            val result = TakeAnketaRepository.getPoceteAnkete()
            when (result) {
                is List<AnketaTaken> -> {
                    onSuccess.invoke(result)
                }
                else-> onError.invoke()
            }
        }
    }

}