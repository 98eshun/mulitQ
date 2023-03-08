package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentInfoDAO {
		
		private Connection conn = null;
		private Statement stmt = null;
		private PreparedStatement pstmt = null;	// 필요한 변수 private 선언
		private ResultSet rs = null;
		private String sql = null;
		
		public StudentInfoDAO() {	// 생성자에 서버 초기화 수행
			String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
			String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "scott";
			String pwd = "tiger";
			
			try {
				Class.forName(jdbc_driver);
				conn = DriverManager.getConnection(jdbc_url, user, pwd);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public int insertInfo(StudentDO studentDO) {
			int rowCount = 0;
			sql = "insert into Studnets(id, passwd, gender) values(?,?,?)";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, studentDO.getId());
				pstmt.setString(2, studentDO.getPasswd());
				pstmt.setString(3, studentDO.getGender());
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally {
				try {
					if(!stmt.isClosed()) {
						stmt.close();
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			return rowCount;
		}

		public int insertScore(GradeDO gradeDO) {
			int rowCount = 0;
			sql = "insert into Grade(KO, EN, MT, SI) values(?,?,?,?)";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, gradeDO.getKO());
				pstmt.setInt(2, gradeDO.getEN());
				pstmt.setInt(3, gradeDO.getMT());
				pstmt.setInt(4, gradeDO.getSI());
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally {
				try {
					if(!stmt.isClosed()) {
						stmt.close();
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			return rowCount;
		}
		
		public ArrayList<StudentDO> getAllStudent(){
			ArrayList<StudentDO> list = new ArrayList<StudentDO>();
			StudentDO studentDO = null;
			sql = "select id, name, gender from Students;";
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					studentDO = new StudentDO();
					studentDO.setId(rs.getString("id"));	//테이블의 열 이름으로 해야함
					studentDO.setName(rs.getString("name"));
					studentDO.setGender(rs.getString("gender"));
					list.add(studentDO);
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally {
				try {
					if(!stmt.isClosed()) {
						stmt.close();
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			return list;
		}
		
		public ArrayList<GradeDO> getAllGrade(){
			ArrayList<GradeDO> score = new ArrayList<GradeDO>();
			GradeDO gradeDO = null;
			sql = "select KO, EN, MT, SI from Grade;";
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					gradeDO = new GradeDO();
					gradeDO.setKO(rs.getInt("KO"));
					gradeDO.setEN(rs.getInt("EN"));
					gradeDO.setMT(rs.getInt("MT"));
					gradeDO.setSI(rs.getInt("SI"));
					score.add(gradeDO);
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally {
				try {
					if(!stmt.isClosed()) {
						stmt.close();
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			return score;
		}
		
		public TwitterLoginDO getLoginDO(TwitterLoginDO loginDO) {	//null값을 반환하면 로그인 실패 
			TwitterLoginDO result = null;
			sql = "select * from twitter_login where id = ? and passwd = ?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, loginDO.getId());
				pstmt.setString(2, loginDO.getPasswd());
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					result = new TwitterLoginDO();
					result.setId(rs.getString("id"));
					result.setPasswd(rs.getString("passwd"));
					result.setName(rs.getString("name"));
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return result;
		}

		public void closeConnection() {
			try {
				if(!conn.isClosed()) {
					conn.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
}
