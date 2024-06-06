package br.com.fiap.OceansLifeCare.Controller;

import br.com.fiap.OceansLifeCare.DTO.AreasMonitoradaDTO;
import br.com.fiap.OceansLifeCare.Service.AreasMonitoradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/AreaMonitorada")
public class AreaMonitoradaController {

    @Autowired
    private AreasMonitoradaService areasMonitoradaService;

    @GetMapping()
    public List<AreasMonitoradaDTO> findAll(){
        return areasMonitoradaService.getAll();
    }

    @GetMapping("/{id}")
    public AreasMonitoradaDTO findById(@PathVariable long id){
        return areasMonitoradaService.getById(id);
    }

    @PostMapping()
    public ResponseEntity<AreasMonitoradaDTO> criarArea(@RequestBody AreasMonitoradaDTO area){
        AreasMonitoradaDTO novoArea = areasMonitoradaService.criarArea(area);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoArea);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirArea(@PathVariable Long id){
        boolean areaDeletada = areasMonitoradaService.deletarArea(id);
        if(areaDeletada){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AreasMonitoradaDTO> atualizarArea(@PathVariable Long id, @RequestBody AreasMonitoradaDTO area ){
        AreasMonitoradaDTO areaAtualizada = areasMonitoradaService.updateArea(id, area);

        if(areaAtualizada != null){
            return ResponseEntity.ok(areaAtualizada);
        }

        return ResponseEntity.notFound().build();
    }
}
