package guru.springframework.sfgpetclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

  public static final String LAST_NAME = "Smith";
  @InjectMocks
  OwnerSDJpaService service;
  @Mock
  OwnerRepository ownerRepository;
  @Mock
  PetRepository petRepository;
  @Mock
  PetTypeRepository petTypeRepository;
  private Owner returnOwner;


  @BeforeEach
  void setUp() {
    returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
  }

  @Test
  void findByLastName() {
    when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

    Owner smith = service.findByLastName(LAST_NAME);

    assertEquals(LAST_NAME, smith.getLastName());

    verify(ownerRepository).findByLastName(any());
  }

  @Test
  void findAll() {
    Set<Owner> ownerSet = new HashSet<>();
    ownerSet.add(Owner.builder().id(1L).build());
    ownerSet.add(Owner.builder().id(2L).build());

    when(ownerRepository.findAll()).thenReturn(ownerSet);

    Set<Owner> owners = service.findAll();

    assertNotNull(owners);

    assertEquals(2, owners.size());
  }

  @Test
  void finbyId() {
    when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

    assertNotNull(service.finbyId(1L));
  }

  @Test
  void save() {
    Owner ownerToSave = Owner.builder().id(1L).build();
    when(ownerRepository.save(any())).thenReturn(returnOwner);
    Owner savedOwner = ownerRepository.save(ownerToSave);
    assertNotNull(savedOwner);
  }

  @Test
  void delete() {
    ownerRepository.delete(returnOwner);
    verify(ownerRepository, times(1)).delete(any());
  }

  @Test
  void deleteById() {
    ownerRepository.deleteById(returnOwner.getId());
    verify(ownerRepository, times(1)).deleteById(any());
  }
}