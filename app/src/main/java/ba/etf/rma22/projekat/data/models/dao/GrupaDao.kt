package ba.etf.rma22.projekat.data.models.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ba.etf.rma22.projekat.data.models.Grupa
import ba.etf.rma22.projekat.data.models.Istrazivanje

@Dao
interface GrupaDao {
    @Query("DELETE FROM grupa")
    suspend fun obrisiDb()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun napraviDb(grupe: List<Grupa>)

    @Insert
    suspend fun unesiGrupe(grupe: List<Grupa>)

    @Query("SELECT * FROM grupa")
    fun getAllGrupe(): List<Grupa>



}