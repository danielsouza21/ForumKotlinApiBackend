package br.com.Forum.controller

import br.com.Forum.dto.AtualizacaoTopicoFormDto
import br.com.Forum.dto.IncluirTopicoFormDto
import br.com.Forum.dto.TopicoViewDto
import br.com.Forum.services.TopicoService
import io.swagger.annotations.ApiOperation
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.util.*

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {

    @GetMapping
    fun Listar(
            @RequestParam(required = false) nomeCurso: String?,
            @PageableDefault(size = 3) paginacao: Pageable
    ): Page<TopicoViewDto> {
        return service.Listar(nomeCurso, paginacao);
    }

    @GetMapping("/{id}")
    fun BuscarPorId(@PathVariable id: Long): TopicoViewDto? {
        return service.buscarPorId(id);
    }

    @PostMapping
    @Transactional //Abrir transação e commitar automaticamente as queries no db
    fun Cadastrar(
        @RequestBody @Valid topicoDto: IncluirTopicoFormDto, //Validação do body com @Valid do BeanValidation
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
    @Transactional
    fun atualizar(@RequestBody @Valid topicoDto: AtualizacaoTopicoFormDto): ResponseEntity<TopicoViewDto?> {
        val topicoView = service.atualizar(topicoDto)
        return ResponseEntity.ok(topicoView)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}