package br.com.fiap.OceansLifeCare.Repository;

import br.com.fiap.OceansLifeCare.Entity.TipoObjeto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoObjetoRepository extends CrudRepository<TipoObjeto, Long> {
}
