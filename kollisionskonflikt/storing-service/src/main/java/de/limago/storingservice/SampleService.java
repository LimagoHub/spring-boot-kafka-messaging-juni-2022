package de.limago.storingservice;

import de.limago.storingservice.events.DataEvent;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

@Service
@AllArgsConstructor
@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
public class SampleService {

    private final SampleRepo repo;
    private final StreamBridge bridge;

    public void save(SampleEntity entity) {
        repo.save(entity);
        DataEvent<SampleEntity> event = DataEvent.<SampleEntity>builder().payload(entity).build();
        bridge.send("persistiert-out-0",event );
    }

    public void updateFirst(long id) {
        try {
            SampleEntity entity = repo.findById(id).orElseThrow(()->new NotFoundException("First gescheitert"));
            entity.setFirst("OK");
        } catch (Exception e) {
            System.out.println("updateFirst: " + e.getClass().getSimpleName() + " " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void updateSecond(long id) {
        try {
            SampleEntity entity = repo.findById(id).orElseThrow(()->new NotFoundException("First gescheitert"));
            entity.setSecond("OK");
        } catch (Exception e) {
            System.out.println("updateSecond: " + e.getClass().getSimpleName() + " " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
