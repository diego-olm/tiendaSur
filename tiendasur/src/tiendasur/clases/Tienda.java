package tiendasur.clases;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import tiendasur.opereciones.ICompraTienda;

public class Tienda implements ICompraTienda {

	private String nombre;
	private int numeroMaxStock;
	private double saldoCaja;
	private Map<String, List<Producto>> productos;

	public Tienda(String nombre, int numeroMaxStock, double saldoCaja)
			 {
		super();
		this.nombre = nombre;
		this.numeroMaxStock = numeroMaxStock;
		this.saldoCaja = saldoCaja;
		this.productos = new HashMap<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroMaxStock() {
		return numeroMaxStock;
	}

	public void setNumeroMaxStock(int numeroMaxStock) {
		this.numeroMaxStock = numeroMaxStock;
	}

	public double getSaldoCaja() {
		return saldoCaja;
	}

	public void setSaldoCaja(double saldoCaja) {
		this.saldoCaja = saldoCaja;
	}

	public Map<String, List<Producto>> getProductos() {
		return productos;
	}

	public void setProductos(Map<String, List<Producto>> productos) {
		this.productos = productos;
	}

	@Override
	public boolean agregarProducto(Producto producto) throws Exception {
		// TODO Auto-generated method stub
		int cantidadStock = obtenerStock() + producto.getCantidadStock();
		double costoProducto = producto.getCantidadStock() * producto.getCostoUnidad();
		if (cantidadStock > this.numeroMaxStock) {
			throw new Exception("no se pueden agregar mas productos sea alcanzado el máximo de stock habilitado");
		}
		if (this.saldoCaja - costoProducto < 0) {
			
			throw new Exception("El producto no podrá ser agregado a la tienda por " + "saldo insuficiente en la caja");
		}

		else {
			this.saldoCaja = this.saldoCaja - costoProducto;

			String id = producto.getIdentificador().substring(0, 2);

			return this.getProductos().get(id).add(producto);
		}

	}

	@Override
	public int obtenerStock() {
		// TODO Auto-generated method stub
		int total = 0;
		total = this.productos.values().stream().flatMap(list -> list.stream()).map(pr -> pr.getCantidadStock())
				.reduce(0, (a, b) -> a + b);
		return total;

	}

	public List<Producto> ventaProductos(List<Producto> productosParaVenta)throws Exception {
		int cantidadVenta;
		boolean stockDisponible = false;
		List<Producto> lista;
		List<String> productoGeneraPerdida = new ArrayList<>();
		List<String> productoNoDisponible = new ArrayList<>();
		if (productosParaVenta.size() > 3) {
			cantidadVenta = 3;
		} 
		else {
			cantidadVenta = productosParaVenta.size();
		}
		for (int i = 0; i < cantidadVenta; i++) {
			
			String id = productosParaVenta.get(i).getIdentificador().substring(0, 2);
			lista = this.productos.get(id);
			
			if (lista.contains(productosParaVenta.get(i))) {
				int posicionProducto = lista.indexOf(productosParaVenta.get(i));
				Producto productoValidaciones = this.productos.get(id).get(posicionProducto);

				if (!productoValidaciones.isDisponible()) {

					productosParaVenta.remove(i);
					productoNoDisponible.add(" " + productoValidaciones.getIdentificador() + " "
							+ productoValidaciones.getDescripcionProducto());

				} else if (productosParaVenta.get(i).getCantidadStock() > 10) {
					productosParaVenta.get(i).setCantidadStock(10);
				}

				else if (productoValidaciones.getCantidadStock() - productosParaVenta.get(i).getCantidadStock() >= 0) {

					productoValidaciones.setCantidadStock(
							productoValidaciones.getCantidadStock() - productosParaVenta.get(i).getCantidadStock());

				} else {

					productosParaVenta.get(i).setCantidadStock(productoValidaciones.getCantidadStock());

					productoValidaciones.setCantidadStock(0);

				}

			}
		}
		detalleVenta(stockDisponible, productosParaVenta, productoNoDisponible, productoGeneraPerdida);

		return productosParaVenta;
	}

	public void detalleVenta(boolean stockDisponible, List<Producto> productoVendidos,
			List<String> productoNodisponibles, List<String> ProductoGeneraPerdida)throws Exception {
		double total = 0;

		for (Producto p : productoVendidos) {

			System.out.print(p.getIdentificador() + " " + p.getDescripcionProducto() + " " + p.getCantidadStock()
					+ " x " + p.obtenerPrecioVentaConDescuento() + "\n");
			total = total + (p.obtenerPrecioVentaConDescuento() * p.getCantidadStock());
		}
		System.out.println("TOTAL VENTA : " + total);
		if (stockDisponible) {
			System.out.println("Hay productos con stock disponible menor al solicitado");
		}
		for (String n : productoNodisponibles) {
			System.out.println("El producto" + n + " no se encuentra disponible.");
		}
		for (String n : ProductoGeneraPerdida) {
			System.out.println("El descuento registrado para el producto " + n + "no pudo ser aplicado");
		}
		this.setSaldoCaja(total + this.saldoCaja);

	}
	public List<String> obtenerComestiblesConMenorDescuento(double porcentaje_descuento){
		List<String> lista;
		lista= this.productos.values().stream().flatMap(Collection::stream).
				filter(producto -> {
					if(producto instanceof Envasado) {
						Envasado envasado=(Envasado) producto;
						return !envasado.isImportando() && envasado.descuento<porcentaje_descuento;
					}
					else if(producto instanceof Bebida) {
						Bebida bebida=(Bebida) producto;
						return !bebida.importado && bebida.descuento<porcentaje_descuento;
					}
					else {
						return false;
					}
				})
				.sorted(Comparator.comparingDouble(Producto::getPrecioUnidad))
				.map(Producto::getDescripcionProducto)
				.map(String::toUpperCase)
				
			
                .collect(Collectors.toList());
		
		return lista;
	}

	@Override
	public String toString() {
		return "Tienda nombre=" + nombre + ", numeroMaxStock=" + numeroMaxStock + ", saldoCaja=" + saldoCaja
				+ ", productos=" + productos + "";
	}
	

}
