package br.com.Forum.services

import br.com.Forum.exception.NotFoundException
import br.com.Forum.model.Curso
import br.com.Forum.repository.ICursoRepository
import org.springframework.stereotype.Service

@Service //DependencyInjection
class CursoService(private var cursoRepository: ICursoRepository) {
    private val NOT_FOUND_MESSAGE: String = "Curso não encontrado!";

    fun buscarPorId(id: Long): Curso {
        return cursoRepository.findById(id)
            .orElseThrow{ NotFoundException(NOT_FOUND_MESSAGE) };
    }
}
