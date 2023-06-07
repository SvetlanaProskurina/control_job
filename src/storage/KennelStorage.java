package storage;

import model.AbstractAnimal;
import model.AbstractPackAnimal;
import model.AbstractPet;
import model.implement.*;
import model.Skill;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Реализация интерфейса Storage
 * Хранилище реализовано на HashMap
 */
public class KennelStorage implements Storage{
  Map<Integer, AbstractAnimal> dbAnimals = new HashMap<>();

  public KennelStorage() {
    init();
  }

  private void init(){
    AbstractPet cat = new Cat("Мася", LocalDate.of(2022, 7, 12));

    int per = cat.getAge();

    cat.learnSkill(new Skill("Принести тапки"));
    dbAnimals.put(cat.getId(), cat);

    AbstractPet dog = new Dog("Дружок", LocalDate.of(2023, 2, 24));
    dog.learnSkill(new Skill("Принести тапки"));
    dog.learnSkill(new Skill("Поклон!"));
    dog.learnSkill(new Skill("Голос!"));
    dbAnimals.put(dog.getId(), dog);

    AbstractPet hamster = new Hamster("Хома", LocalDate.of(2022, 6, 20));
    hamster.learnSkill(new Skill("Вертеться в колесе"));
    dbAnimals.put(hamster.getId(), hamster);

    AbstractPackAnimal horse = new Horse("Резвый", LocalDate.of(2021, 12, 4));
    horse.setLoadCapacity(300);
    horse.learnSkill(new Skill("Галоп!"));
    horse.learnSkill(new Skill("Тпру!"));
    dbAnimals.put(horse.getId(), horse);

    AbstractPackAnimal horse2 = new Horse("Ветер", LocalDate.of(2022, 11, 1));
    horse2.setLoadCapacity(400);
    horse2.learnSkill(new Skill("Галоп!"));
    horse.learnSkill(new Skill("Тпру!"));
    horse2.learnSkill(new Skill("Поклон!"));
    dbAnimals.put(horse2.getId(), horse2);

    AbstractPackAnimal donkey = new Donkey("Тягач", LocalDate.of(2020, 10, 24));
    donkey.setLoadCapacity(500);
    donkey.learnSkill(new Skill("Поклон!"));
    horse.learnSkill(new Skill("Тпру!"));
    dbAnimals.put(donkey.getId(), donkey);

    AbstractPackAnimal camel = new Camel("Ариэль", LocalDate.of(2020, 7, 20));
    camel.setLoadCapacity(1000);
    camel.learnSkill(new Skill("Тпру!"));
    dbAnimals.put(camel.getId(), camel);
  }
  @Override
  public List<AbstractAnimal> getAllAnimals() {
    List<AbstractAnimal> result = new ArrayList<>();
    for (AbstractAnimal animal: dbAnimals.values()) {
      result.add(animal);
    }
    return result;
  }

  @Override
  public AbstractAnimal getAnimalById(int animalId) {
    return dbAnimals.getOrDefault(animalId, null);
  }

  @Override
  public boolean addAnimal(AbstractAnimal animal) {
    if (dbAnimals.containsKey(animal.getId())) {return false;}
    dbAnimals.put(animal.getId(), animal);
    return true;
  }

  @Override
  public int removeAnimal(AbstractAnimal animal) {
    if (!dbAnimals.containsKey(animal.getId())) {
      return -1;
    }
    AbstractAnimal removed = dbAnimals.remove(animal.getId());
    return removed.getId();
  }
}