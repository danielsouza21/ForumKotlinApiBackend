package br.com.Forum.mapper

import br.com.Forum.dto.IncluirTopicoFormDto
import br.com.Forum.model.Topico
import br.com.Forum.services.CursoService
import br.com.Forum.services.UsuarioService
import org.springframework.stereotype.Component

@Component //DI, similar a @Service
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
): IMapper<IncluirTopicoFormDto, Topico> {
    override fun map(t: IncluirTopicoFormDto): Topico {
        val curso = cursoService.buscarPorId(t.idCurso);
        val usuario = usuarioService.buscarPorId(t.idAutor);

        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = curso,
            autor = usuario
        );
    }
}