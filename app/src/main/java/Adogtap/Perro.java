package Adogtap;

public class Perro extends Animal{
    public Perro(String nombre, int edad, String raza, String sexo, int imgFoto) {
        super("Perro", nombre, edad, raza, sexo, imgFoto);
    }

    @Override
    public Animal realizarClonacion() {
        return new Perro(getNombre(),getEdad(),getRaza(),getSexo(),getImgFoto());
    }
}
