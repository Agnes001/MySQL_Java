/*
	JDBC�����������
		1.ע������
		2.��ȡ���ݿ�����
		3.��ȡ���ݿ��������
		4.ִ��SQL���
		5.�����ѯ�����
		6.�ر���Դ
		���岽�������ѯ�����
*/
import java.sql.*;
public class JDBCTest05
{
	public static void main(String[] args){
		try{
			//1.ע������
			Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			//2.��ȡ���ݿ�����
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3366/bjpowernode","root","111");
			//3.��ȡ���ݿ��������
			Statement stmt = conn.createStatement();
			//4.ִ��SQL��䣺DQL���->�����ѯ�����
			String sql = "select e.ename,e.sal,s.grade from emp e join salgrade s on e.sal between s.losal and s.hisal";
			ResultSet rs = stmt.executeQuery(sql);
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
			//5.�����ѯ�����
			while(rs.next()){
				/*
				String ename = rs.getString("ename");
				double sal = rs.getDouble("sal");
				int grade = rs.getInt("grade");
				*/
				//����������д��������ɶ��Բ�ǿ
				String ename = rs.getString(1);
				double sal = rs.getDouble(2);
				int grade = rs.getInt(3);
				System.out.println(ename + " " + sal + " " + grade);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}