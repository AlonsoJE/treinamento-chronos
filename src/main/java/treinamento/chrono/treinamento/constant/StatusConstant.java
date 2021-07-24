package treinamento.chrono.treinamento.constant;

public enum StatusConstant {

    ATIVO(true), INATIVO(false);

    Boolean status;

    StatusConstant(boolean b) {
        this.status = b;
    }

    public boolean isStatus() {
        return status;
    }
}
