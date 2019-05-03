package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
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
