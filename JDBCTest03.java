/*
	JDBC�����������
		1.ע������
		2.��ȡ���ݿ�����
		3.��ȡ���ݿ��������
		4.ִ��SQL���
		5.�����ѯ�����
		6.�ر���Դ
		����������ȡ���ݿ��������
*/
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
public class JDBCTest03
{
	public static void main(String[] args){
		try{
			//1.ע������
			Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);

			//2.��ȡ���ݿ�����
			String url = "jdbc:mysql://localhost:3366/bjpowernode";
			String user = "root";
			String password = "111";
			Connection conn = DriverManager.getConnection(url,user,password);

			//3.��ȡ���ݿ��������
			Statement stmt = conn.createStatement();
			System.out.println(stmt);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}