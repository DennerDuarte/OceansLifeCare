package br.com.fiap.OceansLifeCare.Controller;

import br.com.fiap.OceansLifeCare.DTO.TipoObjetoDTO;
import br.com.fiap.OceansLifeCare.Service.TipoObjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipoObjeto")
public class TipoObjetoController {

    @Autowired
    private TipoObjetoService tipoObjetoService;

    @GetMapping()
    public ResponseEntity<List<EntityModel<TipoObjetoDTO>>> findAll() {
        List<TipoObjetoDTO> tiposObjeto = tipoObjetoService.getAll();
        List<EntityModel<TipoObjetoDTO>> tiposObjetoModel = tiposObjeto.stream()
                .map(TipoObjetoDTO::toModel)
                .collect(Collectors.toList());

        return ResponseEntity.ok(tiposObjetoModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<TipoObjetoDTO>> findById(@PathVariable Long id) {
        TipoObjetoDTO tipoObjetoExistente = tipoObjetoService.getById(id);
        if (tipoObjetoExistente != null) {
            return ResponseEntity.ok(TipoObjetoDTO.toModel(tipoObjetoExistente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<?> criarTipoObjeto(@RequestBody TipoObjetoDTO tipoObjeto) {
        TipoObjetoDTO novoTipoObjeto = tipoObjetoService.criarTipo(tipoObjeto);
        if (novoTipoObjeto != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(TipoObjetoDTO.toModel(novoTipoObjeto));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi possível realizar a operação");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirTipoObjeto(@PathVariable Long id) {
        boolean tipoObjetoDeletado = tipoObjetoService.deletarTipo(id);
        if (tipoObjetoDeletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Foi realizada a exclusão do tipo de objeto.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<TipoObjetoDTO>> atualizarTipoObjeto(@PathVariable Long id, @RequestBody TipoObjetoDTO tipoObjeto) {
        TipoObjetoDTO tipoObjetoAtualizado = tipoObjetoService.updateTipo(id, tipoObjeto);

        if (tipoObjetoAtualizado != null) {
            return ResponseEntity.ok(TipoObjetoDTO.toModel(tipoObjetoAtualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
