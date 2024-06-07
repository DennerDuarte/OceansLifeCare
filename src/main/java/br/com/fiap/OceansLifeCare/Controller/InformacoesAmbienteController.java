package br.com.fiap.OceansLifeCare.Controller;

import br.com.fiap.OceansLifeCare.DTO.InformacoesAmbienteDTO;
import br.com.fiap.OceansLifeCare.Service.InformacoesAmbienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/informacaoAmbiente")
public class InformacoesAmbienteController {

    @Autowired
    private InformacoesAmbienteService informacoesAmbienteService;

    @GetMapping()
    public ResponseEntity<List<EntityModel<InformacoesAmbienteDTO>>> findAll() {
        List<InformacoesAmbienteDTO> informacoes = informacoesAmbienteService.getAll();
        List<EntityModel<InformacoesAmbienteDTO>> informacoesModel = informacoes.stream()
                .map(InformacoesAmbienteDTO::toModel)
                .collect(Collectors.toList());

        return ResponseEntity.ok(informacoesModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<InformacoesAmbienteDTO>> findById(@PathVariable Long id) {
        InformacoesAmbienteDTO informacaoExistente = informacoesAmbienteService.getById(id);
        if (informacaoExistente != null) {
            return ResponseEntity.ok(InformacoesAmbienteDTO.toModel(informacaoExistente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<?> criarInformacao(@RequestBody InformacoesAmbienteDTO informacao) {
        InformacoesAmbienteDTO novaInformacao = informacoesAmbienteService.criarInformacao(informacao);
        if (novaInformacao != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(InformacoesAmbienteDTO.toModel(novaInformacao));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi possível realizar a operação");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirInformacao(@PathVariable Long id) {
        boolean informacaoDeletada = informacoesAmbienteService.deletarInformacao(id);
        if (informacaoDeletada) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Foi realizada a exclusão da informação.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<InformacoesAmbienteDTO>> atualizarInformacao(@PathVariable Long id, @RequestBody InformacoesAmbienteDTO informacao) {
        InformacoesAmbienteDTO informacaoAtualizada = informacoesAmbienteService.updateInformacao(id, informacao);

        if (informacaoAtualizada != null) {
            return ResponseEntity.ok(InformacoesAmbienteDTO.toModel(informacaoAtualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EntityModel<InformacoesAmbienteDTO>> atualizarParcialInformacao(@PathVariable Long id, @RequestBody InformacoesAmbienteDTO informacao) {
        try {
            InformacoesAmbienteDTO informacaoAtualizada = informacoesAmbienteService.updatePartialInformacao(id, informacao);
            if (informacaoAtualizada != null) {
                return ResponseEntity.ok(InformacoesAmbienteDTO.toModel(informacaoAtualizada));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
