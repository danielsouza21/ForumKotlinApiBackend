package br.com.Forum.exception

import java.time.LocalDateTime

data class ErrorView (
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val message: String?,
    val error: String,
    val path: String
)
