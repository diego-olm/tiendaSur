package tiendasur.clases;

import java.time.LocalDate;

public class BebidaSinAlcohol extends Bebida {

	public BebidaSinAlcohol(String identificador, String descripcionProducto, int cantidadStock, double precioUnidad,
			double costoUnidad, boolean disponible, boolean alcoholica, boolean importado, int caloria,
			LocalDate fechaVencimiento, double descuento) throws Exception {
		super(identificador, descripcionProducto, cantidadStock, precioUnidad, costoUnidad, disponible, alcoholica, importado,
				caloria, fechaVencimiento,descuento);
		
	}

	@Override
	public String toString() {
		return super.toString()+" "+"BebidaSinAlcohol alcoholica=" + alcoholica + ", importado=" + importado + ", caloria=" + caloria
				+ ", fechaVencimiento=" + fechaVencimiento + ", identificador=" + identificador
				+ ", descripcionProducto=" + descripcionProducto + ", cantidadStock=" + cantidadStock
				+ ", precioUnidad=" + precioUnidad + ", costoUnidad=" + costoUnidad + ", disponible=" + disponible
				+ ", descuento=" + descuento + "\n \n ";
	}

	
}
