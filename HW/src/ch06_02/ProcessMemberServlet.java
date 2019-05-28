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

@WebServlet("/ch06_02/Insert.do")
public class ProcessMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		// 定義存放錯誤訊息的 Collection物件
		Map<String, String> errorMessage = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMessage);

		// 設定輸入資料的編碼
		request.setCharacterEncoding("UTF-8");
		// 讀取使用者所輸入，由瀏覽器送來的 mId 欄位內的資料，注意大小寫
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
		String area = request.getParameter("mArea");
		if (area == null || area.trim().length() == 0) {
			errorMessage.put("area", "地區欄必須輸入");
		}
		
		String country = request.getParameter("mCountry");
		if (country == null || country.trim().length() == 0) {
			errorMessage.put("country", "縣市欄必須輸入");
		}
		
		String name = request.getParameter("mName");
		if (name == null || name.trim().length() == 0) {
			errorMessage.put("name", "名稱欄必須輸入");
		}

		String address = request.getParameter("mAddress");
		if (address == null || address.trim().length() == 0) {
			errorMessage.put("address", "地址欄必須輸入");
		}
		String tel = request.getParameter("mTel");
		if (tel == null || tel.trim().length() == 0) {
			errorMessage.put("tel", "電話欄必須輸入");
		}
		
	
		// 如果有錯誤，呼叫view元件，送回錯誤訊息
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/ch06_02/InsertMemberForm.jsp");
			rd.forward(request, response);
			return;
		}
		// MemberBean 扮演封裝輸入資料的角色
		MemberBean mb = new MemberBean(id, area, country, name, address, tel);
		try {
			MemberService service = new MemberService();
			service.insertMember(mb);
			session.setAttribute("memberBean", mb);
//			request.setAttribute("memberBean", mb);
			// 依照執行的結果挑選適當的view元件，送回相關訊息
			// 產生 RequestDispatcher 物件 rd
//			RequestDispatcher rd = request.getRequestDispatcher("/ch05_03/InsertMemberSuccess.jsp");
			// 請容器代為呼叫下一棒程式
//			rd.forward(request, response);
			response.sendRedirect("InsertMemberSuccess.jsp");
			return;
        } catch (SQLException e) {
			if (e.getMessage().indexOf("重複的索引鍵") != -1 
				|| e.getMessage().indexOf("Duplicate entry") != -1) {
				errorMessage.put("id", "ID重複，請重新輸入ID");
			} else {
				errorMessage.put("exception", "資料庫存取錯誤:" + e.getMessage());
			}
			RequestDispatcher rd = request.getRequestDispatcher("/ch06_02/InsertMemberForm.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
