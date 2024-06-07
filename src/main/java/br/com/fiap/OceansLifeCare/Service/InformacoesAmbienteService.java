package br.com.fiap.OceansLifeCare.Service;

import br.com.fiap.OceansLifeCare.DTO.InformacoesAmbienteDTO;
import br.com.fiap.OceansLifeCare.Entity.InformacoesAmbiente;
import br.com.fiap.OceansLifeCare.Repository.InformacoesAmbienteRepository;
import br.com.fiap.OceansLifeCare.factory.InformacoesAmbienteFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InformacoesAmbienteService {

    @Autowired
    private InformacoesAmbienteRepository informacoesAmbienteRepository;

    private InformacoesAmbienteFactory factory = new InformacoesAmbienteFactory();

    public List<InformacoesAmbienteDTO> getAll() {
        return factory.toDto((List<InformacoesAmbiente>) informacoesAmbienteRepository.findAll());
    }

    public InformacoesAmbienteDTO getById(Long id) {
        Optional<InformacoesAmbiente> informacoesAmbienteOptional = informacoesAmbienteRepository.findById(id);
        return informacoesAmbienteOptional.map(factory::toDto).orElse(null);
    }

    public InformacoesAmbienteDTO criarInformacao(InformacoesAmbienteDTO informacao) {
        InformacoesAmbiente novaInformacao = informacoesAmbienteRepository.save(factory.toEntity(informacao));
        return factory.toDto(novaInformacao);
    }

    public InformacoesAmbienteDTO updateInformacao(Long id, InformacoesAmbienteDTO informacoes) {
        InformacoesAmbiente informacoesExistente = informacoesAmbienteRepository.findById(id).orElse(null);

        if (informacoesExistente != null) {
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

    public InformacoesAmbienteDTO updatePartialInformacao(Long id, InformacoesAmbienteDTO informacoes) throws Exception {
        Optional<InformacoesAmbiente> informacoesOptional = informacoesAmbienteRepository.findById(id);

        if (!informacoesOptional.isPresent()) {
            return null;
        }

        InformacoesAmbiente informacoesDoBanco = informacoesOptional.get();

        if (informacoes.getDtMedicao() != null) {
            informacoesDoBanco.setDtMedicao(informacoes.getDtMedicao());
        }

        if (informacoes.getNivelOxigenio() != null) {
            informacoesDoBanco.setNivelOxigenio(informacoes.getNivelOxigenio());
        }

        if (informacoes.getQualidade() != null) {
            informacoesDoBanco.setQualidade(informacoes.getQualidade());
        }

        if (informacoes.getTemperatura() != null) {
            informacoesDoBanco.setTemperatura(informacoes.getTemperatura());
        }

        if (informacoes.getIdArea() != null) {
            informacoesDoBanco.setIdArea(informacoes.getIdArea());
        }

        informacoesDoBanco = informacoesAmbienteRepository.save(informacoesDoBanco);

        return factory.toDto(informacoesDoBanco);
    }
}
