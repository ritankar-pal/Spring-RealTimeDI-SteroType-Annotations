package in.ineuron.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import in.ineuron.bo.CustomerBO;


@Repository(value = "dao")
public class CustomerDAOMySQLImpl implements ICustomerDAO {
	
	private static final String CUSTOMER_INSERT_QUERY = "insert into customer(cname, caddress, pamt, rate, time, intrAmt) values(?,?,?,?,?,?)";
	
	@Autowired
	private DataSource dataSource;
	
	static {
		System.out.println("CustomerDAOMySQLImpl .class file is being created...");
	}
	
	public CustomerDAOMySQLImpl() {
		System.out.println("CustomerDAOMySQLImpl:: Zero param constructor is being created...");
	}

	@Override
	public int save(CustomerBO bo) throws Exception {
		
		int count = 0;
		
		try(Connection connection = dataSource.getConnection(); PreparedStatement psmt = connection.prepareStatement(CUSTOMER_INSERT_QUERY)){
			
			psmt.setString(1, bo.getCustomerName());
			psmt.setString(2, bo.getCustomerAddress());
			psmt.setFloat(3, bo.getPamt());
			psmt.setFloat(4, bo.getRate());
			psmt.setFloat(5, bo.getTime());
			psmt.setFloat(6, bo.getIntAmount());
			
			count = psmt.executeUpdate();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public String toString() {
		return "CustomerDAOMySQLImpl [dataSource=" + dataSource + "]";
	}
	
}
