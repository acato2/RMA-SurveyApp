package ba.etf.rma22.projekat.data.repositories

import android.content.Context
import android.text.format.DateFormat.getDateFormat
import ba.etf.rma22.projekat.data.models.Account
import ba.etf.rma22.projekat.data.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.util.*


class AccountRepository {
    companion object {
        var acHash: String = "91fd5734-9146-42c3-a963-0394e0110762"
        private lateinit var context: Context

        fun setContext(_context: Context) {
            context = _context;
        }

        fun getContext(): Context {
            return context
        }

        suspend fun postaviHash(accHash: String): Boolean {
            return withContext(Dispatchers.IO) {
                try {
                    if(accHash!= acHash) {
                        acHash=accHash
                        val db = AppDatabase.getInstance(context)
                        db.accountDao().deleteAcc()
                        db.anketaDao().obrisiDb()
                        db.istrazivanjeDao().obrisiDb()
                        db.grupaDao().obrisiDb()
                        db.pitanjeDao().obrisiDb()
                        db.odgovorDao().obrisiDb()
                        val acc = ApiAdapter.retrofit.getAcc(accHash)
                        db!!.accountDao().insertAcc(acc)

                    }
                    return@withContext true
                } catch (e: Exception) {
                    return@withContext false
                }

            }

        }


        fun getHash(): String {
            return acHash
        }
    }


}