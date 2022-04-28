package ba.etf.rma22.projekat.data.repositories

import ba.etf.rma22.projekat.data.allAnkete
import ba.etf.rma22.projekat.data.models.*
import ba.etf.rma22.projekat.data.models.MojaIstrazivanja
import java.util.*
import kotlin.collections.ArrayList


object AnketaRepository {

    //one u koje je upisan
    fun getMyAnkete():List<Anketa>{
        return MojeAnkete.mojeAnkete
    }
    fun getAll() : List<Anketa>{
        return UradjeneAnkete.sveAnkete
    }
    fun getDone() :List<Anketa>{
        return UradjeneAnkete.uradjeneAnkete
    }

    //buduce ankete te grupe
    fun getFuture() :List<Anketa>{
        var buduceAnketeTeGrupe = ArrayList<Anketa>()
        val calender = Calendar.getInstance()
        val year = calender.get(Calendar.YEAR)-1900
        val month = calender.get(Calendar.MONTH)
        val day = calender.get(Calendar.DAY_OF_MONTH)
        val currentDate : Date = Date(year,month,day)
        for(anketa in MojeAnkete.mojeAnkete){
            for(svaka in getAll()){
                if(anketa.nazivGrupe.equals(svaka.nazivGrupe) && svaka.datumPocetak.after(currentDate) && !buduceAnketeTeGrupe.contains(svaka)){
                    buduceAnketeTeGrupe.add(svaka)

                }
            }
        }

        return buduceAnketeTeGrupe

    }
    fun getNotTaken() :List<Anketa>{
        var prosleAnketeTeGrupe = ArrayList<Anketa>()
        val calender = Calendar.getInstance()
        val year = calender.get(Calendar.YEAR)-1900
        val month = calender.get(Calendar.MONTH)
        val day = calender.get(Calendar.DAY_OF_MONTH)
        val currentDate : Date = Date(year,month,day)
        for(anketa in MojeAnkete.mojeAnkete){
            for(svaka in getAll()){
                if(anketa.nazivGrupe.equals(svaka.nazivGrupe) && svaka.datumKraj.before(currentDate) && !prosleAnketeTeGrupe.contains(svaka)){
                    prosleAnketeTeGrupe.add(svaka)

                }
            }
        }
        return prosleAnketeTeGrupe
    }

}