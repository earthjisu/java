import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



public class MemberDAO {
	private Statement stmt;  //java.sql import
	private Connection conn;  //db와의 연결을 보관
	
	public boolean exist(String userid, String passwd) {
		boolean result=false;
		try {
			connDB();
			String query ="select * from t_member where id='"+userid+"'and pwd='"+passwd+"'";
			this.stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			int n=0;
			while(rs.next()) {
				n++;
			}
			if(n==1) result=true;
			else result=false;
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	public void updateMember(MemberVO mvo) {
		try {
			connDB();
			String query="update t_member set name=?,pwd=?,mobile=?,joindate=? where id=?";
			PreparedStatement psmt= conn.prepareStatement(query);
			psmt.setString(1,mvo.getName());
			psmt.setString(2,mvo.getPwd());
			psmt.setString(3, mvo.getMobile());
			psmt.setString(4, mvo.getJoinDate());
			psmt.setString(5, mvo.getId());
			psmt.executeUpdate();
			psmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteMember(String id) {
		try {
			connDB();
			String query ="delete from t_member where id=?";
			PreparedStatement psmt=conn.prepareStatement(query);
			psmt.setString(1,id);
			psmt.executeUpdate();
			psmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void addnewMember(MemberVO mvo) {
		//db connection
		//SQL 구성
		//실행요청 -> DB에 추가(insert)
		try {
			connDB();
			String query="insert into t_member values(?,?,?,?,?)";
			PreparedStatement psmt=conn.prepareStatement(query);
			psmt.setString(1, mvo.getId());
			psmt.setString(2, mvo.getPwd());
			psmt.setString(3, mvo.getName());
			psmt.setString(4, mvo.getMobile());
			psmt.setString(5, mvo.getJoinDate());
			psmt.executeUpdate();
			psmt.close();
			conn.close();
			
			//Statement stmt=conn.createStatement();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public MemberVO getMember(String id) {
		MemberVO mvo=new MemberVO();
		try {
			connDB();
			String query="select * from t_member where id='"+id+"'";
			this.stmt=conn.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			rs.next();  //처음에 반드시 한 번은 있어야 함
			mvo.setId(rs.getString("id"));
			mvo.setName(rs.getString("name"));
			mvo.setPwd(rs.getString("pwd"));
			mvo.setMobile(rs.getString("mobile"));
			mvo.setJoinDate(rs.getString("joindate"));
			this.stmt.close();
			conn.close();
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return mvo;
	}
	public ArrayList<MemberVO>listMember() { //Read-select
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		try {
			connDB();
			String query="select * from t_member";
			this.stmt=conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				MemberVO mvo=new MemberVO();
				mvo.setId(rs.getString("id"));
				mvo.setPwd(rs.getString("pwd"));
				mvo.setName(rs.getString("name"));
				mvo.setMobile(rs.getString("mobile"));
				mvo.setJoinDate(rs.getString("joindate"));
				list.add(mvo);
				
			}
			rs.close(); //사용 안한 memory 반납
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
			e.printStackTrace(); //에러가 난 라인, 에러메시지 보여줌
		}
	}
}
