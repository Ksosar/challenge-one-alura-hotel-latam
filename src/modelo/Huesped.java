package modelo;

//import java.sql.Date;
import java.time.LocalDate;

public class Huesped {

	private Integer id;
	private String nombre;
	private String apellido;
	private LocalDate fechanacimiento;
	private String nacionalidad;
	private String telefono;
	private Integer idreserva;
	
	
	public Huesped(Integer id, String nombre, String apellido, LocalDate fechanacimiento, String nacionalidad, String telefono,
			Integer idreserva) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechanacimiento = fechanacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.idreserva = idreserva;
	}



	public Huesped(Integer id, String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.id = id;
	}



	public Huesped(String nombre, String apellido, LocalDate fechanacimiento, String nacionalidad, String telefono,
			Integer idreserva) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechanacimiento = fechanacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.idreserva = idreserva;
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public LocalDate getfechanacimiento() {
		return fechanacimiento;
	}


	public void setfechanacimiento(LocalDate fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}


	public String getNacionalidad() {
		return nacionalidad;
	}


	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public int getIdreserva() {
		return idreserva;
	}


	public void setIdreserva(int idreserva) {
		this.idreserva = idreserva;
	}
	
	
	
	
	
}
