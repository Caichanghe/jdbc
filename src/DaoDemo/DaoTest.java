package DaoDemo;

import DaoDemo.Daolmpl.UserinfoDaolmpl;

public class DaoTest {
    public static void main(String[] args) {
        UserinfoDaolmpl uid = new UserinfoDaolmpl();
        Userinfo userinfo = new Userinfo();
        userinfo.setCustomerID(8);
        userinfo.setCustomerName("波波");
        userinfo.setPID("12123123123");
        userinfo.setTelephone("1888888888");
        userinfo.setAddress("江苏南京");
        boolean r = uid.save(userinfo);
        if (r) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }
    }
}
