package fly.be.flyflix.conteudo.dto.curso;

import fly.be.flyflix.conteudo.entity.Curso;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
public class CursoResumoDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDate dataPublicacao;


    public CursoResumoDTO(Curso curso) {
        this.id = curso.getId();
        this.titulo = curso.getTitulo();
        this.descricao = curso.getDescricao();
        this.dataPublicacao = curso.getDataPublicacao();
    }
}