package br.com.fiap.OceansLifeCare.Repository;

import br.com.fiap.OceansLifeCare.Entity.InformacoesAmbiente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface InformacoesAmbienteRepository extends CrudRepository<InformacoesAmbiente, Long> {
}
