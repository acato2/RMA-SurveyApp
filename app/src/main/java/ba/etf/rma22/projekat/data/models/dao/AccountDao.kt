package ba.etf.rma22.projekat.data.models.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ba.etf.rma22.projekat.data.models.Account

@Dao
interface AccountDao {
    @Query ("SELECT * FROM account")
    suspend fun getAcc(): Account

    @Query ("DELETE FROM account")
    suspend fun deleteAcc()

    @Insert
    suspend fun insertAcc(vararg acc: Account)

    @Query("SELECT acHash from Account")
    suspend fun getHash() : String



}