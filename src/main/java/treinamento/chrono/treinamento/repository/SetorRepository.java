package treinamento.chrono.treinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import treinamento.chrono.treinamento.entity.SetorEntity;

@Repository
public interface SetorRepository extends JpaRepository<SetorEntity, Long> {
}
