package ch06_02;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ch06_02.MemberBean;

@WebServlet("/ch06_02/Update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
	
		Map<String, String> errorMessage = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMessage);


		request.setCharacterEncoding("UTF-8");
		
		String id2 = request.getParameter("mId");
		int id = 0;

		if (id2 == null || id2.trim().length() == 0) {
			errorMessage.put("id", "ID欄必須輸入");
		}else if (id2 != null && id2.trim().length() > 0) {
				try {
					id =Integer.valueOf(id2);
				} catch (NumberFormatException e) {
					errorMessage.put("id", "ID欄必須為數值");
					e.printStackTrace();
				}
			
		}
		String area = request.getParameter("mArea");
		String country = request.getParameter("mCountry");
		String name = request.getParameter("mName");
		String address = request.getParameter("mAddress");	
		String tel = request.getParameter("mTel");
		
		
		
	

		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/ch06_02/UpdateForm.jsp");
			rd.forward(request, response);
			return;
		}

		MemberDao dao = new MemberDao();
		try {
			dao.delete(id);

		} catch (Exception e) {
			errorMessage.put("exception", "資料庫存取錯誤:" + e.getMessage());
		}
		
		MemberBean mb = new MemberBean(id, area, country, name, address, tel);
		
			try {
				MemberService service = new MemberService();
				service.insertMember(mb);
				session.setAttribute("memberBean", mb);
//	
				response.sendRedirect("UpdateSuccess.jsp");
				return;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("/ch06_02/UpdateForm.jsp");
			rd.forward(request, response);
	
		
		}
	}

