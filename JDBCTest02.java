/*
	JDBC�����������
		1.ע������
		2.��ȡ���ݿ�����
		3.��ȡ���ݿ��������
		4.ִ��SQL���
		5.�����ѯ�����
		6.�ر���Դ
		�ڶ�������ȡ���ݿ�����

*/
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
public class JDBCTest02
{
	public static void main(String[] args){
		try{
			//1.ע������
			//1.1 ��ȡ��������
			Driver driver = new com.mysql.jdbc.Driver();
			//1.2 ע������
			DriverManager.registerDriver(driver);

			//2.��ȡ���ݿ�����
			String url = "jdbc:mysql://127.0.0.1:3366/bjpowernode";
			String user = "root";
			String password = "111";
			Connection conn = DriverManager.getConnection(url,user,password);
			System.out.println(conn);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}