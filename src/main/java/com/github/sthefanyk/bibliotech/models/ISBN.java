package com.github.sthefanyk.bibliotech.models;

public class ISBN {
    private String code;

    public ISBN(String code) {
        this.code = code;
    }

    public boolean isValid() {
        // Implementar a lógica de validação do ISBN aqui
        // Exemplo simples de validação: checar se o código não é nulo ou vazio
        return code != null && !code.trim().isEmpty();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
