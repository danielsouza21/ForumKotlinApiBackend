package br.com.Forum.repository

import br.com.Forum.dto.TopicoPorCategoriaDto
import br.com.Forum.model.Topico
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

//JpaRepository já fornece métodos padrão para acesso ao banco de dados
interface ITopicoRepository : JpaRepository<Topico, Long> {
    fun findByCursoNome(nomeCurso: String, paginacao: Pageable): Page<Topico>
    //JPA constroi automaticamente método de filtro curso por nome]
    //  ... from curso c1_0 where c1_0.id=? ...

    @Query("SELECT new br.com.Forum.dto.TopicoPorCategoriaDto(curso.categoria, count(t)) FROM Topico t JOIN t.curso curso GROUP BY curso.categoria")
    fun relatorioCursos(): List<TopicoPorCategoriaDto>
}