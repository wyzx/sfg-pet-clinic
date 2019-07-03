package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.PetService;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
  @Override
  public Set<Pet> findAll() {
    return super.findAll();
  }

  @Override
  public Pet finbyId(Long id) {
    return super.findById(id);
  }

  @Override
  public Pet save(Pet pet) {
    return super.save(pet);
  }

  @Override
  public void delete(Pet pet) {
    super.delete(pet);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);

  }
}
