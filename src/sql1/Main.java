package sql1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String jdbcURL = "jdbc:h2:D:\\dbeaver\\db\\curs;AUTO_SERVER=TRUE";
		String userName = "xx";
		String userPasswd = "xx";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		// JDK 1.0+
		try {
			conn = DriverManager.getConnection(jdbcURL, userName, userPasswd);
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.execute("CREATE TABLE if NOT EXISTS pufi(id INTEGER)");
			// stmt.execute("DROP TABLE pufi");
			int result = stmt.executeUpdate("INSERT INTO PUFI(id) VALUES (333) ,(555)");
			System.out.println("Insert:" + result);
			result = stmt.executeUpdate("DELETE FROM PUFI WHERE id=333");
			System.out.println("Delete:" + result);
			// conn.commit();
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
