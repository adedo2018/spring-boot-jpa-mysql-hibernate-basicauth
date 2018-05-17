package com.example.usermedical;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class UserUtility {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		String[][] users = {{"1", "admin", "admin", "Super", "Admin", "yes"}};

		String sql = "insert into users (user_id, username, password, first_name, last_name, admin) values (%s, '%s', '%s', '%s', '%s', '%s');";

		for(String[] user : users) {

			System.out.println(String.format(sql, user[0], user[1], passwordEncoder.encode(user[2]) , user[3], user[4], user[5]));
		}

	}
	
}
