package littlepeople.application.mapper;

public interface MapperInterface <Model, Dto> {
    Model convertDtoToModel(Dto dto);
    Dto convertModelToDto(Model model);
}
