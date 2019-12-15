package littlepeople.application.mapper;

import java.util.Collection;
import java.util.stream.Collectors;

public abstract class AbstractMapper <Model, Dto> implements MapperInterface<Model, Dto>{
    public Collection<Dto> convertModelsToDtos(Collection<Model> models) {
        return models.stream()
                .map(this::convertModelToDto)
                .collect(Collectors.toSet());
    }

    public Collection<Model> convertDtosToModel(Collection<Dto> dataTransferObjects) {
        return dataTransferObjects.stream()
                .map(this::convertDtoToModel)
                .collect(Collectors.toSet());
    }
}
