/*
	JDBC编程六步曲：
		1.注册驱动
		2.获取数据库连接
		3.获取数据库操作对象
		4.执行SQL语句
		5.处理查询结果集
		6.关闭资源
		第二步：获取数据库连接

*/
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
public class JDBCTest02
{
	public static void main(String[] args){
		try{
			//1.注册驱动
			//1.1 获取驱动对象
			Driver driver = new com.mysql.jdbc.Driver();
			//1.2 注册驱动
			DriverManager.registerDriver(driver);

			//2.获取数据库连接
			String url = "jdbc:mysql://localhost:3306/bjpowernode";
			String user = "root";
			String password = "111";
			Connection conn = DriverManager.getConnection(url,user,password);
			System.out.println(conn);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}