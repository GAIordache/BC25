package sql3;

import java.util.Calendar;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class PersonDAO implements PersonDAOInterface{
	
	private String jdbcURL = "D:\\Dbeaver\\Database;AUTO_SERVER=TRUE";
	private String userName = "gigi";
	private String userPasswd = "gigi";
	
	Connection conn = null;
	PreparedStatement updateStmt = null;
	ResultSet rset = null;
	
	@Override
	public void update(Person pPerson) throws SQLException {
		
		
		try {
			conn = DriverManager.getConnection(jdbcURL, userName, userPasswd);
			conn.setAutoCommit(false);
			
			updateStmt = conn.prepareStatement("INSERT INTO PERSON(NUME,DOB,AGE,SEX) " +
					"VALUES (?,?,?,?)" );
			
			updateStmt.setString(2, pPerson.getName());
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, 2000);
			cal.set(Calendar.MONTH,Calendar.FEBRUARY);
			cal.set(Calendar.DAY_OF_MONTH,12);
			updateStmt.setDate(3, new java.sql.Date(cal.getTime().getTime()));
			updateStmt.setInt(4, pPerson.getAge());
			updateStmt.setString(5,pPerson.getSex());
			
			int result = updateStmt.executeUpdate();
			System.out.println("Insert:" + result);
			conn.commit();
		
		} finally {
	
			if(updateStmt != null) 
				updateStmt.close();
			if (conn != null)
				conn.close();
		}
		
	}

	@Override
	public Person create(Person pPerson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Person pPerson) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return null;
	}

}
