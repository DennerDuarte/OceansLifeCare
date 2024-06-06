package br.com.fiap.OceansLifeCare.Service;

import br.com.fiap.OceansLifeCare.DTO.DeteccaoDTO;
import br.com.fiap.OceansLifeCare.DTO.InformacoesAmbienteDTO;
import br.com.fiap.OceansLifeCare.Entity.Deteccao;
import br.com.fiap.OceansLifeCare.Entity.InformacoesAmbiente;
import br.com.fiap.OceansLifeCare.Repository.DeteccaoRepository;
import br.com.fiap.OceansLifeCare.Repository.InformacoesAmbienteRepository;
import br.com.fiap.OceansLifeCare.factory.DeteccaoFactory;
import br.com.fiap.OceansLifeCare.factory.InformacoesAmbienteFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class InformacoesAmbienteService {

    @Autowired
    private InformacoesAmbienteRepository informacoesAmbienteRepository;

    private InformacoesAmbienteFactory factory = new InformacoesAmbienteFactory();

    public List<InformacoesAmbienteDTO> getAll(){
        return factory.toDto((List<InformacoesAmbiente>) informacoesAmbienteRepository.findAll());
    }

    public InformacoesAmbienteDTO getById(Long id){
        Optional<InformacoesAmbiente> informacoesAmbienteOptional = informacoesAmbienteRepository.findById(id);
        return informacoesAmbienteOptional.map(factory::toDto).orElse(null);
    }

    public InformacoesAmbienteDTO criarInformacao(InformacoesAmbienteDTO informacao){
        InformacoesAmbiente novaInformacao = informacoesAmbienteRepository.save(factory.toEntity(informacao));
        return factory.toDto(novaInformacao);
    }

    public InformacoesAmbienteDTO updateInformacao(Long id, InformacoesAmbienteDTO informacoes){
        InformacoesAmbiente informacoesExistente = informacoesAmbienteRepository.findById(id).orElse(null);

        if(informacoesExistente != null){
            InformacoesAmbiente desatualizado = factory.toEntity(informacoes);
            desatualizado.setId(id);

            InformacoesAmbiente atualizado = informacoesAmbienteRepository.save(desatualizado);
            return factory.toDto(atualizado);
        } else {
            return factory.toDto(informacoesExistente);
        }
    }

    public boolean deletarInformacao(Long id) {
        if (informacoesAmbienteRepository.existsById(id)) {
            informacoesAmbienteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
