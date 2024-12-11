package com.example.PruebaTecnica.infraestructure.persistencia.repositorio;

import com.example.PruebaTecnica.domain.repository.DeleteByIdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DeleteByIdTicketImpl implements DeleteByIdRepository {

    private final TicketJpaRepository jpaRepository;

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
