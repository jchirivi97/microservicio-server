apiUsuario = (function(){
	
	return{
	
		loginUser: function(correo,password){
			jQuery.ajax({
				url: "/principal/user/"+ correo +"/"+ password,
				type: "GET",
				success: function(){
					alert("Ingreso exito.");
					location.href = "/principal.html";
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
	                alert("El Usuario o Contraseña no es correcto"); 
	            }
			})
		},
		
		ListaReproduccion: function(usuario,callback){
			jQuery.ajax({
				url:  "/principal/listrep/"+usuario,
				type: "GET",
				success: function(datos){
					callback(datos);
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
	                alert("El Usuario no encontrado"); 
	            }
			})
		},
		ListaCanciones: function(usuario,nombre,callback){
			jQuery.ajax({
				url: "/principal/listcan/"+usuario+"/"+nombre,
				type: "GET",
				success: function(datos){
					callback(datos);
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
	                alert("El Usuario no encontrado"); 
	            }
			})
		},
		
		cancion: function(id,callback){
			jQuery.ajax({
				url: "/principal/cancion/"+id,
				type: "GET",
				success: function(datos){
					callback(datos);
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
	                alert("El Usuario no encontrado"); 
	            }
			})
		}
		
	}
})();



