package ch06_02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ch06_02.MemberBean;


public class MemberDao {
	
	DataSource ds = null;
	
	public MemberDao() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MemberDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}	

	private static final String SELECT_BY_ID = "Select memberId, area, country, name, address,"
			+ " tel from tourism where memberId = ?";
	public MemberBean select(int id) {
		MemberBean result = null;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);
		) {
			stmt.setInt(1, id);
			try (
				ResultSet rset = stmt.executeQuery();					
			){
				if (rset.next()) {
					result = new MemberBean();
					result.setMemberId(rset.getInt("memberid"));
					result.setArea(rset.getString("area"));
					result.setCountry(rset.getString("country"));
					result.setName(rset.getString("name"));
					result.setAddress(rset.getString("address"));
					result.setTel(rset.getString("tel"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	private static final String SELECT_ALL = "Select memberId, area, country, name, address, tel from tourism";
	
	public List<MemberBean> select() {
		List<MemberBean> result = null;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = stmt.executeQuery();				
		) {
			result = new Vector<>();
			while (rset.next()) {
				MemberBean temp = new MemberBean();
				temp.setMemberId(rset.getInt("memberid"));
				temp.setArea(rset.getString("area"));
				temp.setCountry(rset.getString("country"));
				temp.setName(rset.getString("name"));
				temp.setAddress(rset.getString("address"));
				temp.setTel(rset.getString("tel"));
				result.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}

	private static final String INSERT = "Insert into tourism (memberId, area, country, "
			+ "name, address, tel) values (?, ?, ?, ?, ?, ?)";

	public MemberBean insertMember(MemberBean bean) throws SQLException {
		MemberBean result = null;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(INSERT);
		) {
			stmt.setInt(1, bean.getMemberId());
			stmt.setString(2, bean.getArea());
			stmt.setString(3, bean.getCountry());
			stmt.setString(4, bean.getName());
			stmt.setString(5, bean.getAddress());
			stmt.setString(6, bean.getTel());

			int i = stmt.executeUpdate();
			if (i == 1) {
				result = this.select(bean.getMemberId());
			}

		} 
		return result;
	}

	private static final String DELETE = "Delete from tourism where memberId=?";

	public int delete(int id) {
		int result = 0;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(DELETE);
		) {
			stmt.setInt(1, id);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}
}