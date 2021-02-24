package Adogtap;

import Interfaces.IFabricaAnimales;

public class FabricaAnimales implements IFabricaAnimales {
    @Override
    public Animal crearAnimal(String tipo, String nombre, int edad, String raza, String sexo, int imgFoto) {
        Animal a;
        switch (tipo){
            case "Gato": a = new Gato(nombre,edad,raza,sexo, imgFoto);
                break;
            case "Perro": a =  new Perro(nombre,edad,raza,sexo, imgFoto);
                break;
            default: a = null;
        }
        return a;
    }
}
