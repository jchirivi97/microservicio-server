package edu.escuelaing.arep.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.arep.proyecto.service.conexionServices;
import edu.escuelaing.arep.proyecto.service.proyectoServices;

@RestController
@RequestMapping(value="/principal")
public class proyectoController{

	@Autowired
	proyectoServices proyecto;
	
	@Autowired
	conexionServices conexion;
	
	@RequestMapping(method = RequestMethod.GET,path="/user/{nickname}/{password}")
	public ResponseEntity<?> login(@PathVariable("nickname") String nickname,@PathVariable("password") String pass){
		try {
			
			return new ResponseEntity<>(proyecto.loginUser(nickname, pass), HttpStatus.ACCEPTED);
		}
		catch(Exception e){
			return new ResponseEntity<>("usuario no existe", HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/listcan/{nickname}/{nombre}")
	public ResponseEntity<?> getListaCanciones(@PathVariable("nickname") String nickname,@PathVariable("nombre") String nombre){
		try {
			
			return new ResponseEntity<>(proyecto.getListaCanciones(nickname, nombre), HttpStatus.ACCEPTED);
		}
		catch(Exception e){
			return new ResponseEntity<>("usuario no existe", HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/listrep/{nickname}")
	public ResponseEntity<?> getReproduccionesLista(@PathVariable("nickname") String nickname){
		try {
			
			return new ResponseEntity<>(proyecto.getReproduccionesLista(nickname), HttpStatus.ACCEPTED);
		}
		catch(Exception e){
			return new ResponseEntity<>("usuario no existe", HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/cancion/{id}")
	public ResponseEntity<?> getCancion(@PathVariable("id") int id){
		try {
			return new ResponseEntity<>(proyecto.getCancion(id), HttpStatus.ACCEPTED);
		}
		catch(Exception e){
			return new ResponseEntity<>("usuario no existe", HttpStatus.NOT_FOUND);
		}
	}	
}
