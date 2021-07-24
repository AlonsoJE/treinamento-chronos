package treinamento.chrono.treinamento.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ExceptionModel {

    private String status;
    private LocalDateTime dateTime;
    private String exception;
    private String devMessage;
    private String userMessage;

}
