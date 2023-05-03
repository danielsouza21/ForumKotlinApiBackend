package br.com.Forum.dto

import br.com.Forum.model.StatusTopico
import java.time.LocalDateTime

data class TopicoViewDto (
    val id: Long?,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopico,
    val dataCriacao: LocalDateTime
)
