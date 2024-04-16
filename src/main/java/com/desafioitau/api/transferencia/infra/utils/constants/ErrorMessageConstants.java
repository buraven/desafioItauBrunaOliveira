package com.desafioitau.api.transferencia.infra.utils.constants;

public class ErrorMessageConstants {

    private ErrorMessageConstants() {}

    public static final String ERRO_CONTA_NAO_CADASTRADA = "Conta não cadastrada";
    public static final String ERRO_CONTA_NAO_ATIVA = "Conta não está ativa";
    public static final String ERRO_SALDO_MENOR_QUE_ZERO = "Saldo não pode ser menor ou igual a zero";
    public static final String ERRO_SALDO_INSUFICIENTE = "Saldo insuficiente";
    public static final String ERRO_LIMITE_MENOR_QUE_ZERO = "Limite diário não pode ser menor ou igual a zero";
    public static final String ERRO_LIMITE_INSUFICIENTE = "Limite diário insuficiente";

}