package TelTel;

import java.sql.*;
import java.util.ArrayList;



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
            rs = st.executeQuery("select * from telph;"); // 쿼리문 telph테이블 전체 목록 출력
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
    public void updateMember(String name, String addr,String tel) {
        try {
            st = conn.createStatement();
            int stmt = st
                    .executeUpdate("update telph set 주소 = '" + addr +"',전화번호 = '" + tel + "'" +
                            " where 이름 = '" + name + "';");
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
            int stmt = st.executeUpdate("delete from telph where 이름= '" + name + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    // 회원 검색
    public ArrayList<Model> searchMember(String content) {
        ArrayList<Model> arr = new ArrayList<Model>();
        System.out.println(arr);
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from telph where 이름 like '%" + content + "%';");
            while (rs.next()) {
                arr.add(new Model(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        return arr;
    }



}
