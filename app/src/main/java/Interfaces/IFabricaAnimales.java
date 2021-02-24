package Interfaces;

import Adogtap.Animal;

public interface IFabricaAnimales {
    Animal crearAnimal(String tipo, String nombre, int edad, String raza, String sexo, int imgFoto);
}
