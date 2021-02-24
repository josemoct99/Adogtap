package Interfaces;

import Adogtap.Animal;

public interface IBDAnimal {
    void insertarAnimal(Animal animal);
    void obtenerListaAnimales(String tipoAnimal);
    void obtenerAnimal(String idAnimal);
}
