package sudobito.converter.imageinputserver_poc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import sudobito.converter.imageinputserver_poc.infrastructure.external.ExternalImageConverterService;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ExternalImageConverterService externalImageConverterServiceImpl;

    public Flux<DataBuffer> delegate(Flux<DataBuffer> content) {
        return externalImageConverterServiceImpl.convert(content);
    }
}
