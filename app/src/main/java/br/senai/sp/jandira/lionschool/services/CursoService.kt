package br.senai.sp.jandira.lionschool.services

import br.senai.sp.jandira.lionschool.model.ListaCursos
import retrofit2.Call
import retrofit2.http.GET

interface CursoService {
    //http://localhost:8080/v1/lion-school/cursos

    @GET("cursos")
    fun getCursos(): Call<ListaCursos>

}