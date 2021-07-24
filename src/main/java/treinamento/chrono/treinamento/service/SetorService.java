package treinamento.chrono.treinamento.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import treinamento.chrono.treinamento.converter.SetorConverterImplements;
import treinamento.chrono.treinamento.dto.ProcedimentoDto;
import treinamento.chrono.treinamento.dto.SetorDto;
import treinamento.chrono.treinamento.exception.GlobalException;
import treinamento.chrono.treinamento.repository.SetorRepository;
import treinamento.chrono.treinamento.util.StatusUtil;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class SetorService {

    @Autowired
    private SetorRepository repository;

    @Autowired
    private SetorConverterImplements setorConverter;

    public SetorDto save(SetorDto setorDto){
        log.info("[Setor] - save");
        return setorConverter.toDto(repository.save(setorConverter.toEntity(setorDto)));
    }

    public SetorDto update(Long idSetor, SetorDto setorDto){
        log.info("[Setor] - update '{}'", idSetor);
        verifyId(idSetor);
        verifyContentProcedimentoList(setorDto.getProcedimentos());
        setorDto.setId(idSetor);
        return setorConverter.toDto(repository.save(setorConverter.toEntity(setorDto)));
    }

    public SetorDto active(Long idSetor){
        log.info("[Setor] - isActive '{}'", idSetor);
        verifyId(idSetor);
        SetorDto setorDto = findById(idSetor).get();
        verifyContentProcedimentoList(setorDto.getProcedimentos());
        setorDto.setStatus(StatusUtil.changeStatus((setorDto.getStatus().isStatus())));
        return setorConverter.toDto(repository.save(setorConverter.toEntity(setorDto)));
    }

    public List<SetorDto> findAll(){
        log.info("[Setor] - findall");
        return setorConverter.toDtoList(repository.findAll());
    }

    public Optional<SetorDto> findById(Long idsetor){
        log.info("[Setor] - findById");
        return setorConverter.toOptionalDto(repository.findById(idsetor));
    }

    public void deleteById(Long setorId){
        log.info("[Setor] - delete '{}'",setorId);
        verifyId(setorId);
        repository.deleteById(setorId);
    }

    private void verifyId(Long setorId)  {
        log.info("[SetorService] - verifyId() whit id: '{}'", setorId);
        Optional.of(repository.findById(setorId)).filter(Optional::isPresent).orElseThrow(() ->
                new GlobalException(
                        String.format("Não foi localizado nenhum registro com o id: %d", setorId)
                        , String.format("Class: SetorService | Method: verifyId() whit id: %s and Return: %s", setorId, Optional.empty())
                        , HttpStatus.NOT_FOUND));
    }


    // RULES

    private void verifyContentProcedimentoList(List<ProcedimentoDto> procedimentoDtoList){
        Optional.of(procedimentoDtoList).filter(procedimentoDtoList1 ->
                procedimentoDtoList.isEmpty()
        ).orElseThrow(() ->
                new GlobalException(
                        "Não é possível inativar um setor que esta em uso."
                        , "Class: SetorService | Method: verifyContentProcedimentoList()"
                        , HttpStatus.BAD_REQUEST));
    }

}
