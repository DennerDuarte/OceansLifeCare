package br.com.fiap.OceansLifeCare.Service;

import br.com.fiap.OceansLifeCare.DTO.TipoObjetoDTO;
import br.com.fiap.OceansLifeCare.Entity.TipoObjeto;
import br.com.fiap.OceansLifeCare.Factory.TipoObjetoFactory;
import br.com.fiap.OceansLifeCare.Repository.TipoObjetoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoObjetoService {

    @Autowired
    private TipoObjetoRepository tipoObjetoRepository;

    private TipoObjetoFactory factory = new TipoObjetoFactory();

    public List<TipoObjetoDTO> getAll() {
        return factory.toDto((List<TipoObjeto>) tipoObjetoRepository.findAll());
    }

    public TipoObjetoDTO getById(Long id) {
        Optional<TipoObjeto> tipoOptional = tipoObjetoRepository.findById(id);
        return tipoOptional.map(factory::toDto).orElse(null);
    }

    public TipoObjetoDTO criarTipo(TipoObjetoDTO tipo) {
        TipoObjeto novotipo = tipoObjetoRepository.save(factory.toEntity(tipo));
        return factory.toDto(novotipo);
    }

    public TipoObjetoDTO updateTipo(Long id, TipoObjetoDTO tipo) {
        TipoObjeto tipoExistente = tipoObjetoRepository.findById(id).orElse(null);

        if (tipoExistente != null) {
            TipoObjeto desatualizado = factory.toEntity(tipo);
            desatualizado.setId(id);

            TipoObjeto atualizado = tipoObjetoRepository.save(desatualizado);
            return factory.toDto(atualizado);
        } else {
            return factory.toDto(tipoExistente);
        }
    }

    public boolean deletarTipo(Long id) {
        if (tipoObjetoRepository.existsById(id)) {
            tipoObjetoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public TipoObjetoDTO updatePartialTipo(Long id, TipoObjetoDTO tipo) throws Exception {
        Optional<TipoObjeto> tipoOptional = tipoObjetoRepository.findById(id);

        if (!tipoOptional.isPresent()) {
            return null;
        }

        TipoObjeto tipoDoBanco = tipoOptional.get();

        if (tipo.getNomeObjeto() != null) {
            tipoDoBanco.setNomeObjeto(tipo.getNomeObjeto());
        }

        if (tipo.getDescObjeto() != null) {
            tipoDoBanco.setDescObjeto(tipo.getDescObjeto());
        }

        tipoDoBanco = tipoObjetoRepository.save(tipoDoBanco);

        return factory.toDto(tipoDoBanco);
    }
}
