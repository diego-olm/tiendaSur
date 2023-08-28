package tiendasur.opereciones;

import tiendasur.clases.Producto;

public interface ICompraTienda {

	boolean agregarProducto(Producto producto) throws Exception;
	
	int obtenerStock();
}
