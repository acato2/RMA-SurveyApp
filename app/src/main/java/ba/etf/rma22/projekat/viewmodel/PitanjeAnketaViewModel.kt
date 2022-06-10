package ba.etf.rma22.projekat.viewmodel


import ba.etf.rma22.projekat.data.models.Pitanje
import ba.etf.rma22.projekat.data.repositories.OdgovorRepository
import ba.etf.rma22.projekat.data.repositories.PitanjeAnketaRepository
import kotlinx.coroutines.*



class PitanjeAnketaViewModel {
    val scope = CoroutineScope(Job() + Dispatchers.Main)
    fun getPitanja(
        idAnkete: Int, onSuccess: (pitanja: List<Pitanje>) -> Unit,
        onError: () -> Unit
    ){
        scope.launch {
            val pitanja = PitanjeAnketaRepository.getPitanja(idAnkete)
            when (pitanja) {
                is List<Pitanje> -> onSuccess?.invoke(pitanja)
                else -> onError?.invoke()
            }
        }
    }
    fun postaviOdgovorAnketa(idAnketaTaken:Int, idPitanje:Int, odgovor:Int){
        GlobalScope.launch{
            OdgovorRepository.postaviOdgovorAnketa(idAnketaTaken, idPitanje, odgovor)
        }
    }

    fun getProgres(anketaTaken: Int,
                    onSuccess: (rezultat: Int) -> Unit,
                    onError: () -> Unit){
        GlobalScope.launch {
            var rezultat = PitanjeAnketaRepository.getProgres(anketaTaken)
            when(rezultat){
                is Int -> onSuccess?.invoke(rezultat)
                else -> onError?.invoke()
            }
        }
    }

    fun getOdgovor(idAnketaTaken: Int, idPitanje: Int, onSuccess: (odgovor:Int) ->Unit, onError: () ->Unit) {
        scope.launch {
            var odgovor = OdgovorRepository.getOdgovorAnketa(idAnketaTaken,idPitanje)
            when(odgovor){
                is Int -> onSuccess?.invoke(odgovor)
                else -> onError?.invoke()
            }
        }

    }

}