package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Specialty;
import guru.springframework.sfgpetclinic.services.SpecialtyService;

@Service
public class SpecialtyMapService extends AbstractMapService<Specialty, Long> implements SpecialtyService {
  @Override
  public Set<Specialty> findAll() {
    return super.findAll();
  }

  @Override
  public Specialty finbyId(Long id) {
    return super.findById(id);
  }

  @Override
  public Specialty save(Specialty specialty) {
    return super.save(specialty);
  }

  @Override
  public void delete(Specialty specialty) {
    super.delete(specialty);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }
}
