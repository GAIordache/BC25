package sql3;

import java.sql.SQLException;
import java.util.List;
//
// TABLE PERSON(ID INt PK, NAME VARCHAR,DOB DATE,AGE INT, SEX CHAR(1), DEL_FLAG BOOLEAN)
public interface PersonDAOInterface {
	void update(Person pPerson) throws SQLException; // in SQL DB
	Person create(Person pPerson); // in SQL DB
	void delete(Person pPerson);
	List<Person> getAllPersons();
}
// TODO PersonDAO implements PersonDAOInterface