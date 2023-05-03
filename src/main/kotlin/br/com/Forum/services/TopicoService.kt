package br.com.Forum.services

import br.com.Forum.dto.TopicoFormDto
import br.com.Forum.dto.TopicoViewDto
import br.com.Forum.mapper.IMapper
import br.com.Forum.mapper.TopicoFormMapper
import br.com.Forum.mapper.TopicoViewMapper
import br.com.Forum.model.Topico
import org.springframework.stereotype.Service
import java.util.*

@Service //Gerenciamento do service pelo SpringBoot, com DI
class TopicoService(
    private var topicos: MutableList<Topico> = ArrayList(),
    private val topicoViewMapper: IMapper<Topico, TopicoViewDto>,
    private val topicoFormMapper: IMapper<TopicoFormDto, Topico>
)
{
    fun Listar(): List<TopicoViewDto> {
        return topicos.stream().map { t -> topicoViewMapper.map(t) }.toList();
    }

    fun buscarPorId(id: Long): TopicoViewDto? {
        val topico = topicos.stream().filter { t -> t.id == id }.findFirst();
        return topico.map { t -> topicoViewMapper.map(t) }.orElse(null);
    }

    fun cadastrar(topicoDto: TopicoFormDto) {
        topicos.add(topicoFormMapper.map(topicoDto));
    }
}