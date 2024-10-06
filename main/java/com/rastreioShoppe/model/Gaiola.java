package models;

import java.util.ArrayList;
import java.util.List;

public class Gaiola {
    private String id;
    private List<Package> pacotes;

    public Gaiola(String id) {
        this.id = id;
        this.pacotes = new ArrayList<>();
    }

    public void adicionarPacote(Package pacote) {
        this.pacotes.add(pacote);
    }

    public void removerPacote(String qrCode) {
        this.pacotes.removeIf(pacote -> pacote.getQrCode().equals(qrCode));
    }

    public boolean isVazia() {
        return pacotes.isEmpty();
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public List<Package> getPacotes() {
        return pacotes;
    }
}
