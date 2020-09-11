package com.mcit.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mcit.entities.User;

public class UserDao {
	
	private Connection con = ConnectionFactory.getConnection();

	public void save(User user) {

		String sql = "INSERT INTO user_infos (name, password) VALUES (?,?)";

		try {
			PreparedStatement query = con.prepareStatement(sql);
			query.setString(1, user.getName());
			query.setString(2, user.getPassword());

			query.executeUpdate();
			query.close();
			System.out.println("Saved!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
