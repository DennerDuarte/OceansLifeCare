package br.com.fiap.OceansLifeCare.Repository;

import br.com.fiap.OceansLifeCare.Entity.Responsavel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ResponsavelRepository extends CrudRepository<Responsavel, Long> {
}
