package treinamento.chrono.treinamento.util;

import lombok.extern.log4j.Log4j2;
import treinamento.chrono.treinamento.constant.StatusConstant;

@Log4j2
public class StatusUtil {

    public static StatusConstant changeStatus(Boolean status){
        log.info("[Setor] - changeStatus '{}'",status);

        return (status) ? StatusConstant.INATIVO : StatusConstant.ATIVO;

    }

}
