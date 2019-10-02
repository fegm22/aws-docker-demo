package com.fran.demo;


import com.fran.demo.app.ServiceIp;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
@Ignore
public class ServiceIpTest {

    @InjectMocks
    private ServiceIp serviceIp;

    @Test
    public void shouldGetIp() throws UnknownHostException {
        //given
        final String ip = InetAddress.getLocalHost().toString();

        //when
        final Mono<String> response = serviceIp.getIp();

        //then
        StepVerifier
                .create(response)
                .consumeNextWith(responseV1 -> {
                    assertThat(responseV1).isEqualTo(ip);
                })
                .verifyComplete();

    }

}
