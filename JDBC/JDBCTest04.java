/*
	JDBC�����������
		1.ע������
		2.��ȡ���ݿ�����
		3.��ȡ���ݿ��������
		4.ִ��SQL���
		5.�����ѯ�����
		6.�ر���Դ
		���Ĳ���ִ��SQL���
			1.DQL��� -> ���岽�������ѯ�����
			2.DML���
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
			//1.ע������
			Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			//2.��ȡ���ݿ�����
			String url = "JDBC:mysql://localhost:3366/bjpowernode";
			String user = "root";
			String password = "111";
			Connection conn = DriverManager.getConnection(url,user,password);
			//3.��ȡ���ݿ��������
			Statement stmt = conn.createStatement();
			//4.ִ��SQL��䣺DQL���->��ѯ��Ա��нˮ�ȼ�����ʾ��Ա�����ơ�Ա��нˮ��нˮ�ȼ�
			String sql = "select e.ename,e.sal,s.grade from emp e join salgrade s on e.sal between s.losal and s.hisal";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.print(rs);

		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
}