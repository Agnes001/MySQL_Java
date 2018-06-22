import java.sql.*;
public class JDBCTest04_02
{
	public static void main(String[] args){
		Connection conn = null;
		Statement stmt = null;
		int count = 0 ;
		try{
			//1.ע������
			Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			//2.��ȡ���ݿ�����
			String url = "jdbc:mysql://127.0.0.1:3366/bjpowernode";
			String user = "root";
			String password = "111";
			conn = DriverManager.getConnection(url,user,password);
			//3.��ȡ���ݿ��������
			stmt = conn.createStatement();
			//4.ִ��SQL��䣺DML��� -> insert update delete
			String sql_ins = "insert into t_user(name) values('wangwu')";
			//count = stmt.executeUpdate(sql_ins);
			
			String sql_update = "update t_user set name = 'zhaoliu' where id = 4";
			//count = stmt.executeUpdate(sql_update);

			String sql_del = "delete from t_user where id = 5";
			count = stmt.executeUpdate(sql_del);
			System.out.println(count);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
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