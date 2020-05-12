var usuario = (function() {
	var status = 0;
	var status = false;
	
	var login = function() {
		var user = document.getElementById("user").value;
		var password = document.getElementById("pass").value;
		apiUsuario.loginUser(user, password);
		sessionStorage.setItem("usuario", user);
	};

	var lista = function() {
		apiUsuario.ListaReproduccion(sessionStorage.getItem('usuario'),
				mostrarReproduccion);
	};

	var mostrarReproduccion = function(datos) {
		var obj = JSON.parse(datos);
		var nombre = "";
		for (var i = 0; i < obj.length; i++) {
			if (obj[i].nombre != nombre) {
				$("#listas").append('<option>' + obj[i].nombre + '</option>');
				nombre = obj[i].nombre;
			}

		}
	};

	var mostarListaCancion = function() {
		var nombre = document.getElementById("listas").value;
		listaCanciones(nombre);
	}

	var listaCanciones = function(nombre) {
		alert("entro abuscar la lista");
		apiUsuario.ListaCanciones(sessionStorage.getItem('usuario'), nombre,
				mostrarCanciones);
	};

	var mostrarCanciones = function(datos) {
		if (status == true){
			$("table tbody").empty();
			$("table thead").empty();
			status = false;
		}
		var datos = JSON.parse(datos);
		var columnT = '<tr><th scope="col"><center>' + datos[0].nombre +'</th></center></tr>'
		$("table thead").append(columnT);

		var column = '<tr><th scope="col">Nombre</th><th scope="col">Audio</th></tr>'
		$("table thead").append(column);
		
		for (var i=0 ; i < datos.length ; i++){
			cancion(datos[i].idcancion);
			status = true;
		}
	};
	
	var vaciar= function(){
		$('#table').empty();
	}
	
	var cancion = function(id){
		apiUsuario.cancion(id,mostrarCancion);
	}	
	
	var mostrarCancion = function(datos){
		
		var obj = JSON.parse(datos);
		var column = '<tr><th scope="col">'
			+ obj.nombre
			+ '</th><th scope="col">'
			+ '<audio controls>'
			+ '<source src='
			+ obj.contenido
			+ ' type="audio/mpeg" />'
			+ '</audio>'
			+ '</th></tr>'

	$("table tbody").append(column);
	}

	
	return {

		ingresar : login,
		listas : lista,
		vercanciones : mostarListaCancion
	}

})()