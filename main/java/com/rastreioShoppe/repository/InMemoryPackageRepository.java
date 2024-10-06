package repositories;

import models.Package;
import java.util.HashMap;
import java.util.Map;

public class InMemoryPackageRepository implements PackageRepository {
    private Map<String, Package> pacotes = new HashMap<>();

    @Override
    public void salvar(Package pacote) {
        pacotes.put(pacote.getQrCode(), pacote);
    }

    @Override
    public Package buscarPorQrCode(String qrCode) {
        return pacotes.get(qrCode);
    }

    @Override
    public void removerPorQrCode(String qrCode) {
        pacotes.remove(qrCode);
    }
}
