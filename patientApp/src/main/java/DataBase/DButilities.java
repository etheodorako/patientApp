package DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Helpers.Patient;


public abstract class DButilities {

	public static List<Patient> getPatients() {
		
		DBconnection connection;
		List<Patient> list = new ArrayList<Patient>();
		
		try {
			connection = new DBconnection();

			String query = "SELECT * FROM PATIENT ;";

			ResultSet rs = connection.get_statement().executeQuery(query);


			while (rs.next()) {
				list.add(new Patient(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDate(4), rs.getString(5)));
			}
			
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
		
	}
	
	public static Patient getPatientById(String schoolID) {
		
		DBconnection connection;
		Patient p = null;
		
		try {
			connection = new DBconnection();

			String query = "SELECT * FROM PATIENT WHERE SCHOOL_ID = '"+ schoolID +"' ;";

			ResultSet rs = connection.get_statement().executeQuery(query);
			rs.next();

			p = new Patient(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7),
						rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
						rs.getString(12));
			
			
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
		
	}
	
	public static void updatePatient(Patient p) {
		System.out.println(p);
		DBconnection connection;
		
		try {
			connection = new DBconnection();
			
			String query = "UPDATE PATIENT_LIB.PATIENT SET NAME =?,"
					+ "SURNAME =?, BIRTH =?, CLASS =?, TEL_FATHER =?, TEL_MOTHER =?,"
					+ "TEL_PERSONAL_DOCTOR =?, PARENT_EMAIL =?, KNOWN_ALLERGIES =?,"
					+ "KNOWN_HEALTH_ISSUES =?, SPECIAL_NEEDS =?"
					+ " WHERE SCHOOL_ID =? ; ";
			
			PreparedStatement preparedStmt = (PreparedStatement) connection.get_connection().prepareStatement(query);
			preparedStmt.setString(1,p.getName());
			preparedStmt.setString(2,p.getSurname());
			preparedStmt.setDate(3, p.getBirth());
			preparedStmt.setString(4, p.getClS());
			preparedStmt.setString(5, p.getTel_father());
			preparedStmt.setString(6, p.getTel_mother());
			preparedStmt.setString(7, p.getTel_doctor());
			preparedStmt.setString(8, p.getMailOfParent());
			preparedStmt.setString(9, p.getKnownAllergies());
			preparedStmt.setString(10, p.getKnownHealthIssues());
			preparedStmt.setString(11, p.getSpecialNeeds());
			preparedStmt.setString(12, p.getSchoolID());


			// execute the preparedstatement
			preparedStmt.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
