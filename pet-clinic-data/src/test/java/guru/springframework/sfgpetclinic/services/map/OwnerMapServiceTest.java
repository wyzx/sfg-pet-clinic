package guru.springframework.sfgpetclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.model.Owner;

class OwnerMapServiceTest {

  private static final String LAST_NAME = "Jules";
  private OwnerMapService ownerMapService;
  private static final Long OWNER_ID = 1L;

  @BeforeEach
  void setUp() {
    ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
    ownerMapService.save(Owner.builder().id(OWNER_ID).lastName(LAST_NAME).build());
  }

  @Test
  void findAll() {

    assertEquals(1, ownerMapService.findAll().size());
  }

  @Test
  void finbyId() {
    Long id = ownerMapService.finbyId(OWNER_ID).getId();
    assertEquals(OWNER_ID, id);
  }

  @Test
  void saveExistingId() {
    Long id = 2L;
    Owner owner2 = Owner.builder().id(id).build();
    owner2 = ownerMapService.save(owner2);
    assertEquals(id, owner2.getId());

  }

  @Test
  void saveNoId() {

    Owner owner = Owner.builder().build();
    owner = ownerMapService.save(owner);
    assertNotNull(owner);
    assertNotNull(owner.getId());
  }

  @Test
  void delete() {
    ownerMapService.delete(ownerMapService.finbyId(OWNER_ID));
    assertEquals(0, ownerMapService.findAll().size());
  }

  @Test
  void deleteById() {
    ownerMapService.deleteById(OWNER_ID);
    assertEquals(0, ownerMapService.findAll().size());

  }

  @Test
  void findByLastName() {
    assertEquals(OWNER_ID, ownerMapService.findByLastName(LAST_NAME).getId());
  }

  @Test
  void findByLastNameNotFound() {
    assertNull(ownerMapService.findByLastName("foo"));
  }

}