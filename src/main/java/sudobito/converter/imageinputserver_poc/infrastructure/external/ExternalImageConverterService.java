package sudobito.converter.imageinputserver_poc.infrastructure.external;

import org.springframework.core.io.buffer.DataBuffer;
import reactor.core.publisher.Flux;

public interface ExternalImageConverterService {
    Flux<DataBuffer> convert(Flux<DataBuffer> content);
}
