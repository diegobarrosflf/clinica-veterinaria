package com.company.test;

import com.company.domain.Animal;
import com.company.domain.Cliente;
import com.company.domain.Especie;
import com.company.repositories.AnimalRepository;

import java.util.List;

public class AnimalRepositoryTest {
    public static void main(String[] args) {
        var animalRepository = new AnimalRepository();
        Cliente cliente1 = new Cliente("Diego Barros", "Rua XPTO #12", "321.654.987-89", "3216-98745", "diego@email.com");
        Animal animal1 = new Animal("Totó", "1", "macho", new Especie("Canis"), cliente1);

        animalRepository.save(animal1);
        List<Animal> all = animalRepository.findAll();
        all.forEach(System.out::println);

    }
}
