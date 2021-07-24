package treinamento.chrono.treinamento.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import treinamento.chrono.treinamento.constant.StatusConstant;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "setor")
public class SetorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "descricao", length = 100, nullable = true, insertable = true, updatable = true)
    private String descricao;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", nullable = false, insertable = true, updatable = true)
    private StatusConstant status;

    @OneToMany(targetEntity = ProcedimentoEntity.class, fetch = FetchType.LAZY, mappedBy = "setor")
    private List<ProcedimentoEntity> procedimentos;


}
