package treinamento.chrono.treinamento.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.http.HttpStatus;
import treinamento.chrono.treinamento.constant.StatusConstant;
import treinamento.chrono.treinamento.exception.GlobalException;

import java.math.BigDecimal;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ProcedimentoDto {


    private Long id;

    private String mnemonico;

    private String descricao;

    private BigDecimal preco = BigDecimal.ZERO;

    private StatusConstant status;

    @JsonIgnoreProperties("procedimentos")
    private SetorDto setor;

    public void setId(Long id) {
        this.id = id;
    }

    public void setMnemonico(String mnemonico) {
        this.mnemonico = mnemonico;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(BigDecimal preco) {
        if(preco.compareTo(BigDecimal.ZERO) == -1){
            throw new GlobalException(
                    String.format("Não é possível ter preço negativo")
                    , String.format("Class: '%s' | Method: '%s' - whit value: '%s' and Return -> '%s'",this.getClass().getName(), new Throwable().getStackTrace()[0], status, preco)
                    , HttpStatus.BAD_REQUEST);
        }
        this.preco = preco;
    }

    public void setStatus(StatusConstant status) {
        this.status = status;
    }

    public void setSetor(SetorDto setor) {
        this.setor = setor;
    }

}
