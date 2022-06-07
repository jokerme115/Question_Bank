package Bank_util;
/**
 *�����������������ݿ�Ĺ�����
 *
 * @author HeTao
 *
 */

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class jdbc_util 
{
	
		
//	private String url = "jdbc:mysql://127.0.0.1:3306/db_book?useSSL = false";
//	private String username = "root";		//�û�������ǵøĳ��Լ���
//	private String password = "200030222";
//	private String jdbcName = "com.mysql.cj.jdbc.Driver";//����������ǵð�.cjȥ��
			
	/**
	 * ��ȡ���ݿ�����	
	 * @return һ��connection���Ӷ���
	 * @throws Exception
	 */
	public Connection getCon() throws Exception 
	{
		//1.����jar��
		//2.���������ļ�
		//3.���������ļ�
		Properties pro = new Properties();
		pro.load(new FileInputStream("src/druid.properties"));
		
		//4.��ȡ���ӳض���
		DataSource DR = DruidDataSourceFactory.createDataSource(pro);
		
		//5.��ȡ���ݿ�����Connection
		Connection connection = DR.getConnection();
		
		System.out.println(connection);
		return connection;
	}
	
	/**
	 * �ر����ݿ�����
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con)throws Exception{
		if (con != null) {
			con.close();
		}
	}
	
}
