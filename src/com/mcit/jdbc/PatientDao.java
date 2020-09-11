package com.mcit.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mcit.entities.Patient;

public class PatientDao {
	private Connection con = ConnectionFactory.getConnection();

	public void save(Patient patient) {

		String sql = "INSERT INTO patient (patient_id, first_name, last_name, gender) VALUES (?,?,?,?)";

		try {
			PreparedStatement query = con.prepareStatement(sql);
			query.setInt(1, patient.getId());
			query.setString(2, patient.getFirstName());
			query.setString(3, patient.getLastName());
			query.setString(4, patient.getGender());

			query.executeUpdate();
			query.close();
			System.out.println("Saved!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Patient> getAll() {
		String sql = "SELECT * FROM patient";
		List<Patient> list = new ArrayList<>();
		
		try {
			PreparedStatement query = con.prepareStatement(sql);
			ResultSet result = query.executeQuery();
			list.clear();
			
			while(result.next()) {
				Patient patient = new Patient();
				patient.setId(result.getInt("patient_id"));
				patient.setFirstName(result.getString("first_name"));
				patient.setLastName(result.getString("last_name"));
				patient.setGender(result.getString("gender"));
				
				list.add(patient);
			}
			
			query.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
