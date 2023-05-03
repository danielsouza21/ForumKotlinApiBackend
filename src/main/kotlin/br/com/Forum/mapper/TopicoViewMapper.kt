package br.com.Forum.mapper

import br.com.Forum.dto.TopicoViewDto
import br.com.Forum.model.Topico
import org.springframework.stereotype.Component

@Component //DI, similar a @Service
class TopicoViewMapper: IMapper<Topico, TopicoViewDto> {
    override fun map(t: Topico): TopicoViewDto {
        return TopicoViewDto(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            status = t.status
        );
    }
}