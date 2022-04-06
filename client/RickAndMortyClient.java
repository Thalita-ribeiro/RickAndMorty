package com.thalita.webclientrickandmortyapi.client;

import com.thalita.webclientrickandmortyapi.response.CharacterResponse;
import com.thalita.webclientrickandmortyapi.response.EpisodeResponse;
import com.thalita.webclientrickandmortyapi.response.LocationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@Slf4j
public class RickAndMortyClient {

    private WebClient webClient;

    public RickAndMortyClient(WebClient.Builder builder) {
        webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
    }

    public Mono<CharacterResponse> findACharacterById(String id) {
        log.info("Buscando personagem com o id [{}]", id);
        return webClient
                .get()
                .uri("/character/" + id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("verifique os parâmetros informados")))
                .bodyToMono(CharacterResponse.class);
    }

    public Mono<LocationResponse> findALocationById(String id) {
        log.info("Buscando a localizacao com o id [{}]", id);
        return webClient
                .get()
                .uri("/location/" + id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("verifique os parâmetros informados")))
                .bodyToMono(LocationResponse.class);
    }

    public Mono<EpisodeResponse> findAEpisodeById(String id) {
        log.info("Buscando a localizacao com o id [{}]", id);
        return webClient
                .get()
                .uri("/episode/" + id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("verifique os parâmetros informados")))
                .bodyToMono(EpisodeResponse.class);
    }
}
