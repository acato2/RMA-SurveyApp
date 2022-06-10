package ba.etf.rma22.projekat.data

import ba.etf.rma22.projekat.data.models.*
import retrofit2.Response
import retrofit2.http.*

interface Api {

    @GET("anketa/{id}/pitanja")
    suspend fun getPitanja(
        @Path("id") idAnkete:Int
    ): List<Pitanje>


    @GET("anketa")
    suspend fun getAll(
        @Query("offset") offset:Int
    ): List<Anketa>

    @GET("anketa/{id}")
    suspend fun getById(
        @Path("id") id:Int
    ): Anketa

    @GET("grupa/{id}/ankete")
    suspend fun getUpisane(
        @Path("id") id:Int
    ):List<Anketa>


    @GET("student/{id}/anketataken/{ktid}/odgovori")
    suspend fun getOdgovoriAnketa(
        @Path("id") id:String,
        @Path("ktid") idAnkete:Int

    ):List<Odgovor>

    @POST("student/{id}/anketataken/{ktid}/odgovor")
    suspend fun postaviOdgovorAnketa(
        @Path("id") student: String,
        @Path("ktid") idAnketaTaken:Int,
        @Body odgovor:OdgovorPitanjeProgres
    ):PovratniOdg


    @POST("student/{id}/anketa/{kid}")
    suspend fun zapocniAnketu(
        @Path("id") id:String,
        @Path("kid") idAnkete:Int
    ):AnketaTaken

    @GET("student/{id}/anketataken")
    suspend fun getPoceteAnkete(
        @Path("id") id:String
    ):List<AnketaTaken>


    @GET("istrazivanje")
    suspend fun getIstrazivanja(
        @Query("offset") offset:Int
    ): List<Istrazivanje>

    @GET("grupa")
    suspend fun getGrupe(): List<Grupa>


    @GET("grupa")
    suspend fun getGrupeZaIstrazivanje(
        @Query("id") idIstrazivanja:Int
    ): List<Grupa>

    @POST("grupa/{gid}/student/{id}")
    suspend fun upisiUGrupu(
        @Path("gid") idGrupa:Int,
        @Path("id") id:String
    ): Message

    @GET("student/{id}/grupa")
    suspend fun getUpisaneGrupe(
        @Path("id") id:String
    ): List<Grupa>



    @GET("istrazivanje/{id}")
    suspend fun getIstrazivanjaById(
        @Path("id") idIstrazivanja:Int
    ):Istrazivanje

    @GET("anketa/{id}/grupa")
    suspend fun getGrupeZaAnketu(
        @Path("id") idAnkete:Int
    ):List<GrupaIstrazivanje>

    @GET("istrazivanje")
    suspend fun getIstrazivanjaByGodina(
        @Query("offset") offset:Int
    ): List<Istrazivanje>























}