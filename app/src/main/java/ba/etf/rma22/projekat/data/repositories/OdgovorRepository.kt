package ba.etf.rma22.projekat.data.repositories

import android.content.Context
import ba.etf.rma22.projekat.data.AppDatabase
import ba.etf.rma22.projekat.data.models.Odgovor
import ba.etf.rma22.projekat.data.models.OdgovorPitanjeProgres
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.withContext
import java.lang.Exception

class OdgovorRepository {
    companion object {
        private lateinit var context: Context
        fun setContext(_context: Context) {
            context = _context;
        }
        private var maxId: Int = 0

        suspend fun getOdgovoriAnketa(idAnkete: Int): List<Odgovor> {
            return withContext(Dispatchers.IO) {
                val acc = AccountRepository()
                val poceteAnkete = ApiAdapter.retrofit.getPoceteAnkete(AccountRepository.getHash())
                var a: Int = -1
                for (anketa in poceteAnkete) {
                    if (anketa.AnketumId == idAnkete) {
                        a = anketa.id
                        break
                    }
                }
                if (a == -1)
                    return@withContext emptyList<Odgovor>()
                try {
                    val rezultat = ApiAdapter.retrofit.getOdgovoriAnketa(AccountRepository.getHash(), a)
                    return@withContext rezultat
                } catch (e: Exception) {
                    return@withContext emptyList<Odgovor>()
                }
            }

        }

        suspend fun postaviOdgovorAnketa(idAnketaTaken: Int, idPitanje: Int, odgovor: Int): Int {
            return withContext(Dispatchers.IO) {
                val progres = PitanjeAnketaRepository.getProgres(idAnketaTaken)
                // AnketaRepository.anketaTaken!!.progres=progres
                val acc = AccountRepository()
                val odg =
                    OdgovorPitanjeProgres(odgovor = odgovor, pitanje = idPitanje, progres = progres)
                try {
                    ApiAdapter.retrofit.postaviOdgovorAnketa(
                        AccountRepository.getHash(), idAnketaTaken, odg
                    )
                    var baza = AppDatabase.getInstance(context)
                    baza.odgovorDao().obrisiDb()
                    baza.odgovorDao().insertOdgovor(
                        Odgovor(maxId+1,odgovor,idPitanje)
                    )
                    maxId+= 1
                    return@withContext progres
                } catch (e: Exception) {
                    return@withContext -1
                }

            }
        }

        suspend fun getOdgovorAnketa(idAnketaTaken: Int, idPitanje: Int): Int {
            return withContext(Dispatchers.IO){
                val acc = AccountRepository()
                var listaOdgovora = ApiAdapter.retrofit.getOdgovoriAnketa(AccountRepository.getHash(),idAnketaTaken)
                for(odgovor in listaOdgovora){
                    if(odgovor.pitanjeId == idPitanje)
                        return@withContext odgovor.odgovoreno
                }
                return@withContext -1
            }


        }
    }
}