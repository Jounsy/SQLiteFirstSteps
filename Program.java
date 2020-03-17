import java.sql.*;

public class Program {
	
	public static void main(String[] args){
		Program program = new Program();
		program.open();
		program.insert();
		program.close();
	}
	Connection connection;
	void open(){
		try{
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:users.db");
			System.out.println("Connected");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	void insert(){
		
	}
	void close(){
		try{
			connection.close();
		}
		catch(Exception e){System.out.println(e.getMessage());
		}
	}
	
}