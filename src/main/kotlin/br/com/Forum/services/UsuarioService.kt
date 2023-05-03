package br.com.Forum.services

import br.com.Forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service //DependencyInjection
class UsuarioService(private var autores: MutableList<Usuario> = ArrayList()) {
    init {
        val usuario = Usuario(
            id = 1,
            nome = "Daniel",
            email = "test@bmg.com"
        )

        autores = Arrays.asList(usuario);
    }

    fun buscarPorId(id: Long): Usuario? {
        return autores.stream().filter({u -> u.id == id}).findFirst().orElse(null);
    }
}
