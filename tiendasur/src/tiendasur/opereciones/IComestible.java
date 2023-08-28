package tiendasur.opereciones;

import java.time.LocalDate;

public interface IComestible {

	LocalDate getFechaVencimiento();
	void setFechaVencimiento(LocalDate fecha);
	void setCaloria(int caloria);
	int getCaloria();
	
}
