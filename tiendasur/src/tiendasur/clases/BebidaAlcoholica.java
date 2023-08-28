package tiendasur.clases;

import java.time.LocalDate;

public class BebidaAlcoholica extends Bebida {
	
	private double graducionAlcoholica;

	public BebidaAlcoholica(String identificador, String descripcionProducto, int cantidadStock, double precioUnidad,
			double costoUnidad, boolean disponible, boolean alcoholica, boolean importado, int caloria, LocalDate fecha,
			double graducionAlcoholica, double descuento)throws Exception {
		super(identificador, descripcionProducto, cantidadStock, precioUnidad, costoUnidad, disponible, alcoholica,
				importado, caloria, fecha,descuento);
		this.graducionAlcoholica = graducionAlcoholica;
	}

	public double getGraducionAlcoholica() {
		return graducionAlcoholica;
	}

	public void setGraducionAlcoholica(double graducionAlcoholica) {
		this.graducionAlcoholica = graducionAlcoholica;
	}

	@Override
	public String toString() {
		return "BebidaAlcoholica [alcoholica=" + alcoholica + ", importado=" + importado + ", caloria=" + caloria
				+ ", fechaVencimiento=" + fechaVencimiento + ", identificador=" + identificador
				+ ", descripcionProducto=" + descripcionProducto + ", cantidadStock=" + cantidadStock
				+ ", precioUnidad=" + precioUnidad + ", costoUnidad=" + costoUnidad + ", disponible=" + disponible
				+ ", descuento=" + descuento + ", graducionAlcoholica=" + graducionAlcoholica + "\n \n";
	}






	
	
}
