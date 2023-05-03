package br.com.Forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class IncluirTopicoFormDto (
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val titulo: String,

    @field:NotEmpty val mensagem: String,
    @field:NotNull val idCurso: Long,
    @field:NotNull val idAutor: Long
)
