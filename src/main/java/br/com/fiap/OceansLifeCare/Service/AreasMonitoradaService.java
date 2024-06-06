package br.com.fiap.OceansLifeCare.Service;

import br.com.fiap.OceansLifeCare.DTO.AreasMonitoradaDTO;
import br.com.fiap.OceansLifeCare.Entity.AreasMonitoradas;
import br.com.fiap.OceansLifeCare.Repository.AreasMonitoradaRepository;
import br.com.fiap.OceansLifeCare.factory.AreasMonitoradaFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreasMonitoradaService {

    @Autowired
    private AreasMonitoradaRepository areasMonitoradaRepository;

    private final AreasMonitoradaFactory factory = new AreasMonitoradaFactory();

    public List<AreasMonitoradaDTO> getAll(){
        return factory.toDto((List<AreasMonitoradas>) areasMonitoradaRepository.findAll());
    }

    public AreasMonitoradaDTO getById(Long id){
        Optional<AreasMonitoradas> areasMonitoradasOptional = areasMonitoradaRepository.findById(id);
        return areasMonitoradasOptional.map(factory::toDto).orElse(null);
    }

    public AreasMonitoradaDTO criarArea(AreasMonitoradaDTO area){
        AreasMonitoradas novaArea = areasMonitoradaRepository.save(factory.toEntity(area));
        return factory.toDto(novaArea);
    }

    public AreasMonitoradaDTO updateArea(Long id, AreasMonitoradaDTO area){
        AreasMonitoradas areaExistente = areasMonitoradaRepository.findById(id).orElse(null);

        if (areaExistente != null){
            AreasMonitoradas desatualizado = factory.toEntity(area);
            desatualizado.setId(id);

            AreasMonitoradas atualizado = areasMonitoradaRepository.save(desatualizado);
            return factory.toDto(atualizado);
        } else {
            return factory.toDto(areaExistente);
        }

    }

    public boolean deletarArea(Long id) {
        if (areasMonitoradaRepository.existsById(id)) {
            areasMonitoradaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
