package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetTypeService;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

  @Override
  public Set<PetType> findAll() {
    return super.findAll();
  }

  @Override
  public PetType finbyId(Long id) {
    return super.findById(id);
  }

  @Override
  public PetType save(PetType petType) {
    return super.save(petType);
  }

  @Override
  public void delete(PetType petType) {
    super.delete(petType);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }
}
