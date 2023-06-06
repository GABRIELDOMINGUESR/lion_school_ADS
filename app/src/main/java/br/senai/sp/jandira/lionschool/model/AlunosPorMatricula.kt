package br.senai.sp.jandira.lionschool.model

data class AlunosPorMatricula(
    val foto: String,
    val nome: String,
    val matricula: Int,
    val sexo: String,
    val curso: Curso
)
