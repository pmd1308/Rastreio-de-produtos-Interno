# Documentação da Implementação do Sistema

Dado que essa parte teria que fazer internamente, eu vou apenas documentar as sugestões de implementações e as ideias que estou tendo para o uso.

No caso, seria rodar esse software em um servidor interno que configuraria a API Restful e hospedaria o banco de dados. Através de um bypass entre esse servidor e o WMS, supondo que os coletores estão ligados a eles, seria possível registrar a criação de pacotes.

Penso que não haveria necessidade de tocar no WMS, já que seria um processo interno. A única coisa que teria de ser feita é liberar uma porta para esse servidor. E em questão de segurança, o único risco seria a perda de rastreabilidade temporária, mas dado que ele segue o modelo de Markov, o reset dele seria o suficiente para se recuperar. Além disso, trafegar dados irrelevantes é um problema, e se a pessoa que tiver tentando fazer um DDoS ou um MITM num servidor besta precisa urgente de uma namorada. Kkkkkkk!

**PS:** E sim, gosto de ficar imaginando cenários adaptativos seguindo padrões de redundância.

**PS2:** Desculpa a falta de profissionalismo, é que não quero me levar tão a sério. Kkkkkkk!

Lógico, só teria que estudar uma possível derrubada do WMS por números de requisições, mas isso é bem depois.

## Diagrama de Implementação

```mermaid
graph TD;
    A[Início da Coleta] --> B[Coletor Android Lê Pacote]
    B --> C[Ativar Bypass]
    C --> D[Conexão com Servidor]
    D --> E[Autenticação e Registro no Banco de Dados]
    E --> F[Armazenar Dados Localmente e limpar o pacote enviado para o WMS para não consumir banda desnecessária e evitar um possivel DOS]
    F --> G[Enviar Dados para WMS]
    G --> H[Fim da Coleta]
