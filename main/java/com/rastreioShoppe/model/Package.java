package models;

import java.time.LocalDateTime;

public class Package {
    private String qrCode; // Identificador único do pacote
    private String localizacao;
    private String responsavel;
    private String timestamp;
    private int urgencia; // 1 = baixa, 5 = urgente
    private LocalDateTime dataEntrega; // Data de entrega

    public Package(String qrCode, String localizacao, String responsavel, int urgencia, LocalDateTime dataEntrega) {
        this.qrCode = qrCode;
        this.localizacao = localizacao;
        this.responsavel = responsavel;
        this.timestamp = getCurrentTimestamp();
        this.urgencia = urgencia;
        this.dataEntrega = dataEntrega;
    }

    public void atualizarLocalizacao(String novaLocalizacao, String novoResponsavel) {
        this.localizacao = novaLocalizacao;
        this.responsavel = novoResponsavel;
        this.timestamp = getCurrentTimestamp();
    }

    private String getCurrentTimestamp() {
        return LocalDateTime.now().toString();
    }

    // Getters e Setters
    public String getQrCode() {
        return qrCode;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getUrgencia() {
        return urgencia;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }
}
