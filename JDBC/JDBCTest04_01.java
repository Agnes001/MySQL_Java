import java.sql.*;
public class JDBCTest04_01
{
	public static void main(String[] args){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			//1.注册驱动
			Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			//2.获取数据库连接
			String url = "jdbc:mysql://localhost:3366/bjpowernode";
			String user = "root";
			String password = "111";
			conn = DriverManager.getConnection(url,user,password);
			//3.获取数据库操作对象
			stmt = conn.createStatement();
			//4.执行SQL语句—> DQL语句
			String sql = "select e.ename,e.sal,s.grade from emp e join salgrade s on e.sal between s.losal and s.hisal";
			rs = stmt.executeQuery(sql);
			//5.处理查询结果集
			while(rs.next()){
				String ename = rs.getString("ename");
				double sal = rs.getDouble("sal");
				int grade = rs.getInt("grade");
				System.out.println(ename + " " + sal + " " + grade);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//6.关闭资源
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