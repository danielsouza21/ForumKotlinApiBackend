package br.com.Forum.services

import br.com.Forum.dto.AtualizacaoTopicoFormDto
import br.com.Forum.dto.IncluirTopicoFormDto
import br.com.Forum.dto.TopicoViewDto
import br.com.Forum.exception.NotFoundException
import br.com.Forum.mapper.IMapper
import br.com.Forum.model.Topico
import org.springframework.stereotype.Service
import java.util.*

@Service //Gerenciamento do service pelo SpringBoot, com DI
class TopicoService(
    private var topicos: MutableList<Topico> = ArrayList(),
    private val topicoViewMapper: IMapper<Topico, TopicoViewDto>,
    private val topicoFormMapper: IMapper<IncluirTopicoFormDto, Topico>
)
{
    private val NOT_FOUND_MESSAGE: String = "Topico não encontrado!";

    fun Listar(): List<TopicoViewDto> {
        return topicos.stream().map { t -> topicoViewMapper.map(t) }.toList();
    }

    fun buscarPorId(id: Long): TopicoViewDto {
        val topico = topicos.stream().filter { t -> t.id == id }.findFirst()
            .orElseThrow { NotFoundException(NOT_FOUND_MESSAGE) }
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(topicoDto: IncluirTopicoFormDto): TopicoViewDto?  {
        val topico = topicoFormMapper.map(topicoDto);
        topico.id = topicos.size.toLong() + 1;
        topicos.add(topico);
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoFormDto): TopicoViewDto? {
        val index = topicos.indexOfFirst { it.id == form.id }
        if (index != -1) {
            val topicoAntigo = topicos[index]

            val topicoAtualizado = Topico(
                id = form.id,
                titulo = form.titulo,
                mensagem = form.mensagem,
                autor = topicoAntigo.autor,
                curso = topicoAntigo.curso,
                respostas = topicoAntigo.respostas,
                status = topicoAntigo.status,
                dataCriacao = topicoAntigo.dataCriacao
            )

            topicos[index] = topicoAtualizado

            return topicoViewMapper.map(topicoAtualizado)
        }

        return null;
    }

    fun deletar(id: Long) {
        topicos.removeIf { t -> t.id == id }
    }
}