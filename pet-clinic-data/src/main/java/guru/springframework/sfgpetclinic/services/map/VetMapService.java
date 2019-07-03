package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Specialty;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

  private final SpecialtyService specialtyService;

  public VetMapService(SpecialtyService specialtyService) {
    this.specialtyService = specialtyService;
  }

  @Override
  public Set<Vet> findAll() {
    return super.findAll();
  }

  @Override
  public Vet finbyId(Long id) {
    return super.findById(id);
  }

  @Override
  public Vet save(Vet vet) {
    if (vet.getSpecialties().size() >0) {
      vet.getSpecialties().forEach(specialty -> {
        if (specialty.getId() == null) {
           Specialty savedSpecialty = specialtyService.save(specialty);
           specialty.setId(savedSpecialty.getId());
        }
      });
    }
    return super.save(vet);
  }

  @Override
  public void delete(Vet vet) {
    super.delete(vet);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }
}
