package br.com.Forum.services

import br.com.Forum.dto.AtualizacaoTopicoFormDto
import br.com.Forum.dto.IncluirTopicoFormDto
import br.com.Forum.dto.TopicoViewDto
import br.com.Forum.exception.NotFoundException
import br.com.Forum.mapper.IMapper
import br.com.Forum.model.Topico
import br.com.Forum.repository.ITopicoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service //Gerenciamento do service pelo SpringBoot, com DI
class TopicoService(
    private var topicosRepository: ITopicoRepository,
    private val topicoViewMapper: IMapper<Topico, TopicoViewDto>,
    private val topicoFormMapper: IMapper<IncluirTopicoFormDto, Topico>
)
{
    private val NOT_FOUND_MESSAGE: String = "Topico não encontrado!";

    fun Listar(nomeCurso: String?, paginacao: Pageable): Page<TopicoViewDto> {
        val topicos = nomeCurso?.let { topicosRepository.findByCursoNome(it, paginacao) } ?: topicosRepository.findAll(paginacao)

        return topicos
            .map { t -> topicoViewMapper.map(t) };
    }

    fun buscarPorId(id: Long): TopicoViewDto {
        val topico = topicosRepository.findById(id)
            .orElseThrow { NotFoundException(NOT_FOUND_MESSAGE) }
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(topicoDto: IncluirTopicoFormDto): TopicoViewDto?  {
        val topico = topicoFormMapper.map(topicoDto);
        topicosRepository.save(topico);
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoFormDto): TopicoViewDto? {
        val topico = topicosRepository.findById(form.id)
            .orElseThrow { NotFoundException(NOT_FOUND_MESSAGE) };

        //A alteração é commitada automaticamente no banco de dados
        topico.titulo = form.titulo;
        topico.mensagem = form.mensagem;

        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        topicosRepository.deleteById(id);
    }
}