package dao;

//import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import Utilitario.UtilitarioFecha;
import modelo.Huesped;
import modelo.Reserva;

public class ReservaDAO {

	private Connection con;

	public ReservaDAO(Connection con) {
		this.con = con;
	}

	public List<Reserva> listar() {

		List<Reserva> resultado = new ArrayList<Reserva>();

		try {

			final PreparedStatement statement = con.prepareStatement("SELECT R.ID, R.fechaentrada, R.fechasalida, R.formapago,"
					+ " R.valor, H.ID, H.NOMBRE, H.APELLIDO FROM RESERVA R INNER JOIN"
					+ " HUESPED H ON H.IDRESERVA = R.ID");

			try (statement) {
				statement.execute();

				ResultSet resultSet = statement.getResultSet();

				while (resultSet.next()) {
					Reserva fila = new Reserva(resultSet.getInt("R.ID"), resultSet.getDate("R.fechaentrada").toLocalDate(),
							resultSet.getDate("R.fechasalida").toLocalDate(), resultSet.getString("R.formapago"),
							new Huesped(resultSet.getInt("H.ID"), resultSet.getString("H.NOMBRE"),
									resultSet.getString("H.APELLIDO")),
							Integer.parseInt(resultSet.getBigDecimal("R.valor").toString()));
					resultado.add(fila);
				}

				return resultado;

			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public int abrirConexion(Reserva reserva) {

		try {
			con.setAutoCommit(false);

			final PreparedStatement statement = con.prepareStatement(
					"INSERT INTO RESERVA (fechaentrada, " + "fechasalida, formapago, valor)" + " VALUES(?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			try (statement) {
				statement.setDate(1, UtilitarioFecha.tranformarADateSQL(reserva.getfechaentrada()));
				statement.setDate(2, UtilitarioFecha.tranformarADateSQL(reserva.getfechasalida()));
				statement.setString(3, reserva.getformapago());
				statement.setInt(4, reserva.getvalor());

				statement.execute();

				ResultSet resultSet = statement.getGeneratedKeys();

				int resultado = 0;
				while (resultSet.next()) {
					resultado = resultSet.getInt(1);
				}
				return resultado;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void cerrarConexion() {

		try {
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		}
		
		try {
			con.close();
		} catch (SQLException e1) {
			throw new RuntimeException(e1);
		}
		
	}
	
	public void cancelarConexion() {
		try {
			con.rollback();
			System.out.println("cancelo");
		}catch (SQLException e1) {
			throw new RuntimeException(e1);
		}
		try {
			con.close();
		} catch (SQLException e1) {
			throw new RuntimeException(e1);
		}
	}

	public void eliminar(int idReserva) {

		try {
			final PreparedStatement statement = con.prepareStatement("DELETE FROM RESERVA WHERE ID = ?");

			try (statement) {
				statement.setInt(1, idReserva);
				statement.execute();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void modificar(Reserva reserva) {
		try {

			final PreparedStatement statement = con.prepareStatement(
					"UPDATE RESERVA SET "
					+ "fechaentrada = ?, "
					+ "fechasalida = ?, "
					+ "formapago = ?, "
					+ "valor = ? "
					+ "WHERE ID = ?");

			try (statement) {
				statement.setDate(1, UtilitarioFecha.tranformarADateSQL(reserva.getfechaentrada()));
				statement.setDate(2, UtilitarioFecha.tranformarADateSQL(reserva.getfechasalida()));
				statement.setString(3, reserva.getformapago());
				statement.setInt(4, reserva.getvalor());
				statement.setInt(5, reserva.getId());
				statement.execute();
			}

		} catch (SQLException e1) {
			throw new RuntimeException(e1);
		}
		
	}

	public List<Reserva> buscar(String busqueda, String campo) {
		List<Reserva> resultado = new ArrayList<Reserva>();
		try {

			
			final PreparedStatement statement;
			if(campo == "NOMBRE") {
				statement = con.prepareStatement("SELECT R.ID, R.fechaentrada, R.fechasalida, R.formapago,"
						+ " R.valor, H.ID, H.NOMBRE, H.APELLIDO, H.fechanacimiento, H.NACIONALIDAD,  H.TELEFONO, H.IDRESERVA FROM RESERVA R INNER JOIN"
						+ " HUESPED H ON H.IDRESERVA = R.ID WHERE H.NOMBRE LIKE '%' ? '%'");
				statement.setString(1, busqueda);
			}else if (campo == "APELLIDO") {
				statement = con.prepareStatement("SELECT R.ID, R.fechaentrada, R.fechasalida, R.formapago,"
						+ " R.valor, H.ID, H.NOMBRE, H.APELLIDO, H.fechanacimiento, H.NACIONALIDAD,  H.TELEFONO, H.IDRESERVA FROM RESERVA R INNER JOIN"
						+ " HUESPED H ON H.IDRESERVA = R.ID WHERE H.APELLIDO LIKE '%' ? '%'");
				statement.setString(1, busqueda);
			}else {
				statement = con.prepareStatement("SELECT R.ID, R.fechaentrada, R.fechasalida, R.formapago,"
						+ " R.valor, H.ID, H.NOMBRE, H.APELLIDO, H.fechanacimiento, H.NACIONALIDAD,  H.TELEFONO, H.IDRESERVA FROM RESERVA R INNER JOIN"
						+ " HUESPED H ON H.IDRESERVA = R.ID WHERE H.IDRESERVA = ?");
				statement.setInt(1, Integer.parseInt(busqueda));
			}
			
			
			try (statement) {
				statement.execute();

				ResultSet resultSet = statement.getResultSet();

				while (resultSet.next()) {
		
					
					Reserva fila = new Reserva(resultSet.getInt("R.ID"), resultSet.getDate("R.fechaentrada").toLocalDate(),
							resultSet.getDate("R.fechasalida").toLocalDate(), resultSet.getString("R.formapago"),
							new Huesped(resultSet.getInt("H.ID"), resultSet.getString("H.NOMBRE"),
									resultSet.getString("H.APELLIDO"), resultSet.getDate("H.fechanacimiento").toLocalDate(),
									resultSet.getString("H.NACIONALIDAD"),resultSet.getString("H.TELEFONO"),resultSet.getInt("H.IDRESERVA")),
									resultSet.getInt("R.valor"));
					resultado.add(fila);
				}

				return resultado;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		
	}



}
