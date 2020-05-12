package edu.escuelaing.arep.proyecto.service;

import java.io.IOException;

import com.google.gson.JsonElement;

public interface proyectoServices {
	
	String loginUser(String nickname, String password) throws IOException;
	String getReproduccionesLista(String nickname) throws IOException;
	String getListaCanciones(String nickname,String nombre) throws IOException;
	String getCancion(int id) throws IOException;

}
