Weather App - Desafio

Este projeto é um aplicativo simples que exibe informações meteorológicas utilizando a API OpenWeather. Ele foi desenvolvido para cumprir os requisitos do desafio proposto e corrigir bugs existentes.

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
