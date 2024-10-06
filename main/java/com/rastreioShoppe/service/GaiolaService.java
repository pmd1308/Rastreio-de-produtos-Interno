package services;

import models.Gaiola;
import models.Package;
import repositories.PackageRepository;

public class GaiolaService {
    private PackageRepository packageRepository;

    public GaiolaService(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

public void adicionarPacoteNaGaiola(Gaiola gaiola, Package pacote, String setorId, String responsavelId) {
    // Cruze o coletor com o registro de setor para ter a localização
    // Exemplo:
    Setor setor = setorRepository.buscarPorId(setorId);
    Responsavel responsavel = responsavelRepository.buscarPorId(responsavelId);
    
    // Depois de obter os dados, pode atualizar o pacote com essas informações
    pacote.atualizarLocalizacao(setor.getLocalizacao(), responsavel.getNome());
    
    gaiola.adicionarPacote(pacote);
    packageRepository.salvar(pacote);
}

    public void removerPacoteDaGaiola(Gaiola gaiola, String qrCode) {
        gaiola.removerPacote(qrCode);
        packageRepository.removerPorQrCode(qrCode);
    }

    public List<Gaiola> ordenarGaiolasPorPeso(List<Gaiola> gaiolas) {
    return gaiolas.stream()
            .sorted(Comparator.comparingInt(this::calcularPesoGaiola).reversed())
            .collect(Collectors.toList());
    }

    private int calcularPesoGaiola(Gaiola gaiola) {
        int peso = 0;
        for (Package pacote : gaiola.getPacotes()) {
            peso += pacote.getUrgencia(); // Pode ser multiplicado pela data de entrega também
        }
        return peso;
    }



}
