package com.labcerebrone.Server.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@Service
public class ServerService {
    //    WebClient for Calling EndPoint
    private WebClient webClient;

    public ServerService(WebClient webClient){
        this.webClient = webClient;
    }

    public Mono<String> get(Integer id) {
        Mono<String> a = null;
        try {
            a = webClient.get()
                    .uri("http://numbersapi.com/" + id)
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
