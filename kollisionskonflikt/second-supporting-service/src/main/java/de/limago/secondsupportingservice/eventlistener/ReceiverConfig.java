package de.limago.secondsupportingservice.eventlistener;



import de.limago.secondsupportingservice.SampleEntity;
import de.limago.secondsupportingservice.events.DataEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
@Slf4j
public class ReceiverConfig {



    @Bean
    public Function<DataEvent<SampleEntity>, DataEvent<Long>> receiver() {
        return event -> {

                DataEvent<Long> outgoing = DataEvent.<Long>builder().payload(event.getPayload().getId()).build();
                return outgoing;
        };
    }



}
