package br.com.Forum.repository

import br.com.Forum.model.Topico
import org.springframework.data.jpa.repository.JpaRepository

//JpaRepository já fornece métodos padrão para acesso ao banco de dados
interface ITopicoRepository : JpaRepository<Topico, Long> {

}