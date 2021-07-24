package treinamento.chrono.treinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import treinamento.chrono.treinamento.entity.ProcedimentoEntity;

@Repository
public interface ProcedimentoRepository extends JpaRepository<ProcedimentoEntity, Long> {
}
