/*
	JDBC编程六步曲：
		1.注册驱动
		2.获取数据库连接
		3.获取数据库操作对象
		4.执行SQL语句
		5.处理查询结果集
		6.关闭资源
		第五步：处理查询结果集
*/
import java.sql.*;
public class JDBCTest06
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
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3366/bjpowernode","root","111");
			//3.获取数据库操作对象
			stmt = conn.createStatement();
			//4.执行SQL语句：DQL语句->处理查询结果集
			String sql = "select e.ename,e.sal,s.grade from emp e join salgrade s on e.sal between s.losal and s.hisal";
			rs = stmt.executeQuery(sql);
			/*
			+--------+---------+-------+
			| ename  | sal     | grade |
			+--------+---------+-------+
			| SMITH  |  800.00 |     1 |
			| ALLEN  | 1600.00 |     3 |
			| WARD   | 1250.00 |     2 |
			| JONES  | 2975.00 |     4 |
			| MARTIN | 1250.00 |     2 |
			| BLAKE  | 2850.00 |     4 |
			| CLARK  | 2450.00 |     4 |
			| SCOTT  | 3000.00 |     4 |
			| KING   | 5000.00 |     5 |
			| TURNER | 1500.00 |     3 |
			| ADAMS  | 1100.00 |     1 |
			| JAMES  |  950.00 |     1 |
			| FORD   | 3000.00 |     4 |
			| MILLER | 1300.00 |     2 |
			+--------+---------+-------+
			
			*/
			//5.处理查询结果集
			while(rs.next()){
				/*
				String ename = rs.getString("ename");
				double sal = rs.getDouble("sal");
				int grade = rs.getInt("grade");
				*/
				//不建议以下写法：程序可读性不强
				String ename = rs.getString(1);
				double sal = rs.getDouble(2);
				int grade = rs.getInt(3);
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