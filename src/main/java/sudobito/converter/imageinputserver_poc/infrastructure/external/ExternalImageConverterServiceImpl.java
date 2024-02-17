package sudobito.converter.imageinputserver_poc.infrastructure.external;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class ExternalImageConverterServiceImpl implements ExternalImageConverterService{
    private final WebClient webClient;

    public ExternalImageConverterServiceImpl() {
        webClient = WebClient.builder().baseUrl("http://localhost:8081").build();
    }

    public Flux<DataBuffer> convert(Flux<DataBuffer> content) {
        return webClient.post()
                .uri("/converter")
                .body(BodyInserters.fromDataBuffers(content))
                .retrieve()
                .bodyToFlux(DataBuffer.class);
    }
}
