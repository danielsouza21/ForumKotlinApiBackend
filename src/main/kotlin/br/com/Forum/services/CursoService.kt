package br.com.Forum.services

import br.com.Forum.exception.NotFoundException
import br.com.Forum.model.Curso
import br.com.Forum.model.Topico
import org.springframework.stereotype.Service
import java.util.*

@Service //DependencyInjection
class CursoService(private var cursos: MutableList<Curso> = ArrayList()) {
    private val NOT_FOUND_MESSAGE: String = "Curso não encontrado!";

    init {
        val curso = Curso(
            id = 1,
            nome = "Kotlin",
            categoria = "Programação"
        )

        cursos = Arrays.asList(curso);
    }

    fun buscarPorId(id: Long): Curso {
        return cursos.stream().filter { c -> c.id == id }.findFirst()
            .orElseThrow { NotFoundException(NOT_FOUND_MESSAGE) };
    }
}
