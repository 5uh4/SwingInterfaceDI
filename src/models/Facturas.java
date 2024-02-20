package models;

import java.util.List;

public class Facturas {

	private String id;
	private double coste;
	private Clients cliente;
	private List<Products> productos;

	public Facturas(String id, Clients cliente, List<Products> productos) {
		super();
		this.id = id;
		double costos = 0.0;
		for (Products prod : productos) {
			costos = prod.getPrecioUnitario() + costos;
		}
		this.coste = costos;
		this.cliente = cliente;
		this.productos = productos;
	}

	public Facturas() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getCoste() {
		return coste;
	}

	public void setCoste(double coste) {
		this.coste = coste;
	}

	public Clients getCliente() {
		return cliente;
	}

	public void setCliente(Clients cliente) {
		this.cliente = cliente;
	}

	public List<Products> getProductos() {
		return productos;
	}

	public void setProductos(List<Products> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Facturas").append(" id = ").append(id).append(", Cliente = ")
				.append(cliente.getNombre()).append(", Productos = ");
		for (Products product : productos) {
			sb.append(product.getNombre()).append(", ");
		}
		sb.append(", Coste total = ").append(coste).append("\n");

		return sb.toString();

	}

}
