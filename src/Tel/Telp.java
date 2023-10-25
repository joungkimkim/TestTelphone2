package Tel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
class Model1{
    String name;
    String address;
    String tel;

    public Model1(String name, String address, String tel) {
        this.address = address;
        this.name = name;
        this.tel = tel;
    }
}

public class Telp {
    public static Connection conn;
    private static PreparedStatement pstmt;
    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Telphone"
                    ,"root","12345678");
            pstmt = conn.prepareStatement("INSERT INTO telph VALUES(?,?,?);");
            pstmt.setString(1, "김길동"); // 물음표(?)가 여기의 1~6과 매칭된다.
            pstmt.setString(2, "강남");
            pstmt.setString(3, "201-1111");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
