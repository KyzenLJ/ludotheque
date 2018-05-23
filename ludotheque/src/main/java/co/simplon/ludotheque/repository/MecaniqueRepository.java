package co.simplon.ludotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.ludotheque.model.Mecanique;

@Repository
public interface MecaniqueRepository extends JpaRepository<Mecanique, Long>{

}
