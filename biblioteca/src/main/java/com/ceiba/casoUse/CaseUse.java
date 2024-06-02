import java.time.LocalDate;
import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;



public class CaseUse{
	
	public static LocalDate calcularFechaMaximaDevolucion(String tipoUsuario) {
        LocalDate fechaActual = LocalDate.now();
        int diasAAgregar;

        switch (tipoUsuario.toLowerCase()) {
            case "afiliado":
                diasAAgregar = 10;
                break;
            case "empleado":
                diasAAgregar = 8;
                break;
            case "invitado":
                diasAAgregar = 7;
                break;
            default:
                System.out.println("{ \"mensaje\" : \"Tipo de usuario no permitido en la biblioteca\" }");
                return null;
        }

        return calcularFechaConExclusionDeFinesDeSemana(fechaActual, diasAAgregar);
    }

    public static LocalDate calcularFechaConExclusionDeFinesDeSemana(LocalDate fechaInicio, int diasHabiles) {
        Set<DayOfWeek> diasNoHabiles = new HashSet<>();
        diasNoHabiles.add(DayOfWeek.SATURDAY);
        diasNoHabiles.add(DayOfWeek.SUNDAY);

        LocalDate fechaResultado = fechaInicio;
        int diasAgregados = 0;

        while (diasAgregados < diasHabiles) {
            fechaResultado = fechaResultado.plusDays(1);
            if (!diasNoHabiles.contains(fechaResultado.getDayOfWeek())) {
                diasAgregados++;
            }
        }

        return fechaResultado;
    }
	
	
	
}