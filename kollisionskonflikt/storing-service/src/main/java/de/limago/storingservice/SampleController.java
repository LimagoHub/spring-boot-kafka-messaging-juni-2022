package de.limago.storingservice;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/sender")
@AllArgsConstructor
public class SampleController {

    private final SampleHandler handler;

    @GetMapping(path="send")
    public String send() {
        handler.handleSave(new Model());
        return "OK";
    }
}
