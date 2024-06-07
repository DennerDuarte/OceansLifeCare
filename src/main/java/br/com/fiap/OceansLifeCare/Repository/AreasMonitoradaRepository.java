package br.com.fiap.OceansLifeCare.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.OceansLifeCare.Entity.AreasMonitoradas;

@Repository

public interface AreasMonitoradaRepository extends JpaRepository<AreasMonitoradas, Long> {
}
