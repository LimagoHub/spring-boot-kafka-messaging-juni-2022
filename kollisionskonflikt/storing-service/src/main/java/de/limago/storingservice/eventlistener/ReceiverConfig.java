package de.limago.storingservice.eventlistener;


import de.limago.storingservice.SampleHandler;
import de.limago.storingservice.SampleService;
import de.limago.storingservice.events.DataEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@Slf4j
public class ReceiverConfig {



    @Bean
    public Consumer<DataEvent<String>> first(final SampleHandler handler) {
        return event -> {

                handler.handleUpdateFirst(event.getPayload());

        };
    }

    @Bean
    public Consumer<DataEvent<String>> second(final SampleHandler handler) {
        return event -> {

            handler.handleUpdateSecond(event.getPayload());

        };
    }

}
