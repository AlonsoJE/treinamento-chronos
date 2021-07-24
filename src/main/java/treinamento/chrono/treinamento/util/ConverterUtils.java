package treinamento.chrono.treinamento.util;

import org.springframework.http.HttpStatus;
import treinamento.chrono.treinamento.exception.GlobalException;

import java.util.Optional;

public class ConverterUtils {

    public static void verifyObject(Object entity, Object resource) {
        Optional.ofNullable(resource).orElseThrow( () ->new GlobalException(
                "Erro de API. Módulo de conversão interna. Acione o suporte."
                , "Class: Converter |  VerifyObject()"
                , HttpStatus.INTERNAL_SERVER_ERROR));

        Optional.ofNullable(entity).orElseThrow( () ->new GlobalException(
                "Erro de API. Módulo de conversão interna. Acione o suporte."
                , "Class: Converter |  VerifyObject()"
                , HttpStatus.INTERNAL_SERVER_ERROR));
    }

}
