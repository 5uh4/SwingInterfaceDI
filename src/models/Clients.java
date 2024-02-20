package models;

public class Clients {

	public String nombre;
	public String apellidos;
	public int edad;
	public String provincia;

	public Clients(String nombre, String apellidos, int edad, String provincia) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.provincia = provincia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + ", Apellidos: " + apellidos + ", Edad: " + edad + ", Provincia: " + provincia;
	}
	
	
}
