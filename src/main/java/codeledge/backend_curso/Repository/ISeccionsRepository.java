package codeledge.backend_curso.Repository;

import codeledge.backend_curso.Models.SeccionsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISeccionsRepository extends JpaRepository<SeccionsModel, Long> {
}
