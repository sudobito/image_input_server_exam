package sudobito.converter.imageinputserver_poc.controller.user_interface;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

@Controller
public class PageController {
    @GetMapping("/main")
    public Mono<String> getUploadPage(){
        return Mono.just("imageUpload");
    }
}
