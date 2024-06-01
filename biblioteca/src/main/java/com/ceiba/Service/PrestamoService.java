public interface PrestamoService {
	
	public List<Prestamo> listaPrestamos;

    public void guardar (Prestamo prestamos);

    public void eliminar (Prestamos prestamos);

    public Optional<Prestamos> encontrarPrestamos(Prestamos prestamos);	
    
    public int[] batchUpdateUsingJdbcTemplate(List<Prestamo> prestamos);
    
}
