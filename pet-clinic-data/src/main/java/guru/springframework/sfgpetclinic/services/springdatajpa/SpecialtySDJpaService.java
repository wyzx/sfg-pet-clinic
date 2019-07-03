package guru.springframework.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Specialty;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import guru.springframework.sfgpetclinic.services.SpecialtyService;

@Service
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialtyService {

  private final SpecialtyRepository specialtyRepository;

  public SpecialtySDJpaService(SpecialtyRepository specialtyRepository) {
    this.specialtyRepository = specialtyRepository;
  }

  @Override
  public Set<Specialty> findAll() {
    Set<Specialty> specialties = new HashSet<>();
    specialtyRepository.findAll().forEach(specialties::add);
    return specialties;
  }

  @Override
  public Specialty finbyId(Long aLong) {
    return specialtyRepository.findById(aLong).orElse(null);
  }

  @Override
  public Specialty save(Specialty specialty) {
    return specialtyRepository.save(specialty);
  }

  @Override
  public void delete(Specialty specialty) {
    specialtyRepository.delete(specialty);
  }

  @Override
  public void deleteById(Long aLong) {
    specialtyRepository.deleteById(aLong);
  }
}
