package treinamento.chrono.treinamento.converter;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import treinamento.chrono.treinamento.converter.model.ConverterModel;
import treinamento.chrono.treinamento.dto.ProcedimentoDto;
import treinamento.chrono.treinamento.entity.ProcedimentoEntity;
import treinamento.chrono.treinamento.util.ConverterUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProcedimentoConverterImplements implements ConverterModel<ProcedimentoEntity, ProcedimentoDto> {

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public ProcedimentoDto toDto(ProcedimentoEntity procedimentoEntity) {
        ProcedimentoDto dto = new ProcedimentoDto();
        modelMapper.map(procedimentoEntity, dto);
        ConverterUtils.verifyObject(procedimentoEntity, dto);

        return dto;
    }

    @Override
    public ProcedimentoEntity toEntity(ProcedimentoDto procedimentoDto) {
        ProcedimentoEntity entity = new ProcedimentoEntity();
        modelMapper.map(procedimentoDto, entity);
        ConverterUtils.verifyObject(entity, procedimentoDto);
        return entity;
    }

    @Override
    public List<ProcedimentoDto> toDtoList(List<ProcedimentoEntity> procedimentoEntities) {
        List<ProcedimentoDto> list = new ArrayList<>();

        procedimentoEntities.forEach(a ->{
            list.add(toDto(a));
        });
        return list;
    }

    @Override
    public ProcedimentoDto toDtoFromOptionalEntity(Optional<ProcedimentoEntity> optional) {
        return optional.map(this::toDto).orElse(null);
    }

    @Override
    public Optional<ProcedimentoDto> toOptionalDto(Optional<ProcedimentoEntity> optional) {
        return Optional.ofNullable(toDtoFromOptionalEntity(optional));
    }

    @Override
    public Page<ProcedimentoDto> toPageableDto(Page<ProcedimentoEntity> list) {
        return list.map(entity -> toDto(entity));
    }
}
