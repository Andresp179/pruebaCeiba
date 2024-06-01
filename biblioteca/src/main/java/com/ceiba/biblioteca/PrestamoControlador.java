package com.ceiba.biblioteca;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("prestamo")
public class PrestamoControlador {

	  private List<Prestamo> prestamos = new ArrayList<>();

	    @PostMapping("/prestar")
	    public ResponseEntity<Object> prestarLibro(@RequestBody Prestamo prestamo) {
	        // Validación para usuario invitado (tipoUsuario = 3)
	        if (prestamo.getTipoUsuario() == 3) {
	            for (Prestamo p : prestamos) {
	                if (p.getIdentificacionUsuario().equals(prestamo.getIdentificacionUsuario()) && p.getTipoUsuario() == 3) {
	                    return new ResponseEntity<>(new ErrorResponse("El usuario con identificación " + prestamo.getIdentificacionUsuario() + " ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo"), HttpStatus.BAD_REQUEST);
	                }
	            }
	        }

	        prestamos.add(prestamo);
	        return new ResponseEntity<>("Libro prestado exitosamente!", HttpStatus.OK);
	    }

	    @GetMapping
	    public List<Prestamo> obtenerPrestamos() {
	        return prestamos;
	    }

	    // Clase para manejar errores
	    public static class ErrorResponse {
	        private String mensaje;

	        public ErrorResponse(String mensaje) {
	            this.mensaje = mensaje;
	        }

	        public String getMensaje() {
	            return mensaje;
	        }

	        public void setMensaje(String mensaje) {
	            this.mensaje = mensaje;
	        }
	    }

}

