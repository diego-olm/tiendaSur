package tiendasur.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tiendasur.clases.BebidaAlcoholica;
import tiendasur.clases.BebidaSinAlcohol;
import tiendasur.clases.Envasado;
import tiendasur.clases.Limpieza;
import tiendasur.clases.Producto;
import tiendasur.clases.Tienda;
import tiendasur.clases.TipoAplicacion;
import tiendasur.clases.TipoEnvase;

public class ApplicacionTienda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tienda tienda = new Tienda("Tienda Sur",905,4440.25);
		Map<String,List<Producto>> listaProducto= new HashMap<>();
		List<Producto> productosBebibles=new ArrayList<>();
		List<Producto> productosEnvasados= new ArrayList<>();
		List<Producto> productosLimpieza= new ArrayList<>();
		listaProducto.put("AC",productosBebibles);
		listaProducto.put("AB",productosEnvasados);
		listaProducto.put("AZ",productosLimpieza);
		tienda.setProductos(listaProducto);
		LocalDate fecha = LocalDate.of(2034, 12, 31);
		LocalDate fecha2 = LocalDate.of(2025, 06, 2);
		
		try {
			
			/*(identificador, descripcionProducto, cantidadStock, precioUnidad, costoUnidad, disponible, aplicacion, descuento*/
		    Producto bebida1= new BebidaAlcoholica("AC001","vino tinto reserva",50,19.99,12.50,false, true, false,100, fecha, 6.2,5);
		    Producto bebida2= new BebidaAlcoholica("AC002","Cerveza Artesanal IPA",100,5.99,3.80, true, true, false,100, fecha2, 10,12);
		    Producto bebida3= new BebidaAlcoholica("AC003","Whisky Single Malt 12 años",25,45.75,32.00, true, true, false,100, fecha2,40.0,10);
		    Producto bebida4= new BebidaSinAlcohol("AC004", "Agua Mineral Natural",200, 1.50, 0.80, true, false, false, 0,fecha,30);
		    Producto bebida5= new BebidaAlcoholica("AC005"," Licor de Café",50,12.99,8.00, true, true, false,100, fecha, 5,10);
		    
		    /*(identificador, descripcionProducto, cantidadStock, precioUnidad, costoUnidad, disponible, alcoholica, importado, caloria, fecha, graducionAlcoholica)*/
		    Producto limpieza1 = new Limpieza("AZ545", "Limpiador Multiusos", 50, 5.99,3.50, true,TipoAplicacion.MULTIUSO,10);
			Producto limpieza2 = new Limpieza("AZ375", "Detergente para Ropa", 75, 8.49,6.00, true,TipoAplicacion.ROPA,15);
			Producto limpieza3 = new Limpieza("AZ741", "Desinfectante en Aerosol",30, 6.25,4.20, false,TipoAplicacion.COCINA,5);
			Producto limpieza4 = new Limpieza("AZ951", "Escoba", 20, 10.99,8.50, true,TipoAplicacion.PISOS,0);
			Producto limpieza5 = new Limpieza("AZ753", " Papel Toalla",40, 12.75,9.80, true,TipoAplicacion.MULTIUSO,20);
			Producto limpieza6 = new Limpieza("AZ145", "Limpiacristales", 60, 4.75,3.25, true,TipoAplicacion.COCINA,8);
			Producto limpieza7 = new Limpieza("AZ698", "Guantes de Limpieza",100, 2.99,1.50, true,TipoAplicacion.MULTIUSO,12);
			Producto limpieza8 = new Limpieza("AZ125", "Bolsas de Basura", 25, 7.50,5.25, true,TipoAplicacion.COCINA,0);
			
			Producto limpieza9 = new Limpieza("AZ825", "Limpiador para Baño",45, 6.99,4.80, true,TipoAplicacion.MULTIUSO,10);
			Producto limpieza10 = new Limpieza("AZ640", "Cepillo para Inodoros",35, 3.25,2.00, false,TipoAplicacion.PISOS,5);
			
			tienda.setProductos(listaProducto);
			tienda.agregarProducto(limpieza1);
			tienda.agregarProducto(limpieza2);
			tienda.agregarProducto(limpieza3);
			tienda.agregarProducto(limpieza4);
			tienda.agregarProducto(limpieza5);
			tienda.agregarProducto(limpieza6);
			tienda.agregarProducto(limpieza7);
			tienda.agregarProducto(limpieza8);
			tienda.agregarProducto(limpieza9);
			tienda.agregarProducto(limpieza10);
			tienda.agregarProducto(bebida1);
			tienda.agregarProducto(bebida2);
			tienda.agregarProducto(bebida3);
			tienda.agregarProducto(bebida4);
			tienda.agregarProducto(bebida5);
			System.out.println(tienda.obtenerComestiblesConMenorDescuento(15).toString());
			List<Producto> compra= new ArrayList<>();
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
		}
		try {
			System.out.println("Prueba de valicacion de Identificador ");
			System.out.println("se le paso un id incorrecto para demostrar el mensaje de error");
			Producto pruebaId= new Limpieza("AZ125", "Bolsas de Basura", 25, 7.50,5.25, true,TipoAplicacion.COCINA,0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		System.out.println("prueba 2");
		System.out.println("se muestra lo que sucede cuando se supera el saldo en caja");
		try {
			Tienda tiendaPrueba= new Tienda("tienda sur",20,5000);
			List<Producto> productosBebibles2=new ArrayList<>();
			List<Producto> productosEnvasados2= new ArrayList<>();
			List<Producto> productosLimpieza2= new ArrayList<>();
			Map<String,List<Producto>> listaProducto2= new HashMap<>();
			listaProducto2.put("AC",productosBebibles2);
			listaProducto2.put("AB",productosEnvasados2);
			listaProducto2.put("AZ",productosLimpieza2);
			Producto pruebaId= new Limpieza("A125", "Bolsas de Basura", 25, 7.50,5.25, true,TipoAplicacion.COCINA,0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		System.out.println("se crean productos para demostrar que cumplen con los");
		System.out.println("requisitos de porcentaje de ganancia"); 
		System.out.println("--------------");
		try {
			Producto limpieza1 = new Limpieza("AZ545", "Limpiador Multiusos", 10, 100,100, true,TipoAplicacion.MULTIUSO,0);
		    System.out.println("se crea un producto Limpieza con precio venta:100");
		    System.out.println("y costo unidad:100 como es de tipo Multiuso se vende al costo "
		    		+ "ya que no tiene una ganancia minima");
			System.out.println(limpieza1.getDescripcionProducto()+ " "+ limpieza1.getPrecioUnidad());
			System.out.println("--------------");
			System.out.println("se crea un producto Limpieza con precio venta:100");
		    System.out.println("y costo unidad:100 "
		    		+ "y ya que es de tipo cocina se le setea el valor de venta a 110");
		    System.out.println("los tipo cocina tiene un minimo de 10% de ganancia");
		    Producto limpieza2 = new Limpieza("AZ545", "Guantes", 10, 100,100, true,TipoAplicacion.COCINA,0);
		    System.out.println(limpieza2.getDescripcionProducto() + " " +limpieza2.getPrecioUnidad());
		    System.out.println("--------------");
		    System.out.println("se setea el valor de venta del producto guantes a 200 ");
		    System.out.println("que se compro a 100 seria una ganancia del 100% ");
		    System.out.println("pero se demuestra que se lo setea con la ganancia maxima");
		    limpieza2.setPrecioUnidad(200);
		    System.out.println(limpieza2.getDescripcionProducto() +" "+ limpieza2.getPrecioUnidad());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		    Producto limpieza12 = new Limpieza("AZ545", "Limpiador Multiusos", 50, 5.99,3.50, true,TipoAplicacion.MULTIUSO,10);
			Producto limpieza23 = new Limpieza("AZ375", "Detergente para Ropa", 75, 8.49,6.00, true,TipoAplicacion.ROPA,15);
			Producto limpieza34 = new Limpieza("AZ741", "Desinfectante en Aerosol",30, 6.25,4.20, false,TipoAplicacion.COCINA,5);
             List<Producto> p=new ArrayList<>();
			p.add(limpieza12);
			p.add(limpieza23);
			p.add(limpieza34);
			System.out.println("--------------");
			System.out.println("se intenta comprar un producto que no es disponible");
			tienda.ventaProductos(p);
		    Producto Envasado= new Envasado("AB123", "fideos",10,100,100, false, TipoEnvase.PLASTICO,false,0, 23,LocalDate.now());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--------------");
		System.out.println("se imprimen todos los productos que tenga un porcentaje menor a 15%");
		System.out.println(tienda.obtenerComestiblesConMenorDescuento(15).toString());
		
	}

}
