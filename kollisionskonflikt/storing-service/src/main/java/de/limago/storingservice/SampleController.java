package de.limago.storingservice;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/sender")
@AllArgsConstructor
public class SampleController {

    private final SampleService service;

    @GetMapping(path="send")
    public String send() {
        service.save(new SampleEntity());
        return "OK";
    }
}
