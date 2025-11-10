package itmo.aulouu.inf.sec.lab1.repository;

import itmo.aulouu.inf.sec.lab1.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    Pet findByName(String name);
}
