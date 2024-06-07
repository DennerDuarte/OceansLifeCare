package br.com.fiap.OceansLifeCare.Controller;

import br.com.fiap.OceansLifeCare.DTO.DeteccaoDTO;
import br.com.fiap.OceansLifeCare.Service.DeteccaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/deteccao")
public class DeteccaoController {

    @Autowired
    private DeteccaoService deteccaoService;

    @GetMapping()
    public ResponseEntity<List<EntityModel<DeteccaoDTO>>> findAll() {
        List<DeteccaoDTO> deteccoes = deteccaoService.getAll();
        List<EntityModel<DeteccaoDTO>> deteccoesModel = deteccoes.stream()
                .map(DeteccaoDTO::toModel)
                .collect(Collectors.toList());

        return ResponseEntity.ok(deteccoesModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<DeteccaoDTO>> findById(@PathVariable Long id) {
        DeteccaoDTO deteccaoExistente = deteccaoService.getById(id);
        if (deteccaoExistente != null) {
            return ResponseEntity.ok(DeteccaoDTO.toModel(deteccaoExistente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<?> criarDeteccao(@RequestBody DeteccaoDTO deteccao) {
        DeteccaoDTO novaDeteccao = deteccaoService.criarDeteccao(deteccao);
        if (novaDeteccao != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(DeteccaoDTO.toModel(novaDeteccao));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi possível realizar a operação");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirDeteccao(@PathVariable Long id) {
        boolean deteccaoDeletada = deteccaoService.deletarDeteccao(id);
        if (deteccaoDeletada) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Foi realizada a exclusão da detecção.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<DeteccaoDTO>> atualizarDeteccao(@PathVariable Long id, @RequestBody DeteccaoDTO deteccao) {
        DeteccaoDTO deteccaoAtualizada = deteccaoService.updateDeteccao(id, deteccao);

        if (deteccaoAtualizada != null) {
            return ResponseEntity.ok(DeteccaoDTO.toModel(deteccaoAtualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EntityModel<DeteccaoDTO>> atualizarParcialDeteccao(@PathVariable Long id, @RequestBody DeteccaoDTO deteccao) {
        try {
            DeteccaoDTO deteccaoAtualizada = deteccaoService.updatePartialDeteccao(id, deteccao);
            if (deteccaoAtualizada != null) {
                return ResponseEntity.ok(DeteccaoDTO.toModel(deteccaoAtualizada));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
