package fly.be.flyflix.auth.repository;

import fly.be.flyflix.auth.entity.Aluno;
import fly.be.flyflix.auth.entity.UsuarioBase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Page<Aluno> findAllByAtivoTrue(Pageable paginacao);
    Optional<UsuarioBase> findByLogin (String login);
    Optional<Aluno> findById(Long id);
    Optional <Aluno> findByEmail(String email);
    Optional<Aluno> findByEmailContaining(String email);


}
