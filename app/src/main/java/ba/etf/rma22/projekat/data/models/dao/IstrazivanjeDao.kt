package ba.etf.rma22.projekat.data.models.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ba.etf.rma22.projekat.data.models.Istrazivanje

@Dao
interface IstrazivanjeDao {
    @Query("DELETE FROM istrazivanje")
    suspend fun obrisiDb()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun napraviDb(istrazivanja: List<Istrazivanje>)

    @Insert
    suspend fun unesiIstrazivanja(istrazivanje: List<Istrazivanje>)

    @Query("SELECT * FROM istrazivanje")
    fun getAllIstrazivanja(): List<Istrazivanje>?
}