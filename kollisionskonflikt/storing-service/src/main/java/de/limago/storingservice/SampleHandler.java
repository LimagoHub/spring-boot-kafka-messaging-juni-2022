package de.limago.storingservice;

import de.limago.storingservice.events.DataEvent;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

@Component
@AllArgsConstructor
@Transactional()
public class SampleHandler {
    private final SampleService service;
    private final StreamBridge bridge;

    public void handleSave(Model model) {

            service.save(model);

            DataEvent<Model> event = DataEvent.<Model>builder().payload(model).build();
            bridge.send("persistiert-out-0",event );

    }

    public void handleUpdateFirst(String id) {
        service.updateFirst(id);
    }

    public void handleUpdateSecond(String id) {
       service.updateSecond(id);
    }
}
