package com.fran.demo;

import com.fran.demo.app.Handler;
import com.fran.demo.app.ServiceIp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.reactive.function.server.MockServerRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.Provider;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HandlerTest {

	@Autowired
	private Handler handler;

	@SpyBean
	private ServiceIp serviceIp;

	@Test
	public void findMyOpenTypes() throws UnknownHostException {
		//given
		final MockServerRequest request = MockServerRequest.builder().build();
		final String response = InetAddress.getLocalHost().toString();

		//when
		when(serviceIp.getIp()).thenReturn(Mono.just(response));
		final Mono<ServerResponse> mono = handler.getIp(request);

		//then
		StepVerifier
				.create(mono)
				.consumeNextWith(this::verifyServerResponse)
				.verifyComplete();

		verify(serviceIp, times(1)).getIp();
	}

	public void verifyServerResponse(final ServerResponse serverResponse) {
		assertThat(serverResponse.statusCode(), is(HttpStatus.OK));
	}

}
