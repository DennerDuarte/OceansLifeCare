package br.com.fiap.OceansLifeCare.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fiap.OceansLifeCare.DTO.AreasMonitoradasDTO;
import br.com.fiap.OceansLifeCare.Entity.AreasMonitoradas;
import br.com.fiap.OceansLifeCare.Factory.AreasMonitoradasFactory;
import br.com.fiap.OceansLifeCare.Repository.AreasMonitoradaRepository;

@Service
public class AreasMonitoradaService {

    @Autowired
    private AreasMonitoradaRepository areasMonitoradaRepository;

    private final AreasMonitoradasFactory factory = new AreasMonitoradasFactory();

//    public Page<AreasMonitoradasDTO> getAll(Pageable pageable){
//        Page<AreasMonitoradas> findAll =  areasMonitoradaRepository.findAll(pageable);
//		return  factory.toDto(findAll);
//    }
    
    public Page<AreasMonitoradasDTO> getAll(Pageable pageable){
        Page<AreasMonitoradas> areasPaginadas = areasMonitoradaRepository.findAll(pageable);
        return areasPaginadas.map(factory::toDto);
    }
    
    public AreasMonitoradasDTO getById(Long id){
        Optional<AreasMonitoradas> areasMonitoradasOptional = areasMonitoradaRepository.findById(id);
        return areasMonitoradasOptional.map(factory::toDto).orElse(null);
    }

    public AreasMonitoradasDTO criarArea(AreasMonitoradasDTO area){
        AreasMonitoradas novaArea = areasMonitoradaRepository.save(factory.toEntity(area));
        return factory.toDto(novaArea);
    }

    public AreasMonitoradasDTO updateArea(Long id, AreasMonitoradasDTO area){
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


    public  AreasMonitoradasDTO updatePartialArea(Long id, AreasMonitoradasDTO area) throws Exception{
        Optional<AreasMonitoradas> areaOptional = areasMonitoradaRepository.findById(id);

        if (!areaOptional.isPresent()){
            return null;
        }

        AreasMonitoradas areaDoBanco = areaOptional.get();

        if(area.getNomeArea() != null){
            areaDoBanco.setNomeArea(area.getNomeArea());
        }

        if(area.getLatitude() != null){
            areaDoBanco.setLatitude(area.getLatitude());
        }

        if(area.getLongitude() != null){
            areaDoBanco.setLongitude(area.getLongitude());
        }

        if(area.getRaio() != null){
            areaDoBanco.setRaio(area.getRaio());
        }

        if(area.getDsArea() != null){
            areaDoBanco.setDsArea(area.getDsArea());
        }

        areaDoBanco = areasMonitoradaRepository.save(areaDoBanco);

        return factory.toDto(areaDoBanco);
    }

}
