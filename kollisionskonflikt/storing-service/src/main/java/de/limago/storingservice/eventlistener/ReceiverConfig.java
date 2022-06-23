package de.limago.storingservice.eventlistener;


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
    public Consumer<DataEvent<Long>> first(final SampleService service) {
        return event -> {

                service.updateFirst(event.getPayload());

        };
    }

    @Bean
    public Consumer<DataEvent<Long>> second(final SampleService service) {
        return event -> {

            service.updateSecond(event.getPayload());

        };
    }

}
