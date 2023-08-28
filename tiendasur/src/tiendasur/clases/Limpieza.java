package tiendasur.clases;

public class Limpieza extends Producto {

	private TipoAplicacion aplicacion;

	public Limpieza(String identificador, String descripcionProducto, int cantidadStock, double precioUnidad,
			double costoUnidad, boolean disponible, TipoAplicacion aplicacion, double descuento) throws Exception {
		super(descripcionProducto, cantidadStock, costoUnidad, disponible);
		this.aplicacion = aplicacion;
		this.setIdentificador(identificador);
		setPrecioUnidad(precioUnidad);
		setPorcentajeDescuento(descuento);
	}

	public void setIdentificador(String identificador) throws Exception {
		char primeraLetra = 'A';
		char segundaLetra = 'Z';
		if (super.validarIdentidicador(identificador, primeraLetra, segundaLetra)) {
			this.identificador = identificador;
		}

	}

	public TipoAplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(TipoAplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((aplicacion == null) ? 0 : aplicacion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Limpieza other = (Limpieza) obj;
		if (aplicacion != other.aplicacion)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + " "+ "Limpieza aplicacion=" + aplicacion + ", identificador=" + identificador + ", descripcionProducto="
				+ descripcionProducto + ", cantidadStock=" + cantidadStock + ", precioUnidad=" + precioUnidad
				+ ", costoUnidad=" + costoUnidad + ", disponible=" + disponible + "\n \n";
	}

	@Override
	public void setPorcentajeDescuento(double descuento) {
		if (descuento > 25) {
			this.descuento = 25;
		} else {
			this.descuento = descuento;
		}

	}

	@Override
	public double obtenerPorcentajeDescuento() {

		return this.descuento;
	}



	@Override
	public double calcularGananciaMax() {
		double gananciaMax = this.costoUnidad + (this.costoUnidad * 0.25);
		return gananciaMax;
	}

	public double calcularGananciaMin() {
		double gananciaMin = this.costoUnidad + (this.costoUnidad * 0.10);
		return gananciaMin;
	}

	public void setPrecioUnidad(double precioUnidad) {
		double gananciaMax = calcularGananciaMax();
		double gananciaMin = calcularGananciaMin();
		if (precioUnidad < this.costoUnidad) {
			this.precioUnidad = precioUnidad;
		} else if (precioUnidad > gananciaMax) {
			this.precioUnidad = gananciaMax;
		} else if (this.aplicacion == TipoAplicacion.ROPA || this.aplicacion == TipoAplicacion.MULTIUSO) {
			this.precioUnidad = precioUnidad;
		} else if (precioUnidad >= gananciaMin) {
			this.precioUnidad = precioUnidad;
		} else {
			this.precioUnidad = gananciaMin;
		}

	}

}
