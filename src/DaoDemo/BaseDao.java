package DaoDemo;

import java.sql.*;

public class BaseDao {
    static public Connection connection = null;
    static public PreparedStatement pstm = null;

    static {
        getConnDef();
    }

    static public Connection getConnDef() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://192.168.0.79:3306/bankdb", "root", "123456");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeResourse() {
        try {
            if (pstm != null) {
                pstm.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean executeSql(String pSql, Object[] params) {
        int r = 0;
        try {
            pstm = connection.prepareStatement(pSql);
            for (int i = 0; (params != null && i < params.length); i++) {
                pstm.setObject(i+1, params[i]);
            }
            r = pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeResourse();
        }
        return r > 0 ? true : false;
    }

}
