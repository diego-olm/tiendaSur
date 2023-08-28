package tiendasur.clases;

import tiendasur.opereciones.IDescuento;

public abstract class Producto implements IDescuento{

	protected String identificador;
	protected String descripcionProducto;
	protected int cantidadStock;
	protected double precioUnidad;
	protected double costoUnidad;
	protected boolean disponible;
	protected double descuento;
	

	

	public Producto(String descripcionProducto, int cantidadStock, double costoUnidad,
			boolean disponible) {
		
		this.descripcionProducto = descripcionProducto;
		this.cantidadStock=cantidadStock;
		this.costoUnidad = costoUnidad;
		this.disponible = disponible;
		
	}
	public Producto(String descripcionProducto, int cantidadStock, double costoUnidad) {
		
		this.descripcionProducto = descripcionProducto;
		this.cantidadStock=cantidadStock;
		this.costoUnidad = costoUnidad;
		this.disponible =true;
		
	}

	public String getIdentificador() {
		return identificador;
	}

	

	public void setIdentificador(String identificador) throws Exception {
		
			this.identificador=identificador;	
		
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public int getCantidadStock() {
		return cantidadStock;
	}

	public void setCantidadStock(int cantidadStock) {
		if(cantidadStock<=0) {
			this.disponible=false;
		}
		this.cantidadStock = cantidadStock;
	}

	public double getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecioUnidad(double precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public double getCostoUnidad() {
		return costoUnidad;
	}

	public void setCostoUnidad(double costoUnidad) {
		this.costoUnidad = costoUnidad;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identificador == null) ? 0 : identificador.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (identificador == null) {
			if (other.identificador != null)
				return false;
		} else if (!identificador.equals(other.identificador))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Producto identificador=" + identificador + ", descripcionProducto=" + descripcionProducto
				+ ", cantidadStock=" + cantidadStock + ", precioUnidad=" + precioUnidad + ", costoUnidad=" + costoUnidad
				+ ", disponible=" + disponible + ", descuento=" + descuento + "\n";
	}

	public boolean validarIdentidicador(String identificador, char primeraLetra, char segundaLetra)throws Exception {
		boolean bandera=false;
		if(identificador.length()==5) {
			char primeraPosicion = identificador.charAt(0);
			char segundaPosicion = identificador.charAt(1);
			char terceraPosicion = identificador.charAt(2);
			char cuartaPosicion = identificador.charAt(3);
			char quintaPosicion = identificador.charAt(4);
			if(Character.isLetter(primeraPosicion) && Character.isLetter(segundaPosicion) && 
			   Character.isDigit(terceraPosicion) && Character.isDigit(cuartaPosicion) && Character.isDigit(quintaPosicion)	) {
				
			}
			if(identificador.charAt(0)==primeraLetra && identificador.charAt(1)==segundaLetra) {
				bandera=true;
			}
			
		}
		
		if(!bandera)
		{
			throw new Exception("identificador incorrecto para crear un producto");
		}
		return bandera;
	};
	
	public abstract double calcularGananciaMax();
	@Override
	public double obtenerPrecioVentaConDescuento()throws Exception {
		double descuento = this.descuento;
		double valor = this.precioUnidad;
		double montoDescuento = valor * (descuento / 100.0);
		
		double total = valor - montoDescuento;
		if(total<this.costoUnidad) {
			throw new Exception("El descuento registrado para el producto "+ this.identificador+" no pudo ser aplicado.");
		}
		return total;
	}
	
}
