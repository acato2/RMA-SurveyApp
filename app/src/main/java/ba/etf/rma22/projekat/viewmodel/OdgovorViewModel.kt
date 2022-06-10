package ba.etf.rma22.projekat.viewmodel

import ba.etf.rma22.projekat.data.models.Odgovor
import ba.etf.rma22.projekat.data.repositories.OdgovorRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class OdgovorViewModel {
    val scope = CoroutineScope(Job() + Dispatchers.Main)
    fun postaviOdgovorAnketa(onSuccess: (progres : Int) -> Unit,
                             onError: () -> Unit,idAnketaTaken:Int, idPitanje:Int, odgovor:Int){
        scope.launch{
           val result =  OdgovorRepository.postaviOdgovorAnketa(idAnketaTaken,idPitanje,odgovor)
            when (result) {
                is Int -> {
                    onSuccess.invoke(result)
                }
                else-> onError.invoke()
            }
        }
        }
    fun getOdgovoriAnketa(onSuccess: (odgovori:List<Odgovor>) -> Unit,
                          onError: () -> Unit, idAnketa:Int){
        scope.launch{
            val result =  OdgovorRepository.getOdgovoriAnketa(idAnketa)
            when (result) {
                is List<Odgovor> -> {
                    onSuccess.invoke(result)
                }
                else-> onError.invoke()
            }
        }
    }


}