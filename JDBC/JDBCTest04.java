/*
	JDBC编程六步曲：
		1.注册驱动
		2.获取数据库连接
		3.获取数据库操作对象
		4.执行SQL语句
		5.处理查询结果集
		6.关闭资源
		第四步：执行SQL语句
			1.DQL语句 -> 第五步：处理查询结果集
			2.DML语句
*/
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
public class JDBCTest04
{
	public static void main(String[] args){
		try{
			//1.注册驱动
			Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			//2.获取数据库连接
			String url = "JDBC:mysql://localhost:3366/bjpowernode";
			String user = "root";
			String password = "111";
			Connection conn = DriverManager.getConnection(url,user,password);
			//3.获取数据库操作对象
			Statement stmt = conn.createStatement();
			//4.执行SQL语句：DQL语句->查询出员工薪水等级：显示：员工名称、员工薪水、薪水等级
			String sql = "select e.ename,e.sal,s.grade from emp e join salgrade s on e.sal between s.losal and s.hisal";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.print(rs);

		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
}