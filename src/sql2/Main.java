package sql2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String jdbcURL = "D:\\Dbeaver\\Database;AUTO_SERVER=TRUE";
		String userName = "gigi";
		String userPasswd = "gigi";

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement updateStmt = null;
		PreparedStatement selectStmt = null;

		ResultSet rset = null;
		// JDK 1.0+
		try {
			conn = DriverManager.getConnection(jdbcURL, userName, userPasswd);
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.execute("CREATE TABLE if NOT EXISTS ANGAJAT(id INTEGER PRIMARY KEY,NUME VARCHAR(32),DATA_ANGAJARII DATE,SALARIU DECIMAL(12,2))");
			// stmt.execute("DROP TABLE pufi");
			//////////////////////////////////////////////////////
			updateStmt = conn.prepareStatement("INSERT INTO ANGAJAT(id,NUME,DATA_ANGAJARII,SALARIU) " +
					"VALUES (?, ?,?,?)" );
			updateStmt.setInt(1, 3);
			updateStmt.setString(2, "Vasile");
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, 2009);
			cal.set(Calendar.MONTH,Calendar.FEBRUARY);
			cal.set(Calendar.DAY_OF_MONTH,12);
			updateStmt.setDate(3, new java.sql.Date(cal.getTime().getTime()));
			updateStmt.setDouble(4, 3.14);
			
			int result = updateStmt.executeUpdate();
			System.out.println("Insert:" + result);
			
			updateStmt.setInt(1, 4);
			updateStmt.setString(2, "Vasile");
			cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, 2009);
			cal.set(Calendar.MONTH,Calendar.FEBRUARY);
			cal.set(Calendar.DAY_OF_MONTH,12);
			updateStmt.setDate(3, new java.sql.Date(cal.getTime().getTime()));
			updateStmt.setDouble(4, 3.14);
			
			result = updateStmt.executeUpdate();
			System.out.println("Insert:" + result);
			
			selectStmt = conn.prepareStatement("SELECT ID,DATA_ANGAJARII,NUME,SALARIU FROM ANGAJAT WHERE id > ?");
			selectStmt.setInt(1, 44);
			rset = selectStmt.executeQuery();
			rset.close();
			
			//result = stmt.executeUpdate("DELETE FROM PUFI WHERE id=333");
			//System.out.println("Delete:" + result);
			//
			rset = stmt.executeQuery("SELECT id*3.14 as hihi FROM PUFI");
			
			ResultSetMetaData rsetMeta = rset.getMetaData();
			System.out.println(rsetMeta.getColumnCount());
			for (int i = 1; i <= rsetMeta.getColumnCount(); i++) {
				String cName = rsetMeta.getColumnLabel(i);
				int cType = rsetMeta.getColumnType(i);
				String cTypeName = rsetMeta.getColumnTypeName(i);
				// Types.
				System.out.println(cName + ":" + cType + ":" + cTypeName);
			}
			while (rset.next()) {
				System.out.println(rset.getBigDecimal(1));
				System.out.println(rset.getString(1));
				// System.out.println(rset.getByte(1));
				System.out.println(rset.getInt(1));
				System.out.println(rset.getFloat(1));

			}
			conn.commit();
		} finally {
			if (rset != null)
				rset.close();
			if(updateStmt != null) 
				updateStmt.close();
			if(selectStmt != null) 
				selectStmt.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		// ECHIVALENTE
		// JDK 1.7+
		try (Connection c1 = DriverManager.getConnection(jdbcURL, userName, userPasswd)) {

		}

	}

}
