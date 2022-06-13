package main;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    
//    public Connection dbCheck() throws URISyntaxException, SQLException {
//        String dbUrl = System.getenv("JDBC_DATABASE_URL");
//        return DriverManager.getConnection(dbUrl);
//    }
    
    public Connection dbCheck() throws URISyntaxException, SQLException {
        URI dbUri = new URI("postgres://aclqhtkyrjquay:b56c9bff730cdd8f27ee48ca4cb6138b4919229436f3ee3d6a877f7af96d1220@ec2-54-157-16-196.compute-1.amazonaws.com:5432/d169u3kp59punn");

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
        return DriverManager.getConnection(dbUrl, username, password);
    }
}