package DaoDemo.Daolmpl;

import DaoDemo.BaseDao;
import DaoDemo.Userinfo;
import DaoDemo.UserinfoDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;

public class UserinfoDaolmpl extends BaseDao implements UserinfoDao {
    private int customerID;

    public boolean save(Userinfo userinfo) {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("INSERT into userinfo(customerId,customerName,pid,telephone,address)");
        stringBuffer.append("values (?,?,?,?,?)");
        Object[] params = new Object[5];
        params[0] = userinfo.getCustomerID();
        params[1] = userinfo.getCustomerName();
        params[2] = userinfo.getPID();
        params[3] = userinfo.getTelephone();
        params[4] = userinfo.getAddress();

        System.out.println(stringBuffer);

        boolean b = executeSql(stringBuffer.toString(), params);

        return b;
    }
    public ResultSet student(){
        ResultSet resultSet =null;
        String sql="select customerID,customerName,Pid,telephone,address FROM userinfo";
        try{
            pstm = connection.prepareStatement(sql);
            resultSet =pstm.executeQuery();
            int i=1;
            int coustomerID = 0;
            String Pid;
            String telephone;
            String address;
            String  customerName;
            while(resultSet.next()){
                customerID=resultSet.getInt("customerID");
                customerName=resultSet.getString("customerName");
                Pid=resultSet.getString("Pid");
                telephone=resultSet.getString("telephone");
                address=resultSet.getString("address");
                System.out.println(""+customerID+","+customerName+","+Pid+","+telephone+","+address);
            }
        }catch(SQLException throwables){
            System.out.println("执行了catch方法");
            throwables.printStackTrace();
        }finally {
            System.out.println("执行了finally方法！");
            try{
                resultSet.close();
                pstm.close();
                connection.close();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return resultSet;
    }


}
