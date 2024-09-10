package codeledge.backend_curso.Repository;

import codeledge.backend_curso.Models.TiposPostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITiposPostRepository extends JpaRepository<TiposPostModel, Long> {
}
