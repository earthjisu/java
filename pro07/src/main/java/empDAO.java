import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class empDAO {
	private Statement stmt;
	private Connection conn;
	
	public ArrayList<empDTO>listEmp(){
		ArrayList<empDTO> list = new ArrayList<empDTO>();
		try {
			connDB();
			String query="select a.employee_id,a.emp_name,b.emp_name manager_name,c.department_name department_name"+
			" from employees a, employees b,departments c"+
			" where a.manager_id=b.employee_id"+
			" and a.department_id=c.department_id";
			this.stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				int e_id=rs.getInt("employee_id");
				String name=rs.getString("emp_name");
				String m_name=rs.getString("manager_name");
				String d_name=rs.getString("department_name");
				
				empDTO dto=new empDTO();
				dto.setEmployee_id(e_id);
				dto.setEmp_name(name);
				dto.setManager_id(m_name);
				dto.setDepartment_id(d_name);
				list.add(dto);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	private void connDB() {
		String driver ="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String userid="ora_user";
		String passcode="human123";
		
		try {
			Class.forName(driver);
			this.conn=DriverManager.getConnection(url,userid,passcode);
			if(conn==null) {
				System.out.println("데이터베이스 접속 실패");
			}
		}catch(Exception e) {
			e.printStackTrace(); 
		}
		
	}
}
