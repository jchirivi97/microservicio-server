package edu.escuelaing.arep.proyecto.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import edu.escuelaing.arep.proyecto.service.conexionServices;

@Service
public class conexionServicesImpl implements conexionServices{

	@Override
	public String loginUser(String nickname, String password) throws IOException{
		
		RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> call= restTemplate.getForEntity("https://microservicios-usuario.herokuapp.com/usuario/"+nickname+"/"+password,String.class);
        System.out.println(call.getBody());
        return call.getBody();
	}

	@Override
	public String getReproduccionesLista(String nickname) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> call= restTemplate.getForEntity("https://microservicio-reproduccion.herokuapp.com/reproduccion/user/"+nickname,String.class);
        System.out.println(call.getBody());
        return call.getBody();
	}

	@Override
	public String getListaCanciones(String nickname, String nombre) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> call= restTemplate.getForEntity("https://microservicio-reproduccion.herokuapp.com/reproduccion/"+ nickname +"/"+nombre,String.class);
        System.out.println(call.getBody());
        return call.getBody();
	}

	@Override
	public String getCancion(int id) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> call= restTemplate.getForEntity("https://microservicio-cancion.herokuapp.com/canciones/"+id,String.class);
        System.out.println(call.getBody());
        return call.getBody();
	}

}
