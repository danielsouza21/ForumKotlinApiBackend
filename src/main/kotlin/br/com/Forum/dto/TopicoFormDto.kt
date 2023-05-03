package br.com.Forum.dto

data class TopicoFormDto (
    val titulo: String,
    val mensagem: String,
    val idCurso: Long,
    val idAutor: Long
)
