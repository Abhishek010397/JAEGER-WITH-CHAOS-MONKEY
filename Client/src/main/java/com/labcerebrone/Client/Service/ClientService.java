package com.labcerebrone.Client.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@Service
public class ClientService {

    private WebClient webClient;

    public ClientService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> get(Integer id) {
        try {
            Mono<String> a = webClient.get()
                    .uri("http://localhost:9021/server/" + id)
                    .retrieve()
                    .bodyToMono(String.class);
            return a;
        }
        catch (Exception e){

            System.out.println("STackTrace: " + Arrays.toString(e.getStackTrace()));
        }
        return null;
    }
}
