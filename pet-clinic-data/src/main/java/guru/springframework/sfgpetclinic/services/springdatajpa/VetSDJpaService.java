package guru.springframework.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.VetRepository;
import guru.springframework.sfgpetclinic.services.VetService;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

  final private VetRepository vetRepository;

  public VetSDJpaService(VetRepository vetRepository) {
    this.vetRepository = vetRepository;
  }

  @Override
  public Set<Vet> findAll() {
    Set<Vet> vets = new HashSet<>();
    vetRepository.findAll().forEach(vets::add);
    return vets;
  }

  @Override
  public Vet finbyId(Long aLong) {
    return vetRepository.findById(aLong).orElse(null);
  }

  @Override
  public Vet save(Vet vet) {
    return vetRepository.save(vet);
  }

  @Override
  public void delete(Vet vet) {
    vetRepository.delete(vet);
  }

  @Override
  public void deleteById(Long aLong) {
    vetRepository.deleteById(aLong);
  }
}
