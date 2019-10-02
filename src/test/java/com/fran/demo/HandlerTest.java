package com.fran.demo;

import com.fran.demo.app.Handler;
import com.fran.demo.app.ServiceIp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.reactive.function.server.MockServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HandlerTest {

	@InjectMocks
	private Handler handler;

	@Mock
	private ServiceIp serviceIp;

	@Test
	public void getIp() throws UnknownHostException {
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
