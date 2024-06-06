package br.com.fiap.OceansLifeCare.Repository;

import br.com.fiap.OceansLifeCare.Entity.AreasMonitoradas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AreasMonitoradaRepository extends CrudRepository<AreasMonitoradas, Long> {
}
