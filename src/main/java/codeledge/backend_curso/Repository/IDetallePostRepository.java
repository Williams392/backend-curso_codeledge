package codeledge.backend_curso.Repository;

import codeledge.backend_curso.Models.DetallePostModel;
import codeledge.backend_curso.Models.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetallePostRepository extends JpaRepository<DetallePostModel, Long> {
}
