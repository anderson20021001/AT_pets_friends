package br.com.petfriends.transporte.domain.repository;

import br.com.petfriends.transporte.domain.model.aggregate.Transporte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransporteRepository extends JpaRepository<Transporte, UUID> {
}
