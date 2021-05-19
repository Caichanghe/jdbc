package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test2 {
    public static void main(String[] args) {
        Connection connection =null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://192.168.0.79:3306/bankdb", "root", "123456");
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        Statement statement =null;
        try{
            statement = connection.createStatement();
            StringBuffer stringBuffer =new StringBuffer();
            stringBuffer.append("INSERT INTO userinfo (customerID,customerName,PID,telephone,address)");
            stringBuffer.append("VALUES(5,'才长鹤',123456787654321,17686486553,'南京市雨花台')");
            String s = stringBuffer.toString();
            statement.execute(s);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
