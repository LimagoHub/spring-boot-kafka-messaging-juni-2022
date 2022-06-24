package de.limago.storingservice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@AllArgsConstructor

public class SampleService {

    private final SampleRepo repo;


    public void save(Model model) {
        repo.save(model);

    }

    public void updateFirst(String id) {
        try {
            Model model = repo.findById(id).orElseThrow(()->new NotFoundException("First gescheitert"));
            model.setFirst("OkX");
            save(model);
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    public void updateSecond(String id) {
        try {
            Model model = repo.findById(id).orElseThrow(()->new NotFoundException("First gescheitert"));
            model.setSecond("OkX");
            save(model);
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

}
