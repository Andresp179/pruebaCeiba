public class PrestamoServiceImpl implements ProductoService {
	
	private PrestamoDao prestamoDao;
	
	
	@Override
	public List<Prestamo> listaPrestamos() {
		// TODO Auto-generated method stub
		return (List<Prestams>) prestamoDao.findAll();
	}

	@Override
	public void guardar(Prestamo prestamo) {
		// TODO Auto-generated method stub
		prestamoDao.save(prestamoDao);
	}

	@Override
	public void eliminar(Prestamo prestamo) {
		// TODO Auto-generated method stub
		prestamoDao.delete(prestamo);
	}

	@Override
	public Optional<Prestamo> encontrarPrestamo(Prestamo prestamo) {
		// TODO Auto-generated method stub
		return prestamoDao.findById(prestamo.getIsbn());
	}
    
}
