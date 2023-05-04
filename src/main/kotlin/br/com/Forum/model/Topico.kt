package br.com.Forum.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Topico (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var titulo: String,
    var mensagem:  String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    val curso: Curso,

    @ManyToOne
    val autor: Usuario,

    @Enumerated(value = EnumType.STRING)
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,

    //'Resposta' possui campo 'topico' com id dos topicos referencias
    //Um topico pode ter varias respostas, mas resposta esta relacionda a um topico apenas
    @OneToMany(mappedBy = "topico")
    val respostas: List<Resposta> = ArrayList()
)