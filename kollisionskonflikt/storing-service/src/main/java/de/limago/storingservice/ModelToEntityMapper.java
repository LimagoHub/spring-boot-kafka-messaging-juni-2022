package de.limago.storingservice;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModelToEntityMapper {
    Model convert(SampleEntity entity);
    SampleEntity convert(Model model);
}
