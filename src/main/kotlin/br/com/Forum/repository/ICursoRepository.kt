package br.com.Forum.repository

import br.com.Forum.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface ICursoRepository: JpaRepository<Curso, Long> {
}