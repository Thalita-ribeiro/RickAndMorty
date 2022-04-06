package com.thalita.webclientrickandmortyapi.controller;

import com.thalita.webclientrickandmortyapi.client.RickAndMortyClient;
import com.thalita.webclientrickandmortyapi.response.CharacterResponse;
import com.thalita.webclientrickandmortyapi.response.EpisodeResponse;
import com.thalita.webclientrickandmortyapi.response.LocationResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/webclient")
public class RickAndMortyController {

    RickAndMortyClient rickAndMortyClient;

    @GetMapping("/character/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<CharacterResponse> getCharacterById(@PathVariable String id) {
        return rickAndMortyClient.findACharacterById(id);
    }

    @GetMapping("/location/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<LocationResponse> getLocationById(@PathVariable String id) {
        return rickAndMortyClient.findALocationById(id);
    }

    @GetMapping("/episode/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<EpisodeResponse> getEpisodeById(@PathVariable String id) {
        return rickAndMortyClient.findAEpisodeById(id);
    }
}
