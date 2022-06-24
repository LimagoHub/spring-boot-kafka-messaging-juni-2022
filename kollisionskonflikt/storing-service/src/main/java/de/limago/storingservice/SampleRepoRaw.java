package de.limago.storingservice;

import org.springframework.data.repository.CrudRepository;

public interface SampleRepoRaw extends CrudRepository<SampleEntity, String> {
}
