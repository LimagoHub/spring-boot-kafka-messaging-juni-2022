package de.limago.firstsupportingservice.eventlistener;


import de.limago.firstsupportingservice.SampleEntity;
import de.limago.firstsupportingservice.events.DataEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
@Slf4j
public class ReceiverConfig {



    @Bean
    public Function<DataEvent<SampleEntity>, DataEvent<String>> receiver() {
        return event -> {
            System.out.println("First receiving data");
                DataEvent<String> outgoing = DataEvent.<String>builder().payload(event.getPayload().getId()).build();
                return outgoing;
        };
    }



}
