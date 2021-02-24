package Interfaces;

import Perfil.Perfil;

public interface IBDUsuario {
    void insertarUsuario(Perfil usuario);
    void obtenerListaUsuarios();
    void obtenerUsuario(String id);
}
