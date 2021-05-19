package Test;

import com.sun.org.apache.xpath.internal.objects.XString;

import java.sql.*;

public class Test {
    public static void main(String[] args) {
        Connection connection =null;
        Statement statement = null;
        ResultSet resultSet = null;
        String s="张三";

        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        try{
            connection = DriverManager.getConnection("jdbc:mysql://192.168.0.79:3306/bankdb","root","123456");
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try{
            statement =connection.createStatement();
            resultSet = statement.executeQuery("SELECT u.customerID,u.customerName FROM userinfo u where u.customerName = '"+s+"'");

            while (resultSet.next()){
                System.out.print(resultSet.getString(1)+",");;
                System.out.println(resultSet.getString(2));;

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
