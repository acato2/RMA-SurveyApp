package ba.etf.rma22.projekat.data.models.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ba.etf.rma22.projekat.data.models.Odgovor

@Dao
interface OdgovorDao {
    @Query("DELETE FROM odgovor")
    suspend fun obrisiDb()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun napraviDb(odgovor: List<Odgovor>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun dodajOdgovor(odgovor: Odgovor)

    @Insert
    fun insertOdgovor(odgovor: Odgovor)

}