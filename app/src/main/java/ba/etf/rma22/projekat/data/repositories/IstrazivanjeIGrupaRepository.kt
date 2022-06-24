package ba.etf.rma22.projekat.data.repositories

import android.content.Context
import ba.etf.rma22.projekat.data.AppDatabase
import ba.etf.rma22.projekat.data.models.Grupa
import ba.etf.rma22.projekat.data.models.Istrazivanje
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class IstrazivanjeIGrupaRepository {
    companion object {
        private lateinit var context: Context
        fun setContext(_context: Context) {
            context = _context;
        }


        suspend fun getIstrazivanja(): List<Istrazivanje> {
            return withContext(Dispatchers.IO) {
                try{
                var page1 = getIstrazivanja(1)
                var page2 = getIstrazivanja(2)
                var svaIstrazivanja = mutableListOf<Istrazivanje>()
                svaIstrazivanja.addAll(page1!!)
                svaIstrazivanja.addAll(page2!!)
                try {
                    var baza = AppDatabase.getInstance(context)
                    baza.istrazivanjeDao().unesiIstrazivanja(svaIstrazivanja)
                    return@withContext svaIstrazivanja
                } catch (e: Exception) {
                    return@withContext svaIstrazivanja
                }

                }catch (e:Exception){
                    try {
                        var baza = AppDatabase.getInstance(context)
                        var istrazivanja = baza.istrazivanjeDao().getAllIstrazivanja()
                        return@withContext istrazivanja!!
                    }
                    catch (e:Exception){
                        return@withContext null!!
                    }
                }

            }
        }

        //sva istrazivanja
        suspend fun getIstrazivanja(offset: Int): List<Istrazivanje>? {
            return withContext(Dispatchers.IO) {
                try{
                var response = ApiAdapter.retrofit.getIstrazivanja(offset)
                try {
                    var baza = AppDatabase.getInstance(context)
                    baza.istrazivanjeDao().unesiIstrazivanja(response)
                    return@withContext response

                } catch (e: Exception) {
                    return@withContext response
                }


            }catch (e:Exception){
                try {
                    var baza = AppDatabase.getInstance(context)
                    var istrazivanja = baza.istrazivanjeDao().getAllIstrazivanja()
                    return@withContext istrazivanja
                }
                catch (e:Exception){
                    return@withContext null
                }

                }            }
                }


        //sve grupe
        suspend fun getGrupe(): List<Grupa>? {
            return withContext(Dispatchers.IO) {
                try{

                    var response = ApiAdapter.retrofit.getGrupe()
                    try {
                        var baza = AppDatabase.getInstance(context)
                        baza.grupaDao().unesiGrupe(response)
                        return@withContext response

                    } catch (e: Exception) {
                        return@withContext response
                    }

                    }catch (e:Exception){
                        try {
                            var baza = AppDatabase.getInstance(context)
                            var grupe = baza.grupaDao().getAllGrupe()
                            return@withContext grupe
                        }catch (e:Exception){
                            return@withContext null
                        }
                    }

            }
        }


        //grupe na istrazivanju sa idIstrazivanje
        suspend fun getGrupeZaIstrazivanje(idIstrazivanja: Int): List<Grupa> {
            return withContext(Dispatchers.IO) {
                var sveGrupe = ApiAdapter.retrofit.getGrupeZaIstrazivanje(idIstrazivanja)
                var pomocni = mutableListOf<Grupa>()
                for (grupa in sveGrupe) {
                    if (grupa.istrazivanjeId == idIstrazivanja) {
                        pomocni.add(grupa)
                    }
                }
                return@withContext pomocni
            }

        }


        suspend fun upisiUGrupu(idGrupa: Int): Boolean {
            return withContext(Dispatchers.IO) {
                val acc = AccountRepository()
                val odg = ApiAdapter.retrofit.upisiUGrupu(idGrupa, AccountRepository.getHash())
                var rez = true
                if (odg.message.contains("not found") || odg.message.contains("Ne postoji account"))
                    rez = false
                return@withContext rez
            }
        }

        suspend fun getUpisaneGrupe(): List<Grupa> {
            return withContext(Dispatchers.IO) {
                val acc = AccountRepository()
                return@withContext ApiAdapter.retrofit.getUpisaneGrupe(AccountRepository.getHash())
            }

        }
    }
}