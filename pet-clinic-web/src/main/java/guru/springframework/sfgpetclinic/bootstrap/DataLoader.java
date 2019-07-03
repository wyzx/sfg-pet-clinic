package guru.springframework.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Specialty;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;
  private final PetTypeService petTypeService;
  private final SpecialtyService specialtyService;
  private final VisitService visitService;

  @Autowired
  public DataLoader(OwnerService ownerService, VetService vetService,
                    PetTypeService petTypeService, SpecialtyService specialtyService,
                    VisitService visitService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
    this.petTypeService = petTypeService;
    this.specialtyService = specialtyService;
    this.visitService = visitService;
  }

  @Override
  public void run(String... args) {
    int count = petTypeService.findAll().size();
    if (count == 0) {
      loadData();
    }
  }

  private void loadData() {
    PetType dog = new PetType();
    dog.setName("Dog");
    PetType savedDogPetType = petTypeService.save(dog);

    PetType cat = new PetType();
    dog.setName("Cat");
    PetType savedCatPetType = petTypeService.save(cat);

    System.out.println("Loaded petTypes...");

    Specialty radiology = new Specialty();
    radiology.setDescription("Radiology");
    Specialty savedRadiology = specialtyService.save(radiology);

    Specialty surgery = new Specialty();
    surgery.setDescription("Surgery");
    Specialty savedSurgery = specialtyService.save(surgery);

    Specialty dentistry = new Specialty();
    dentistry.setDescription("Dentistry");
    Specialty savedDentistry = specialtyService.save(dentistry);

    Owner owner1 = new Owner();
    owner1.setFirstName("Michael");
    owner1.setLastName("Glenanne");
    owner1.setAddress("123 Brickerel");
    owner1.setCity("Miami");
    owner1.setTelephone("1233213132145");

    Pet mikesPet = new Pet();
    mikesPet.setPetType(savedDogPetType);
    mikesPet.setOwner(owner1);
    mikesPet.setBirthDate(LocalDate.now());
    mikesPet.setName("Rosco");
    owner1.getPets().add(mikesPet);
    ownerService.save(owner1);

    Owner owner2 = new Owner();
    owner2.setFirstName("Fiona");
    owner2.setLastName("Glenanne");
    owner2.setAddress("123 Brickerel");
    owner2.setCity("Miami");
    owner2.setTelephone("1233213132145");

    Pet fionaPet = new Pet();
    fionaPet.setPetType(savedCatPetType);
    fionaPet.setOwner(owner2);
    fionaPet.setBirthDate(LocalDate.now());
    fionaPet.setName("Rosca");
    owner2.getPets().add(fionaPet);
    ownerService.save(owner2);

    Visit catVisit = new Visit();
    catVisit.setPet(fionaPet);
    catVisit.setDate(LocalDate.now());
    catVisit.setDescription("Sneezy kitty");
    visitService.save(catVisit);

    System.out.println("Loaded owners...");

    Vet vet1 = new Vet();
    vet1.setFirstName("Sam");
    vet1.setLastName("Axe");
    vet1.getSpecialties().add(savedRadiology);

    vetService.save(vet1);

    Vet vet2 = new Vet();
    vet2.setFirstName("Jessie");
    vet2.setLastName("Porter");
    vet2.getSpecialties().add(savedSurgery);

    vetService.save(vet2);

    System.out.println("Loaded vets...");
  }
}
