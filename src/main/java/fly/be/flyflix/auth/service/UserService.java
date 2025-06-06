package fly.be.flyflix.auth.service;

import fly.be.flyflix.auth.controller.dto.CadastroAluno;
import fly.be.flyflix.auth.controller.dto.DadosAtualizacaoAluno;
import fly.be.flyflix.auth.controller.dto.DadosDetalhamentoAluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Map;

public interface UserService {

    public ResponseEntity<Map<String, Object>> cadastrarAluno(CadastroAluno dados);
    public ResponseEntity<Map<String, Object>> atualizarAluno(DadosAtualizacaoAluno dados);
    public ResponseEntity<Map<String, Object>> removerAluno(long id);
    public ResponseEntity<Map<String, Object>> obterAluno(long id);
    public ResponseEntity<Map<String, Object>> obterAlunoByEmail(String email);
    public Page<DadosDetalhamentoAluno> listar(Pageable paginacao);

}
