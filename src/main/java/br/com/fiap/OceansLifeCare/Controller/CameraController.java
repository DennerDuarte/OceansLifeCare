package br.com.fiap.OceansLifeCare.Controller;

import br.com.fiap.OceansLifeCare.DTO.CameraDTO;
import br.com.fiap.OceansLifeCare.Service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Cameras")
public class CameraController {

    @Autowired
    private CameraService cameraService;

    @GetMapping()
    public ResponseEntity<List<EntityModel<CameraDTO>>> findAll() {
        List<CameraDTO> cameras = cameraService.getAll();
        List<EntityModel<CameraDTO>> camerasModel = cameras.stream()
                .map(CameraDTO::toModel)
                .collect(Collectors.toList());

        return ResponseEntity.ok(camerasModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<CameraDTO>> findById(@PathVariable Long id) {
        CameraDTO cameraExistente = cameraService.getById(id);
        if (cameraExistente != null) {
            return ResponseEntity.ok(CameraDTO.toModel(cameraExistente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<?> criarCamera(@RequestBody CameraDTO camera) {
        CameraDTO novaCamera = cameraService.criarCamera(camera);
        if (novaCamera != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(CameraDTO.toModel(novaCamera));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi possível realizar a operação");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirCamera(@PathVariable Long id) {
        boolean cameraDeletada = cameraService.deletarCamera(id);
        if (cameraDeletada) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Foi realizada a exclusão da câmera.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<CameraDTO>> atualizarCamera(@PathVariable Long id, @RequestBody CameraDTO camera) {
        CameraDTO cameraAtualizada = cameraService.updateCamera(id, camera);

        if (cameraAtualizada != null) {
            return ResponseEntity.ok(CameraDTO.toModel(cameraAtualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EntityModel<CameraDTO>> atualizarParcialCamera(@PathVariable Long id, @RequestBody CameraDTO camera) {
        try {
            CameraDTO cameraAtualizada = cameraService.updatePartialCamera(id, camera);
            if (cameraAtualizada != null) {
                return ResponseEntity.ok(CameraDTO.toModel(cameraAtualizada));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
