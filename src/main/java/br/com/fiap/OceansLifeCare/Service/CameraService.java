package br.com.fiap.OceansLifeCare.Service;

import br.com.fiap.OceansLifeCare.DTO.CameraDTO;
import br.com.fiap.OceansLifeCare.Entity.Camera;
import br.com.fiap.OceansLifeCare.Repository.CameraRepository;
import br.com.fiap.OceansLifeCare.factory.CameraFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CameraService {

    @Autowired
    private CameraRepository cameraRepository;

    private CameraFactory factory = new CameraFactory();

    public List<CameraDTO> getAll(){
        return factory.toDto((List<Camera>) cameraRepository.findAll());
    }

    public CameraDTO getById(Long id){
        Optional<Camera> cameraOptional = cameraRepository.findById(id);
        return cameraOptional.map(factory::toDto).orElse(null);
    }

    public CameraDTO criarCamera(CameraDTO camera){
        Camera novaCamera = cameraRepository.save(factory.toEntity(camera));
        return factory.toDto(novaCamera);
    }

    public CameraDTO updateCamera(Long id, CameraDTO camera){
        Camera cameraExistente = cameraRepository.findById(id).orElse(null);

        if(cameraExistente != null){
            Camera desatualizado = factory.toEntity(camera);
            desatualizado.setId(id);

            Camera atualizado = cameraRepository.save(desatualizado);
            return factory.toDto(atualizado);
        } else {
            return factory.toDto(cameraExistente);
        }
    }

    public boolean deletarCamera(Long id) {
        if (cameraRepository.existsById(id)) {
            cameraRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public CameraDTO updatePartialCamera(Long id, CameraDTO camera) throws Exception {
        Optional<Camera> cameraOptional = cameraRepository.findById(id);

        if (!cameraOptional.isPresent()) {
            return null;
        }

        Camera cameraDoBanco = cameraOptional.get();

        if (camera.getLatitude() != null) {
            cameraDoBanco.setLatitude(camera.getLatitude());
        }

        if (camera.getLongitude() != null) {
            cameraDoBanco.setLongitude(camera.getLongitude());
        }

        if (camera.getDataInstalacao() != null) {
            cameraDoBanco.setDataInstalacao(camera.getDataInstalacao());
        }

        if (camera.getDataUltimaManutecao() != null) {
            cameraDoBanco.setDataUltimaManutecao(camera.getDataUltimaManutecao());
        }

        if (camera.getStatus() != null) {
            cameraDoBanco.setStatus(camera.getStatus());
        }

        cameraDoBanco = cameraRepository.save(cameraDoBanco);

        return factory.toDto(cameraDoBanco);
    }

}
