package com.fiap.msEntrega.infra.gateways.entrega;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.msEntrega.app.gateways.entrega.ConsultarMelhorRotaInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.NoSuchElementException;

public class RepositorioDeEntregaHTTP implements
        ConsultarMelhorRotaInterface {

    private final WebClient webClient;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Value("${endereco.consult.URL}")
    private String consultaEnderecoURL;
    @Value("${start.latitude}")
    private String startLatitude;
    @Value("${start.longitude}")
    private String startLongitude;

    public RepositorioDeEntregaHTTP(WebClient.Builder webClientBuilder, RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.webClient = webClientBuilder
                .baseUrl("https://api.openrouteservice.org/v2/directions/driving-car")
                .build();
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public String consultarMelhorEndereco(Long idEndereco) {

        String endLatitude = null;
        String endLongitude = null;
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(
                    consultaEnderecoURL,
                    String.class,
                    idEndereco
            );
            if (response.getBody() != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootNode = objectMapper.readTree(response.getBody());

                endLatitude = rootNode.get("latitude").asText();
                endLongitude = rootNode.get("longitude").asText();
            }
        } catch (HttpClientErrorException.NotFound e) {
            throw new NoSuchElementException("Cliente não encontrado");
        } catch (Exception e) {
            throw new RuntimeException("Erro na comunicação entre microsserviços", e);
        }

        String apiKey = "5b3ce3597851110001cf62483ece89d245eb47819f58dcd6ac590423";

        String finalStartLatitude = startLongitude + "," + startLatitude;
        String finalEndLongitude = endLongitude + "," + endLatitude;

        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("api_key", apiKey)
                        .queryParam("start", finalStartLatitude)
                        .queryParam("end", finalEndLongitude)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
