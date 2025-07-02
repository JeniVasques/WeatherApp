Weather App - Desafio
AVISO 
## Configuração da API Key para OpenWeather

Para que o app funcione corretamente, é necessário configurar a chave da API do OpenWeather.

Siga os passos:

1. Crie (ou edite) o arquivo `local.properties` na raiz do projeto Android (no mesmo nível do `build.gradle`).

2. Adicione a linha abaixo com sua chave pessoal da API (substitua pelo seu valor):

WEATHER_API_KEY=Sua_Chave_Do_OpenWeather_Aqui

Este projeto é um aplicativo simples que exibe informações meteorológicas utilizando a API OpenWeather. Ele foi desenvolvido para cumprir os requisitos do desafio proposto e corrigir bugs existentes.

Primeiro clonei pelo Android Studio o repositorio do desafio e depois comecei a mexer no codigo.

O que foi implementado
Arquitetura MVVM para melhor organização do código e separação de responsabilidades.

Busca assíncrona das previsões de várias cidades, atualizadas automaticamente a cada 2 minutos.

Atualização manual dos dados por botão "refresh".

Prevenção de dados duplicados na lista exibida, garantindo que cada cidade apareça apenas uma vez.

Interface com RecyclerView exibindo cards personalizados com:

Nome da cidade

Temperatura atual, máxima e mínima (convertidas para Celsius)

Pressão atmosférica

Umidade

Ícone do clima correspondente ao status retornado pela API

Cards com cores de fundo temáticas conforme o clima, deixando o visual mais atrativo.

Correção do problema do ícone padrão (bonequinho Android) exibido, garantindo que os ícones certos sejam mostrados.
