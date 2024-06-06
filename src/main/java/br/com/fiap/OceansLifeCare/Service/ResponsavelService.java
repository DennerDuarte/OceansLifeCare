package br.com.fiap.OceansLifeCare.Service;

import br.com.fiap.OceansLifeCare.DTO.InformacoesAmbienteDTO;
import br.com.fiap.OceansLifeCare.DTO.ResponsavelDTO;
import br.com.fiap.OceansLifeCare.Entity.InformacoesAmbiente;
import br.com.fiap.OceansLifeCare.Entity.Responsavel;
import br.com.fiap.OceansLifeCare.Repository.InformacoesAmbienteRepository;
import br.com.fiap.OceansLifeCare.Repository.ResponsavelRepository;
import br.com.fiap.OceansLifeCare.factory.InformacoesAmbienteFactory;
import br.com.fiap.OceansLifeCare.factory.ResponsavelFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ResponsavelService {

    @Autowired
    private ResponsavelRepository responsavelRepository;

    private ResponsavelFactory factory = new ResponsavelFactory();

    public List<ResponsavelDTO> getAll(){
        return factory.toDto((List<Responsavel>) responsavelRepository.findAll());
    }

    public ResponsavelDTO getById(Long id){
        Optional<Responsavel> responsavelOptional = responsavelRepository.findById(id);
        return responsavelOptional.map(factory::toDto).orElse(null);
    }

    public ResponsavelDTO criarResponsavel(ResponsavelDTO responsavel){
        Responsavel novoResponsavel = responsavelRepository.save(factory.toEntity(responsavel));
        return factory.toDto(novoResponsavel);
    }

    public ResponsavelDTO updateResponsavel(Long id, ResponsavelDTO responsavel){
        Responsavel responsavelExistente = responsavelRepository.findById(id).orElse(null);

        if(responsavelExistente != null){
            Responsavel desatualizado = factory.toEntity(responsavel);
            desatualizado.setId(id);

            Responsavel atualizado = responsavelRepository.save(desatualizado);
            return factory.toDto(atualizado);
        } else {
            return factory.toDto(responsavelExistente);
        }
    }

    public boolean deletarResponsavel(Long id) {
        if (responsavelRepository.existsById(id)) {
            responsavelRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
