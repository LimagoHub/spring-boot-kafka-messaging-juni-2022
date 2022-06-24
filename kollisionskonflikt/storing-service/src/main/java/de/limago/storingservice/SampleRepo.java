package de.limago.storingservice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class SampleRepo {

    private final SampleRepoRaw repoRaw;
    private final ModelToEntityMapper mapper;
    public void save(Model model) {
        repoRaw.save(mapper.convert(model));
    }

    public Optional<Model> findById(String s) {
        return repoRaw.findById(s).map(mapper::convert);
    }
}
