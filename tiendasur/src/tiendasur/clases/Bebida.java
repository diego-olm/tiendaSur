package tiendasur.clases;

import java.time.LocalDate;

import tiendasur.opereciones.IComestible;

public abstract  class Bebida extends Producto implements IComestible {

	protected boolean alcoholica;
	protected boolean importado;
	protected int caloria;
	protected LocalDate fechaVencimiento;


	
	public Bebida(String identificador, String descripcionProducto, int cantidadStock, double precioUnidad, double costoUnidad,
			boolean disponible, boolean alcoholica, boolean importado, int caloria, LocalDate fechaVencimiento, double descuento)throws Exception {
		super(descripcionProducto, cantidadStock,costoUnidad, disponible);
		this.alcoholica = alcoholica;
		this.importado = importado;
		this.caloria = caloria;
		this.fechaVencimiento = fechaVencimiento;
		setIdentificador(identificador);
		setPrecioUnidad(precioUnidad);
		setPorcentajeDescuento(descuento);
	}

	public void setIdentificador(String identificador)throws Exception {
		char primeraLetra='A';
		char segundaLetra='C';
		if(super.validarIdentidicador(identificador, primeraLetra, segundaLetra)) {
			this.identificador=identificador;
		}
		
	}

	
	public boolean isAlcoholica() {
		return alcoholica;
	}

	public void setAlcoholica(boolean alcoholica) {
		this.alcoholica = alcoholica;
	}

	public boolean isImportado() {
		return importado;
	}

	public void setImportado(boolean importado) {
		this.importado = importado;
	}
	@Override
	public void setPorcentajeDescuento(double descuento) {
		if(descuento > 15) {
			this.descuento=15;
		}
		else {
			this.descuento=descuento;
		}
		
	}
	@Override
	public double obtenerPorcentajeDescuento() {
		
		return this.descuento;
	}

	@Override
	public LocalDate getFechaVencimiento() {
		
		return this.fechaVencimiento;
	}
	@Override
	public void setFechaVencimiento(LocalDate fecha) {
		this.fechaVencimiento=fecha;
		
	}
	@Override
	public void setCaloria(int caloria) {
		this.caloria=caloria;
		
	}
	@Override
	public int getCaloria() {
		
		return caloria;
	}

	@Override
	public double calcularGananciaMax() {
		double gananciaMax = this.costoUnidad + (this.costoUnidad * 0.20);
		return gananciaMax;
		
	}
	public void setPrecioUnidad(double precioUnidad) {
		this.precioUnidad=calcularPrecioUnidadEsImportado(precioUnidad);
	}
	public double calcularPrecioUnidadEsImportado(double precio) {
		double gananciaMax = calcularGananciaMax();
		double precioTemporal=0;
		double aumento=0;
		double total=0;
		double porcentajeAumento=10;
		if (precio < this.costoUnidad) {
            precioTemporal = costoUnidad;
		} else if (precio > gananciaMax) {
			precioTemporal = gananciaMax;
		} else {
			precioTemporal = precio;
		}

		if(this.importado) {
			aumento= precioTemporal*(porcentajeAumento/100);
			total=aumento+ precioTemporal;
		}
		else {
			total=precioTemporal;
		}
		return total;
	}

	@Override
	public String toString() {
		return super.toString()+ " " +" Bebida alcoholica=" + alcoholica + ", importado=" + importado + ", caloria=" + caloria
				+ ", fechaVencimiento=" + fechaVencimiento + ", identificador=" + identificador
				+ ", descripcionProducto=" + descripcionProducto + ", cantidadStock=" + cantidadStock
				+ ", precioUnidad=" + precioUnidad + ", costoUnidad=" + costoUnidad + ", disponible=" + disponible
				+ ", descuento=" + descuento + "\n \n";
	} 
}
