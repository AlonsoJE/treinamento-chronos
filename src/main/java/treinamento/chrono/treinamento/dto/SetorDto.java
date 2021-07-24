package treinamento.chrono.treinamento.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import treinamento.chrono.treinamento.constant.StatusConstant;

import java.util.List;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class SetorDto {

    @JsonProperty("id")
    private Long id;

    private String descricao;

    private StatusConstant status;

    @JsonIgnoreProperties("setor")
    private List<ProcedimentoDto> procedimentos;

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setStatus(StatusConstant status) {
        this.status = status;
    }

    public void setProcedimentos(List<ProcedimentoDto> procedimentos) {
        this.procedimentos = procedimentos;
    }
}
