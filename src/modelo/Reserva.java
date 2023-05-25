package modelo;

import java.time.LocalDate;

public class Reserva {
	private Integer id;
	private LocalDate fechaentrada;
	private LocalDate fechasalida;
	private String formapago;
	private Integer valor;
	private Huesped huesped;
	
	public Reserva(Integer id, LocalDate fechaentrada, LocalDate fechasalida, String formapago, Integer valor) {
		this.id = id;
		this.fechaentrada = fechaentrada;
		this.fechasalida = fechasalida;
		this.formapago = formapago;
		this.valor = valor;
	}

	
	public Reserva(Integer id, LocalDate fechaentrada, LocalDate fechasalida, String formapago, Huesped huesped, Integer valor) {
		this.id = id;
		this.fechaentrada = fechaentrada;
		this.fechasalida = fechasalida;
		this.formapago = formapago;
		this.huesped = huesped;
		this.valor = valor;
	}

	public Reserva(LocalDate fechaentrada, LocalDate fechasalida, String formapago, Integer valor) {
		this.fechaentrada = fechaentrada;
		this.fechasalida = fechasalida;
		this.formapago = formapago;
		this.valor = valor;
	}


	public Huesped getHuesped() {
		return huesped;
	}


	public void setHuesped(Huesped huesped) {
		this.huesped = huesped;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getfechaentrada() {
		return fechaentrada;
	}

	public void setfechaentrada(LocalDate fechaentrada) {
		this.fechaentrada = fechaentrada;
	}

	public LocalDate getfechasalida() {
		return fechasalida;
	}

	public void setfechasalida(LocalDate fechasalida) {
		this.fechasalida = fechasalida;
	}

	public String getformapago() {
		return formapago;
	}

	public void setformapago(String formapago) {
		this.formapago = formapago;
	}


	public Integer getvalor() {
		return valor;
	}


	public void setvalor(Integer valor) {
		this.valor = valor;
	}
	
	
	
	
	
}
