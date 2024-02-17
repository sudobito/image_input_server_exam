package sudobito.converter.imageinputserver_poc.controller.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sudobito.converter.imageinputserver_poc.service.ImageService;

@RestController
@RequiredArgsConstructor
public class ImageInputController {
    private final ImageService imageService;
    @PostMapping("/images")
    public Mono<Void> uploadImage(@RequestPart("image") FilePart inputtedImage, ServerHttpResponse response) throws InterruptedException {
        MediaType mediaType = inputtedImage.headers().getContentType();
        Flux<DataBuffer> content = inputtedImage.content();

        response.getHeaders().setContentType(mediaType);
        return response.writeWith(imageService.delegate(content));
    }
}
