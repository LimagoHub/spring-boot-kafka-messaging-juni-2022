package de.limago.storingservice;

import org.springframework.data.repository.CrudRepository;

public interface SampleRepo extends CrudRepository<SampleEntity, Long> {
}
