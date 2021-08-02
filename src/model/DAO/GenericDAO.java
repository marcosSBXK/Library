package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class GenericDAO<T> {
	public static boolean create(String query, Object... parametros) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(query);
			for (int i =0; i< parametros.length; i++) {
				pstm.setObject(i +1, parametros[i]);
			}
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null ) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public static boolean update(String query, Object... parametros) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(query);
			for (int i =0; i< parametros.length; i++) {
				pstm.setObject(i +1, parametros[i]);
			}
			pstm.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if(conn != null ) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public static boolean delete(String query) throws SQLException {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			 conn = ConnectionFactory.createConnectionToMySQL();
			 pstm = conn.prepareStatement(query);
			 pstm.executeUpdate();
			 return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}