package ba.etf.rma22.projekat.data.repositories

import ba.etf.rma22.projekat.data.models.*

object AnketaRepository {

    fun getMyAnkete():List<Anketa>{
        return myAnkete()
    }
    fun getAll() : List<Anketa>{
        return allAnkete()
    }
    fun getDone() :List<Anketa>{
        return doneAnkete()
    }
    fun getFuture() :List<Anketa>{
        return futureAnkete()
    }
    fun getNotTaken() :List<Anketa>{
        return notTakenAnkete()

    }

}