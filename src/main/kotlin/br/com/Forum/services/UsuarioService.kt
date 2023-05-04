package br.com.Forum.services

import br.com.Forum.exception.NotFoundException
import br.com.Forum.model.Usuario
import br.com.Forum.repository.IUsuarioRepository
import org.springframework.stereotype.Service

@Service //DependencyInjection
class UsuarioService(private var usuarioRepository: IUsuarioRepository) {
    private val NOT_FOUND_MESSAGE: String = "Usuário não encontrado!";

    fun buscarPorId(id: Long): Usuario {
        return usuarioRepository.findById(id)
            .orElseThrow{ NotFoundException(NOT_FOUND_MESSAGE) };
    }
}
