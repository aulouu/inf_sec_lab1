package itmo.aulouu.inf.sec.lab1.service;

import itmo.aulouu.inf.sec.lab1.dto.PetDto;
import itmo.aulouu.inf.sec.lab1.entity.Pet;
import itmo.aulouu.inf.sec.lab1.repository.PetRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@AllArgsConstructor
@Service
public class PetService {
    private final PetRepository petRepository;

    @Transactional(rollbackFor = Exception.class)
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Transactional(rollbackFor = Exception.class)
    public void create(PetDto petDto) {
        Pet entity = Pet.builder()
                .name(petDto.getName())
                .species(petDto.getSpecies())
                .age(petDto.getAge())
                .owner(petDto.getOwner())
                .description(petDto.getDescription())
                .build();
        save(entity);
    }

    @Transactional(readOnly = true)
    public Pet getPetByName(String name) {
        Pet pet = petRepository.findByName(name);
        if (pet == null) throw new EntityNotFoundException("Pet don't find");
        return pet;
    }

    @Transactional(readOnly = true)
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }
}
