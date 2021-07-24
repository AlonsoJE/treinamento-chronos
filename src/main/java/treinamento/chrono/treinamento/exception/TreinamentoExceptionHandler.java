package treinamento.chrono.treinamento.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Log4j2
public class TreinamentoExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<?> generic(GlobalException e) {
        log.error(String.valueOf(e.getStatus().value())
                .concat("-")
                .concat(e.getStatus().name())
                .concat(".\t\t")
                .concat(e.getDevMessage()));

        ExceptionModel exception = ExceptionModel.builder()
                .status(String.valueOf(e.getStatus().value()).concat(" "+e.getStatus().name()))
                .exception(e.getClass().getName())
                .dateTime(LocalDateTime.now())
                .userMessage(e.getUserMessage())
                .devMessage(e.getDevMessage()).build();
        return new ResponseEntity(exception, e.getStatus());
    }

}
