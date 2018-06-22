/*
	JDBC编程六步曲：
		1.注册驱动
		2.获取数据库连接
		3.获取数据库操作对象
		4.执行SQL语句
		5.处理查询结果集
		6.关闭资源
		第三步：获取数据库操作对象
*/
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
public class JDBCTest03
{
	public static void main(String[] args){
		try{
			//1.注册驱动
			Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);

			//2.获取数据库连接
			String url = "jdbc:mysql://localhost:3366/bjpowernode";
			String user = "root";
			String password = "111";
			Connection conn = DriverManager.getConnection(url,user,password);

			//3.获取数据库操作对象
			Statement stmt = conn.createStatement();
			System.out.println(stmt);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}