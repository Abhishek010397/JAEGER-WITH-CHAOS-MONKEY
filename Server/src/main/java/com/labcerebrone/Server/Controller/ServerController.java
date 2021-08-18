package com.labcerebrone.Server.Controller;

import com.labcerebrone.Server.Service.ServerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/server")
public class ServerController {

    private ServerService serverService;


    public ServerController(ServerService serverService){
        this.serverService = serverService;
    }

    @GetMapping("/{id}")
    public Mono<String> get(@PathVariable("id") Integer id){
        return serverService.get(id);
    }
}
