package de.limago.storingservice;

import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class SampleService {

    private final SampleRepo repo;
    private final StreamBridge bridge;

    public void save(SampleEntity entity) {
        repo.save(entity);
        bridge.send("persistiert-out-0",entity );
    }



}
