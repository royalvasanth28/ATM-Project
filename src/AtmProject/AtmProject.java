package AtmProject;

import java.sql.*;
import java.util.*;
public class AtmProject {
	static Connection con;
	static Statement st;
	static void changeBalance(int id , int newBalance) throws SQLException{
		PreparedStatement statement = con.prepareStatement("UPDATE user SET balance = ? WHERE id = ?");
		statement.setInt(1, newBalance);
		statement.setInt(2, id);
		statement.executeUpdate();
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AtmProject","root","1234");
		st = con.createStatement();
		ResultSet rs = st.executeQuery("Select * from user");
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		Map<Integer,Integer> map1 = new HashMap<Integer,Integer>();
		while(rs.next()){
			map.put(rs.getInt(1), rs.getInt(4));
			map1.put(rs.getInt(1), rs.getInt(3));
		}
		System.out.println("Do you want to add new User...?");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		if(input.equalsIgnoreCase("yes")) {
			System.out.println("Enter new User Name");
			String name = sc.next();
			System.out.println("Enter PIN for new User");
			int pin = sc.nextInt();
			System.out.println("Enter Initial Balance");
			int balance  = sc.nextInt();
			PreparedStatement statement = con.prepareStatement("INSERT INTO user VALUES (?, ?, ?, ?)");
			statement.setInt(1, map.size()+1);
            statement.setString(2, name);
            statement.setInt(3, balance);
            statement.setInt(4, pin);
			statement.executeUpdate();
		}
		while(rs.next()){
			System.out.println(rs.getInt(1) +"-"+ rs.getString(2));
			map.put(rs.getInt(1), rs.getInt(4));
			map1.put(rs.getInt(1), rs.getInt(3));
		}
		new Atm_Process(map , map1);
		st.close();
		con.close();
		sc.close();
	}
}