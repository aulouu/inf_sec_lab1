package itmo.aulouu.inf.sec.lab1.controller;

import itmo.aulouu.inf.sec.lab1.dto.PetDto;
import itmo.aulouu.inf.sec.lab1.entity.Pet;
import itmo.aulouu.inf.sec.lab1.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data")
@RequiredArgsConstructor
public class PetController {
    private final PetService petService;

    @GetMapping()
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @PostMapping()
    public void create(@RequestBody PetDto petDto) {
        petService.create(petDto);
    }
}
