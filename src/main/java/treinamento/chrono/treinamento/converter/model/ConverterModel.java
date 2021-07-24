package treinamento.chrono.treinamento.converter.model;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ConverterModel<Entity, Dto> {
    Dto toDto(final Entity entity);
    Entity toEntity (final Dto dto);
    List<Dto> toDtoList (final List<Entity> entityList);
    Dto toDtoFromOptionalEntity (final Optional<Entity> entityOptional);
    Optional<Dto> toOptionalDto (final Optional<Entity> entityOptional);
    Page<Dto> toPageableDto (final Page<Entity> entityPage);

}
