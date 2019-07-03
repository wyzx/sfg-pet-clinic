package guru.springframework.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinic.services.PetTypeService;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {
  private final PetTypeRepository petTypeRepository;

  public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
    this.petTypeRepository = petTypeRepository;
  }

  @Override
  public Set<PetType> findAll() {
    Set<PetType> petTypes = new HashSet<>();
    petTypeRepository.findAll().forEach(petTypes::add);
    return petTypes;
  }

  @Override
  public PetType finbyId(Long aLong) {
    return petTypeRepository.findById(aLong).orElse(null);
  }

  @Override
  public PetType save(PetType petType) {
    return petTypeRepository.save(petType);
  }

  @Override
  public void delete(PetType petType) {
    petTypeRepository.delete(petType);
  }

  @Override
  public void deleteById(Long aLong) {
    petTypeRepository.deleteById(aLong);
  }
}
