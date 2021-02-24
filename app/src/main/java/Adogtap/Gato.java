package Adogtap;

public class Gato extends Animal{
    public Gato(String nombre, int edad, String raza, String sexo, int imgFoto) {
        super("Gato", nombre, edad, raza, sexo, imgFoto);
    }

    @Override
    public Animal realizarClonacion() {
        return new Gato(getNombre(),getEdad(),getRaza(),getSexo(), getImgFoto());
    }
}
