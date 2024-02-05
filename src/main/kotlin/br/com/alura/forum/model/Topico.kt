package br.com.alura.forum.model

import java.time.LocalDate
import javax.persistence.*
import java.time.LocalDateTime

@Entity
data class Topico(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var titulo: String,
    var mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val curso: Curso,
    @ManyToOne
    val autor: Usuario,
    @Enumerated(value = EnumType.STRING)
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
    @OneToMany (mappedBy = "topico")
    val respostas: List<Resposta> = ArrayList(),
    var dataAlteracao: LocalDate? = null
)
