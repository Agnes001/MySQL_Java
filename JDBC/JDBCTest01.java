/*
	JDBC编程六步曲：
		1.注册驱动
		2.获取数据库连接
		3.获取数据库操作对象
		4.执行SQL语句
		5.处理查询结果集
		6.关闭资源
		第一步：注册驱动
			1.1 获取驱动对象
			1.2 注册驱动
*/
import java.sql.Driver;
import java.sql.DriverManager;
public class JDBCTest01
{
	public static void main(String[] args){
		try{
			//1.注册驱动
			//1.1 获取驱动对象
			Driver driver = new com.mysql.jdbc.Driver();
			//1.2 注册驱动
			DriverManager.registerDriver(driver);
		}catch(Exception e){
			e.printStackTrace();
		}
		

	}
}