package edu.escuelaing.arep.proyecto.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;

import edu.escuelaing.arep.proyecto.service.conexionServices;
import edu.escuelaing.arep.proyecto.service.proyectoServices;

@Service
public class proyectoServicesImpl implements proyectoServices {
	
	@Autowired
	conexionServices conexion;

	@Override
	public String loginUser(String nickname, String password) throws IOException {
		return conexion.loginUser(nickname, password);
	}

	@Override
	public String getReproduccionesLista(String nickname) throws IOException {
		return conexion.getReproduccionesLista(nickname);
	}

	@Override
	public String getListaCanciones(String nickname, String nombre) throws IOException {
		return conexion.getListaCanciones(nickname, nombre);
	}

	@Override
	public String getCancion(int id) throws IOException {
		return conexion.getCancion(id);
	}

}
