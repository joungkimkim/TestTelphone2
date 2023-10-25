package TelTel;

import java.sql.*;
import java.util.ArrayList;

import static Tel.Telp.conn;

public class Controller {
    Connection conn = null;
    ResultSet rs = null;
    Statement st = null;

    public Controller() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Telphone", "root",
                    "12345678");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // 회원 추가
    public void insertMember(Model model) {
        Statement st = null;
        try {
            st = conn.createStatement();
            int stmt = st.executeUpdate(
                    "insert into telph values ('" + model.name + "', '" + model.addr + "', '" + model.tel + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 회원 목록 출력
    public ArrayList<Model> readMember() {
        ArrayList<Model> arr = new ArrayList<Model>();
        System.out.println(arr);
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from telph;");
            while (rs.next()) {
                arr.add(new Model(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arr;
    }

    // 회원수정
    public void updateMember(String name, String tel) {
        try {
            st = conn.createStatement();
            int stmt = st
                    .executeUpdate("update telph set tel = '" + tel + "' where name = '" + name + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 회원삭제
    public void deleteMember(String name) {
        try {
            st = conn.createStatement();
            int stmt = st.executeUpdate("delete from telph where name = '" + name + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 회원 검색
    public ArrayList<Model> searchMember(String content) {
        ArrayList<Model> arr = new ArrayList<Model>();
        System.out.println(arr);
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from telph where name like '%" + content + "%';");
            while (rs.next()) {
                arr.add(new Model(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arr;
    }



}
