package chtioui.zelleg.restapi.service;

import java.security.SecureRandom;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import com.mysql.cj.api.mysqla.result.Resultset;

import chtioui.zelleg.restapi.model.Collocation;
import chtioui.zelleg.restapi.model.Service;
import chtioui.zelleg.restapi.model.User;

public class UserManager {
	
	private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
	private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe


Connection con;

	
	public UserManager(){
		
		try {
			String url =String.format("jdbc:mysql://localhost:3306/shareloc");
			String uname ="root";
			String pwd = "oumaimach738";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pwd);
			
		} catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
	}

	
	public User insertUser(User user) {
		String insert = "insert into user(email,password,firstname,lastname,score) values(?,?,?,?,?) ";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstname());
			ps.setString(4, user.getLastname());
			ps.setLong(5, user.getScore());
			
			ps.execute();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return user;
		
	}


	public String checkUser(String email,String password) throws SQLException {
		// TODO Auto-generated method stub

		
		ArrayList<User> data = new ArrayList<User>();
		
		String select = "select * from user where email='"+email+"' and password='"+password+"'";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		String token = null;
		
		if(rs.next()) {
			token=issueToken(email);
			long time =System.currentTimeMillis()/1000;
			String insert = "update user set token=?,created_at=?  where email='"+email+"' and password='"+password+"'" ;
			
			try {
				PreparedStatement ps2 = con.prepareStatement(insert);
				ps2.setString(1, token);
				ps2.setLong(2,time);
				
				
				ps2.execute();
			}catch(Exception e) {
				System.out.println(e +"data insert unsuccess.");
			}
			return token;
		}
		
		return token;
	}
private String issueToken(String email) {
		
		byte[] randomBytes = new byte[24];
	    secureRandom.nextBytes(randomBytes);
	    return base64Encoder.encodeToString(randomBytes);
	}

public Collocation createCollocation(Collocation collocation) {
	String insert = "insert into collocation(name,iduser) values(?,?) ";
	
	try {
		PreparedStatement ps = con.prepareStatement(insert);
		ps.setString(1, collocation.getName());
		ps.setLong(2, collocation.getIduser());
		
		
		ps.execute();
	}catch(Exception e) {
		System.out.println(e +"data insert unsuccess.");
	}
	
	return collocation;
	
}

public Service createService(Service service) {
	String insert = "insert into service(title,description,cost,idcollocation,admin) values(?,?,?,?,?) ";
	
	try {
		PreparedStatement ps = con.prepareStatement(insert);
		ps.setString(1, service.getTitle());
		ps.setString(2, service.getDescription());
		ps.setLong(3, service.getCost());
		ps.setLong(4, service.getIdcollocation());
		ps.setLong(4, service.getAdmin());
		
		ps.execute();
	}catch(Exception e) {
		System.out.println(e +"data insert unsuccess.");
	}
	
	return service;
	
}

}
	
	
	

	
