package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
  @Override
  public Set<Owner> findAll() {
    return super.findAll();
  }

  @Override
  public Owner finbyId(Long id) {
    return super.findById(id);
  }

  @Override
  public Owner save(Owner owner) {
    return super.save(owner.getId(), owner);
  }

  @Override
  public void delete(Owner owner) {
    super.delete(owner);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);

  }

  @Override
  public Owner findByLastName(String lastName) {
    return null; //FIXME
  }
}
