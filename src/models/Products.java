package models;

public class Products {

	public String nombre;
	public double precioUnitario;
	public boolean perecedero;

	public Products(String nombre, double precioUnitario, boolean perecedero) {
		super();
		this.nombre = nombre;
		this.precioUnitario = precioUnitario;
		this.perecedero = perecedero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public boolean isPerecedero() {
		return perecedero;
	}

	public void setPerecedero(boolean perecedero) {
		this.perecedero = perecedero;
	}

	@Override
	public String toString() {
		return "\n Nombre:" + nombre + ", Precio Unitario: " + precioUnitario + ", Perecedero: " + perecedero;
	}
}
