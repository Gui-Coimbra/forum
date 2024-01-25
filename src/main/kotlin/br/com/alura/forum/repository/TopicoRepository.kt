package br.com.alura.forum.repository

import br.com.alura.forum.dto.TopicoPorCategoriaDto
import br.com.alura.forum.model.StatusTopico
import br.com.alura.forum.model.Topico
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicoRepository: JpaRepository<Topico, Long> {

    fun findByCursoNome(nomeCurso: String, paginacao: Pageable): Page<Topico>

    @Query(value = "SELECT new br.com.alura.forum.dto.TopicoPorCategoriaDto(t.curso.categoria, count(t)) FROM Topico t GROUP BY t.curso.categoria")
    // se colocarmos nativeQuery = true no @Query, conseguimos realizar uma consulta sql nativa, diferente da consulta JPQL a cima
    fun relatorio(): List<TopicoPorCategoriaDto>

    //todos os tópicos que ainda não foram respondidos

    fun findTopicoByStatus(statusTopico: StatusTopico, paginacao: Pageable): Page<Topico>
}