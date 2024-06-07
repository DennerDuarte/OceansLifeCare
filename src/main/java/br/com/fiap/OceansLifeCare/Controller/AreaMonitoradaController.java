package br.com.fiap.OceansLifeCare.Controller;

import br.com.fiap.OceansLifeCare.DTO.AreasMonitoradasDTO;
import br.com.fiap.OceansLifeCare.Service.AreasMonitoradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/AreaMonitorada")
public class AreaMonitoradaController {

    @Autowired
    private AreasMonitoradaService areasMonitoradaService;

    @GetMapping()
    public ResponseEntity<List<EntityModel<AreasMonitoradasDTO>>> findAll(){
        List<AreasMonitoradasDTO> areas = areasMonitoradaService.getAll();
        List<EntityModel<AreasMonitoradasDTO>> areasModel = areas.stream()
                .map(AreasMonitoradasDTO::toModel)
                .collect(Collectors.toList());

        return ResponseEntity.ok(areasModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<AreasMonitoradasDTO>> findById(@PathVariable Long id){
        AreasMonitoradasDTO areaExistente = areasMonitoradaService.getById(id);
        if(areaExistente != null){
            return ResponseEntity.ok(AreasMonitoradasDTO.toModel(areaExistente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<?> criarArea(@RequestBody AreasMonitoradasDTO area){
        AreasMonitoradasDTO novoArea = areasMonitoradaService.criarArea(area);
        if( novoArea != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(AreasMonitoradasDTO.toModel(novoArea));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi possível realizar a operação");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirArea(@PathVariable Long id){
        boolean areaDeletada = areasMonitoradaService.deletarArea(id);
        if(areaDeletada){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Foi realizado a exclusão da area.");
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<AreasMonitoradasDTO>> atualizarArea(@PathVariable Long id, @RequestBody AreasMonitoradasDTO area ){
        AreasMonitoradasDTO areaAtualizada = areasMonitoradaService.updateArea(id, area);

        if(areaAtualizada != null){
            return ResponseEntity.ok(AreasMonitoradasDTO.toModel(areaAtualizada));
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PatchMapping("/{id}")
    public ResponseEntity<EntityModel<AreasMonitoradasDTO>> atualizarParcialArea(@PathVariable Long id, @RequestBody AreasMonitoradasDTO area){
        try{
            AreasMonitoradasDTO areaAtualizada = areasMonitoradaService.updatePartialArea(id, area);

            if(areaAtualizada != null){
                return ResponseEntity.ok(AreasMonitoradasDTO.toModel(areaAtualizada));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
