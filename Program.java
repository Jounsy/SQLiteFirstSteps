import java.sql.*;
import java.util.Scanner;

public class Program {

    public static void main(String[] args){
        Program program = new Program();
        program.open();
        //program.insert();
        program.select();
        program.close();
    }
    Connection connection;
    void open(){
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:c:\\sqlite\\users.db");
            System.out.println("Connected");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    void select(){
        try{
            Statement statement = connection.createStatement();
            String query =
                    "SELECT id, name, phone " +
                            "FROM users " +
                            "ORDER BY name";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                System.out.println(id + "\t | " + name + "\t | " + phone +"\t | ");
            }
            resultSet.close();
            statement.close();
        }
        catch(Exception e){System.out.println(e.getMessage());
        }
    }
    void insert(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter user name: ");
            String name = scanner.nextLine();
            System.out.println("Enter phone: ");
            String phone = scanner.nextLine();

            String query = "INSERT INTO users (name, phone) " +
                    "VALUES ('" + name + "', '" + phone + "' )";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Rows added");
        }
        catch(Exception e){System.out.println(e.getMessage());
        }
    }
    void close(){
        try{
            connection.close();
        }
        catch(Exception e){System.out.println(e.getMessage());
        }
    }

}
