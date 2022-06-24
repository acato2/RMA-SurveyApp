package ba.etf.rma22.projekat.data.models.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ba.etf.rma22.projekat.data.models.Pitanje

@Dao
interface PitanjeDao {

    @Query("DELETE FROM pitanje")
    suspend fun obrisiDb()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun napraviDb(pitanje: List<Pitanje>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPitanja(pitanja: List<Pitanje>)

}