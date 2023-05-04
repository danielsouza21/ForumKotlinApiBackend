package br.com.Forum.repository

import br.com.Forum.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface IUsuarioRepository : JpaRepository<Usuario, Long> {
}