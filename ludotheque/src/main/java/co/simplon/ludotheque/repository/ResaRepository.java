package co.simplon.ludotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.ludotheque.model.Resa;

@Repository
public interface ResaRepository extends JpaRepository<Resa, Long> {

}
