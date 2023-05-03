package br.com.Forum.controller

import br.com.Forum.dto.AtualizacaoTopicoFormDto
import br.com.Forum.dto.IncluirTopicoFormDto
import br.com.Forum.dto.TopicoViewDto
import br.com.Forum.services.TopicoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
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
    //Validação do body com @Valid do BeanValidation
    fun Cadastrar(
        @RequestBody @Valid topicoDto: IncluirTopicoFormDto,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicoViewDto?> {
        val topicoView = service.cadastrar(topicoDto)

        if(topicoView != null){
            /* O objeto topicoView é verificado para não ser nulo.
            Se não for nulo, uma nova resposta HTTP é criada com o status 201 Created
            e o objeto topicoView como corpo da resposta. A URI do novo tópico criado
            é adicionada ao cabeçalho da resposta (key: "Location"). */

            val uri = uriBuilder.path("/topicos/${topicoView.id}").build().toUri();
            return ResponseEntity.created(uri).body(topicoView);
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid topicoDto: AtualizacaoTopicoFormDto): ResponseEntity<TopicoViewDto?> {
        val topicoView = service.atualizar(topicoDto)
        return ResponseEntity.ok(topicoView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}