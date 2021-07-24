package treinamento.chrono.treinamento.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import treinamento.chrono.treinamento.constant.StatusConstant;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@Table(name = "procedimento")
public class ProcedimentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "mnemonico", nullable = false, insertable = true, updatable = true)
    private String mnemonico;

    @Column(name = "descricao", nullable = false, insertable = true, updatable = true)
    private String descricao;

    @Column(name = "preco", nullable = false, insertable = true, updatable = true)
    private BigDecimal preco = BigDecimal.ZERO;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", nullable = false, insertable = true, updatable = true)
    private StatusConstant status;

    @ManyToOne(targetEntity = SetorEntity.class)
    @JoinColumn(name = "id_procedimento")
    private SetorEntity setor;
}
