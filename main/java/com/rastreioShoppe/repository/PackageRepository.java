package repositories;

import models.Package;

public interface PackageRepository {
    void salvar(Package pacote);
    Package buscarPorQrCode(String qrCode);
    void removerPorQrCode(String qrCode);
}
