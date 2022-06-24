package ba.etf.rma22.projekat.data.models.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.data.models.Grupa

@Dao
interface AnketaDao {
    @Query("DELETE FROM anketa")
    suspend fun obrisiDb()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun napraviDb(anketa: List<Anketa>)


    @Insert
    suspend fun unesiAnkete(grupe: List<Anketa>)

    @Query("SELECT * FROM anketa")
    fun getAllAnkete(): List<Anketa>?



}