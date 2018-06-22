import java.sql.*;
public class JDBCTest04_01
{
	public static void main(String[] args){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			//1.ע������
			Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			//2.��ȡ���ݿ�����
			String url = "jdbc:mysql://localhost:3366/bjpowernode";
			String user = "root";
			String password = "111";
			conn = DriverManager.getConnection(url,user,password);
			//3.��ȡ���ݿ��������
			stmt = conn.createStatement();
			//4.ִ��SQL��䡪> DQL���
			String sql = "select e.ename,e.sal,s.grade from emp e join salgrade s on e.sal between s.losal and s.hisal";
			rs = stmt.executeQuery(sql);
			//5.�����ѯ�����
			while(rs.next()){
				String ename = rs.getString("ename");
				double sal = rs.getDouble("sal");
				int grade = rs.getInt("grade");
				System.out.println(ename + " " + sal + " " + grade);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//6.�ر���Դ
			if(rs != null){
				try{
					rs.close();
				}catch(Exception e){
					e.printStackTrace();
				} 
			}

			if(stmt != null){
				try{
					stmt.close();
				}catch(Exception e){
					e.printStackTrace();
				} 
			}
			
			if(conn != null){
				try{
					conn.close();
				}catch(Exception e){
					e.printStackTrace();
				} 
			}
		}
	}
}