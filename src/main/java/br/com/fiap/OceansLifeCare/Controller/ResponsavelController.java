package br.com.fiap.OceansLifeCare.Controller;

import br.com.fiap.OceansLifeCare.DTO.ResponsavelDTO;
import br.com.fiap.OceansLifeCare.Service.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Responsaveis")
public class ResponsavelController {

    @Autowired
    private ResponsavelService responsavelService;

    @GetMapping()
    public ResponseEntity<List<EntityModel<ResponsavelDTO>>> findAll() {
        List<ResponsavelDTO> responsaveis = responsavelService.getAll();
        List<EntityModel<ResponsavelDTO>> responsaveisModel = responsaveis.stream()
                .map(ResponsavelDTO::toModel)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responsaveisModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ResponsavelDTO>> findById(@PathVariable Long id) {
        ResponsavelDTO responsavelExistente = responsavelService.getById(id);
        if (responsavelExistente != null) {
            return ResponseEntity.ok(ResponsavelDTO.toModel(responsavelExistente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<?> criarResponsavel(@RequestBody ResponsavelDTO responsavel) {
        ResponsavelDTO novoResponsavel = responsavelService.criarResponsavel(responsavel);
        if (novoResponsavel != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(ResponsavelDTO.toModel(novoResponsavel));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi possível realizar a operação");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirResponsavel(@PathVariable Long id) {
        boolean responsavelDeletado = responsavelService.deletarResponsavel(id);
        if (responsavelDeletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Foi realizada a exclusão do responsável.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<ResponsavelDTO>> atualizarResponsavel(@PathVariable Long id, @RequestBody ResponsavelDTO responsavel) {
        ResponsavelDTO responsavelAtualizado = responsavelService.updateResponsavel(id, responsavel);

        if (responsavelAtualizado != null) {
            return ResponseEntity.ok(ResponsavelDTO.toModel(responsavelAtualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
