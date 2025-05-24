package fly.be.flyflix.conteudo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Setter
@Getter
@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private LocalDate dataPublicacao; // 🗓️ Data de lançamento
    private String imagemCapa;
    private Long autorId; // ID vindo do microserviço de usuários

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Modulo> modulos;

}

