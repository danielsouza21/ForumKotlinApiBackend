package br.com.Forum.controller

import br.com.Forum.dto.TopicoFormDto
import br.com.Forum.dto.TopicoViewDto
import br.com.Forum.services.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {

    @GetMapping
    fun Listar(): List<TopicoViewDto> {
        return service.Listar();
    }

    @GetMapping("/{id}")
    fun BuscarPorId(@PathVariable id: Long): TopicoViewDto? {
        return service.buscarPorId(id);
    }

    @PostMapping
    fun Cadastrar(@RequestBody topicoDto: TopicoFormDto) {
        service.cadastrar(topicoDto);
    }
}