/*
	JDBC�����������
		1.ע������
		2.��ȡ���ݿ�����
		3.��ȡ���ݿ��������
		4.ִ��SQL���
		5.�����ѯ�����
		6.�ر���Դ
		��һ����ע������
			1.1 ��ȡ��������
			1.2 ע������
*/
import java.sql.Driver;
import java.sql.DriverManager;
public class JDBCTest01
{
	public static void main(String[] args){
		try{
			//1.ע������
			//1.1 ��ȡ��������
			Driver driver = new com.mysql.jdbc.Driver();
			//1.2 ע������
			DriverManager.registerDriver(driver);
		}catch(Exception e){
			e.printStackTrace();
		}
		

	}
}