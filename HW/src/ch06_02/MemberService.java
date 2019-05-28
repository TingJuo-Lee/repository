package ch06_02;

import java.sql.SQLException;
import java.util.List;

public class MemberService {
	
	MemberDao dao = null;
	
	public MemberService() {
		dao = new MemberDao();
	}	

	public MemberBean select(int id) {
		return dao.select(id);
	}
	
	public List<MemberBean> select() {
		return dao.select();
	}

	public MemberBean insertMember(MemberBean bean) throws SQLException {
		return dao.insertMember(bean);
	}

	public int delete(int memberId) {
		return dao.delete(memberId);
	}
	public List<MemberBean> getAllinfo() {
		System.out.println(select());
		return select();
	
	}

}