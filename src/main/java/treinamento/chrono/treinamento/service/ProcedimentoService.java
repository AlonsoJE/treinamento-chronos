package treinamento.chrono.treinamento.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import treinamento.chrono.treinamento.constant.StatusConstant;
import treinamento.chrono.treinamento.converter.ProcedimentoConverterImplements;
import treinamento.chrono.treinamento.dto.ProcedimentoDto;
import treinamento.chrono.treinamento.exception.GlobalException;
import treinamento.chrono.treinamento.repository.ProcedimentoRepository;
import treinamento.chrono.treinamento.util.StatusUtil;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
@Log4j2
public class ProcedimentoService {

    @Autowired
    private ProcedimentoRepository repository;

    @Autowired
    private SetorService setorService;

    @Autowired
    private ProcedimentoConverterImplements procedimentoConverter;

    public ProcedimentoDto save(ProcedimentoDto procedimentoDto){
        log.info("[Procedimento] - save");
        verifyStatusSetor(procedimentoDto.getSetor().getId());
        return procedimentoConverter.toDto(repository.save(procedimentoConverter.toEntity(procedimentoDto)));

    }

    public ProcedimentoDto update(Long idProcedimento, ProcedimentoDto procedimentoDto){
        log.info("[Procedimento] - update '{}'", idProcedimento);
        verifyId(idProcedimento);
        verifyStatusSetor(procedimentoDto.getId());
        procedimentoDto.setId(idProcedimento);
        return procedimentoConverter.toDto(repository.save(procedimentoConverter.toEntity(procedimentoDto)));
    }

    public ProcedimentoDto active(Long idSetor){
        log.info("[Setor] - isActive '{}'", idSetor);
        verifyId(idSetor);
        ProcedimentoDto setorDto = findById(idSetor).get();
        setorDto.setStatus(StatusUtil.changeStatus((setorDto.getStatus().isStatus())));
        return procedimentoConverter.toDto(repository.save(procedimentoConverter.toEntity(setorDto)));
    }

    public List<ProcedimentoDto> findAll(){
        log.info("[Procedimento] - findall");
        return procedimentoConverter.toDtoList(repository.findAll());
    }

    public Optional<ProcedimentoDto> findById(Long idProcedimento){
        log.info("[Procedimento] - findById");
        return procedimentoConverter.toOptionalDto(repository.findById(idProcedimento));
    }

    public HttpStatus deleteById(Long id){
        log.info("[Procedimento] - delete '{}'",id);
        verifyId(id);
        repository.deleteById(id);
        return HttpStatus.OK;
    }

    private void verifyId(Long procedimentoId){
        log.info("[Procedimento] - verifyId '{}'", procedimentoId);
        Optional.of(repository.findById(procedimentoId)).filter(Optional::isPresent).orElseThrow(() ->
                new RuntimeException(String.format("[Procedimento] Não existe registro vinculado ao id: %d", procedimentoId)));
    }

    private void verifyStatusSetor(Long id) {
        StatusConstant status = setorService.findById(id).get().getStatus();
        Optional.of(status)
                .filter(Predicate.isEqual(StatusConstant.ATIVO))
                .orElseThrow(() -> (
                    new GlobalException(
                        String.format("Não é possível utilizar Setores INATIVOS nos procedimentos. O setor '%d' atualmente possui status INATIVO", id)
                        , String.format("Class: ProcedimentoService | Method: verifyStatusSetor() whit id '%s' and Return: '%s'", id, status)
                        , HttpStatus.BAD_REQUEST)));
    }
}
