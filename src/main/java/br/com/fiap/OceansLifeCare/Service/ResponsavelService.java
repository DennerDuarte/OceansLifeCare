package br.com.fiap.OceansLifeCare.Service;

import br.com.fiap.OceansLifeCare.DTO.ResponsavelDTO;
import br.com.fiap.OceansLifeCare.Entity.Responsavel;
import br.com.fiap.OceansLifeCare.Repository.ResponsavelRepository;
import br.com.fiap.OceansLifeCare.factory.ResponsavelFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponsavelService {

    @Autowired
    private ResponsavelRepository responsavelRepository;

    private ResponsavelFactory factory = new ResponsavelFactory();

    public List<ResponsavelDTO> getAll() {
        return factory.toDto((List<Responsavel>) responsavelRepository.findAll());
    }

    public ResponsavelDTO getById(Long id) {
        Optional<Responsavel> responsavelOptional = responsavelRepository.findById(id);
        return responsavelOptional.map(factory::toDto).orElse(null);
    }

    public ResponsavelDTO criarResponsavel(ResponsavelDTO responsavel) {
        Responsavel novoResponsavel = responsavelRepository.save(factory.toEntity(responsavel));
        return factory.toDto(novoResponsavel);
    }

    public ResponsavelDTO updateResponsavel(Long id, ResponsavelDTO responsavel) {
        Responsavel responsavelExistente = responsavelRepository.findById(id).orElse(null);

        if (responsavelExistente != null) {
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

    public ResponsavelDTO updatePartialResponsavel(Long id, ResponsavelDTO responsavel) throws Exception {
        Optional<Responsavel> responsavelOptional = responsavelRepository.findById(id);

        if (!responsavelOptional.isPresent()) {
            return null;
        }

        Responsavel responsavelDoBanco = responsavelOptional.get();

        if (responsavel.getResponsavel() != null) {
            responsavelDoBanco.setResponsavel(responsavel.getResponsavel());
        }

        if (responsavel.getUsuario() != null) {
            responsavelDoBanco.setUsuario(responsavel.getUsuario());
        }

        if (responsavel.getSenha() != null) {
            responsavelDoBanco.setSenha(responsavel.getSenha());
        }

        if (responsavel.getEmail() != null) {
            responsavelDoBanco.setEmail(responsavel.getEmail());
        }

        if (responsavel.getTelefone() != null) {
            responsavelDoBanco.setTelefone(responsavel.getTelefone());
        }

        responsavelDoBanco = responsavelRepository.save(responsavelDoBanco);

        return factory.toDto(responsavelDoBanco);
    }
}
