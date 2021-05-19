package Test;

import java.sql.*;
import java.util.Scanner;

public class Ps {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement pr= null;
        Scanner input=new Scanner(System.in);
        System.out.println("请输入地址不详的邮箱地址");
        String s =input.next();
        String sql;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.0.79:3306/school", "root", "123456");
            sql="UPDATE student SET email=? WHERE address=?";
            pr =  connection.prepareStatement(sql);
            pr.setString(1, s);

            pr.setString(2,"地址不详");
            pr.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {

            try {
                pr.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }


    }
}