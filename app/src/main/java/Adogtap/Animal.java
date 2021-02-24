package Adogtap;

import Interfaces.IClonarAnimal;

public abstract class Animal implements IClonarAnimal {

    private String tipo;
    private String nombre;
    private int edad;
    private String infoVacunas;
    private String infoSalud;
    private String raza;
    private String sexo;

    private int imgFoto;


    public Animal(String tipo, String nombre, int edad, String raza, String sexo, int imgFoto) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.sexo = sexo;
        this.imgFoto = imgFoto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getInfoVacunas() {
        return infoVacunas;
    }

    public void setInfoVacunas(String infoVacunas) {
        this.infoVacunas = infoVacunas;
    }

    public String getInfoSalud() {
        return infoSalud;
    }

    public void setInfoSalud(String infoSalud) {
        this.infoSalud = infoSalud;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


    public String mostrarInfoImportante() {
        return null;
    }


    public String mostrarInfoBasica() {
        return "El animal es un "+tipo+" Su nombre es: "+nombre+" La edad es de : "+edad+"\n"+
                "Su raza es: "+raza+" y es "+ sexo;
    }

    public String getTipo() {
        return tipo;
    }

    public int getImgFoto() {
        return imgFoto;
    }

    public void setImgFoto(int imgFoto) {
        this.imgFoto = imgFoto;
    }
}
