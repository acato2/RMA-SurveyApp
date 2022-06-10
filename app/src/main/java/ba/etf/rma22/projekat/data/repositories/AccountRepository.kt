package ba.etf.rma22.projekat.data.repositories



class AccountRepository {
    companion object {
        var acHash: String = "91fd5734-9146-42c3-a963-0394e0110762"
    }
    fun postaviHash(accHash:String):Boolean{
        try {
            acHash = accHash
            return true
        }catch (e:Exception){
            return false
        }
    }

    fun getHash():String{
        return acHash
    }
}