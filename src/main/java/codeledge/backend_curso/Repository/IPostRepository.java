package codeledge.backend_curso.Repository;

import codeledge.backend_curso.Models.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<PostModel, Long> {
}
