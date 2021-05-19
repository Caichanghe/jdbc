package Test;

import java.sql.*;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        Scanner input = new Scanner(System.in);
        int num = 0;
        String phone =null;
        int i = 0;
        try {
            System.out.println("请输入ID");
            num=input.nextInt();
            System.out.println("请输入修改的手机号");
            phone=input.next();
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://192.168.0.79:3306/bankdb", "root", "123456");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            statement = connection.createStatement();
            i = statement.executeUpdate("UPDATE userinfo SET telephone="+phone+" WHERE customerID="+num+"");
            System.out.println(i);
            if (i > 0) {
                System.out.println("成功修改为："+phone);
            }else{
                System.out.println("失败");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
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
