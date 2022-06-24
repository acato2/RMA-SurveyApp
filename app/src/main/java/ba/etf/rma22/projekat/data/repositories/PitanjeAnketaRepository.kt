package ba.etf.rma22.projekat.data.repositories

import android.content.Context
import ba.etf.rma22.projekat.data.AppDatabase
import ba.etf.rma22.projekat.data.models.Pitanje
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class PitanjeAnketaRepository {
    companion object {
        private lateinit var context: Context
        fun setContext(_context: Context) {
            context = _context;
        }

        suspend fun getPitanja(idAnkete: Int): List<Pitanje>? {
            return withContext(Dispatchers.IO) {

                    var response = ApiAdapter.retrofit.getPitanja(idAnkete)
                    var baza = AppDatabase.getInstance(context)
                    baza.pitanjeDao().insertPitanja(response)

                    return@withContext response

            }
        }

        suspend fun getProgres(idAnketaTaken: Int): Int {
            return withContext(Dispatchers.IO) {
                //uzimamo id ankete
                var idPoceteAnkete = 0
                val poceteAnkete = TakeAnketaRepository.getPoceteAnkete()
                if (poceteAnkete != null) {
                    for (anketa in poceteAnkete) {
                        if (anketa.id == idAnketaTaken) {
                            idPoceteAnkete = anketa.AnketumId
                        }
                    }
                }
                //uzimamo pitanja te ankete
                val pitanja = getPitanja(idPoceteAnkete)
                val odgovori = OdgovorRepository.getOdgovoriAnketa(idPoceteAnkete)
                var postotak = ((odgovori.size.toDouble() + 1) / (pitanja!!.size.toDouble()))
                var r = 0.2
                var progres = Math.round(postotak / r) * r
                progres *= 100
                return@withContext progres.toInt()
            }
        }
    }
}
