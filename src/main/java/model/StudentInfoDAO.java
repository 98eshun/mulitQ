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
		private PreparedStatement pstmt = null;
		private ResultSet rs = null;
		private String sql = null;
		
		public StudentInfoDAO() {
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
				pstmt.executeUpdate();
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
				pstmt.executeUpdate();
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
			sql = "select id, passwd, gender from Students";
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					studentDO = new StudentDO();
					studentDO.setId(rs.getString("id"));
					studentDO.setPasswd(rs.getString("passwd"));
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
			sql = "select id, KO, EN, MT, SI from grade";
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					gradeDO = new GradeDO();
					gradeDO.setId(rs.getString("id"));
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
		
		public String findStudent(StudentDO studentDO) {
			String result="";
			sql = "select id, passwd "
				+ "from students "
				+ "where id = ? and passwd = ?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, studentDO.getId());
				pstmt.setString(2, studentDO.getPasswd());
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					result += rs.getString("id") + ":::" + rs.getString("passwd");
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return result;
		}
		
		public String findScore(StudentDO gradeDO) {
			String result = null;
			sql = "select KO, EN, MT, SI "
				+ "from Grade"
				+ "where id = ?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, gradeDO.getId());
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					result += rs.getString("KO") + rs.getString("EN") + rs.getString("MT") + rs.getString("SI"); 
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return result;
		}
		
		public int modifyInfo(String id, String passwd, StudentDO studentDO) {
			int rowCount = 0;
			sql = "update Studnets "
				+ "set id=?, passwd=?, gender=?"
				+ "where id = ? and passwd = ?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,studentDO.getId());
				pstmt.setString(2,studentDO.getPasswd());
				pstmt.setString(3,studentDO.getGender());						
				pstmt.setString(4, id);
				pstmt.setString(5, passwd);
				pstmt.executeUpdate();
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
		
		public int modifyScore(String id, GradeDO scoreDO) {
			int rowCount = 0;
			sql = "update Grade "
				+ "set KO=?, EN=?, MT=?, SI=?"
				+ "where id = ?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,scoreDO.getKO());
				pstmt.setInt(2,scoreDO.getEN());
				pstmt.setInt(3,scoreDO.getMT());
				pstmt.setInt(4,scoreDO.getSI());
				pstmt.setString(5, id);
				pstmt.executeUpdate();
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

		public int delete(StudentDO studentDO) {
			int rowCount = 0;
			sql = "delete from students where id = ?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,studentDO.getId());
				pstmt.executeUpdate();
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
