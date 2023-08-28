package tiendasur.clases;

import java.time.LocalDate;

import tiendasur.opereciones.IComestible;

public class Envasado extends Producto implements IComestible {

	private TipoEnvase envase;
	private boolean importando;
	private LocalDate fechaVencimiento;
	private int caloria;

	public Envasado(String identificador, String descripcionProducto, int cantidadStock, double precioUnidad,
			double costoUnidad, boolean disponible, TipoEnvase envase, boolean importando,double descuento,int caloria,LocalDate fechaVencimiento)throws Exception {
		super(descripcionProducto, cantidadStock, costoUnidad, disponible);
		this.setIdentificador(identificador);
		this.envase = envase;
		this.importando = importando;
		this.setPorcentajeDescuento(descuento);
		this.setPrecioUnidad(precioUnidad);
		this.caloria=caloria;
		this.fechaVencimiento=fechaVencimiento;
	}

	public void setIdentificador(String identificador)throws Exception {
		char primeraLetra='A';
		char segundaLetra='B';
		if (super.validarIdentidicador(identificador, primeraLetra,segundaLetra)) {
			this.identificador = identificador;
		}

	}
	
	public TipoEnvase getEnvase() {
		return envase;
	}

	public void setEnvase(TipoEnvase envase) {
		this.envase = envase;
	}

	public boolean isImportando() {
		return importando;
	}

	public void setImportando(boolean importando) {
		this.importando = importando;
	}

	@Override
	public void setPorcentajeDescuento(double descuento) {
		
		if(descuento >20) {
			this.descuento=20;
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
		this.fechaVencimiento = fecha;

	}

	@Override
	public void setCaloria(int caloria) {
		this.caloria = caloria;

	}

	@Override
	public int getCaloria() {
		
		return caloria;
	}

	public void setPrecioUnidad(double precioUnidad) {
		this.precioUnidad= calcularPrecioUnidadEsImportado(precioUnidad);

	}

	@Override
	public double calcularGananciaMax() {
		double gananciaMax = this.costoUnidad + (this.costoUnidad * 0.20);
		return gananciaMax;
	}
	public double calcularPrecioUnidadEsImportado(double precio) {
		double gananciaMax = calcularGananciaMax();
		double precioTemporal=0;
		double total=0;
		double aumento=0;
		double porcentajeAumento=10;
		if (precio < this.costoUnidad) {
			precioTemporal= this.precioUnidad;
		} else if (precio > gananciaMax) {
			precioTemporal = gananciaMax;
		} else {
			precioTemporal = precio;
		}
		if(this.importando==true) {
			aumento = precioTemporal * (porcentajeAumento/100);
			total=precioTemporal+aumento;
		}
		else {
			total=precioTemporal;
			
		}
		return total;
	}

	@Override
	public String toString() {
		return "Envasado [identificador=" + identificador + ", descripcionProducto=" + descripcionProducto
				+ ", cantidadStock=" + cantidadStock + ", precioUnidad=" + precioUnidad + ", costoUnidad=" + costoUnidad
				+ ", disponible=" + disponible + ", descuento=" + descuento + ", envase=" + envase + ", importando="
				+ importando + ", fechaVencimiento=" + fechaVencimiento + ", caloria=" + caloria + "]";
	}




	
}
