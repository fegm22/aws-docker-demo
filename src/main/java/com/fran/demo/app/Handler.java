package com.fran.demo.app;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Slf4j
@RequiredArgsConstructor
@Component
public class Handler {

    private final ServiceIp serviceIp;

    public Mono<ServerResponse> getIp(final ServerRequest request) {
        log.trace(request.toString());
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(serviceIp.getIp(), EC2Info.class);
    }
}
