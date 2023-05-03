package br.com.Forum.services

import br.com.Forum.model.Curso
import br.com.Forum.model.Topico
import org.springframework.stereotype.Service
import java.util.*

@Service //DependencyInjection
class CursoService(private var cursos: MutableList<Curso> = ArrayList()) {
    init {
        val curso = Curso(
            id = 1,
            nome = "Kotlin",
            categoria = "Programação"
        )

        cursos = Arrays.asList(curso);
    }

    fun buscarPorId(id: Long): Curso? {
        return cursos.stream().filter({c -> c.id == id}).findFirst().orElse(null);
    }
}
