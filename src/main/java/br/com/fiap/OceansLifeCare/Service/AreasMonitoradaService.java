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
        return factory.toDto(novaArea)
    }
}
