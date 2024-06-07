package br.com.fiap.OceansLifeCare.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fiap.OceansLifeCare.DTO.DeteccaoDTO;
import br.com.fiap.OceansLifeCare.Entity.Deteccao;
import br.com.fiap.OceansLifeCare.Factory.DeteccaoFactory;
import br.com.fiap.OceansLifeCare.Repository.DeteccaoRepository;

@Service
public class DeteccaoService {

    @Autowired
    private DeteccaoRepository deteccaoRepository;

    private DeteccaoFactory factory = new DeteccaoFactory();
    
    public Page<DeteccaoDTO> getAll(Pageable pageable){
        Page<Deteccao> deteccoes = deteccaoRepository.findAll(pageable);
        return deteccoes.map(factory::toDto);
    }

    public DeteccaoDTO getById(Long id){
        Optional<Deteccao> deteccaoOptional = deteccaoRepository.findById(id);
        return deteccaoOptional.map(factory::toDto).orElse(null);
    }

    public DeteccaoDTO criarDeteccao(DeteccaoDTO deteccao){
        Deteccao novaDeteccao = deteccaoRepository.save(factory.toEntity(deteccao));
        return factory.toDto(novaDeteccao);
    }

    public DeteccaoDTO updateDeteccao(Long id, DeteccaoDTO deteccao){
        Deteccao deteccaoExistente = deteccaoRepository.findById(id).orElse(null);

        if(deteccaoExistente != null){
            Deteccao desatualizado = factory.toEntity(deteccao);
            desatualizado.setId(id);

            Deteccao atualizado = deteccaoRepository.save(desatualizado);
            return factory.toDto(atualizado);
        } else {
            return factory.toDto(deteccaoExistente);
        }
    }

    public boolean deletarDeteccao(Long id) {
        if (deteccaoRepository.existsById(id)) {
            deteccaoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public DeteccaoDTO updatePartialDeteccao(Long id, DeteccaoDTO deteccao) throws Exception {
        Optional<Deteccao> deteccaoOptional = deteccaoRepository.findById(id);

        if (!deteccaoOptional.isPresent()) {
            return null;
        }

        Deteccao deteccaoDoBanco = deteccaoOptional.get();

        if (deteccao.getDataDeteccao() != null) {
            deteccaoDoBanco.setDataDeteccao(deteccao.getDataDeteccao());
        }

        if (deteccao.getNivelConfianca() != null) {
            deteccaoDoBanco.setNivelConfianca(deteccao.getNivelConfianca());
        }

        if (deteccao.getStatus() != null) {
            deteccaoDoBanco.setStatus(deteccao.getStatus());
        }

        if (deteccao.getIdCamera() != null) {
            deteccaoDoBanco.setIdCamera(deteccao.getIdCamera());
        }

        if (deteccao.getIdArea() != null) {
            deteccaoDoBanco.setIdArea(deteccao.getIdArea());
        }

        if (deteccao.getIdTipoObjeto() != null) {
            deteccaoDoBanco.setIdTipoObjeto(deteccao.getIdTipoObjeto());
        }

        deteccaoDoBanco = deteccaoRepository.save(deteccaoDoBanco);

        return factory.toDto(deteccaoDoBanco);
    }
}
