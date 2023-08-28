package tiendasur.opereciones;

public interface IDescuento {

	public void setPorcentajeDescuento(double descuento);
	public double obtenerPorcentajeDescuento();
	public double obtenerPrecioVentaConDescuento()throws Exception;
}
