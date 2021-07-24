package treinamento.chrono.treinamento.exception;

import org.springframework.http.HttpStatus;

public class GlobalException extends  RuntimeException{

    private String userMessage;
    private String devMessage;
    private HttpStatus status;

    public String getUserMessage() {
        return userMessage;
    }

    public String getDevMessage() {
        return devMessage;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public GlobalException(String userMessage, String devMessage, HttpStatus status) {
        this.userMessage = userMessage;
        this.devMessage = devMessage;
        this.status = status;
    }
}
