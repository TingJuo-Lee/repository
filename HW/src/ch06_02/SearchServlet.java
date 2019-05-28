package ch06_02;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ch06_02/Search.do")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Map<String, String> errorMessage = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMessage);
		request.setCharacterEncoding("UTF-8");
		String id2 = request.getParameter("mId");
		int id = 0;
		// 檢核使用者的輸入資料
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
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/ch06_02/SearchForm.jsp");
			rd.forward(request, response);
			return;
		}
		MemberDao dao = new MemberDao();
			try {
				MemberBean bean = dao.select(id);
				String str = null;
				
				str = "<table border='1'><tr>"
						+ "<th width='200px'>memberId</th>"
						+ "<th width='200px'>area</th>"
						+ "<th width='200px'>country</th>"
						+ "<th width='200px'>name</th>"
						+ "<th width='200px'>address</th>"
						+ "<th width='200px'>tel</th>";
				
				str += "<tr><td>" + bean.getMemberId() + "</td><td>" + bean.getArea() + "</td><td>" + bean.getCountry()
						+ "</td><td>" + bean.getName() + "</td><td>" + bean.getAddress() + "</td><td>"
						+ bean.getTel() +"</td></tr>";
				
				str += "</table>";
				session.setAttribute("SearchInfo", str);

				response.sendRedirect("SearchSuccess.jsp");
				return;

			} catch (Exception e) {
				errorMessage.put("exception", "資料庫存取錯誤:" + e.getMessage());
			}
			RequestDispatcher rd = request.getRequestDispatcher("/ch06_02/Search.jsp");
			rd.forward(request, response);
			return;
		}
	}