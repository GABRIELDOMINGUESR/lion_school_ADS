package br.senai.sp.jandira.lionschool.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    private val URL_BASE = "http://localhost:8080/v1/lion-school/"

    //Guarda a conexão com o server, devolve a conexão
    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL_BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun getCursoService(): CursoService{
        return retrofitFactory.create(CursoService::class.java)
    }


}