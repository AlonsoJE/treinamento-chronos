package treinamento.chrono.treinamento.converter;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import treinamento.chrono.treinamento.converter.model.ConverterModel;
import treinamento.chrono.treinamento.dto.SetorDto;
import treinamento.chrono.treinamento.entity.SetorEntity;
import treinamento.chrono.treinamento.util.ConverterUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SetorConverterImplements implements ConverterModel<SetorEntity, SetorDto> {

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public SetorDto toDto(SetorEntity entity) {
        SetorDto dto = new SetorDto();
        modelMapper.map(entity, dto);
        ConverterUtils.verifyObject(entity, dto);

        return dto;
    }

    @Override
    public SetorEntity toEntity(SetorDto dto) {
        SetorEntity entity = new SetorEntity();
        modelMapper.map(dto, entity);
        ConverterUtils.verifyObject(entity, dto);
        return entity;
    }

    @Override
    public List<SetorDto> toDtoList(List<SetorEntity> entityList) {
        List<SetorDto> list = new ArrayList<>();

        entityList.forEach(a ->{
            list.add(toDto(a));
        });
        return list;
    }

    @Override
    public SetorDto toDtoFromOptionalEntity(Optional<SetorEntity> optional) {
        return optional.map(this::toDto).orElse(null);
    }

    @Override
    public Optional<SetorDto> toOptionalDto(Optional<SetorEntity> optional) {
        return Optional.ofNullable(toDtoFromOptionalEntity(optional));
    }

    @Override
    public Page<SetorDto> toPageableDto(Page<SetorEntity> list) {
        return list.map(entity -> toDto(entity));
    }

}
