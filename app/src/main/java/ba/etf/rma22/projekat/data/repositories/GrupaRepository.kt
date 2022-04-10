package ba.etf.rma22.projekat.data.repositories

import ba.etf.rma22.projekat.data.models.allGroups
import ba.etf.rma22.projekat.data.models.Grupa

object GrupaRepository {
   fun getGroupsByIstrazivanje(nazivIstrazivanja : String):List<Grupa>{
       val grupe = ArrayList<Grupa>()
       for(grupa in allGroups()){
           if(nazivIstrazivanja.equals(grupa.nazivIstrazivanja)){
               grupe.add(grupa)
           }
       }
        return grupe
   }

}