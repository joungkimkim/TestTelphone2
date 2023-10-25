/*package Tel;

public class jdbcTest5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "scott";
            String pwd = "1234";

            conn = DriverManager.getConnection(url,user,pwd);
            //////////////////////////////////////////////////////////////
            System.out.println("전화번호부 v1.0");
            while (true) {
                System.out.println("1.전화번호 등록 2.전화번호 검색 3.전화번호 모두 보기 4.종료");
                int input = sc.nextInt();
                sc.nextLine();
                if (input == 1) {
                    System.out.println("==전화번호 등록==");
                    String sql1 = "insert into student values (?,?,?,?)";
                    ps1 = conn.prepareStatement(sql1);

                    System.out.print("이름 : ");
                    String name = sc.nextLine();
                    ps1.setString(1, name);

                    System.out.print("나이 : ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    ps1.setInt(2, age);

                    System.out.print("주소 : ");
                    String addr = sc.nextLine();
                    ps1.setString(3, addr);

                    System.out.print("전화번호 : ");
                    String tel = sc.nextLine();
                    ps1.setString(4, tel);


                    int count1 = ps1.executeUpdate();
                    System.out.println(name+"의 정보가 등록되었습니다.");

                }else if (input ==2) {
                    System.out.println("==전화번호 검색==");
                    System.out.print("이름 : ");
                    String name = sc.nextLine();

                    String sql2 = "select * from student where name = ?";
                    ps2 = conn.prepareStatement(sql2);
                    ps2.setString(1, name);
                    rs2 = ps2.executeQuery();
                    if (rs2.next()) {
                        do {
                            int age = rs2.getInt("age");
                            String addr = rs2.getString("addr");
                            String tel = rs2.getString("tel");

                            System.out.println(name+"\t"+age+"\t"+addr+"\t"+tel);
                        }while (rs2.next());
                    }else {
                        System.out.println("등록된 이름이 아닙니다.");
                    }

                }else if (input ==3) {
                    System.out.println("==등록된 전화번호 정보==");
                    String sql3 = "select * from student";
                    ps3 = conn.prepareStatement(sql3);
                    rs3 = ps3.executeQuery();

                    while(rs3.next()) {
                        String name = rs3.getString("name");
                        int age = rs3.getInt("age");
                        String addr = rs3.getString("addr");
                        String tel = rs3.getString("tel");

                        System.out.println(name +"\t"+ age +"\t"+ addr +"\t"+ tel);
                    }

                }else if (input ==4) {
                    System.out.println("프로그램 종료");
                    break;
                }else {
                    System.out.println("잘못된 입력입니다.");

                }
            }

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if(rs2!=null)rs2.close();
                if(rs3!=null)rs3.close();
                if(ps1!=null)ps1.close();
                if(ps2!=null)ps2.close();
                if(ps3!=null)ps3.close();
                if(conn!=null)conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }



    }

}
*/