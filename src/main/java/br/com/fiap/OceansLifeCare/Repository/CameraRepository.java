package br.com.fiap.OceansLifeCare.Repository;

import br.com.fiap.OceansLifeCare.Entity.Camera;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CameraRepository extends CrudRepository<Camera, Long> {
}
